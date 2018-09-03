package principal;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class OfertaController {

	@FXML
	private TableView<?> tblOferta;

	@FXML
	private TableColumn<?, ?> tbcImagem;

	@FXML
	private TableColumn<?, ?> tbcNome;

	@FXML
	private TableColumn<?, ?> tbcModelo;

	@FXML
	private TableColumn<?, ?> tbcValor;

	@FXML
	void selecionaProduto(MouseEvent event) {

	}
}
