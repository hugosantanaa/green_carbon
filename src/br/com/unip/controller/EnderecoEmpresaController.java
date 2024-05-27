package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.EnderecoEmpresa;
import br.com.unip.repository.EnderecoEmpresaDAO;

public class EnderecoEmpresaController {
	
	private EnderecoEmpresaDAO enderecoEmpresaDAO;

	public EnderecoEmpresaController() {
		enderecoEmpresaDAO = new EnderecoEmpresaDAO();
	}

	public void cadastrarEndereco(EnderecoEmpresa endEmpresa) {
		enderecoEmpresaDAO.insertEnderecoEmpresa(endEmpresa);
	}

	public void atualizarEndereco(EnderecoEmpresa endEmpresa) {
		enderecoEmpresaDAO.updateEnderecoEmpresa(endEmpresa);
	}

	public void excluirEndereco(String cnpj) {
		enderecoEmpresaDAO.delete(cnpj);
	}
	
	//LISTA TODAS AS EMPRESAS CADASTRADAS NO BANCO DE DADOS
	public List<EnderecoEmpresa> listarTodosEnderecos() {
		return enderecoEmpresaDAO.selectAll();
	}

	public EnderecoEmpresa buscarPorCNPJ(String cnpj) {
		return enderecoEmpresaDAO.selectByCNPJ(cnpj);
	}

}
