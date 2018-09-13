package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AdminMenuController {

	@FXML
	private BorderPane bpPrincipalAdmin;

	@FXML
	private MenuItem mmiEditarAdmin;

	@FXML
	private MenuItem mmiAdicionarAdmin;

	@FXML
	private MenuItem mmiProdutos;

	@FXML
	private MenuItem mmiCategorias;

	@FXML
	void menuAddAdmin(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("AdicionarAdminForm.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipalAdmin.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuAddProdutos(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("EditarProdutosForm.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipalAdmin.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuCategorias(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("EditarCategoriaForm.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipalAdmin.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuEditarAdmin(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("EditarAdminForm.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipalAdmin.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
