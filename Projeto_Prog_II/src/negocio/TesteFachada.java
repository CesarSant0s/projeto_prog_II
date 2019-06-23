package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
import negocioClassesBasicas.Administrador;

class TesteFachada {

	@Test
	final void testFachada() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetInstance() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testLoginCliente() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testLoginAdministrador() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testInserirAdmnistrador() {

		Administrador admActual = null, admExpected = null;
		try {
			admExpected = new Administrador("nome", "123", 354);
			Fachada.getInstance().inserirAdmnistrador(admExpected);
		} catch (AdministradorVazioException | AdministradorJaCadastradoException e) {
			e.printStackTrace();
		}

		try {
			admActual = Fachada.getInstance().buscarAdmnistrador(354);
		} catch (AdministradorNaoEncotradoException e) {
			e.printStackTrace();
		}

		assertEquals(admExpected, admActual);
	}

	@Test
	final void testRemoverAdmnistrador() {

		Administrador admActual = null, admInserido = null;

		try {
			admInserido = new Administrador("nome", "123", 354);
			Fachada.getInstance().inserirAdmnistrador(admInserido);
			Fachada.getInstance().inserirAdmnistrador(new Administrador("teste1", "teste1", 1));
			Fachada.getInstance().inserirAdmnistrador(new Administrador("teste2", "teste2", 2));

			Fachada.getInstance().removerAdmnistrador(354);

			admActual = Fachada.getInstance().buscarAdmnistrador(354);
		} catch (AdministradorVazioException | AdministradorJaCadastradoException
				| AdministradorNaoEncotradoException e) {
			// e.printStackTrace();
		}

		if (admActual == null) {
			System.out.println("teste");
		}

		assertNull(admActual);

	}

	@Test
	final void testBuscarAdmnistrador() {
		Administrador admActual = null, admExpected = null;
		try {
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome123", "123", 123));

			admExpected = new Administrador("nome", "123", 354);
			Fachada.getInstance().inserirAdmnistrador(admExpected);

			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome321", "321", 321));
		} catch (AdministradorVazioException | AdministradorJaCadastradoException e) {
			e.printStackTrace();
		}

		try {
			admActual = Fachada.getInstance().buscarAdmnistrador(354);
		} catch (AdministradorNaoEncotradoException e) {
			e.printStackTrace();
		}

		assertEquals(admExpected, admActual);

	}

	@Test
	final void testAlterarAdministrador() {

		Administrador admActual = null, admExpected = null;
		try {
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome123", "123", 123));
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome321", "321", 321));

			admExpected = new Administrador("novoNome", "0123", 321);

			Fachada.getInstance().alterarAdministrador(admExpected);

			admActual = Fachada.getInstance().buscarAdmnistrador(321);

		} catch (AdministradorVazioException | AdministradorJaCadastradoException
				| AdministradorNaoEncotradoException e) {
			// e.printStackTrace();
		}

		assertEquals(admExpected, admActual);

	}

	@Test
	final void testListarAdiministrador() {

		Administrador[] listaInserida = new Administrador[100];
		Administrador[] lista = null;
		try {
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome1", "1", 1));
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome2", "2", 2));
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome3", "3", 3));

			listaInserida[1] = new Administrador("nome1", "1", 1);
			listaInserida[2] = new Administrador("nome2", "2", 2);
			listaInserida[3] = new Administrador("nome3", "3", 3);

			lista = Fachada.getInstance().listarAdiministrador();

		} catch (AdministradorVazioException | AdministradorJaCadastradoException e) {
			// e.printStackTrace();
		}

		for (int i = 0; i < 3; i++) {
			assertEquals(lista[i], listaInserida[i]);
		}

	}

	@Test
	final void testFinalizarPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFazerPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testNovoPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testInserirPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testRemoverPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testBuscarPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAlterarPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testListarPedido() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testInserirLoja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testRemoverLoja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testBuscarLoja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAlterarLoja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testListarLoja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testInserirUsuarioCliente() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testInserirUsuarioEntregador() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testRemoverUsuario() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testBuscarUsuario() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAtualizarUsuarioEntregador() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAtualizarUsuarioCliente() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testListarUsuario() {
		fail("Not yet implemented"); // TODO
	}

}
