package repositorio;

import negocio.Cliente;

public class RepositorioClienteArray {

	private Cliente[] cliente;
	private int quantidadeCliente;

	public RepositorioClienteArray() {
		cliente = new Cliente[100];
	}

	public void inserirCliente(Cliente novoCliente) {
		if (quantidadeCliente > 0) {
			if (!(novoCliente == null)
					&& !(novoCliente.getCpf().equals((buscarCliente(novoCliente.getCpf())).getCpf()))) {
				cliente[quantidadeCliente] = novoCliente;
				quantidadeCliente++;
			}
		} else {
			if (!(novoCliente == null)) {
				cliente[quantidadeCliente] = novoCliente;
				quantidadeCliente++;
			}
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

	public void alterarCliente(Cliente novoCliente) {
		for (int i = 0, j = quantidadeCliente; i < j; i++) {
			if (novoCliente.getCpf().equals(cliente[i].getCpf())) {
				cliente[i] = novoCliente;
			}
		}

	}

	public Cliente[] listarCliente() {
		return cliente;
	}

}
