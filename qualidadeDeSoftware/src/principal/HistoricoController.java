package principal;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistoricoController {

    @FXML
    private TableView<?> tblHistorico;

    @FXML
    private TableColumn<?, ?> tbcData;

    @FXML
    private TableColumn<?, ?> tbcProduto;

    @FXML
    private TableColumn<?, ?> tbcValor;
}
