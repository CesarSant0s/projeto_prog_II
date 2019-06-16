package negocio;

import static org.junit.jupiter.api.Assertions.*;

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
		try {
			Fachada.getInstance().inserirAdmnistrador(new Administrador("nome", "123", 354));
		} catch (AdministradorVazioException | AdministradorJaCadastradoException e) {
			e.printStackTrace();
		}
		Administrador adm = null;
		try {
			adm = Fachada.getInstance().buscarAdmnistrador(354);
		} catch (AdministradorNaoEncotradoException e) {
			e.printStackTrace();
		}
		assertEquals(new Administrador("nome", "123", 354), adm);

		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testRemoverAdmnistrador() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testBuscarAdmnistrador() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAlterarAdministrador() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testListarAdiministrador() {
		fail("Not yet implemented"); // TODO
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
