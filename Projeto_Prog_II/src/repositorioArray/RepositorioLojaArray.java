package repositorioArray;

import classesBasicasNegocio.Loja;
import repositorio.RepositorioLoja;

public class RepositorioLojaArray implements RepositorioLoja {
	private Loja[] array;
	private int indice;
	private static final int TAMANHO = 100;

	public RepositorioLojaArray() {
		array = new Loja[TAMANHO];
	}

	@Override
	public void inserir(Loja loja) {

		this.array[indice] = loja;
		indice++;

	}

	@Override
	public void remover(String cnpj) {
		for (int i = 0, j = indice; i < j; i++) {
			if (cnpj.equals(array[i].getCnpj())) {
				array[i] = array[indice];
				array[--indice] = null;
				indice--;
			}
		}
	}

	@Override
	public Loja buscar(String cnpj) {

		if (indice > 0) {
			for (int i = 0, j = indice; i < j; i++) {
				if (cnpj.equals(array[i].getCnpj())) {
					return array[i];
				}
			}

		}
		return null;

	}

	@Override
	public void alterar(Loja novoLoja) {
		for (int i = 0, j = indice; i < j; i++) {
			if (novoLoja.getCnpj().equals(array[i].getCnpj())) {
				array[i] = novoLoja;
			}
		}

	}

	@Override
	public Loja[] listarLoja() {
		return array;
	}

}
