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

	public String loginCliente(String cpf, String senha)
			throws UsuarioNaoCadastradoException, CpfNaoCadastradoException, SenhaIncorretaException {
		Cliente usuario = (Cliente) Fachada.getInstance().buscarUsuario(cpf);
		if (usuario == null) {
			CpfNaoCadastradoException e = new CpfNaoCadastradoException();
			throw e;
		} else {
			if (!(usuario.getSenha().equals(senha))) {
				SenhaIncorretaException e = new SenhaIncorretaException();
				throw e;
			}
		}
		return usuario.getCpf();
	}

	public int loginAdministrador(int id, String senha)
			throws AdministradorNaoEncotradoException, IdNaoCadastradoException {
		Administrador adm = Fachada.getInstance().buscarAdmnistrador(id);
		if (adm == null) {
			IdNaoCadastradoException e = new IdNaoCadastradoException();
			throw e;
		} else {
			if (!(adm.getSenha().equals(senha))) {
				IdNaoCadastradoException e = new IdNaoCadastradoException();
				throw e;
			}
		}
		return adm.getId();
	}

}
