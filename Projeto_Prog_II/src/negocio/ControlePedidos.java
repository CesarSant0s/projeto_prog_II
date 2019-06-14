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
import repositorioArray.RepositorioPedidoArray;

public class ControlePedidos {

	public void finalizarPedido(Pedido pedido)
			throws LojaNaoCadastradaException, PratoNaoEncontradoException, PratoVazioException {

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
				novoPedido.getPratosEscolhidos().inserir(p);
			} catch (PratoVazioException | PratoJaInseridoException e) {
			}
		}

		novoPedido.setCliente(cliente);
		novoPedido.setLoja(loja);
		novoPedido.setEntregador(entregadorPedido);

		RepositorioPedidoArray.getInstance().inserir(novoPedido);

	}

	public int gerarCodigo() {
		return ((int) (10000 + Math.random() * 89999));
	}

	public Pedido novoPedido() {

		Pedido resultado = null;

		while (resultado == null) {

			int i = gerarCodigo();
			try {
				RepositorioPedidoArray.getInstance().buscar(i);
			} catch (PedidoNaoCadastrado e) {
				resultado = new Pedido(i);
			}
		}
		return resultado;

	}

	public void inserirPedido(Pedido pedido) throws PedidoJaInseridoException, PedidoVazioException {
		RepositorioPedidoArray.getInstance().inserir(pedido);
	}

	public void removerPedido(int codigo) throws PedidoNaoCadastrado {
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
