package negocio;

import repositorio.RepositorioPedido;
import repositorio.RepositorioPedidoArray;

public class ControlePedidos {
	RepositorioPedido pedidos = new RepositorioPedidoArray();

	public void FazerPedido(Pedido pedido) {
		if (pedido != null && (pedidos.buscar(pedido.getCodigo()) == null)) {
			pedidos.inserir(pedido);
		} else {

		}

	}

	public void remover(int codigo) {

		pedidos.remover(codigo);

	}

	public Pedido buscar(int codigo) {

		Pedido resultadoBuscar = pedidos.buscar(codigo);

		if (resultadoBuscar != null) {
			return resultadoBuscar;
		} else {
			return resultadoBuscar;
		}

	}

	public void alterar(Pedido pedido) {

		if (pedido != null && (pedidos.buscar(pedido.getCodigo()) != null)) {
			pedidos.alterar(pedido);
		} else {

		}
	}

	public Pedido[] listar() {

		return pedidos.listar();

	}

}
