package excepitonRepositorioArray;

import classesBasicasNegocio.Usuario;

public class UsuarioAnteriormenteCadastradoException extends Exception {

	private Usuario e;

	public UsuarioAnteriormenteCadastradoException(Usuario e) {
		super("O usuario foi cadastrado anteriormente com o mesmo cpf.");
		this.e = e;
		// TODO Auto-generated constructor stub
	}

	public Usuario getE() {
		return e;
	}

	public void setE(Usuario e) {
		this.e = e;
	}

}
