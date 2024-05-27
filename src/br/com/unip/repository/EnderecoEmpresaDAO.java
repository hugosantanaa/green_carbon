package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.unip.connection.ConnectionFactory;
import br.com.unip.model.EnderecoEmpresa;

public class EnderecoEmpresaDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public EnderecoEmpresaDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	// ---------- CADASTRAR EMPRESA NA TABELA ---------- //
	public void insertEnderecoEmpresa(EnderecoEmpresa end_empresa) {
		String sql = "insert into end_empresa (nr_cep, ds_rua, ds_bairro, ds_cidade, ds_estado, nr_cnpj) values (?, ?, ?, ?, ?, ?)";
		try {
			//prepara dados para enviar separadamente para o BD
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Complemento da Query
			stmt.setString(1, end_empresa.getCep());
			stmt.setString(2, end_empresa.getRua());
			stmt.setString(3, end_empresa.getBairro());
			stmt.setString(4, end_empresa.getCidade());
			stmt.setString(5, end_empresa.getEstado());
			stmt.setString(6, end_empresa.getCnpj());
			
			//Executar Query
			stmt.execute();
			
			//Fechar Operação
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ------------SelectAll------------
	public List<EnderecoEmpresa> selectAll() {
		List<EnderecoEmpresa> empresas = new ArrayList<EnderecoEmpresa>();
		String sql = "select * from end_empresa order by nr_cep";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				EnderecoEmpresa colaborador = new EnderecoEmpresa();
				colaborador = new EnderecoEmpresa();
				colaborador.setCep(rs.getString("nr_cep"));
				colaborador.setRua(rs.getString("ds_rua"));
				colaborador.setBairro(rs.getString("ds_bairro"));
				colaborador.setCidade(rs.getString("ds_cidade"));
				colaborador.setEstado("ds_estado");
				colaborador.setCnpj(rs.getString("nr_cnpj"));
				empresas.add(colaborador); // Cada objeto usuário adicionado a lista de empresas.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresas;
	}
	
	// ---------- EXCLUIR ENDEREÇO EMPRESA DA TABELA ---------- //
	public void delete(String nr_cnpj) {
		String sql = "delete from end_empresa where nr_cnpj=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nr_cnpj);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ---------- CONSULTAR DADOS DO CLIENTE ---------- //
	public EnderecoEmpresa selectByCNPJ(String cnpj) {

		EnderecoEmpresa empresa = null;
		String sql = "select * from end_empresa where nr_cnpj=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cnpj);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				empresa = new EnderecoEmpresa();
				empresa.setCep(rs.getString("nr_cep"));
				empresa.setRua(rs.getString("ds_rua"));
				empresa.setBairro(rs.getString("ds_bairro"));
				empresa.setCidade(rs.getString("ds_cidade"));
				empresa.setEstado("ds_estado");
				empresa.setCnpj(rs.getString("nr_cnpj"));
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
	
	// ---------- ATUALIZAR DADOS DO CLIENTE ---------- //
	public void updateEnderecoEmpresa(EnderecoEmpresa empresa) {
		String sql = "update end_empresa set nr_cep=?, ds_rua=?, ds_bairro=?, ds_estado=? where nr_cnpj=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, empresa.getCep());
			stmt.setString(2, empresa.getRua());
			stmt.setString(3, empresa.getBairro());
			stmt.setString(4, empresa.getEstado());
			stmt.setString(5, empresa.getCnpj());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
