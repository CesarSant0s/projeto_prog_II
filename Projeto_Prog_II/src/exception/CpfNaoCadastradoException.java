package exception;

public class CpfNaoCadastradoException extends Exception {

	public CpfNaoCadastradoException() {
		super("Cpf ou Cnpj Não Cadastradao");
	}

}
