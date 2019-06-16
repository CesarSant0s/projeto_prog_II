package negocio;

import java.util.List;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocioClassesBasicas.Loja;
import repositorio.RepositorioLoja;
import repositorioArray.RepositorioLojaArray;

public class ControleLoja {

	private RepositorioLoja lojas;

	public ControleLoja() {
		lojas = RepositorioLojaArray.getInstance();
	}

	public void inserir(Loja loja) throws LojaVaziaException, LojaJaCadastradaException {

		lojas.inserir(loja);
		RepositorioLojaArray.salvarArquivo();

	}

	public void remover(String cnpj) throws LojaNaoCadastradaException {
		lojas.remover(cnpj);
		RepositorioLojaArray.salvarArquivo();
	}

	public Loja buscar(String cnpj) throws LojaNaoCadastradaException {
		Loja resultadoBusca = lojas.buscar(cnpj);

		return resultadoBusca;

	}

	public void alterar(Loja loja) throws LojaVaziaException, LojaNaoCadastradaException {

		lojas.alterar(loja);
		RepositorioLojaArray.salvarArquivo();

	}

	public List<Loja> listar() {
		return lojas.listarLoja();
	}
}
