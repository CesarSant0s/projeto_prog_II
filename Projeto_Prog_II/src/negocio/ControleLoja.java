package negocio;

import repositorio.RepositorioLoja;
import repositorio.RepositorioLojaArray;

public class ControleLoja {

	RepositorioLoja lojas = new RepositorioLojaArray();

	public void inserir(Loja loja) {
		if (loja != null && lojas.buscar(loja.getCnpj()) == null) {
			lojas.inserir(loja);
		} else {

		}
	}

	public void remover(String cnpj) {
		lojas.remover(cnpj);
	}

	public Loja buscar(String cnpj) {
		Loja resultadoBusca = lojas.buscar(cnpj);

		if (resultadoBusca != null) {
			return resultadoBusca;
		} else {
			return resultadoBusca;
		}

	}

	public void alterar(Loja loja) {

		if (loja != null && lojas.buscar(loja.getCnpj()) != null) {
			lojas.alterar(loja);
		} else {

		}

	}

	public Loja[] listar() {
		return lojas.listarLoja();
	}
}
