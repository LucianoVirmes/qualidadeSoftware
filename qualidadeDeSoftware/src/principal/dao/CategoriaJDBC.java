package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Categoria;

public class CategoriaJDBC implements CategoriaDAO{

	@Override
	public void inserir(Categoria dado) {
		try {
			String sql = "insert into categoria(nome) values (?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void alterar(Categoria dado) {
		try {
			String sql = "update categoria set nome = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setInt(2, dado.getCodigo());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void excluir(Integer codigo) {
		try {
			String sql = "delete from categoria where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, codigo);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from categoria");
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setCodigo(rs.getInt("codigo"));
				categoria.setNome(rs.getString("nome"));
				categorias.add(categoria);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public Categoria buscar(Integer codigo) {
		Categoria categoria = null;
		try {
			String sql = "select * from categoria where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while(rs1.next()) {
				categoria = new Categoria();
				categoria.setNome(rs1.getString("nome"));
				categoria.setCodigo(rs1.getInt("codigo"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return categoria;
	}

}
