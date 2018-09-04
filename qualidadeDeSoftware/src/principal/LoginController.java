package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController {

	@FXML
	private TextField tfNomeUsuario;

	@FXML
	private TextField tfSenha;

	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnCadastrar;
	
	@FXML
	private BorderPane bpPrincipal;

	@FXML
	void cadastrar(ActionEvent event) {
		Main.changeScreen(TipoTela.CADASTROCLIENTE);
	}
	

	@FXML
	void entrar(ActionEvent event) {
		Main.changeScreen(TipoTela.MENUCLIENTE);
	}
}
