package negocioClassesBasicas;

import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class Loja {

	private String nome;
	private String telefone;
	private String cnpj;
	private String endereco;

	private RepositorioPratos cardapio;

	public Loja(String nome, String telefone, String cnpj, String endereco) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
