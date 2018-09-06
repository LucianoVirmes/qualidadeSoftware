package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {

	@FXML
	private MenuItem mmiEditarUsuario;

	@FXML
	private MenuItem mmiHistorico;

	@FXML
	private MenuItem mmiProdutos;

	@FXML
	private MenuItem mmiOferta;

	@FXML
	private MenuItem mmiVisualizarCarrinho;
	
    @FXML
    private BorderPane bpPrincipalCliente;

	@FXML
	void menuEditarUsuario(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("EditarCliente.fxml"));
		try {
			AnchorPane View = (AnchorPane) loader.load();
			bpPrincipalCliente.setCenter(View);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuHistorico(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Historico.fxml"));
		try {
			AnchorPane View = (AnchorPane) loader.load();
			bpPrincipalCliente.setCenter(View);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuOferta(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Oferta.fxml"));
		try {
			AnchorPane View = (AnchorPane) loader.load();
			bpPrincipalCliente.setCenter(View);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuProdutos(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Produtos.fxml"));
		try {
			AnchorPane View = (AnchorPane) loader.load();
			bpPrincipalCliente.setCenter(View);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuVisualizarCarrinho(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Carrinho.fxml"));
		try {
			AnchorPane View = (AnchorPane) loader.load();
			bpPrincipalCliente.setCenter(View);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
