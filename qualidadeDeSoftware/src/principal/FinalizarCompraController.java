package principal;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
	private Button btnCancelar;

	@FXML
	private ChoiceBox<?> chbFormaPagamento;

	@FXML
	void cancelar(ActionEvent event) {
		Alert alerta = new Alert(AlertType.NONE, "Deseja realmente cancelar sua compra?", ButtonType.NO, ButtonType.YES);

		final Optional<ButtonType> result = alerta.showAndWait();
		if (ButtonType.YES.equals(result.get())) {
			Main.changeScreen(TipoTela.MENUCLIENTE);
		}

	}

	@FXML
	void comprar(ActionEvent event) {

	}
}
