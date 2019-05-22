package repositorioArray;

import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import negocioClassesBasicas.Pedido;
import repositorio.RepositorioPedido;

public class RepositorioPedidoArray implements RepositorioPedido {

	private Pedido[] array;
	private int indice;
	private static final int TAMANHO = 100;

	public RepositorioPedidoArray() {
		array = new Pedido[TAMANHO];
	}

	public void inserir(Pedido pedido) throws PedidoJaInseridoException, PedidoVazioException {

		if (pedido == null) {

			PedidoVazioException e = new PedidoVazioException();
			throw e;

		} else {

			Pedido resultadoBusca = null;

			for (int i = 0; i < indice; i++) {
				if (pedido.getCodigo() == array[i].getCodigo()) {
					resultadoBusca = array[i];
				}
			}

			if (resultadoBusca != null) {
				PedidoJaInseridoException e = new PedidoJaInseridoException();
				throw e;
			} else {
				array[indice] = pedido;
				indice++;
			}

		}

	}

	public void remover(int codigo) throws PedidoNaoCadastrado {

		buscar(codigo);

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

	public Pedido buscar(int codigo) throws PedidoNaoCadastrado {

		Pedido resultadoBusca = null;

		if (indice > 0) {
			for (int i = 0, j = indice; i < j; i++) {
				if (codigo == array[i].getCodigo()) {
					resultadoBusca = array[i];
				}
			}
		} else {
			resultadoBusca = null;
		}

		if (resultadoBusca == null) {
			PedidoNaoCadastrado e = new PedidoNaoCadastrado();

			throw e;

		} else {
			return resultadoBusca;
		}

	}

	public void alterar(Pedido pedido) throws PedidoVazioException, PedidoNaoCadastrado {

		if (pedido == null) {
			PedidoVazioException e = new PedidoVazioException();
			throw e;
		} else {
			buscar(pedido.getCodigo());
			for (int i = 0, j = indice; i < j; i++) {
				if (pedido.getCodigo() == array[i].getCodigo()) {
					array[i] = pedido;
				}
			}

		}

	}

	public Pedido[] listar() {
		return array;
	}

}
