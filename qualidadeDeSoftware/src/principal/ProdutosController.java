package principal;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import principal.dao.AbstractFactory;
import principal.dao.CategoriaDAO;
import principal.dao.ProdutoDAO;
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
    
	private CategoriaDAO categoriaDao = AbstractFactory.get().categoriaDAO();
	
	private ProdutoDAO produtoDao = AbstractFactory.get().produtoDAO();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		populaCombo();
		tblProdutos.setItems(FXCollections.observableArrayList(produtoDao.listar()));
	}
    
	private void populaCombo(){
		for(Categoria categoria: categoriaDao.listar()){
			cbxClassificacao.getItems().add(categoria);
		}
	}
	
    @FXML
    void seleciona(ActionEvent event) {
    		Main.changeScreen(TipoTela.VERPRODUTO);
    }

    @FXML
    void selecionaProduto(MouseEvent event) {
    }
}
