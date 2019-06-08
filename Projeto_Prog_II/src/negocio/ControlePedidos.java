package negocio;

import java.util.ArrayList;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import excepitonRepositorioArray.QuantidadeIndisponivelException;
import negocioClassesBasicas.Pedido;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPedido;
import repositorioArray.RepositorioPedidoArray;

public class ControlePedidos {

	public ControlePedidos() {
	}

	public void FazPeredido(Pedido pedido) throws PedidoJaInseridoException, PedidoVazioException {
		RepositorioPedidoArray.getInstance().inserir(pedido);
	}

	public void inserirPratoPedido(int codigoDoPedido, Prato prato)
			throws PratoVazioException, PratoJaInseridoException, PedidoNaoCadastrado {
		RepositorioPedidoArray.getInstance().buscar(codigoDoPedido).getPratosEscolhidos().inserir(prato);
	}

	public void finalizarPedido(int codigo) throws PedidoNaoCadastrado, PratoNaoEncontradoException,
			LojaNaoCadastradaException, QuantidadeIndisponivelException {
		ArrayList<Prato> array = RepositorioPedidoArray.getInstance().buscar(codigo).getPratosEscolhidos().listar();
		String cnpjLoja = RepositorioPedidoArray.getInstance().buscar(codigo).getLoja().getCnpj();

		for (int i = 0, j = array.size(); i < j; i++) {
			Fachada.getInstance().buscarLoja(cnpjLoja).getCardapio().buscar(array.get(i).getNome()).retirarStock(1);
		}
		RepositorioPedidoArray.getInstance().remover(codigo);
	}

	public Pedido buscar(int codigo) throws PedidoNaoCadastrado {
		Pedido resultadoBuscar = RepositorioPedidoArray.getInstance().buscar(codigo);
		return resultadoBuscar;
	}

	public void alterar(Pedido pedido) throws PedidoVazioException, PedidoNaoCadastrado {
		RepositorioPedidoArray.getInstance().alterar(pedido);
	}

	public Pedido[] listar() {
		return RepositorioPedidoArray.getInstance().listar();
	}

}
