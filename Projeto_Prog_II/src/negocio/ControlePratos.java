package negocio;

import classesBasicasNegocio.Prato;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class ControlePratos {

	RepositorioPratos pratos = new RepositorioPratosArray();

	public void inserir(Prato prato) {

		if (prato != null && pratos.buscar(prato.getNome()) == null) {
			pratos.inserir(prato);
		} else {

		}

	}

	public void remover(String nome) {

		pratos.remover(nome);

	}

	public Prato buscar(String nome) {
		Prato resultadoBusca = pratos.buscar(nome);

		if (resultadoBusca != null) {
			return resultadoBusca;
		} else {
			return resultadoBusca;
		}

	}

	public void alterar(Prato prato) {

		if (prato != null && pratos.buscar(prato.getNome()) != null) {
			pratos.alterar(prato);
		} else {

		}

	}

	public Prato[] listar() {
		return pratos.listar();
	}
}
