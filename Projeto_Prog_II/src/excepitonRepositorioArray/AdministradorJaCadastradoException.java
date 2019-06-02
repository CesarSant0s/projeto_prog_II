package excepitonRepositorioArray;

public class AdministradorJaCadastradoException extends Exception {
	public AdministradorJaCadastradoException() {
		super("Id cadastrado anteriormente");
	}
}
