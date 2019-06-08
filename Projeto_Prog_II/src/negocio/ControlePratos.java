package negocio;

import java.util.List;

import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class ControlePratos {

	public void inserir(Prato prato) throws PratoVazioException, PratoJaInseridoException {
		RepositorioPratosArray.getInstance().inserir(prato);
	}

	public void remover(String nome) throws PratoNaoEncontradoException {
		RepositorioPratosArray.getInstance().remover(nome);
	}

	public Prato buscar(String nome) throws PratoNaoEncontradoException {
		Prato resultadoBusca = RepositorioPratosArray.getInstance().buscar(nome);
		return resultadoBusca;
	}

	public void alterar(Prato prato) throws PratoVazioException, PratoNaoEncontradoException {
		RepositorioPratosArray.getInstance().alterar(prato);
	}

	public List<Prato> listar() {
		return RepositorioPratosArray.getInstance().listar();
	}
}
