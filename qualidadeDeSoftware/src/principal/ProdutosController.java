package principal;

import javafx.fxml.FXML;
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
    void selecionaProduto(MouseEvent event) {

    }
}
