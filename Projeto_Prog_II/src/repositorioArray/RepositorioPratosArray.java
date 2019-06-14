package repositorioArray;

import java.util.ArrayList;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPratos;

public class RepositorioPratosArray implements RepositorioPratos {

	private Prato[] cardapio;
	private int quantidadePratos;

	public RepositorioPratosArray() {
		cardapio = new Prato[100];
	}

	public void inserir(Prato prato) throws PratoVazioException, PratoJaInseridoException {

		if (prato == null) {

			PratoVazioException e = new PratoVazioException();
			throw e;

		} else {

			Prato resultadoPrato = null;

			for (int i = 0; i < quantidadePratos; i++) {
				if (prato.getNome().equals(cardapio[i].getNome())) {
					resultadoPrato = cardapio[i];

				}
			}

			if (resultadoPrato != null) {

				PratoJaInseridoException e = new PratoJaInseridoException(prato.getNome());
				throw e;
			} else {
				cardapio[quantidadePratos] = prato;
				quantidadePratos++;
			}

		}

	}

	public void remover(String nomePrato) throws PratoNaoEncontradoException {

		buscar(nomePrato);

		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (nomePrato.equals(cardapio[i].getNome())) {

				cardapio[i] = cardapio[quantidadePratos];
				cardapio[--quantidadePratos] = null;
				quantidadePratos--;

			}
		}
	}

	public Prato buscar(String nomePrato) throws PratoNaoEncontradoException {

		Prato resultadoPrato = null;

		if (quantidadePratos > 0) {
			for (int i = 0, j = quantidadePratos; i < j; i++) {
				if (nomePrato.equals(cardapio[i].getNome())) {
					resultadoPrato = cardapio[i];
				}
			}
		} else {
			resultadoPrato = null;
		}

		if (resultadoPrato == null) {
			PratoNaoEncontradoException e = new PratoNaoEncontradoException();
			throw e;
		} else {
			return resultadoPrato;
		}

	}

	public void alterar(Prato novoPrato) throws PratoVazioException, PratoNaoEncontradoException {

		if (novoPrato == null) {

			PratoVazioException e = new PratoVazioException();
			throw e;

		} else {

			buscar(novoPrato.getNome());

			for (int i = 0, j = quantidadePratos; i < j; i++) {
				if (novoPrato.getNome().equals(cardapio[i].getNome())) {
					cardapio[i] = novoPrato;
				}

			}

		}

	}

	public ArrayList<Prato> listar() {

		ArrayList<Prato> pratos = new ArrayList<Prato>();
		int i = 0;
		while (i < quantidadePratos) {
			pratos.add(cardapio[i]);
			i++;
		}
		return pratos;
	}
}
