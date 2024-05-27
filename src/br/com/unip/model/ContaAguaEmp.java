package br.com.unip.model;

import java.sql.Date;

public class ContaAguaEmp {
	private String periodo_consumo, estacao, cnpj, dataRef;
	private Double valor, consumo_metros_cubicos;
	private Date data;


	public ContaAguaEmp(String periodo_consumo, Double valor, Double consumo_metros_cubicos, String estacao, String cnpj, String dataRef) {
		this.periodo_consumo = periodo_consumo;
		this.valor = valor;
		this.consumo_metros_cubicos = consumo_metros_cubicos;
		this.estacao = estacao;
		this.cnpj = cnpj;
		this.dataRef = dataRef;
		
		//PEGA AUTOMATICAMENTE 
				this.data = new Date(System.currentTimeMillis());
	}
	
	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getDataRef() {
		return dataRef;
	}


	public void setDataRef(String dataRef) {
		this.dataRef = dataRef;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getPeriodo_consumo() {
		return periodo_consumo;
	}

	public void setPeriodo_consumo(String periodo_consumo) {
		this.periodo_consumo = periodo_consumo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getConsumo_metros_cubicos() {
		return consumo_metros_cubicos;
	}

	public void setConsumo_metros_cubicos(Double consumo_metros_cubicos) {
		this.consumo_metros_cubicos = consumo_metros_cubicos;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	
	public ContaAguaEmp() {
		//CONSTRUTOR VAZIO
	}

}



