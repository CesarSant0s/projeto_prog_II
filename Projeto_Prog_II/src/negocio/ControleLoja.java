package negocio;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocioClassesBasicas.Loja;
import repositorio.RepositorioLoja;
import repositorioArray.RepositorioLojaArray;

public class ControleLoja {

	private static ControleLoja instance;
	private RepositorioLoja lojas;

	public ControleLoja() {
		lojas = new RepositorioLojaArray();
	}

	public static ControleLoja getInstance() {
		if (ControleLoja.instance == null) {
			ControleLoja.instance = new ControleLoja();
		}
		return ControleLoja.instance;
	}

	public void inserir(Loja loja) throws LojaVaziaException, LojaJaCadastradaException {

		lojas.inserir(loja);

	}

	public void remover(String cnpj) throws LojaNaoCadastradaException {
		lojas.remover(cnpj);
	}

	public Loja buscar(String cnpj) throws LojaNaoCadastradaException {
		Loja resultadoBusca = lojas.buscar(cnpj);

		return resultadoBusca;

	}

	public void alterar(Loja loja) throws LojaVaziaException, LojaNaoCadastradaException {

		lojas.alterar(loja);

	}

	public Loja[] listar() {
		return lojas.listarLoja();
	}
}
