package principal;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


// ver controllers


public class Main extends Application {
	
	private static Stage stage;
	
	private static Scene loginScene;
	private static Scene menuClienteScene;
	private static Scene menuAdminScene;
	private static Scene cadastroCliente;
	private static Scene finalizarCompra;
	private static Scene verProduto;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		stage = primaryStage;
		
		primaryStage.setTitle("ExemploLogin");
		
		BorderPane fxmlLogin = (BorderPane)FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
		loginScene = new Scene(fxmlLogin, 800,600);
		loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		BorderPane fxmlMenu = (BorderPane)FXMLLoader.load(getClass().getResource("MenuForm.fxml"));
		menuClienteScene = new Scene(fxmlMenu, 800,600);
		menuClienteScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		BorderPane fxmlAdminMenu = (BorderPane)FXMLLoader.load(getClass().getResource("AdminMenuForm.fxml"));
		menuAdminScene  = new Scene(fxmlAdminMenu, 800,600);
		menuAdminScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		AnchorPane fxmlCadastroCliente = (AnchorPane)FXMLLoader.load(getClass().getResource("CadastroClienteForm.fxml"));
		cadastroCliente  = new Scene(fxmlCadastroCliente, 800,600);
		cadastroCliente.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		AnchorPane fxmlFinalizarCompra = (AnchorPane)FXMLLoader.load(getClass().getResource("FinalizarCompraForm.fxml"));
		finalizarCompra  = new Scene(fxmlFinalizarCompra, 800,600);
		finalizarCompra.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		AnchorPane fxmlVisualizarProduto = (AnchorPane)FXMLLoader.load(getClass().getResource("VisualizarProdutoForm.fxml"));
		verProduto  = new Scene(fxmlVisualizarProduto, 800,600);
		verProduto.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}
	
	public static void changeScreen(TipoTela tt) {
		switch (tt) {
		case LOGIN:
			stage.setScene(loginScene);
			break;
		case MENUCLIENTE:
			stage.setScene(menuClienteScene);
			break;
		case CADASTROCLIENTE:
			stage.setScene(cadastroCliente);
			break;
		case MENUADMIN:
			stage.setScene(menuAdminScene);
			break;
		case FINALIZACOMPRA:
			stage.setScene(finalizarCompra);
			break;
		case VERPRODUTO:
			stage.setScene(verProduto);
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
