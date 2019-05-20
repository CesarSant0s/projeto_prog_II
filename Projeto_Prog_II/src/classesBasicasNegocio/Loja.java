package classesBasicasNegocio;

import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class Loja {

	private String nomeUsuario;
	private String senha;
	private String nome;
	private String telefone;
	private String cnpj;
	private String endereco;

	private RepositorioPratos cardapio;

	public Loja(String nomeUsuario, String senha, String nome, String telefone, String cnpj, String endereco) {
		setNomeUsuario(nomeUsuario);
		setSenha(senha);
		setNome(nome);
		setNome(nome);
		setTelefone(telefone);
		setCnpj(cnpj);
		setEndereco(endereco);
		cardapio = new RepositorioPratosArray();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (!(cnpj == null) && !(cnpj.equals("")))
			this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (!(endereco == null) && !(endereco.contentEquals("")))
			this.endereco = endereco;
	}

	public RepositorioPratos getCardapio() {
		return cardapio;
	}

	public void setCardapio(RepositorioPratos cardapio) {
		this.cardapio = cardapio;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		if (!(nomeUsuario == null) && !(nomeUsuario.equals("")))
			this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (!(senha == null) && !(senha.equals("")))
			this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!(nome == null) && !(nome.equals("")))
			this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (!(telefone == null) && !(telefone.equals("")))
			this.telefone = telefone;
	}

}
