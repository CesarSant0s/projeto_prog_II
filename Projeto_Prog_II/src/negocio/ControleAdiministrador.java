package negocio;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
import negocioClassesBasicas.Administrador;
import repositorioArray.RepositorioAdministradorArray;

public class ControleAdiministrador {

	private static ControleAdiministrador instance;

	public static ControleAdiministrador getInsance() {
		if (ControleAdiministrador.instance == null) {
			ControleAdiministrador.instance = new ControleAdiministrador();
		}
		return ControleAdiministrador.instance;
	}

	public void inserirAdmnistrador(Administrador adm)
			throws AdministradorVazioException, AdministradorJaCadastradoException {
		RepositorioAdministradorArray.getInstance().inserir(adm);
	}

	public void removerAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		RepositorioAdministradorArray.getInstance().remover(id);
	}

	public Administrador buscarAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		return RepositorioAdministradorArray.getInstance().buscar(id);
	}

	public void alterarAdministrador(Administrador adm)
			throws AdministradorVazioException, AdministradorNaoEncotradoException {
		RepositorioAdministradorArray.getInstance().alterar(adm);
	}

	public Administrador[] listarAdministrador() {
		return RepositorioAdministradorArray.getInstance().listarAdministrador();
	}

}
