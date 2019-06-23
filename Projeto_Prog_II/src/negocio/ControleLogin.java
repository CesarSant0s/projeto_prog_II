package negocio;

import java.io.Serializable;
import java.util.ArrayList;

import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import negocioClassesBasicas.Administrador;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Usuario;
import repositorioArray.RepositorioAdministradorArray;
import repositorioArray.RepositorioUsuarioArray;

public class ControleLogin implements Serializable {

	private static ControleLogin instance;

	public ControleLogin() {
	}

	public ControleLogin getInstance() {
		if (instance == null) {
			instance = new ControleLogin();
		}
		return ControleLogin.instance;
	}

	public String loginCliente(String nomeUsuario, String senha) throws UsuarioNaoCadastradoException {

		ArrayList<Usuario> lista = RepositorioUsuarioArray.getInstance().listar();

		for (Usuario u : lista) {
			if (u instanceof Cliente) {
				if (((Cliente) u).getNomeUsuario().equals(nomeUsuario) && ((Cliente) u).getSenha().equals(senha)) {
					return u.getCpf();
				}
			}

		}
		UsuarioNaoCadastradoException e = new UsuarioNaoCadastradoException(nomeUsuario);
		throw e;

	}

	public int loginAdministrador(String login, String senha) throws AdministradorNaoEncotradoException {

		RepositorioAdministradorArray rep = RepositorioAdministradorArray.getInstance();

		Administrador[] adms = rep.listarAdministrador();

		int result = 0;
		for (int i = 0; i < adms.length; i++) {
			if (adms[i] != null && adms[i].getLogin().equals(login) && adms[i].getSenha().equals(senha)) {
				result = adms[i].getId();
			}
		}

		if (result == 0) {
			AdministradorNaoEncotradoException e = new AdministradorNaoEncotradoException();
			throw e;
		} else {
			return result;
		}

	}

}
