package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import principal.model.Categoria;
import principal.model.Produto;

public class ProdutosController {

    @FXML
    private TableView<Produto> tblProdutos;

    @FXML
    private TableColumn<Produto, String> tbcNome;

    @FXML
    private TableColumn<Produto, String> tbcModelo;

    @FXML
    private TableColumn<Produto, Double> tbcValor;

    @FXML
    private ComboBox<Categoria> cbxClassificacao;

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
