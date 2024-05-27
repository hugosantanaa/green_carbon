package br.com.unip.model;

import java.sql.Date;
	
	public class Cliente {

		private String cpfCliente, nomeCliente, dataNascimento, emailCliente, senhaCliente, telefoneCliente, generoCliente;
		private Date data;

		public Cliente(String nomeCliente, String cpfCliente, String dataNascimento, String emailCliente, String senhaCliente,
				String telefoneCliente, String generoCliente) {

			this.nomeCliente = nomeCliente;
			this.cpfCliente = cpfCliente;
			this.dataNascimento = dataNascimento;
			this.emailCliente = emailCliente;
			this.senhaCliente = senhaCliente;
			this.telefoneCliente = telefoneCliente;
			this.generoCliente = generoCliente;
			
			//PEGA AUTOMATICAMENTE 
			this.data = new Date(System.currentTimeMillis());
		}

		public String getCpfCliente() {
			return cpfCliente;
		}

		public void setCpfCliente(String cpfCliente) {
			this.cpfCliente = cpfCliente;
		}

		public String getNomeCliente() {
			return nomeCliente;
		}

		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getEmailCliente() {
			return emailCliente;
		}
		
		public void setEmailCliente(String emailCliente) {
			this.emailCliente = emailCliente;
		}

		public void setSenhaCliente(String senhaCliente) {
			this.senhaCliente = senhaCliente;
		}
		
		public String getSenhaCliente() {
			return senhaCliente;
		}

		public String getTelefoneCliente() {
			return telefoneCliente;
		}

		public void setTelefoneCliente(String telefoneCliente) {
			this.telefoneCliente = telefoneCliente;
		}

		public String getGeneroCliente() {
			return generoCliente;
		}

		public void setGeneroCliente(String generoCliente) {
			this.generoCliente = generoCliente;
		}

		public Date getDataCadastro() {
			return data;
		}

		public void setDataCadastro(Date dataCadastro) {
			this.data = dataCadastro;
		}

		public Cliente() {
			// CONSTRUTOR VAZIO
		}

	}

