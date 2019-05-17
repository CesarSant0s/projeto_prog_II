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
		cardapio[quantidadePratos] = prato;
		quantidadePratos++;
	}

	public void remover(String nomePrato) {
		for (int i = 0, j = quantidadePratos; i < j; i++) {
			if (nomePrato.equals(cardapio[i].getNome())) {

				cardapio[i] = cardapio[quantidadePratos];
				cardapio[quantidadePratos] = null;
				quantidadePratos--;

			}
		}
	}

	public Prato buscar(String nomePrato) {

		if (quantidadePratos > 0)
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
