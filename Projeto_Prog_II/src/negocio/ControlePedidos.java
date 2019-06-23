package negocio;

import java.util.ArrayList;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Pedido;
import negocioClassesBasicas.Prato;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioPedido;
import repositorioArray.RepositorioPedidoArray;

public class ControlePedidos {

	private RepositorioPedido pedidos;

	public ControlePedidos() {
		pedidos = RepositorioPedidoArray.getInstance();
	}

	public void finalizarPedido(Pedido pedido)
			throws LojaNaoCadastradaException, PratoNaoEncontradoException, PratoVazioException {

		JavaMailApp.enviarEmailParraEntregador(pedido);

		for (Prato p : pedido.getPratosEscolhidos().listar()) {
			p.setQuantiadeDisponivel(p.getQuantiadeDisponivel() - 1);
			Fachada.getInstance().buscarLoja(pedido.getLoja().getCnpj()).alterar(p);
		}

	}

	public void fazerPedido(Cliente cliente, Loja loja, ArrayList<Prato> pratosEscolhidos)
			throws PedidoJaInseridoException, PedidoVazioException {

		Pedido novoPedido = novoPedido();

		Entregador entregadorPedido = null;

		for (Usuario e : Fachada.getInstance().listarUsuario()) {
			if (e instanceof Entregador) {
				entregadorPedido = (Entregador) e;
				break;
			}
		}

		for (Prato p : pratosEscolhidos) {
			try {
				if (p != null) {
					novoPedido.getPratosEscolhidos().inserir(p);
				}
			} catch (PratoVazioException | PratoJaInseridoException e) {
			}
		}

		novoPedido.setCliente(cliente);
		novoPedido.setLoja(loja);
		novoPedido.setEntregador(entregadorPedido);

		pedidos.inserir(novoPedido);
		RepositorioPedidoArray.salvarArquivo();

	}

	public int gerarCodigo() {
		return ((int) (10000 + Math.random() * 89999));
	}

	public Pedido novoPedido() {

		Pedido resultado = null;

		while (resultado == null) {

			int i = gerarCodigo();
			try {
				pedidos.buscar(i);
			} catch (PedidoNaoCadastrado e) {
				resultado = new Pedido(i);
			}
		}
		return resultado;

	}

	public void inserirPedido(Pedido pedido) throws PedidoJaInseridoException, PedidoVazioException {
		pedidos.inserir(pedido);
		RepositorioPedidoArray.salvarArquivo();
	}

	public void removerPedido(int codigo) throws PedidoNaoCadastrado {
		pedidos.remover(codigo);
		RepositorioPedidoArray.salvarArquivo();
	}

	public Pedido buscar(int codigo) throws PedidoNaoCadastrado {
		Pedido resultadoBuscar = pedidos.buscar(codigo);
		return resultadoBuscar;
	}

	public void alterar(Pedido pedido) throws PedidoVazioException, PedidoNaoCadastrado {
		pedidos.alterar(pedido);
		RepositorioPedidoArray.salvarArquivo();
	}

	public Pedido[] listar() {
		return pedidos.listar();
	}

}
