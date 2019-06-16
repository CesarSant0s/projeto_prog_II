package negocio;

import java.util.ArrayList;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;
import repositorioArray.RepositorioUsuarioArray;

public class ControleUsuario {

	private RepositorioUsuario usuarios;

	public ControleUsuario() {
		usuarios = RepositorioUsuarioArray.getInstance();
	}

	public void inserir(Usuario usuario) throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException {
		usuarios.inserir(usuario);
		RepositorioUsuarioArray.salvarArquivo();
	}

	public void remover(String cpf) throws UsuarioNaoCadastradoException {
		usuarios.remover(cpf);
		RepositorioUsuarioArray.salvarArquivo();
	}

	public Usuario buscar(String cpf) throws UsuarioNaoCadastradoException {
		Usuario resultadoBusca = usuarios.buscar(cpf);
		return resultadoBusca;
	}

	public void atualizar(Usuario usuario) throws UsuarioVazioException, UsuarioNaoCadastradoException {
		usuarios.atualizar(usuario);
		RepositorioUsuarioArray.salvarArquivo();
	}

	public ArrayList<Usuario> listar() {
		return usuarios.listar();
	}
}
