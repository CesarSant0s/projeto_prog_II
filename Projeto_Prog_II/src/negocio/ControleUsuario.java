package negocio;

import java.util.ArrayList;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;
import repositorioArray.RepositorioUsuarioArray;

public class ControleUsuario {

	private static ControleUsuario instance;

	public static ControleUsuario getInstance() {
		if (ControleUsuario.instance == null) {
			ControleUsuario.instance = new ControleUsuario();
		}
		return ControleUsuario.instance;
	}

	public void inserir(Usuario usuario) throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException {
		RepositorioUsuarioArray.getInstance().inserir(usuario);
	}

	public void remover(String cpf) throws UsuarioNaoCadastradoException {
		RepositorioUsuarioArray.getInstance().remover(cpf);
	}

	public Usuario buscar(String cpf) throws UsuarioNaoCadastradoException {
		Usuario resultadoBusca = RepositorioUsuarioArray.getInstance().buscar(cpf);
		return resultadoBusca;
	}

	public void atualizar(Usuario usuario) throws UsuarioVazioException, UsuarioNaoCadastradoException {
		RepositorioUsuarioArray.getInstance().atualizar(usuario);
	}

	public ArrayList<Usuario> listar() {
		return RepositorioUsuarioArray.getInstance().listar();
	}
}
