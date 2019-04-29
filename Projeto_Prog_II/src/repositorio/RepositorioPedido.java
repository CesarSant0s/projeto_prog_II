package repositorio;

import dados.Pedido;

public class RepositorioPedido {
	private Pedido[] pedido;
	private int quantidadePedido;

	public RepositorioPedido() {
		pedido = new Pedido[100];
	}

	public void inserirPedido(Pedido pedido) {
		if (!(pedido == null) && !(pedido.equals(buscarPedido(pedido.getCodigo())))) {
			this.pedido[quantidadePedido] = pedido;
			quantidadePedido++;
		}
	}

	public void removerPedido(int codigo) {
		for (int i = 0, j = quantidadePedido; i < j; i++) {
			if (codigo == pedido[i].getCodigo()) {
				pedido[i] = null;
				for (int k = i; k < j; k++) {
					pedido[k] = pedido[++k];
				}
				quantidadePedido--;
			}
		}
	}

	public Pedido buscarPedido(int codigo) {
		for (int i = 0, j = quantidadePedido; i < j; i++) {
			if (codigo == pedido[i].getCodigo()) {
				return pedido[i];
			}
		}
		return null;
	}
}
