package negocio;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import excepitonRepositorioArray.QuantidadeIndisponívelException;
import negocioClassesBasicas.Loja;
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

	public void finalizarPedido(int codigo) throws PedidoNaoCadastrado, PratoNaoEncontradoException,
			LojaNaoCadastradaException, QuantidadeIndisponívelException {

		Prato[] array = pedidos.buscar(codigo).getPratosEscolhidos().listar();

		String cnpjLoja = pedidos.buscar(codigo).getLoja().getCnpj();

		for (int i = 0, j = array.length; i < j; i++) {

			Fachada.getInstance().buscarLoja(cnpjLoja).getCardapio().buscar(array[i].getNome()).retirarStock(1);

		}

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
