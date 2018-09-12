package principal;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import principal.dao.AbstractFactory;
import principal.dao.ClienteDAO;
import principal.model.Cliente;

public class CadastroClienteController {

	 @FXML
	    private TextField tfNome;

	    @FXML
	    private TextField tfSobrenome;

	    @FXML
	    private TextField tfCpf;

	    @FXML
	    private TextField tfEstado;

	    @FXML
	    private TextField tfCidade;

	    @FXML
	    private TextField tfBairro;

	    @FXML
	    private TextField tfRua;

	    @FXML
	    private TextField tfNumero;

	    @FXML
	    private TextField tfEmail;
	    
	    @FXML
	    private TextField tfSenha;
	    
	    @FXML
	    private Button btnCadastrar;
	    
	    @FXML
	    private Button btnVoltar;
	    

	    private Cliente cliente = new Cliente();
	    
	    private ClienteDAO clienteDao = AbstractFactory.get().clienteDao();
	    
	
	    
	    @FXML
	    void voltar(ActionEvent event) {
	    		Main.changeScreen(TipoTela.LOGIN);
	    }

	    @FXML
	    void cadastrar(ActionEvent event) {
	    		populaCliente();
	    		
	    			
	    		if(verificaCliente()) {
	    			clienteDao.inserir(cliente);
	    			Alert alerta = new Alert(AlertType.INFORMATION, "Cadastro realizado com sucesso", ButtonType.OK);
//	    			Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
//	    			okButton.setDefaultButton(false);
//	    			okButton.setText("OK");
	    			final Optional<ButtonType> result = alerta.showAndWait();
	    			
	    			if(ButtonType.OK.equals(result.get())) {
	    				Main.changeScreen(TipoTela.LOGIN);
	    			}
	    		}else {
	    			Alert alerta = new Alert(AlertType.WARNING, "O cadastro não pode ser efetuado", ButtonType.OK);
//	    			Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
//	    			okButton.setDefaultButton(false);
//	    			okButton.setText("OK");
	    			final Optional<ButtonType> result = alerta.showAndWait();
	    			if(ButtonType.OK.equals(result.get())) {
	    				novoCliente();
	    			}
	    		}			
			novoCliente();
		
	    }
	    
	    
	    public void populaCliente() {
	    		cliente.setNome(tfNome.getText());
	    		cliente.setSobrenome(tfSobrenome.getText());
	    		cliente.setCpf(tfCpf.getText());
	    		cliente.setEstado(tfEstado.getText());
	    		cliente.setCidade(tfCidade.getText());
	    		cliente.setBairro(tfBairro.getText());
	    		cliente.setRua(tfRua.getText());
	    		cliente.setNumero(tfNumero.getText());
	    		cliente.setEmail(tfEmail.getText());
	    		cliente.setSenha(tfSenha.getText());
	    }
	    
	    public boolean verificaCliente() {
	    		boolean verifica = true;
	    		if(cliente.getBairro().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getCidade().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getCpf().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getEmail().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getEstado().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getNome().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getNumero().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getRua().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getSenha().isEmpty()) {
	    			verifica = false;
	    		}else if(cliente.getSobrenome().isEmpty()) {
	    			verifica = false;
	    		}
	    		return verifica;
	    }
	    
	    void novoCliente() {
	    		tfNome.clear();
	    		tfSobrenome.clear();
	    		tfCpf.clear();
	    		tfEstado.clear();
	    		tfCidade.clear();
	    		tfBairro.clear();
	    		tfRua.clear();
	    		tfNumero.clear();
	    		tfEmail.clear();
	    		tfSenha.clear();
	    		cliente = new Cliente();
	    }
}
