package principal;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Stage stage;
	
	/**
	 * Scenes criados como estaticos e privados 
	 * para carregados no star
	 */
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
		
		/**
		 * carrega a tela de login puxando o fxml 
		 */
		BorderPane fxmlLogin = (BorderPane)FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
		loginScene = new Scene(fxmlLogin, 800,600);
		loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		/**
		 * carrega a de menu do cliente puxando o fxml
		 * acessada apos login 
		 */
		BorderPane fxmlMenu = (BorderPane)FXMLLoader.load(getClass().getResource("MenuForm.fxml"));
		menuClienteScene = new Scene(fxmlMenu, 800,600);
		menuClienteScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		/**
		 * carrega a tela de menu do admin puxando o fxml
		 * acessada quando o usuario for admin 
		 */
		BorderPane fxmlAdminMenu = (BorderPane)FXMLLoader.load(getClass().getResource("AdminMenuForm.fxml"));
		menuAdminScene  = new Scene(fxmlAdminMenu, 800,600);
		menuAdminScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		/**
		 * carrega a tela de cadastro do cliente o fxml
		 * acessada quando botao cadastrar for acionado 
		 */
		AnchorPane fxmlCadastroCliente = (AnchorPane)FXMLLoader.load(getClass().getResource("CadastroClienteForm.fxml"));
		cadastroCliente  = new Scene(fxmlCadastroCliente, 800,600);
		cadastroCliente.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		/**
		 * carrega a tela finalização de compra puxando o fxml
		 * acessada ao finalizar a compra em carrinho 
		 */
		AnchorPane fxmlFinalizarCompra = (AnchorPane)FXMLLoader.load(getClass().getResource("FinalizarCompraForm.fxml"));
		finalizarCompra  = new Scene(fxmlFinalizarCompra, 800,600);
		finalizarCompra.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		/**
		 * carrega a tela de detalhe do produto puxando o fxml
		 * acessada ao selecionar um produto 
		 */
		AnchorPane fxmlVisualizarProduto = (AnchorPane)FXMLLoader.load(getClass().getResource("VisualizarProdutoForm.fxml"));
		verProduto  = new Scene(fxmlVisualizarProduto, 800,600);
		verProduto.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}
	
	/**
	 * metodo que muda a screen recebendo um tipo de tela
	 * retorna uma scene previamente carregada
	 * @param tipo
	 */
	public static void changeScreen(TipoTela tipo) {
		switch (tipo) {
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
		System.setProperty("tipoPersistencia", 
				TipoPersistencia.BANCO.name());
		if(args.length > 0){
			System.setProperty("tipoConexao", args[0]);
		}
		launch(args);
	}
	

}
