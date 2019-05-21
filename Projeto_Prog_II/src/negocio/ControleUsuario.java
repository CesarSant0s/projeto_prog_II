package negocio;

import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;
import repositorioArray.RepositorioUsuarioArray;

public class ControleUsuario {

	RepositorioUsuario usuarios = new RepositorioUsuarioArray();

	public void inserir(Usuario usuario) throws UsuarioVazioException {

		usuarios.inserir(usuario);
	}

	public void remover(String cpf) {

		usuarios.remover(cpf);
	}

	public Usuario buscar(String cpf) {

		Usuario resultadoBusca = usuarios.buscar(cpf);

		return resultadoBusca;
	}

	public void atualizar(Usuario usuario) {
		usuarios.atualizar(usuario);

	}

	public Usuario[] listar() {
		return usuarios.listar();
	}
}
