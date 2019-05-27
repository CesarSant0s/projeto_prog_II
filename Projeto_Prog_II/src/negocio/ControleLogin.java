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

	public void login(String cpfCNPJ, String senha) throws UsuarioNaoCadastradoException, LojaNaoCadastradaException,
			CpfNaoCadastradoException, SenhaIncorretaException {

		Loja loja = ControleLoja.getInstance().buscar(cpfCNPJ);

		Usuario usuario = ControleUsuario.getInstance().buscar(cpfCNPJ);

		if (loja == null && usuario == null) {
			CpfNaoCadastradoException e = new CpfNaoCadastradoException();
			throw e;
		} else if (loja != null) {
			if (!(loja.getSenha().equals(senha))) {
				SenhaIncorretaException e = new SenhaIncorretaException();
				throw e;
			}
		} else {
			if (!(usuario.getSenha().equals(senha))) {
				SenhaIncorretaException e = new SenhaIncorretaException();
				throw e;
			}
		}

	}
}
