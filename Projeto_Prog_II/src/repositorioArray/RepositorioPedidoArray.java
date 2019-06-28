package repositorioArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import negocioClassesBasicas.Pedido;
import repositorio.RepositorioPedido;

public class RepositorioPedidoArray implements RepositorioPedido, Serializable {

	private Pedido[] array;
	private int indice;
	private static final int TAMANHO = 100;
	private static RepositorioPedidoArray instance;

	public static RepositorioPedidoArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static RepositorioPedidoArray lerDoArquivo() {
		RepositorioPedidoArray instanciaLocal = null;
		// Criando um arquivo e passando o nome dele
		File in = new File("pedidos.dat");// criando um arquivo .dat na pasta do projeto

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioPedidoArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioPedidoArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (!(instance == null)) {

			File out = new File("pedidos.dat");
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream(out);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(instance);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}

	public RepositorioPedidoArray() {
		array = new Pedido[TAMANHO];
		indice = 0;
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
				pedido.setStatus(true);
				array[indice] = pedido;
				indice++;
			}

		}

	}

	public void remover(int codigo) throws PedidoNaoCadastrado {

		buscar(codigo);

		for (int i = 0, j = indice; i < j; i++) {
			if (codigo == array[i].getCodigo() && array[i].isStatus() == true) {
				array[i].setStatus(false);
			}
		}
	}

	public Pedido buscar(int codigo) throws PedidoNaoCadastrado {

		Pedido resultadoBusca = null;

		if (indice > 0) {
			for (int i = 0, j = indice; i < j; i++) {
				if ((array[i] != null) && codigo == array[i].getCodigo()) {
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
