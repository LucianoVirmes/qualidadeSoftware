package principal;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.AbstractFactory;
import principal.dao.CategoriaDAO;
import principal.dao.CategoriaJDBC;
import principal.dao.ProdutoDAO;
import principal.model.Categoria;
import principal.model.Produto;

public class EditarCategoriaController {

	@FXML
	private TextField tfNome;

	@FXML
	private TableView<Categoria> tblCategoria;

	@FXML
	private TableColumn<Categoria, String> tbcNome;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnSalvar;

	
	private CategoriaDAO categoriaDao = AbstractFactory.get().categoriaDAO();
	
	private Categoria categoria = new Categoria();
	
	private boolean editando;
	
	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		novaCategoria();
	}
	
	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.WARNING, "Deseja excluir esta categoria ?",ButtonType.CANCEL, ButtonType.OK);
		Button okButton = (Button)
		alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);
		okButton.setText("Sim");
		
		Button cancelButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL);
		cancelButton.setText("Não");
		final Optional<ButtonType> result = alerta.showAndWait();
		if (ButtonType.OK.equals(result.get())) {
			categoriaDao.excluir(categoria.getCodigo());
			novaCategoria();
		}
	}

	@FXML
	void novo(ActionEvent event) {
		novaCategoria();
	}

	@FXML
	void salvar(ActionEvent event) {
		populaCategoria();
		if (editando) {
			categoriaDao.alterar(categoria);
			Alert alerta = new Alert(AlertType.INFORMATION, "Alteração salva com sucesso", ButtonType.OK);
			alerta.showAndWait();
		} else {
			categoriaDao.inserir(categoria);
			Alert alerta = new Alert(AlertType.INFORMATION, "Produto adicionado com sucesso", ButtonType.OK);
			alerta.showAndWait();
		}
		novaCategoria();
		tblCategoria.refresh();
	}

	@FXML
	void selecionaCategoria(MouseEvent event) {
		if (tblCategoria.getSelectionModel().getSelectedItem() != null) {
			categoria = tblCategoria.getSelectionModel().getSelectedItem();
			populaTela(categoria);
			editando = true;
		}
	}
	public void populaCategoria() {
		categoria.setNome(tfNome.getText());
		
	}
	public void populaTela(Categoria categoria) {
		tfNome.setText(categoria.getNome());
	}
	
	void novaCategoria() {
		tfNome.clear();
		categoria = new Categoria();
		editando = false;
		
		tblCategoria.setItems(FXCollections.observableArrayList(categoriaDao.listar()));
	}

}
