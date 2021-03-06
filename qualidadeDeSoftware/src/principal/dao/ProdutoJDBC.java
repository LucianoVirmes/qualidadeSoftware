package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Categoria;
import principal.model.Produto;

public class ProdutoJDBC implements ProdutoDAO{

	@Override
	public void inserir(Produto dado) {
		try {
			String sql = "insert into produto(nome, valor, disponibilidade, modelo, porcentagemDesconto,codCategoria) values (?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setDouble(2, dado.getValor());
			dado.setDisponibilidade(true);
			statement.setBoolean(3, dado.getDisponibilidade());
			statement.setString(4, dado.getModelo());
			statement.setDouble(5, dado.getPorcentagemDesconto());
			statement.setInt(6, dado.getCategoria().getCodigo());
			statement.executeUpdate();
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Produto dado) {
		try {
			String sql = "update produto set nome = ?, valor = ?, disponibilidade= ?, modelo=?, porcentagemDesconto = ?, codCategoria = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setString(1, dado.getNome());
			statement.setDouble(2, dado.getValor());
			statement.setBoolean(3, dado.getDisponibilidade());
			statement.setString(4, dado.getModelo());
			statement.setDouble(5, dado.getPorcentagemDesconto());
			statement.setInt(6, dado.getCategoria().getCodigo());
			statement.setInt(7, dado.getCodigo());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Integer codigo) {
		try {
			String sql = "delete from produto where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, codigo);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from produto");
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setDisponibilidade(rs.getBoolean("disponibilidade"));
				produto.setModelo(rs.getString("modelo"));
				produto.setPorcentagemDesconto(rs.getDouble("porcentagemDesconto"));
				produto.setCategoria(buscarCategoria(rs.getInt("codCategoria")));
				
				produtos.add(produto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return produtos;

	}

	@Override
	public Produto buscar(Integer codigo) {
		Produto produto = null;
		try {
			String sql = "select * from produto where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while(rs1.next()) {
				produto = new Produto();
				produto.setCodigo(rs1.getInt("codigo"));
				produto.setNome(rs1.getString("nome"));
				produto.setValor(rs1.getDouble("valor"));
				produto.setDisponibilidade(rs1.getBoolean("disponibilidade"));
				produto.setModelo(rs1.getString("modelo"));
				produto.setPorcentagemDesconto(rs1.getDouble("porcentagemDesconto"));
				produto.setCategoria(buscarCategoria(rs1.getInt("codCategoria")));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return produto;

	}

	
	public Categoria buscarCategoria(Integer codigo) {
		Categoria categoria = null;
		try {
			String sql = "select * from categoria where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while(rs1.next()) {
				categoria = new Categoria();
				categoria.setCodigo(rs1.getInt("codigo"));
				categoria.setNome(rs1.getString("nome"));

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return categoria;

	}
	
	
	public List<Produto> produtosEmOferta() {
		List<Produto> produtos = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from produto where porcentagemDesconto > 0");
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setDisponibilidade(rs.getBoolean("disponibilidade"));
				produto.setModelo(rs.getString("modelo"));
				produto.setPorcentagemDesconto(rs.getDouble("porcentagemDesconto"));
				produto.setCategoria(buscarCategoria(rs.getInt("codCategoria")));				
				produtos.add(produto);
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return produtos;

	}
 

}
