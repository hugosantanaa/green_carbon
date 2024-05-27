package br.com.unip.controller;

import java.util.List;

import br.com.unip.model.Cliente;
import br.com.unip.repository.ClienteDAO;


public class UsuarioController {
	
	private ClienteDAO clienteDAO;

	public UsuarioController() {
		clienteDAO = new ClienteDAO();
	}

	public void cadastrarCliente(Cliente cliente) {
		clienteDAO.insertCliente(cliente);
	}

	public void atualizarCliente(Cliente cliente) {
		clienteDAO.updateCliente(cliente);
	}

	public void excluirCliente(String cpf) {
		clienteDAO.delete(cpf);
	}

	public List<Cliente> listarTodosClientes() {
		return clienteDAO.selectAll();
	}

	public Cliente buscarPorCPF(String cpf) {
		return clienteDAO.selectByCPF(cpf);
	}

}
