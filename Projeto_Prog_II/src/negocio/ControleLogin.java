package negocio;

import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import exception.CnpjNaoCadastradoException;
import exception.CpfNaoCadastradoException;
import exception.IdNaoCadastradoException;
import exception.SenhaIncorretaException;
import negocioClassesBasicas.Administrador;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Usuario;

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

	public void loginUsuario(String cpf, String senha)
			throws UsuarioNaoCadastradoException, CpfNaoCadastradoException, SenhaIncorretaException {
		Usuario usuario = ControleUsuario.getInstance().buscar(cpf);
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

	public void lojaLogin(String cnpj, String senha)
			throws LojaNaoCadastradaException, CnpjNaoCadastradoException, SenhaIncorretaException {
		Loja loja = ControleLoja.getInstance().buscar(cnpj);
		if (loja == null) {
			CnpjNaoCadastradoException e = new CnpjNaoCadastradoException();
			throw e;
		} else {
			if (!(loja.getSenha().equals(senha))) {
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
