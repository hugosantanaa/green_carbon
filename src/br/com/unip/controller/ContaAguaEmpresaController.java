package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.ContaAgua;
import br.com.unip.model.ContaAguaEmp;
import br.com.unip.repository.ContaAguaEmpDAO;

public class ContaAguaEmpresaController {
	private ContaAguaEmpDAO contaAguaEmpDAO;

	public ContaAguaEmpresaController() {
		contaAguaEmpDAO = new ContaAguaEmpDAO();
	}

	public void cadastrarConta(ContaAguaEmp contAgua) {
		contaAguaEmpDAO.insertContaAguaEmp(contAgua);
	}

	public void atualizarConta(ContaAguaEmp contAgua) {
		contaAguaEmpDAO.updateContaAguaEmp(contAgua);
	}

	public void excluirConta(String cnpj) {
		contaAguaEmpDAO.deleteContaAguaEmp(cnpj);
	}
	
	//LISTA TODAS AS CONTAS CADASTRADAS NO BANCO DE DADOS
	public List<ContaAguaEmp> listarTodasContas() {
		return contaAguaEmpDAO.selectAll();
	}

	public ContaAgua buscarPorCNPJ(String cnpj) {
		return contaAguaEmpDAO.selectByCPF(cnpj);
	}

}
