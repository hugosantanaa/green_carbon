package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.ContaEnergiaEmp;
import br.com.unip.repository.ContaEnergiaEmpDAO;

public class ContaEnergiaEmpresaController {
	
	private ContaEnergiaEmpDAO contaEnergiaDAO;

	public ContaEnergiaEmpresaController() {
		contaEnergiaDAO = new ContaEnergiaEmpDAO();
	}

	public void cadastrarConta(ContaEnergiaEmp contEnergia) {
		contaEnergiaDAO.insertContaEnergiaEmp(contEnergia);
	}

	public void atualizarConta(ContaEnergiaEmp contEnergia) {
		contaEnergiaDAO.updateContaEnergiaEmp(contEnergia);
	}

	public void excluirConta(String cpf) {
		contaEnergiaDAO.deleteContaEnergiaEmp(cpf);
	}
	
	//LISTA TODAS AS CONTAS CADASTRADAS NO BANCO DE DADOS
	public List<ContaEnergiaEmp> listarTodasContas() {
		return contaEnergiaDAO.selectAll();
	}

	public ContaEnergiaEmp buscarPorCNPJ(String cnpj) {
		return contaEnergiaDAO.selectByCNPJ(cnpj);
	}

}
