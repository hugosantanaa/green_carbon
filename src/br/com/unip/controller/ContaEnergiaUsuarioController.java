package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.ContaEnergia;
import br.com.unip.repository.ContaEnergiaUsuDAO;

public class ContaEnergiaUsuarioController {
	
	private ContaEnergiaUsuDAO contaEnergiaDAO;

	public ContaEnergiaUsuarioController() {
		contaEnergiaDAO = new ContaEnergiaUsuDAO();
	}

	public void cadastrarConta(ContaEnergia contEnergia) {
		contaEnergiaDAO.insertContaEnergiaUsu(contEnergia);
	}

	public void atualizarConta(ContaEnergia contEnergia) {
		contaEnergiaDAO.updateContaEnergia(contEnergia);
	}

	public void excluirConta(String cpf) {
		contaEnergiaDAO.deleteContaEnergiaUsu(cpf);
	}
	
	//LISTA TODAS AS CONTAS CADASTRADAS NO BANCO DE DADOS
	public List<ContaEnergia> listarTodasContas() {
		return contaEnergiaDAO.selectAll();
	}

	public ContaEnergia buscarPorCPF(String cpf) {
		return contaEnergiaDAO.selectByCPF(cpf);
	}

}
