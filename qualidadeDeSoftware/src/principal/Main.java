package principal;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
		
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
		loginScene = new Scene(fxmlLogin, 800,600);
		
		Parent fxmlMenu = FXMLLoader.load(getClass().getResource("MenuForm.fxml"));
		menuClienteScene = new Scene(fxmlMenu, 800,600);
		
		Parent fxmlAdminMenu = FXMLLoader.load(getClass().getResource("AdminMenuForm.fxml"));
		menuAdminScene  = new Scene(fxmlAdminMenu, 800,600);
		
		Parent fxmlCadastroCliente = FXMLLoader.load(getClass().getResource("CadastroClienteForm.fxml"));
		cadastroCliente  = new Scene(fxmlCadastroCliente, 800,600);
		
		Parent fxmlFinalizarCompra = FXMLLoader.load(getClass().getResource("FinalizarCompraForm.fxml"));
		finalizarCompra  = new Scene(fxmlFinalizarCompra, 800,600);
		
		Parent fxmlVisualizarProduto = FXMLLoader.load(getClass().getResource("VisualizarProdutoForm.fxml"));
		verProduto  = new Scene(fxmlVisualizarProduto, 800,600);
		
		primaryStage.setScene(loginScene);
		primaryStage.show();
		
	
	}
	
	public static void changeScreen(String str) {
		switch (str) {
		case "login":
			stage.setScene(loginScene);
			break;
		case "menuCliente":
			stage.setScene(menuClienteScene);
			break;
		case "cadastroCliente":
			stage.setScene(cadastroCliente);
			break;
		case "menuAdmin":
			stage.setScene(menuAdminScene);
			break;
		case "finalizaCompra":
			stage.setScene(finalizarCompra);
			break;
		case "verProduto":
			stage.setScene(verProduto);
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
