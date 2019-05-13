package repositorio;

import negocio.Pedido;

public class RepositorioPedidoArray implements RepositorioPedido {

	private Pedido[] array;
	private int indice;
	private static final int TAMANHO = 100;

	public RepositorioPedidoArray() {
		array = new Pedido[TAMANHO];
	}

	public void inserir(Pedido pedido) {

		if (indice > 0) {
			if (!(pedido == null) && !(array.equals(buscar(pedido.getCodigo())))) {
				this.array[indice] = pedido;
				indice++;
			}
		} else {
			if (!(array == null)) {
				this.array[indice] = pedido;
				indice++;
			}
		}
	}

	public void remover(int codigo) {
		for (int i = 0, j = indice; i < j; i++) {
			if (codigo == array[i].getCodigo()) {
				array[i] = null;
				for (int k = i; k < j; k++) {
					array[k] = array[++k];
				}
				indice--;
			}
		}
	}

	public Pedido buscar(int codigo) {
		for (int i = 0, j = indice; i < j; i++) {
			if (codigo == array[i].getCodigo()) {
				return array[i];
			}
		}
		return null;
	}

	public void alterar(Pedido pedido) {
		for (int i = 0, j = indice; i < j; i++) {
			if (pedido.getCodigo() == array[i].getCodigo()) {
				array[i] = pedido;
			}
		}

	}

	public Pedido[] listar() {
		return array;
	}

}
