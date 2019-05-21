package repositorio;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;

public interface RepositorioUsuario {
	public void inserir(Usuario usuario)
			throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException, UsuarioNaoCadastradoException;

	public void atualizar(Usuario usuario) throws UsuarioVazioException, UsuarioNaoCadastradoException;

	public Usuario buscar(String cpf) throws UsuarioNaoCadastradoException;

	public void remover(String cpf) throws UsuarioNaoCadastradoException;

	public Usuario[] listar();
}
