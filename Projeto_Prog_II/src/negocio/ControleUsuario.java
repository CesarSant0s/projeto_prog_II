package negocio;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;
import repositorioArray.RepositorioUsuarioArray;

public class ControleUsuario {

	RepositorioUsuario usuarios = new RepositorioUsuarioArray();

	public void inserir(Usuario usuario) throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException {

		usuarios.inserir(usuario);
	}

	public void remover(String cpf) throws UsuarioNaoCadastradoException {

		usuarios.remover(cpf);
	}

	public Usuario buscar(String cpf) throws UsuarioNaoCadastradoException {

		Usuario resultadoBusca = usuarios.buscar(cpf);

		return resultadoBusca;
	}

	public void atualizar(Usuario usuario) throws UsuarioVazioException, UsuarioNaoCadastradoException {
		usuarios.atualizar(usuario);

	}

	public Usuario[] listar() {
		return usuarios.listar();
	}
}
