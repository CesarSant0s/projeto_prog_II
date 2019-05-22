package excepitonRepositorioArray;

public class PratoJaInseridoException extends Exception {

	private String nome;

	public PratoJaInseridoException(String nome) {
		super("O prat já foi inserido");

		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
