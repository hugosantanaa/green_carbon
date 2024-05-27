package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.ContaAgua;
import br.com.unip.repository.ContaAguaUsuarioDAO;

public class ContaAguaUsuarioController {
	
	private ContaAguaUsuarioDAO contaAguaUsuarioDAO;

	public ContaAguaUsuarioController() {
		contaAguaUsuarioDAO = new ContaAguaUsuarioDAO();
	}

	public void cadastrarConta(ContaAgua contAgua) {
		contaAguaUsuarioDAO.insertContaAguaUsu(contAgua);
	}

	public void atualizarConta(ContaAgua contAgua) {
		contaAguaUsuarioDAO.updateContaAguaUsuario(contAgua);
	}

	public void excluirConta(String cpf) {
		contaAguaUsuarioDAO.deleteContaAgua(cpf);
	}
	
	//LISTA TODAS AS CONTAS CADASTRADAS NO BANCO DE DADOS
	public List<ContaAgua> listarTodasContas() {
		return contaAguaUsuarioDAO.selectAll();
	}

	public ContaAgua buscarPorCPF(String cpf) {
		return contaAguaUsuarioDAO.selectByCPF(cpf);
	}

}
