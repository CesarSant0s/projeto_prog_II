package negocio;

import negocioClassesBasicas.Prato;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class ControlePratos {

	RepositorioPratos pratos = new RepositorioPratosArray();

	public void inserir(Prato prato) {

		pratos.inserir(prato);

	}

	public void remover(String nome) {

		pratos.remover(nome);

	}

	public Prato buscar(String nome) {
		Prato resultadoBusca = pratos.buscar(nome);

		return resultadoBusca;

	}

	public void alterar(Prato prato) {

		pratos.alterar(prato);

	}

	public Prato[] listar() {
		return pratos.listar();
	}
}
