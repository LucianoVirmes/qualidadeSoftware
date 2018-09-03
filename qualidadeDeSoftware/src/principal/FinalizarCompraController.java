package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FinalizarCompraController {

	@FXML
	private TableView<?> tblProdutos;

	@FXML
	private TableColumn<?, ?> tbcNome;

	@FXML
	private TableColumn<?, ?> tbcValor;

	@FXML
	private TableColumn<?, ?> tbcDesconto;

	@FXML
	private Label lblValorTotal;

	@FXML
	private Button btnComprar;

	@FXML
	private TextField tfNomeTitular;

	@FXML
	private TextField tfNumeroCartao;

	@FXML
	private TextField tfPIN;

	@FXML
	private ChoiceBox<?> chbVezes;

	@FXML
	private ChoiceBox<?> chbFormaPagamento;

	@FXML
	void comprar(ActionEvent event) {

	}
}
