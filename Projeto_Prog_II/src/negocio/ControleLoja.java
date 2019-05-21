package negocio;

import negocioClassesBasicas.Loja;
import repositorio.RepositorioLoja;
import repositorioArray.RepositorioLojaArray;

public class ControleLoja {

	RepositorioLoja lojas = new RepositorioLojaArray();

	public void inserir(Loja loja) {

		lojas.inserir(loja);

	}

	public void remover(String cnpj) {
		lojas.remover(cnpj);
	}

	public Loja buscar(String cnpj) {
		Loja resultadoBusca = lojas.buscar(cnpj);

		return resultadoBusca;

	}

	public void alterar(Loja loja) {

		lojas.alterar(loja);

	}

	public Loja[] listar() {
		return lojas.listarLoja();
	}
}
