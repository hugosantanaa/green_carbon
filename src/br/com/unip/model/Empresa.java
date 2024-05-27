package br.com.unip.model;

import java.sql.Date;

public class Empresa {

	private String cnpjEmpresa, nomeEmpresa, emailEmpresa, senhaEmpresa, ramoAtividade;
	private Date data;

	public Empresa(String cnpjEmpresa, String nomeEmpresa, String emailEmpresa,
			String senhaEmpresa, String ramoAtividade) {
		this.cnpjEmpresa = cnpjEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.senhaEmpresa = senhaEmpresa;
		this.ramoAtividade = ramoAtividade;
		this.data = new Date(System.currentTimeMillis());
	}
	
	
	public String getSenhaEmpresa() {
		return senhaEmpresa;
	}


	public void setSenhaEmpresa(String senhaEmpresa) {
		this.senhaEmpresa = senhaEmpresa;
	}


	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}


	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}


	public String getNomeEmpresa() {
		return nomeEmpresa;
	}


	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}


	public String getEmailEmpresa() {
		return emailEmpresa;
	}


	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}


	public String getRamoAtividade() {
		return ramoAtividade;
	}


	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}


	public Date getDataCadastro() {
		return data;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.data = dataCadastro;
	}

	public Empresa() {
		// CONSTRUTOR VAZIO
	}

}


