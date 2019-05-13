package repositorio;

import dados.Loja;

public class RepositorioLoja {
	private Loja[] loja;
	private int quantidadeLoja;

	public RepositorioLoja() {
		loja = new Loja[100];
	}

	public void inserirLoja(Loja novaLoja) {
		if (quantidadeLoja > 0) {
			if (!(novaLoja == null) && !(novaLoja.getCnpj().equals((buscarLoja(novaLoja.getCnpj())).getCnpj()))) {
				loja[quantidadeLoja] = novaLoja;
				quantidadeLoja++;
			}

		} else {
			if (!(novaLoja == null)) {
				loja[quantidadeLoja] = novaLoja;
				quantidadeLoja++;
			}

		}

	}

	public void removerLoja(String cnpj) {
		for (int i = 0, j = quantidadeLoja; i < j; i++) {
			if (cnpj.equals(loja[i].getCnpj())) {
				loja[i] = null;
				for (int k = i; k < j; k++) {
					loja[k] = loja[++k];
				}
				quantidadeLoja--;
			}
		}

	}

	public Loja buscarLoja(String cnpj) {
		for (int i = 0, j = quantidadeLoja; i < j; i++) {
			if (cnpj.equals(loja[i].getCnpj())) {
				return loja[i];
			}
		}
		return null;
	}

	public void alterarLoja(Loja novoLoja) {
		for (int i = 0, j = quantidadeLoja; i < j; i++) {
			if (novoLoja.getCnpj().equals(loja[i].getCnpj())) {
				loja[i] = novoLoja;
			}
		}

	}

	public Loja[] listarLoja() {
		return loja;
	}

}
