package negocio;

import classesBasicasNegocio.Pedido;
import classesBasicasNegocio.Prato;
import repositorio.RepositorioPedido;
import repositorioArray.RepositorioPedidoArray;

public class ControlePedidos {
	RepositorioPedido pedidos = new RepositorioPedidoArray();

	public void FazerPedido(Pedido pedido) {

		if (pedido != null && (pedidos.buscar(pedido.getCodigo()) == null)) {
			pedidos.inserir(pedido);
		} else {

		}
	}

	public void inserirPratoPedido(int codigoDoPedido, Prato prato) {
		if (prato != null) {
			pedidos.buscar(codigoDoPedido).getPratosEscolhidos().inserir(prato);
		}
	}

	public void finalizarPedido(int codigo) {

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
