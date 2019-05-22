package negocio;

import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class ControlePratos {

	RepositorioPratos pratos = new RepositorioPratosArray();

	public void inserir(Prato prato) throws PratoVazioException, PratoJaInseridoException {

		pratos.inserir(prato);

	}

	public void remover(String nome) throws PratoNaoEncontradoException {

		pratos.remover(nome);

	}

	public Prato buscar(String nome) throws PratoNaoEncontradoException {
		Prato resultadoBusca = pratos.buscar(nome);

		return resultadoBusca;

	}

	public void alterar(Prato prato) throws PratoVazioException, PratoNaoEncontradoException {

		pratos.alterar(prato);

	}

	public Prato[] listar() {
		return pratos.listar();
	}
}
