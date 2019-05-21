package repositorioArray;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;

public class RepositorioUsuarioArray implements RepositorioUsuario {

	private Usuario[] array;
	private static int indice;
	private final static int TAMANHO = 100;

	public RepositorioUsuarioArray() {
		array = new Usuario[TAMANHO];
	}

	@Override
	public void inserir(Usuario usuario) throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException {

		Usuario resulUsuario = null;

		for (int i = 0; i < indice; i++) {
			if (usuario.getCpf().equals(array[i].getCpf())) {
				resulUsuario = array[i];
			}
		}

		if (usuario == null) {

			UsuarioVazioException e = new UsuarioVazioException();
			throw e;

		} else if (resulUsuario == null) {
			UsuarioAnteriormenteCadastradoException e = new UsuarioAnteriormenteCadastradoException(usuario);

			throw e;

		} else {
			array[indice] = usuario;
			indice++;
		}

	}

	@Override
	public void atualizar(Usuario usuario) {

		for (int i = 0, j = indice; i < j; i++) {
			if (usuario.getCpf().equals(array[i].getCpf())) {
				array[i] = usuario;

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
			resulUsuario = array[0];
		}

		if (resulUsuario == null) {
			UsuarioNaoCadastradoException e = new UsuarioNaoCadastradoException(cpf);
			throw e;
		} else {
			return resulUsuario;
		}

	}

	@Override
	public void remover(String cpf) {
		for (int i = 0, j = indice; i < j; i++) {

			if (cpf.equals(array[i].getCpf())) {

				array[i] = array[indice - 1];
				array[--indice] = null;
				indice--;

			}
		}

	}

	@Override
	public Usuario[] listar() {

		return array;
	}

}
