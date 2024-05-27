package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.unip.connection.ConnectionFactory;
import br.com.unip.model.ContaEnergia;

public class ContaEnergiaUsuDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public ContaEnergiaUsuDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	// ---------- CADASTRAR CONTA NA TABELA ---------- //
	public void insertContaEnergiaUsu(ContaEnergia contaEnergia) {
		String sql = "insert into conta_energia_usuario (ds_periodo_consumo, nr_valor, ds_consumo_kwh, ds_estacao, dt_ref, nr_cpf) values (?, ?, ?, ?, ?, ?)";
		try {
			//prepara dados para enviar separadamente para o BD
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Complemento da Query
			stmt.setString(1, contaEnergia.getPeriodo_consumo());
			stmt.setDouble(2, contaEnergia.getValor());
			stmt.setString(3, contaEnergia.getConsumo_kwh());
			stmt.setString(4, contaEnergia.getEstacao());
			stmt.setString(5, contaEnergia.getCpf());
			stmt.setString(6, contaEnergia.getDataRef());

			//Executar Query
			stmt.execute();
			
			//Fechar Operação
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ---------- EXCLUIR CONTA DA TABELA ---------- //
			public void deleteContaEnergiaUsu(String nr_cpf) {
				String sql = "delete from conta_energia_usuario where nr_cpf=?";
				try {
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1, nr_cpf);
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			// ---------- LISTAR CONTAS DO CLIENTE ---------- //
		    public List<ContaEnergia> selectAll() {
		        List<ContaEnergia> contas = new ArrayList<>();
		        String sql = "SELECT * FROM conta_energia_usuario WHERE nr_cpf=?";

		        try {
		            PreparedStatement stmt = conexao.prepareStatement(sql);

		            ResultSet rs = stmt.executeQuery();

		            while (rs.next()) {
		            	ContaEnergia conta = new ContaEnergia();
		                conta.setPeriodo_consumo(rs.getString("ds_periodo_consumo"));
		                conta.setValor(rs.getDouble("nr_valor"));
		                conta.setConsumo_kwh(rs.getString("ds_consumo_kwh"));
		                conta.setEstacao(rs.getString("ds_estacao"));
		                conta.setCpf(rs.getString("nr_cpf"));
		                conta.setDataRef(rs.getString("data_ref"));
		                conta.setData(rs.getDate("dt_Cadastro"));
		                contas.add(conta);
		            }
		            rs.close();
		            stmt.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return contas;
		    }
		    
		 // ---------- CONSULTAR DADOS DO CLIENTE ---------- //
			public ContaEnergia selectByCPF(String cpf) {

				ContaEnergia contaEnergia = null;
				String sql = "select * from conta_energia_usuario where nr_cpf=?";

				try {
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1, cpf);

					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {
						 ContaEnergia conta = new ContaEnergia();
			                conta.setPeriodo_consumo(rs.getString("ds_periodo_consumo"));
			                conta.setValor(rs.getDouble("nr_valor"));
			                conta.setConsumo_kwh(rs.getString("ds_consumo_kwh"));
			                conta.setEstacao(rs.getString("ds_estacao"));
			                conta.setCpf(rs.getString("nr_cpf"));
			                conta.setDataRef(rs.getString("data_ref"));
			                conta.setData(rs.getDate("dt_Cadastro"));
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado");
					}
					rs.close();
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return contaEnergia;
			}
			
			// ---------- ATUALIZAR DADOS DO CLIENTE ---------- //
			public void updateContaEnergia(ContaEnergia contaEnergia) {
				String sql = "update conta_energia_usuario set ds_periodo_consumo=?, nr_valor=?, ds_consumo_kwh=?, ds_estacao=?, dt_ref=? where nr_cpf=?";
				
				try {
					//prepara dados para enviar separadamente para o BD
					PreparedStatement stmt = conexao.prepareStatement(sql);
					
					//Complemento da Query
					stmt.setString(1, contaEnergia.getPeriodo_consumo());
					stmt.setDouble(2, contaEnergia.getValor());
					stmt.setString(3, contaEnergia.getConsumo_kwh());
					stmt.setString(4, contaEnergia.getEstacao());
					stmt.setString(5, contaEnergia.getCpf());
					stmt.setString(6, contaEnergia.getDataRef());
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


}
