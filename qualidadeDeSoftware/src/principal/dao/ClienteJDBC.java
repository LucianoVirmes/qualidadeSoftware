package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Cliente;

public class ClienteJDBC implements ClienteDAO{

	@Override
	public void inserir(Cliente dado) {
		try {
			String sql = "insert into cliente values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, buscarCodigoCliente());
			statement.setString(2, dado.getEmail());
			statement.setString(3, dado.getNome());
			statement.setString(4, dado.getSobrenome());
			statement.setString(5, dado.getSenha());
			statement.setString(6, dado.getCpf());
			statement.setString(7, dado.getCidade());
			statement.setString(8, dado.getEstado());
			statement.setString(9, dado.getBairro());
			statement.setString(10, dado.getRua());
			statement.setString(11, dado.getNumero());
			
			/**
			 * tentativa de implementacao de auto_increment 
			 * fracassada !
			 */
//			ResultSet rs = statement.getGeneratedKeys();
//			rs.next();
//			dado.setCodigo(rs.getInt(1));
			
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Cliente dado) {
		try {
			String sql = "update cliente set email = ?, nome = ?, sobrenome = ?, senha=?, cpf =?, cidade=?, estado=?, bairro=?, rua=? numero = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			
			statement.setString(1, dado.getEmail());
			statement.setString(2, dado.getNome());
			statement.setString(3, dado.getSobrenome());
			statement.setString(4, dado.getSenha());
			statement.setString(5, dado.getCpf());
			statement.setString(6, dado.getCidade());
			statement.setString(7, dado.getEstado());
			statement.setString(8, dado.getBairro());
			statement.setString(9, dado.getRua());
			statement.setString(10, dado.getNumero());
			statement.setInt(11, dado.getCodigo());
			
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Integer codigo) {
		try {
			String sql = "delete from cliente where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, codigo);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from cliente");
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setEmail(rs.getString("email"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setRua(rs.getString("rua"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setCodigo(rs.getInt("codigo"));
				clientes.add(cliente);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Cliente buscar(Integer codigo) {
		Cliente cliente = null;
		try {
			String sql = "select * from cliente where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while(rs1.next()) {
				cliente = new Cliente();
				cliente.setEmail(rs1.getString("email"));
				cliente.setNome(rs1.getString("nome"));
				cliente.setSobrenome(rs1.getString("sobrenome"));
				cliente.setSenha(rs1.getString("senha"));
				cliente.setCpf(rs1.getString("cpf"));
				cliente.setCidade(rs1.getString("cidade"));
				cliente.setEstado(rs1.getString("estado"));
				cliente.setBairro(rs1.getString("bairro"));
				cliente.setRua(rs1.getString("rua"));
				cliente.setNumero(rs1.getString("numero"));
				cliente.setCodigo(rs1.getInt("codigo"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cliente;
	}
	
	public Integer buscarCodigoCliente() {
		Integer retorno = null;
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select max(codigo) from cliente");
			while(rs.next()) {
				retorno = rs.getRow();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(retorno.equals(null)) {
			return 1;
		}else {
			return Integer.valueOf(retorno + 1);			
		}
	}
	

}
