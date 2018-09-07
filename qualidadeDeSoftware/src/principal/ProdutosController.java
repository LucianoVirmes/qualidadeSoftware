package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ProdutosController {

    @FXML
    private TableView<?> tblProdutos;

    @FXML
    private TableColumn<?, ?> tbcNome;

    @FXML
    private TableColumn<?, ?> tbcModelo;

    @FXML
    private TableColumn<?, ?> tbcValor;

    @FXML
    private ComboBox<?> cbxClassificacao;

    @FXML
    private Button btnSelecionar;

    @FXML
    void seleciona(ActionEvent event) {
    		Main.changeScreen(TipoTela.VERPRODUTO);
    }

    @FXML
    void selecionaProduto(MouseEvent event) {

    }
}
