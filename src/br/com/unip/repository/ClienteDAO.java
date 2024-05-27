package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.unip.connection.ConnectionFactory;
import br.com.unip.model.Cliente;

public class ClienteDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public ClienteDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	// ---------- CADASTRAR CLIENTE NA TABELA ---------- //
	public void insertCliente(Cliente cliente) {
		String sql = "insert into usuario (nm_usuario, nr_cpf, ds_email, ds_senha, nr_telefone, ds_genero, dt_dataNascimento) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			//prepara dados para enviar separadamente para o BD
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Complemento da Query
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEmailCliente());
			stmt.setString(4, cliente.getSenhaCliente());
			stmt.setString(5, cliente.getTelefoneCliente());
			stmt.setString(6, cliente.getGeneroCliente());
			stmt.setString(7, cliente.getDataNascimento());	
			
			//Executar Query
			stmt.execute();
			
			//Fechar Operação
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		// ------------SelectAll------------
		public List<Cliente> selectAll() {
			List<Cliente> usuarios = new ArrayList<Cliente>();
			String sql = "select * from usuario order by nm_usuario";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente = new Cliente();
					cliente.setNomeCliente(rs.getString("nm_usuario"));
					cliente.setCpfCliente(rs.getString("nr_cpf"));
					cliente.setEmailCliente(rs.getString("ds_email"));
					cliente.setSenhaCliente(rs.getString("ds_senha"));
					cliente.setTelefoneCliente(rs.getString("nr_telefone"));
					cliente.setGeneroCliente(rs.getString("ds_genero"));
					cliente.setDataNascimento(rs.getString("dt_dataNascimento"));
					cliente.setDataCadastro(rs.getDate("dt_dataCadastro"));
					usuarios.add(cliente); // Cada objeto usuário adicionado a lista de usuários.
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return usuarios;
		}
		
		// ---------- EXCLUIR CLIENTE DA TABELA ---------- //
		public void delete(String nr_cpf) {
			String sql = "delete from usuario where nr_cpf=?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nr_cpf);
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// ---------- CONSULTAR DADOS DO CLIENTE ---------- //
		public Cliente selectByCPF(String cpf) {

			Cliente cliente = null;
			String sql = "select * from usuario where nr_cpf=?";

			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cpf);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					cliente = new Cliente();
					cliente.setNomeCliente(rs.getString("nm_usuario"));
					cliente.setCpfCliente(rs.getString("nr_cpf"));
					cliente.setEmailCliente(rs.getString("ds_email"));
					cliente.setSenhaCliente(rs.getString("ds_senha"));
					cliente.setTelefoneCliente(rs.getString("nr_telefone"));
					cliente.setGeneroCliente(rs.getString("ds_genero"));
					cliente.setDataNascimento(rs.getString("dt_dataNascimento"));
					cliente.setDataCadastro(rs.getDate("dt_dataCadastro"));
				} else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado");
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cliente;
		}
		// ---------- ATUALIZAR DADOS DO CLIENTE ---------- //
		public void updateCliente(Cliente cliente) {
			String sql = "update usuario set nm_usuario=?, ds_email=?, nr_telefone=?, ds_genero=?, dt_dataNascimento=? where nr_cpf=?";
			
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cliente.getNomeCliente());
				stmt.setString(2, cliente.getEmailCliente());
				stmt.setString(3, cliente.getTelefoneCliente());
				stmt.setString(4, cliente.getGeneroCliente());
				stmt.setString(5, cliente.getDataNascimento());	
				stmt.setString(6, cliente.getCpfCliente());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


