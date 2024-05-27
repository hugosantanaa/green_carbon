package br.com.unip.test;

import java.util.List;

import br.com.unip.model.Cliente;
import br.com.unip.model.ContaAgua;
import br.com.unip.model.ContaEnergia;
import br.com.unip.model.ContaEnergiaEmp;
import br.com.unip.model.Empresa;
import br.com.unip.model.EnderecoCliente;
import br.com.unip.model.EnderecoEmpresa;
import br.com.unip.repository.ClienteDAO;
import br.com.unip.repository.ContaAguaUsuarioDAO;
import br.com.unip.repository.ContaEnergiaEmpDAO;
import br.com.unip.repository.ContaEnergiaUsuDAO;
import br.com.unip.repository.EmpresaDAO;
import br.com.unip.repository.EnderecoClienteDAO;
import br.com.unip.repository.EnderecoEmpresaDAO;

public class TestConnection {
		public static void main(String[]args) {
	
//			ClienteDAO usuario = new ClienteDAO();
			
			 // ------ TESTE CADASTRO ------ // FUNCIONANDO!
//		Cliente julia = new Cliente("julia", "29134806256", "10/10/2004", "julia@gmail.com", "1598476", "11947249789", "feminino");
//		usuario.insertCliente(julia);

			// ------ TESTE DELETE CLIENTE------ // FUNCIONANDO!
//			usuario.delete("98765432101");
			
//			 --------SELECTBYCPF CLIENTE-------- // FUNCIONANDO!
//			Cliente cliente = usuario.selectByCPF("29134806288");
//			System.out.println("Nome: " + cliente.getNomeCliente());
//			System.out.println("CPF: " + cliente.getCpfCliente());
//			System.out.println("E-mail: " + cliente.getEmailCliente());
//			System.out.println("Telefone: " + cliente.getTelefoneCliente());
//			System.out.println("Gênero: " + cliente.getGeneroCliente());
//			System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
//			System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
			
			 //--------UPDATE CLIENTE-------- // FUNCIONANDO!
//			Cliente update = usuario.selectByCPF("29134806256");
//			update.setEmailCliente("ALTERADO@gmail.com");
//			usuario.updateCliente(update);
			
			 //--------CADASTRO EMPRESA-------- // FUNCIONANDO!
//			EmpresaDAO empresa = new EmpresaDAO();
//			Empresa BK = new Empresa ("9876543210112", "bk", "BK@gmail.com","1598476", "FAST-FOOD");
//			empresa.insertEmpresa(BK);
			
			// ------ TESTE DELETE EMPRESA------ // FUNCIONANDO!
//			empresa.delete("MC DONALDS");
			
//			 --------SELECTBYCNPJ EMPRESA-------- // FUNCIONANDO!
//			Empresa empresas = empresa.selectByCNPJ("9876543210112");
//			System.out.println("Nome da Empresa: " + empresas.getNomeEmpresa());
//			System.out.println("CNPJ Empresa: " + empresas.getCnpjEmpresa());
//			System.out.println("E-mail: " + empresas.getEmailEmpresa());
//			System.out.println("Ramo de Atividade: " + empresas.getRamoAtividade());
//			System.out.println("Data de Cadastro: " + empresas.getDataCadastro());
			
			 // ------ TESTE CADASTRO ENDEREÇO EMPRESA ------ // FUNCIONANDO!!
//		EnderecoEmpresaDAO end_emp = new EnderecoEmpresaDAO();
//		EnderecoEmpresa end = new EnderecoEmpresa ("04421200", "Rua Elizabeth", "Jardim Luso", "São Paulo", "SP", "9876543210112");
//		end_emp.insertEnderecoEmpresa(end);
			
			 // ------ TESTE CADASTRO ENDEREÇO USUARIO ------ // 
//		EnderecoClienteDAO end_cli = new EnderecoClienteDAO();
//		EnderecoCliente end = new EnderecoCliente ("04421220", "Rua Maria Tereza", "Jardim Luso", "São Paulo", "SP", "29134806256");
//		end_cli.insertEnderecoCliente(end);
			
			
			 // ------ TESTE CADASTRO CONTA AGUA USUARIO ------ // FUNCIONANDO!
//		ContaAguaUsuarioDAO cont_usu = new ContaAguaUsuarioDAO();
//		ContaAgua end = new ContaAgua("08721254", 258.15, 225.99 , "Outono", "29134806256", "05/01/2024");
//		cont_usu.insertContaAguaUsu(end);

			// ------ TESTE DELETE CONTA AGUA------ // FUNCIONANDO!
//			cont_usu.deleteContaAgua("29134806256");

//			List<ContaAgua> contas = cont_usu.selectContasByCPF("29134806256");
//
//            for (ContaAgua conta : contas) {
//                System.out.println("CPF: " + conta.getCpf());
//                System.out.println("Período de Consumo: " + conta.getPeriodo_consumo());
//                System.out.println("Valor da Conta: " + conta.getValor());
//                System.out.println("Consumo Metros Cubicos: " + conta.getConsumo_metros_cubicos());
//                System.out.println("Estação: " + conta.getEstacao());
//                System.out.println("Data de Cadastro: " + conta.getData());
//                System.out.println("Data de Refêrencia: " + conta.getDataRef());
//                System.out.println("-------------------------------------");
//            }
			 // ------ TESTE CADASTRO CONTA ENERGIA USUARIO ------ // FUNCIONANDO!
//		ContaEnergiaUsuDAO cont_usu = new ContaEnergiaUsuDAO();
//		ContaEnergia end = new ContaEnergia("08721254", 258.15, "225.99" , "Outono", "29134806256", "05/01/2024");
//		cont_usu.insertContaEnergiaUsu(end);
			
			 // ------ TESTE CADASTRO CONTA ENERGIA EMPRESA ------ // FUNCIONANDO!
//			ContaEnergiaEmpDAO cont_emp = new ContaEnergiaEmpDAO();
//			ContaEnergiaEmp end = new ContaEnergiaEmp("08721254", 258.15, "225.99" , "Outono", "29134806256", "05/01/2024");
//			cont_emp.insertContaEnergiaEmp(end);
			
}
}
