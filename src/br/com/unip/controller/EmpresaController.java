package br.com.unip.controller;

import java.util.List;
import br.com.unip.model.Empresa;
import br.com.unip.repository.EmpresaDAO;

public class EmpresaController {
	
		private EmpresaDAO empresaDAO;

		public EmpresaController() {
			empresaDAO = new EmpresaDAO();
		}

		public void cadastrarEmpresa(Empresa empresa) {
			empresaDAO.insertEmpresa(empresa);;
		}

		public void atualizarEmpresa(Empresa empresa) {
			empresaDAO.updateEmpresa(empresa);
		}

		public void excluirEmpresa(String cnpj) {
			empresaDAO.delete(cnpj);
		}
		
		//LISTA TODAS AS EMPRESAS CADASTRADAS NO BANCO DE DADOS
		public List<Empresa> listarTodasEmpresas() {
			return empresaDAO.selectAll();
		}

		public Empresa buscarPorCNPJ(String cnpj) {
			return empresaDAO.selectByCNPJ(cnpj);
		}

	
}
