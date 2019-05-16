package negocio;

import repositorio.RepositorioPedido;
import repositorio.RepositorioPedidoArray;

public class ControlePedidos {
	RepositorioPedido pedidos = new RepositorioPedidoArray();

	public void FazerPedido(Cliente cliente, Loja loja, Entregador entregador) {
		
		Pedido novoPedido= new Pedido(cliente, loja, entregador);
		
	}
	
	public void inserir(Pedido pedido) {
		// Incluir validacoes e regras de negocio
		pedidos.inserir(pedido);
	}

	public void remover(int codigo) {
		// Incluir validacoes e regras de negocio
		pedidos.remover(codigo);
	}

	public Pedido buscar(int codigo) {
		// Incluir validacoes e regras de negocio
		return pedidos.buscar(codigo);
	}

	public void alterar(Pedido pedido) {
		// Incluir validacoes e regras de negocio
		pedidos.alterar(pedido);
	}

	public Pedido[] listar() {
		// Incluir validacoes e regras de negocio
		return pedidos.listar();
	}

}
