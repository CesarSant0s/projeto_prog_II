package negocio;

import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Pedido;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPedido;
import repositorioArray.RepositorioPedidoArray;

public class ControlePedidos {
	RepositorioPedido pedidos = new RepositorioPedidoArray();

	public void FazerPedido(Pedido pedido) throws PedidoJaInseridoException, PedidoVazioException {

		pedidos.inserir(pedido);

	}

	public void inserirPratoPedido(int codigoDoPedido, Prato prato)
			throws PratoVazioException, PratoJaInseridoException, PedidoNaoCadastrado {
		pedidos.buscar(codigoDoPedido).getPratosEscolhidos().inserir(prato);
	}

	public void finalizarPedido(int codigo) throws PedidoNaoCadastrado {

		pedidos.remover(codigo);

	}

	public Pedido buscar(int codigo) throws PedidoNaoCadastrado {

		Pedido resultadoBuscar = pedidos.buscar(codigo);

		return resultadoBuscar;

	}

	public void alterar(Pedido pedido) throws PedidoVazioException, PedidoNaoCadastrado {

		pedidos.alterar(pedido);

	}

	public Pedido[] listar() {

		return pedidos.listar();

	}

}
