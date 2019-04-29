package repositorio;

import dados.Cliente;

public class RepositorioCliente {

	private Cliente[] cliente;
	private int quantidadeCliente;

	public RepositorioCliente() {
		cliente = new Cliente[100];
	}

	public void inserirCliente(Cliente novoCliente) {
		if (!(novoCliente == null) && !(novoCliente.getCpf().equals((buscarCliente(novoCliente.getCpf())).getCpf()))) {
			cliente[quantidadeCliente] = novoCliente;
			quantidadeCliente++;
		}

	}

	public void removerCliente(String cpf) {
		for (int i = 0, j = quantidadeCliente; i < j; i++) {
			if (cpf.equals(cliente[i].getCpf())) {
				cliente[i] = null;
				for (int k = i; k < j; k++) {
					cliente[k] = cliente[++k];
				}
				quantidadeCliente--;
			}
		}

	}

	public Cliente buscarCliente(String cpf) {
		for (int i = 0, j = quantidadeCliente; i < j; i++) {
			if (cpf.equals(cliente[i].getCpf())) {
				return cliente[i];
			}
		}
		return null;
	}

}
