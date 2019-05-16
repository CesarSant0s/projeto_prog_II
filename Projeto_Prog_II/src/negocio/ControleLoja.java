package negocio;

import repositorio.RepositorioLoja;
import repositorio.RepositorioLojaArray;

public class ControleLoja {

	RepositorioLoja lojas = new RepositorioLojaArray();

	public void inserir(Loja loja) {
		lojas.inserir(loja);
	}

	public void remover(String cnpj) {
		lojas.remover(cnpj);
	}

	public Loja buscar(String cnpj) {
		return lojas.buscar(cnpj);
	}

	public void alterar(Loja loja) {
		lojas.alterar(loja);
	}

	public Loja[] listar() {
		return lojas.listarLoja();
	}
}
