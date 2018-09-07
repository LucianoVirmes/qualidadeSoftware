package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class CarrinhoController {

	@FXML
	private TableView<?> tblCarrinho;

	@FXML
	private TableColumn<?, ?> tbcNomeProduto;

	@FXML
	private TableColumn<?, ?> tbcQuantidade;

	@FXML
	private TableColumn<?, ?> tbcValor;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnFinalizarCompra;

	@FXML
	private Label lblTotal;

	@FXML
	void excluir(ActionEvent event) {

	}

	@FXML
	void finalizarCompra(ActionEvent event) {
		Main.changeScreen(TipoTela.FINALIZACOMPRA);
	}

	@FXML
	void selecionaProduto(MouseEvent event) {

	}
}
