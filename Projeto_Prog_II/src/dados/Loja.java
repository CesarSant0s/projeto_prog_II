package dados;

import repositorio.RepositorioPratos;

public class Loja extends Usuario {
	private String cnpj;
	private String endereco;
	private RepositorioPratos cardapio;

	public Loja(String nomeUsuario, String senha, String nome, String telefone, String cnpj, String endereco) {
		super(nomeUsuario, senha, nome, telefone);
		setCnpj(cnpj);
		setEndereco(endereco);
		setCardapio(new RepositorioPratos());
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

}
