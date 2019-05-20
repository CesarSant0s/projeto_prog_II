package excepitonRepositorioArray;

public class UsuarioNaoCadastradoException extends Exception {

	String e;

	public UsuarioNaoCadastradoException(String e) {
		super("O usuario não foi cadastrado.");
		this.e = e;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

}
