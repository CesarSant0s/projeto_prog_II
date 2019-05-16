package negocio;

import repositorio.RepositorioUsuario;
import repositorio.RepositorioUsuarioArray;

public class ControleUsuario {

	RepositorioUsuario usuarios = new RepositorioUsuarioArray();

	public void inserir(Usuario usuario) {

		if (usuario != null && usuarios.buscar(usuario.getCpf()) == null) {
			usuarios.inserir(usuario);
		} else {

		}

	}

	public void remover(String cpf) {

		usuarios.remover(cpf);
	}

	public Usuario buscar(String cpf) {

		Usuario resultadoBusca = usuarios.buscar(cpf);

		if (resultadoBusca != null) {
			return resultadoBusca;
		} else {
			return resultadoBusca;
		}
	}

	public void atualizar(Usuario usuario) {
		if (usuario != null && usuarios.buscar(usuario.getCpf()) != null) {
			usuarios.atualizar(usuario);
		} else {
		}
	}

	public Usuario[] listar() {
		return usuarios.listar();
	}
}
