package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditarProdutosController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfModelo;

	@FXML
	private TextField tfPreco;

	@FXML
	private ComboBox<?> cbxCategoria;

	@FXML
	private TableView<?> tblProdutos;

	@FXML
	private TableColumn<?, ?> tbcNome;

	@FXML
	private TableColumn<?, ?> tbcModelo;

	@FXML
	private TableColumn<?, ?> tbcClassificacao;

	@FXML
	private TableColumn<?, ?> tbcPreco;

	@FXML
	private TableColumn<?, ?> tbcDesconto;

	@FXML
	private TextField tfProcentageDesconto;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnNovo;

	@FXML
	void excluir(ActionEvent event) {

	}

	@FXML
	void novo(ActionEvent event) {

	}

	@FXML
	void salvar(ActionEvent event) {

	}

	@FXML
	void selecionaProduto(MouseEvent event) {

	}
}
