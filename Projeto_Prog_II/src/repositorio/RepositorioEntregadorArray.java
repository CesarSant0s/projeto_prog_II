package repositorio;

import dados.Entregador;
import dados.Entregador;
import dados.Entregador;

public class RepositorioEntregador {
	private Entregador[] entregador;
	private int quantidadeEntregador;

	public RepositorioEntregador() {
		// TODO Auto-generated constructor stub
		entregador = new Entregador[100];
	}

	public void inserirEntregador(Entregador novoEntregador) {

		if (quantidadeEntregador > 0) {
			if (!(novoEntregador == null)
					&& !(novoEntregador.getCpf().equals((buscarEntregador(novoEntregador.getCpf())).getCpf()))) {
				entregador[quantidadeEntregador] = novoEntregador;
				quantidadeEntregador++;
			}
		} else {
			if (!(novoEntregador == null)) {
				entregador[quantidadeEntregador] = novoEntregador;
				quantidadeEntregador++;
			}

		}
	}

	public void removerEntregador(String cpf) {
		for (int i = 0, j = quantidadeEntregador; i < j; i++) {
			if (cpf.equals(entregador[i].getCpf())) {
				entregador[i] = null;
				for (int k = i; k < j; k++) {
					entregador[k] = entregador[++k];
				}
				quantidadeEntregador--;
			}
		}

	}

	public Entregador buscarEntregador(String cpf) {
		for (int i = 0, j = quantidadeEntregador; i < j; i++) {
			if (cpf.equals(entregador[i].getCpf())) {
				return entregador[i];
			}
		}
		return null;
	}

	public void alterarEntregador(Entregador novoEntregador) {
		for (int i = 0, j = quantidadeEntregador; i < j; i++) {
			if (novoEntregador.getCpf().equals(entregador[i].getCpf())) {
				entregador[i] = novoEntregador;
			}
		}

	}

	public Entregador[] listarEntregador() {
		return entregador;
	}
}
