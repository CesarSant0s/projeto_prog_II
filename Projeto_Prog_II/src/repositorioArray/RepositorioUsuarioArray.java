package repositorioArray;

import java.util.ArrayList;
import java.util.UUID;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;

public class RepositorioUsuarioArray implements RepositorioUsuario {

	private Usuario[] array;
	private static int indice;
	private final static int TAMANHO = 100;
	private static RepositorioUsuarioArray instance;

	public static RepositorioUsuarioArray getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuarioArray();
		}
		return instance;
	}

	public RepositorioUsuarioArray() {
		array = new Usuario[TAMANHO];
	}

	@Override
	public void inserir(Usuario usuario) throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException {

		if (usuario == null) {

			UsuarioVazioException e = new UsuarioVazioException();
			throw e;

		} else {

			Usuario resultadoBusca = null;
			for (int i = 0; i < indice; i++) {
				if (usuario.getCpf().equals(array[i].getCpf())) {
					resultadoBusca = array[i];
				}
			}

			if (resultadoBusca != null) {
				UsuarioAnteriormenteCadastradoException e = new UsuarioAnteriormenteCadastradoException(usuario);
				throw e;
			} else {
				array[indice] = usuario;
				indice++;
			}

		}

	}

	@Override
	public void atualizar(Usuario usuario) throws UsuarioVazioException, UsuarioNaoCadastradoException {

		if (usuario == null) {
			UsuarioVazioException e = new UsuarioVazioException();
			throw e;
		} else {
			buscar(usuario.getCpf());
			for (int i = 0, j = indice; i < j; i++) {
				if (usuario.getCpf().equals(array[i].getCpf())) {
					array[i] = usuario;

				}
			}
		}

	}

	@Override
	public Usuario buscar(String cpf) throws UsuarioNaoCadastradoException {

		Usuario resulUsuario = null;

		if (indice > 0) {
			for (int i = 0; i < indice; i++) {
				if (cpf.equals(array[i].getCpf())) {
					resulUsuario = array[i];
				}
			}
		} else {
			resulUsuario = null;
		}

		if (resulUsuario == null) {
			UsuarioNaoCadastradoException e = new UsuarioNaoCadastradoException(cpf);
			throw e;
		} else {
			return resulUsuario;
		}

	}

	@Override
	public void remover(String cpf) throws UsuarioNaoCadastradoException {

		buscar(cpf);

		for (int i = 0; i < indice; i++) {

			if (cpf.equals(array[i].getCpf())) {

				array[i] = array[indice - 1];
				array[indice - 1] = null;
				indice--;
			}

		}

	}

	@Override
	public ArrayList<Usuario> listar() {

		ArrayList<Usuario> resultado = new ArrayList<Usuario>();

		for (Usuario u : array) {
			resultado.add(u);
		}

		return resultado;
	}

}
