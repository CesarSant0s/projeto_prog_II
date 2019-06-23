package negocioClassesBasicas;

import java.io.Serializable;
import java.util.ArrayList;

import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioLojaArray;
import repositorioArray.RepositorioPratosArray;

public class Loja implements RepositorioPratos, Serializable {

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

	@Override
	public boolean equals(Object obj) {
		Loja loja = (Loja) obj;
		if (loja.getCnpj().equals(this.cnpj) && loja.getEndereco().equals(this.cnpj) && loja.getNome().equals(this.nome)
				&& loja.getTelefone().equals(this.telefone)) {
			return true;
		}
		return false;
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

	@Override
	public void inserir(Prato prato) throws PratoVazioException, PratoJaInseridoException {
		cardapio.inserir(prato);
		RepositorioLojaArray.salvarArquivo();
	}

	@Override
	public void remover(String nomePrato) throws PratoNaoEncontradoException {
		cardapio.remover(nomePrato);
		RepositorioLojaArray.salvarArquivo();
	}

	@Override
	public Prato buscar(String nomePrato) throws PratoNaoEncontradoException {
		return cardapio.buscar(nomePrato);
	}

	@Override
	public void alterar(Prato novoPrato) throws PratoVazioException, PratoNaoEncontradoException {
		cardapio.alterar(novoPrato);
		RepositorioLojaArray.salvarArquivo();
	}

	@Override
	public ArrayList<Prato> listar() {
		return cardapio.listar();
	}

}
