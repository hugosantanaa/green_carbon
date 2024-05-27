package br.com.unip.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.unip.connection.ConnectionFactory;
import br.com.unip.model.ContaAgua;

public class ContaAguaUsuarioDAO {
	
	private Connection conexao;

	// Conexão para essa entidade.
	public ContaAguaUsuarioDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	// ---------- CADASTRAR CONTA NA TABELA ---------- //
	public void insertContaAguaUsu(ContaAgua contaAgua) {
		String sql = "insert into conta_agua_usuario (ds_periodo_consumo, nr_valor, nr_consumo_metros_cubicos, ds_estacao, nr_cpf, data_ref) values (?, ?, ?, ?, ?, ?)";
		try {
			//prepara dados para enviar separadamente para o BD
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Complemento da Query
			stmt.setString(1, contaAgua.getPeriodo_consumo());
			stmt.setDouble(2, contaAgua.getValor());
			stmt.setDouble(3, contaAgua.getConsumo_metros_cubicos());
			stmt.setString(4, contaAgua.getEstacao());
			stmt.setString(5, contaAgua.getCpf());
			stmt.setString(6, contaAgua.getDataRef());

			//Executar Query
			stmt.execute();
			
			//Fechar Operação
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ---------- EXCLUIR CONTA DA TABELA ---------- //
			public void deleteContaAgua(String nr_cpf) {
				String sql = "delete from conta_agua_usuario where nr_cpf=?";
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
		    public List<ContaAgua> selectAll() {
		        List<ContaAgua> contas = new ArrayList<>();
		        String sql = "SELECT * FROM conta_agua_usuario WHERE nr_cpf=?";

		        try {
		            PreparedStatement stmt = conexao.prepareStatement(sql);

		            ResultSet rs = stmt.executeQuery();

		            while (rs.next()) {
		                ContaAgua conta = new ContaAgua();
		                conta.setPeriodo_consumo(rs.getString("ds_periodo_consumo"));
		                conta.setValor(rs.getDouble("nr_valor"));
		                conta.setConsumo_metros_cubicos(rs.getDouble("nr_consumo_metros_cubicos"));
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
			public ContaAgua selectByCPF(String cpf) {

				ContaAgua contaAgua = null;
				String sql = "select * from conta_agua_usuario where nr_cpf=?";

				try {
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1, cpf);

					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {
						ContaAgua conta = new ContaAgua();
		                conta.setPeriodo_consumo(rs.getString("ds_periodo_consumo"));
		                conta.setValor(rs.getDouble("nr_valor"));
		                conta.setConsumo_metros_cubicos(rs.getDouble("nr_consumo_metros_cubicos"));
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
				return contaAgua;
			}
			
			// ---------- ATUALIZAR DADOS DO CLIENTE ---------- //
			public void updateContaAguaUsuario(ContaAgua contaAgua) {
				String sql = "update conta_agua_usuario set ds_periodo_consumo=?, nr_valor=?, nr_consumo_metros_cubicos=?, ds_estacao=?, data_ref=? where nr_cpf=?";
				
				try {
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1, contaAgua.getPeriodo_consumo());
					stmt.setDouble(2, contaAgua.getValor());
					stmt.setDouble(3, contaAgua.getConsumo_metros_cubicos());
					stmt.setString(4, contaAgua.getEstacao());
					stmt.setString(5, contaAgua.getCpf());
					stmt.setString(6, contaAgua.getDataRef());
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
