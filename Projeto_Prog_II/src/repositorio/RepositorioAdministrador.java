package repositorio;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
import negocioClassesBasicas.Administrador;
import negocioClassesBasicas.Loja;

public interface RepositorioAdministrador {

	public void inserir(Administrador administrador)
			throws AdministradorVazioException, AdministradorJaCadastradoException;

	public void remover(int id) throws AdministradorNaoEncotradoException;

	public Administrador buscar(int id) throws AdministradorNaoEncotradoException;

	public void alterar(Administrador novoAdministrador)
			throws AdministradorVazioException, AdministradorNaoEncotradoException;

	public Administrador[] listarAdministrador();

}
