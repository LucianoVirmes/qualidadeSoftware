package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController {

	@FXML
	private TextField tfNomeUsuario;

	@FXML
	private PasswordField tfSenha;

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
		if(tfNomeUsuario.getText().equals("admin") && tfSenha.getText().equals("admin")) {
			Main.changeScreen(TipoTela.MENUADMIN);
		}else {
			Main.changeScreen(TipoTela.MENUCLIENTE);
				
		}
		}
}
