package repositorio;

import negocio.Prato;

public class RepositorioPratosArray implements RepositorioPratos {

	private Prato[] cardapio;
	private int quantidadePratos;

	public RepositorioPratosArray() {
		cardapio = new Prato[100];
		quantidadePratos = 0;
	}

	public void inserir(Prato prato) {
		if (quantidadePratos > 0) {
			if (!(prato == null) && !(prato.equals(buscar(prato.getNome())))) {
				cardapio[quantidadePratos] = prato;
				quantidadePratos++;
			}
		} else {
			if (!(prato == null)) {
				cardapio[quantidadePratos] = prato;
				quantidadePratos++;
			}
		}
	}

	public void remover(String nomePrato) {
		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (nomePrato.equals(cardapio[i].getNome())) {
				cardapio[i] = null;
				for (int k = i; k < j; k++) {
					cardapio[k] = cardapio[++k];
				}
				quantidadePratos--;
			}
		}
	}

	public Prato buscar(String nomePrato) {
		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (nomePrato.equals(cardapio[i].getNome())) {
				return cardapio[i];
			}
		}
		return null;
	}

	public void alterar(Prato novoPrato) {
		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (novoPrato.getNome().equals(cardapio[i].getNome())) {
				cardapio[i] = novoPrato;
			}
		}

	}

	public Prato[] listar() {
		return cardapio;
	}
}
