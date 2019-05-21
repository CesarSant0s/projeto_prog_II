package negocio;

import negocioClassesBasicas.Pedido;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPedido;
import repositorioArray.RepositorioPedidoArray;

public class ControlePedidos {
	RepositorioPedido pedidos = new RepositorioPedidoArray();

	public void FazerPedido(Pedido pedido) {

		pedidos.inserir(pedido);

	}

	public void inserirPratoPedido(int codigoDoPedido, Prato prato) {
		pedidos.buscar(codigoDoPedido).getPratosEscolhidos().inserir(prato);
	}

	public void finalizarPedido(int codigo) {

		pedidos.remover(codigo);

	}

	public Pedido buscar(int codigo) {

		Pedido resultadoBuscar = pedidos.buscar(codigo);

		return resultadoBuscar;

	}

	public void alterar(Pedido pedido) {

		pedidos.alterar(pedido);

	}

	public Pedido[] listar() {

		return pedidos.listar();

	}

}
