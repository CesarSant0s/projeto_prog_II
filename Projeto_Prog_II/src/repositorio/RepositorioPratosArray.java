package repositorio;

import dados.Pedido;
import dados.Prato;

public class RepositorioPratos {

	private Prato[] cardapio;
	private int quantidadePratos;

	public RepositorioPratos() {
		cardapio = new Prato[100];
		quantidadePratos = 0;
	}

	public void inserirPrato(Prato prato) {
		if (quantidadePratos > 0) {
			if (!(prato == null) && !(prato.equals(buscarPrato(prato.getNome())))) {
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

	public void removerPrato(String nomePrato) {
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

	public Prato buscarPrato(String nomePrato) {
		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (nomePrato.equals(cardapio[i].getNome())) {
				return cardapio[i];
			}
		}
		return null;
	}

	public void alterarPrato(Prato novoPrato) {
		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (novoPrato.getNome().equals(cardapio[i].getNome())) {
				cardapio[i] = novoPrato;
			}
		}

	}

	public Prato[] listarPedido() {
		return cardapio;
	}
}
