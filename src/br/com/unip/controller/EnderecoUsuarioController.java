package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.EnderecoCliente;
import br.com.unip.repository.EnderecoClienteDAO;

public class EnderecoUsuarioController {
	
	private EnderecoClienteDAO enderecoClienteDAO;

	public EnderecoUsuarioController() {
		enderecoClienteDAO = new EnderecoClienteDAO();
	}

	public void cadastrarEndereco(EnderecoCliente endCliente) {
		enderecoClienteDAO.insertEnderecoCliente(endCliente);
	}

	public void atualizarEndereco(EnderecoCliente endCliente) {
		enderecoClienteDAO.updateEnderecoCliente(endCliente);
	}

	public void excluirEndereco(String cpf) {
		enderecoClienteDAO.delete(cpf);
	}
	
	//LISTA TODAS AS EMPRESAS CADASTRADAS NO BANCO DE DADOS
	public List<EnderecoCliente> listarTodosEnderecos() {
		return enderecoClienteDAO.selectAll();
	}

	public EnderecoCliente buscarPorCPF(String cpf) {
		return enderecoClienteDAO.selectByCPF(cpf);
	}

}
