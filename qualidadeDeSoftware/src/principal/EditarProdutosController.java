package principal;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.AbstractFactory;
import principal.dao.CategoriaDAO;
import principal.dao.ProdutoDAO;
import principal.model.Categoria;
import principal.model.Produto;

public class EditarProdutosController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfModelo;

	@FXML
	private TextField tfPreco;

	@FXML
	private ComboBox<Categoria> cbxCategoria;

	@FXML
	private TableView<Produto> tblProdutos;

	@FXML
	private TableColumn<Produto, String> tbcNome;

	@FXML
	private TableColumn<Produto, String> tbcModelo;

	@FXML
	private TableColumn<Produto, Categoria> tbcClassificacao;

	@FXML
	private TableColumn<Produto, Double> tbcPreco;

	@FXML
	private TableColumn<Produto, Double> tbcDesconto;

	@FXML
	private TextField tfProcentagemDesconto;
	
	
	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnNovo;
	
	private Produto produto;
	
	private boolean editando;
	
	private CategoriaDAO categoriaDao = AbstractFactory.get().categoriaDAO();
	
	private ProdutoDAO produtoDao = AbstractFactory.get().produtoDAO();
	
	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tbcClassificacao.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		tbcPreco.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tbcDesconto.setCellValueFactory(new PropertyValueFactory<>("porcentagemDesconto"));
		populaCombo();
		novoProduto();
	}

	private void populaCombo(){
		for(Categoria categoria: categoriaDao.listar()){
			cbxCategoria.getItems().add(categoria);
		}
	}
	
	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.WARNING, "Deseja excluir este produto ?",ButtonType.CANCEL, ButtonType.OK);
		Button okButton = (Button)
		alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);
		okButton.setText("Sim");
		
		Button cancelButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL);
		cancelButton.setText("NÃ£o");
		final Optional<ButtonType> result = alerta.showAndWait();
		if (ButtonType.OK.equals(result.get())) {
			produtoDao.excluir(produto.getCodigo());
			novoProduto();
		}
	}

	@FXML
	void novo(ActionEvent event) {
		novoProduto();
	}

	@FXML
	void salvar(ActionEvent event) {
		populaProduto();

		if (editando) {
			produtoDao.alterar(produto);
			Alert alerta = new Alert(AlertType.INFORMATION, "Alteração salva com sucesso", ButtonType.OK);
			alerta.showAndWait();
		} else {
			produtoDao.inserir(produto);
			Alert alerta = new Alert(AlertType.INFORMATION, "Produto adicionado com sucesso", ButtonType.OK);
			alerta.showAndWait();
		}
		novoProduto();
		tblProdutos.refresh();
	}

	@FXML
	void selecionaProduto(MouseEvent event) {
		if (tblProdutos.getSelectionModel().getSelectedItem() != null) {
			produto = tblProdutos.getSelectionModel().getSelectedItem();
			populaTela(produto);
			editando = true;
		}
	}
	
	public void populaProduto() {
		produto.setNome(tfNome.getText());
		produto.setModelo(tfModelo.getText());
		produto.setValor(Double.valueOf(tfPreco.getText()));
		produto.setPorcentagemDesconto(Double.valueOf(tfProcentagemDesconto.getText()));
		produto.setCategoria(cbxCategoria.getValue());
	}

	public void populaTela(Produto produto) {
		tfNome.setText(produto.getNome());
		tfModelo.setText(produto.getModelo());
		tfPreco.setText(produto.getValor().toString());
		tfProcentagemDesconto.setText(produto.getPorcentagemDesconto().toString());
		cbxCategoria.getSelectionModel().select(produto.getCategoria());
	}
	
	void novoProduto() {
		tfNome.clear();
		tfModelo.clear();
		tfPreco.clear();
		tfProcentagemDesconto.clear();
		produto = new Produto();
		editando = false;
		cbxCategoria.getSelectionModel().clearSelection();
		tblProdutos.setItems(FXCollections.observableArrayList(produtoDao.listar()));
	}

}
