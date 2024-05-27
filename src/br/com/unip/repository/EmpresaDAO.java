package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.unip.connection.ConnectionFactory;
import br.com.unip.model.Empresa;

public class EmpresaDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public EmpresaDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	// ---------- CADASTRAR EMPRESA NA TABELA ---------- //
		public void insertEmpresa(Empresa empresa) {
			String sql = "insert into empresa (nm_empresa, nr_cnpj, ds_email, ds_senha, ds_ramo_atividade) values (?, ?, ?, ?, ?)";
			try {
				//prepara dados para enviar separadamente para o BD
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				//Complemento da Query
				stmt.setString(1, empresa.getNomeEmpresa());
				stmt.setString(2, empresa.getCnpjEmpresa());
				stmt.setString(3, empresa.getEmailEmpresa());
				stmt.setString(4, empresa.getSenhaEmpresa());
				stmt.setString(5, empresa.getRamoAtividade());
				
				//Executar Query
				stmt.execute();
				
				//Fechar Operação
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// ------------SelectAll------------
				public List<Empresa> selectAll() {
					List<Empresa> empresas = new ArrayList<Empresa>();
					String sql = "select * from empresa order by nm_empresa";
					try {
						PreparedStatement stmt = conexao.prepareStatement(sql);
						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {
							Empresa colaborador = new Empresa();
							colaborador = new Empresa();
							colaborador.setNomeEmpresa(rs.getString("nm_empresa"));
							colaborador.setCnpjEmpresa(rs.getString("nr_cnpj"));
							colaborador.setEmailEmpresa(rs.getString("ds_email"));
							colaborador.setSenhaEmpresa(rs.getString("ds_senha"));
							colaborador.setRamoAtividade(rs.getString("ds_ramo_atividade"));
							colaborador.setDataCadastro(rs.getDate("dt_dataCadastro"));
							empresas.add(colaborador); // Cada objeto usuário adicionado a lista de empresas.
						}
						rs.close();
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return empresas;
				}
				
				// ---------- EXCLUIR EMPRESA DA TABELA ---------- //
				public void delete(String nr_cnpj) {
					String sql = "delete from empresa where nr_cnpj=?";
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
				public Empresa selectByCNPJ(String cnpj) {

					Empresa empresa = null;
					String sql = "select * from empresa where nr_cnpj=?";

					try {
						PreparedStatement stmt = conexao.prepareStatement(sql);
						stmt.setString(1, cnpj);

						ResultSet rs = stmt.executeQuery();

						if (rs.next()) {
							empresa = new Empresa();
							empresa.setNomeEmpresa(rs.getString("nm_empresa"));
							empresa.setCnpjEmpresa(rs.getString("nr_cnpj"));
							empresa.setEmailEmpresa(rs.getString("ds_email"));
							empresa.setSenhaEmpresa(rs.getString("ds_senha"));
							empresa.setRamoAtividade(rs.getString("ds_ramo_atividade"));
							empresa.setDataCadastro(rs.getDate("dt_dataCadastro"));
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
				public void updateEmpresa(Empresa empresa) {
					String sql = "update empresa set nm_empresa=?, ds_email=?, ds_ramo_atividade=? where nr_cpf=?";
					
					try {
						PreparedStatement stmt = conexao.prepareStatement(sql);
						stmt.setString(1, empresa.getNomeEmpresa());
						stmt.setString(2, empresa.getEmailEmpresa());
						stmt.setString(3, empresa.getRamoAtividade());
						stmt.setString(6, empresa.getCnpjEmpresa());
						stmt.execute();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

}
