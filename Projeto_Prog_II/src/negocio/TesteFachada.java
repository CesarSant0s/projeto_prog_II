package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Entregador;

class TesteFachada {

	@Test
	void testFachada() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	void testLoginCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	void testInserirAdmnistrador() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoverAdmnistrador() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarAdmnistrador() {
		fail("Not yet implemented");
	}

	@Test
	void testAlterarAdministrador() {
		fail("Not yet implemented");
	}

	@Test
	void testListarAdiministrador() {
		fail("Not yet implemented");
	}

	@Test
	void testInserirPrato() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoverPrato() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarPrato() {
		fail("Not yet implemented");
	}

	@Test
	void testAlterarPrato() {
		fail("Not yet implemented");
	}

	@Test
	void testListar() {
		fail("Not yet implemented");
	}

	@Test
	void testAbrirPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalizarPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testAlterarPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testListarPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testInserirLoja() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoverLoja() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarLoja() {
		fail("Not yet implemented");
	}

	@Test
	void testAlterarLoja() {
		fail("Not yet implemented");
	}

	@Test
	void testListarLoja() {
		fail("Not yet implemented");
	}

	@Test
	void testInserirUsuarioCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testInserirUsuarioEntregador() {

		Entregador expecteds, actuals = null;

		expecteds = new Entregador("Paulo", "995544", "15378565430", "pcr-5544", "paulo@gmail.com");
		try {
			Fachada.getInstance().inserirUsuarioEntregador("Paulo", "995544", "15378565430", "pcr-5544",
					"paulo@gmail.com");
		} catch (UsuarioVazioException | UsuarioAnteriormenteCadastradoException | UsuarioNaoCadastradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			actuals = (Entregador) Fachada.getInstance().buscarUsuario("15378565430");
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(expecteds, actuals);

		fail("Not yet implemented");
	}

	@Test
	void testRemoverUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarUsuarioEntregador() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarUsuarioCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testListarUsuario() {
		fail("Not yet implemented");
	}

}
