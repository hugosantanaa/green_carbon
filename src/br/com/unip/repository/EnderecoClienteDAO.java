package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.unip.connection.ConnectionFactory;
import br.com.unip.model.EnderecoCliente;


public class EnderecoClienteDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public EnderecoClienteDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	// ---------- CADASTRAR ENDEREÇO CLIENTE NA TABELA ---------- //
	public void insertEnderecoCliente(EnderecoCliente end_cliente) {
		String sql = "insert into end_usuarios (nr_cep, ds_rua, ds_bairro, ds_cidade, ds_estado, nr_cpf) values (?, ?, ?, ?, ?, ?)";
		try {
			//prepara dados para enviar separadamente para o BD
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Complemento da Query
			stmt.setString(1, end_cliente.getCep());
			stmt.setString(2, end_cliente.getRua());
			stmt.setString(3, end_cliente.getBairro());
			stmt.setString(4, end_cliente.getCidade());
			stmt.setString(5, end_cliente.getEstado());
			stmt.setString(6, end_cliente.getCpf());
			
			//Executar Query
			stmt.execute();
			
			//Fechar Operação
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ------------SelectAll------------
	public List<EnderecoCliente> selectAll() {
		List<EnderecoCliente> usuarios = new ArrayList<EnderecoCliente>();
		String sql = "select * from end_usuarios order by nr_cep";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				EnderecoCliente usu = new EnderecoCliente();
				usu = new EnderecoCliente();
				usu.setCep(rs.getString("nr_cep"));
				usu.setRua(rs.getString("ds_rua"));
				usu.setBairro(rs.getString("ds_bairro"));
				usu.setCidade(rs.getString("ds_cidade"));
				usu.setEstado("ds_estado");
				usu.setCpf(rs.getString("nr_cpf"));
				usuarios.add(usu); // Cada objeto usuário adicionado a lista de empresas.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	// ---------- EXCLUIR ENDEREÇO CLIENTE DA TABELA ---------- //
	public void delete(String nr_cpf) {
		String sql = "delete from end_usuarios where nr_cpf=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nr_cpf);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ---------- CONSULTAR ENDEREÇO DO CLIENTE ---------- //
	public EnderecoCliente selectByCPF(String CPF) {

		EnderecoCliente usuario = null;
		String sql = "select * from end_usuarios where nr_cpf=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, CPF);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				EnderecoCliente usu = new EnderecoCliente();
				usu = new EnderecoCliente();
				usu.setCep(rs.getString("nr_cep"));
				usu.setRua(rs.getString("ds_rua"));
				usu.setBairro(rs.getString("ds_bairro"));
				usu.setCidade(rs.getString("ds_cidade"));
				usu.setEstado("ds_estado");
				usu.setCpf(rs.getString("nr_cpf"));
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	// ---------- ATUALIZAR ENDEREÇO DO CLIENTE ---------- //
	public void updateEnderecoCliente(EnderecoCliente usuario) {
		String sql = "update end_usuarios set nr_cep=?, ds_rua=?, ds_bairro=?, ds_estado=? where nr_cpf=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getCep());
			stmt.setString(2, usuario.getRua());
			stmt.setString(3, usuario.getBairro());
			stmt.setString(4, usuario.getEstado());
			stmt.setString(5, usuario.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
