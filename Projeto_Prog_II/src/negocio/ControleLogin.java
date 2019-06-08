package negocio;

import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import exception.CpfNaoCadastradoException;
import exception.IdNaoCadastradoException;
import exception.SenhaIncorretaException;
import negocioClassesBasicas.Administrador;
import negocioClassesBasicas.Cliente;

public class ControleLogin {

	private static ControleLogin instance;

	public ControleLogin() {
	}

	public ControleLogin getInstance() {
		if (ControleLogin.instance == null) {
			ControleLogin.instance = new ControleLogin();
		}
		return ControleLogin.instance;
	}

	public void loginCliente(String cpf, String senha)
			throws UsuarioNaoCadastradoException, CpfNaoCadastradoException, SenhaIncorretaException {
		Cliente usuario = (Cliente) ControleUsuario.getInstance().buscar(cpf);
		if (usuario == null) {
			CpfNaoCadastradoException e = new CpfNaoCadastradoException();
			throw e;
		} else {
			if (!(usuario.getSenha().equals(senha))) {
				SenhaIncorretaException e = new SenhaIncorretaException();
				throw e;
			}
		}
	}

	public void loginAdministrador(int id, String senha)
			throws AdministradorNaoEncotradoException, IdNaoCadastradoException {
		Administrador adm = ControleAdiministrador.getInsance().buscarAdmnistrador(id);
		if (adm == null) {
			IdNaoCadastradoException e = new IdNaoCadastradoException();
			throw e;
		} else {
			if (!(adm.getSenha().contentEquals(senha))) {
				IdNaoCadastradoException e = new IdNaoCadastradoException();
				throw e;
			}
		}

	}

}
