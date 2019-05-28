package negocio;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import exception.CpfNaoCadastradoException;
import exception.SenhaIncorretaException;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Usuario;

public class ControleLogin {

	public ControleLogin() {
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

}
