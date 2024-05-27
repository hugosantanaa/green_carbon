package br.com.unip.model;

import java.sql.Date;

public class ContaEnergiaEmp {
	
	private String periodo_consumo, consumo_kwh, estacao, dataRef, cnpj;
	private Double valor;
	private Date data;

	public ContaEnergiaEmp(String periodo_consumo, Double valor, String consumo_kwh, String estacao, String dataRef, String cnpj) {
		this.periodo_consumo = periodo_consumo;
		this.valor = valor;
		this.consumo_kwh = consumo_kwh;
		this.estacao = estacao;
		this.dataRef = dataRef;
		this.cnpj = cnpj;
		
		//PEGA AUTOMATICAMENTE 
				this.data = new Date(System.currentTimeMillis());
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public String getConsumo_kwh() {
		return consumo_kwh;
	}

	public void setConsumo_kwh(String consumo_kwh) {
		this.consumo_kwh= consumo_kwh;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	
	public ContaEnergiaEmp() {
		//CONSTRUTOR VAZIO
	}


}
