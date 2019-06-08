package negocio;

import java.util.List;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocioClassesBasicas.Loja;
import repositorioArray.RepositorioLojaArray;

public class ControleLoja {

	private static ControleLoja instance;

	public static ControleLoja getInstance() {
		if (ControleLoja.instance == null) {
			ControleLoja.instance = new ControleLoja();
		}
		return ControleLoja.instance;
	}

	public void inserir(Loja loja) throws LojaVaziaException, LojaJaCadastradaException {

		RepositorioLojaArray.getInstance().inserir(loja);

	}

	public void remover(String cnpj) throws LojaNaoCadastradaException {
		RepositorioLojaArray.getInstance().remover(cnpj);
	}

	public Loja buscar(String cnpj) throws LojaNaoCadastradaException {
		Loja resultadoBusca = RepositorioLojaArray.getInstance().buscar(cnpj);

		return resultadoBusca;

	}

	public void alterar(Loja loja) throws LojaVaziaException, LojaNaoCadastradaException {

		RepositorioLojaArray.getInstance().alterar(loja);

	}

	public List<Loja> listar() {
		return RepositorioLojaArray.getInstance().listarLoja();
	}
}
