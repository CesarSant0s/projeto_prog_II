package negocio;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
import negocioClassesBasicas.Administrador;
import repositorio.RepositorioAdministrador;
import repositorioArray.RepositorioAdministradorArray;

public class ControleAdiministrador {

	private RepositorioAdministrador repositorio;

	public ControleAdiministrador() {
		repositorio = RepositorioAdministradorArray.getInstance();
	}

	public void inserirAdmnistrador(Administrador adm)
			throws AdministradorVazioException, AdministradorJaCadastradoException {
		repositorio.inserir(adm);
		RepositorioAdministradorArray.salvarArquivo();
	}

	public void removerAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		repositorio.remover(id);
		RepositorioAdministradorArray.salvarArquivo();
	}

	public Administrador buscarAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		return repositorio.buscar(id);
	}

	public void alterarAdministrador(Administrador adm)
			throws AdministradorVazioException, AdministradorNaoEncotradoException {
		repositorio.alterar(adm);
		RepositorioAdministradorArray.salvarArquivo();
	}

	public Administrador[] listarAdministrador() {
		return repositorio.listarAdministrador();
	}

}
