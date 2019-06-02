package negocio;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
import negocioClassesBasicas.Administrador;
import repositorio.RepositorioAdministrador;
import repositorioArray.RepositorioAdministradorArray;

public class ControleAdiministrador {

	private static ControleAdiministrador instance;
	private RepositorioAdministrador adms;

	public ControleAdiministrador() {
		adms = new RepositorioAdministradorArray();
	}

	public static ControleAdiministrador getInsance() {
		if (ControleAdiministrador.instance == null) {
			ControleAdiministrador.instance = new ControleAdiministrador();
		}
		return ControleAdiministrador.instance;
	}

	public void inserirAdmnistrador(Administrador adm)
			throws AdministradorVazioException, AdministradorJaCadastradoException {
		adms.inserir(adm);
	}

	public void removerAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		adms.remover(id);
	}

	public Administrador buscarAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		return adms.buscar(id);
	}

	public void alterarAdministrador(Administrador adm)
			throws AdministradorVazioException, AdministradorNaoEncotradoException {
		adms.alterar(adm);
	}

	public Administrador[] listarAdministrador() {
		return adms.listarAdministrador();
	}

}
