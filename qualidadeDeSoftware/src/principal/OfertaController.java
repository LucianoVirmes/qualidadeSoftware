package principal;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.AbstractFactory;
import principal.dao.ProdutoDAO;
import principal.model.Produto;

public class OfertaController {

	@FXML
	private TableView<Produto> tblOferta;

	@FXML
	private TableColumn<?, ?> tbcImagem;

	@FXML
	private TableColumn<Produto, String> tbcNome;

	@FXML
	private TableColumn<Produto, String> tbcModelo;

	@FXML
	private TableColumn<Produto, Double> tbcValor;
	
	@FXML
    private TableColumn<Produto, Double> tbcDesconto;
	
	private ProdutoDAO produtoDao = AbstractFactory.get().produtoDAO();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tbcDesconto.setCellValueFactory(new PropertyValueFactory<>("porcentagemDesconto"));
		tblOferta.setItems(FXCollections.observableArrayList(produtoDao.produtosEmOferta()));
	}


	@FXML
	void selecionaProduto(MouseEvent event) {

	}
}
