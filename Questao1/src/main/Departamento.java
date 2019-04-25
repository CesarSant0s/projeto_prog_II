package main;

public class Departamento {
	private int codigo;
	private String nome;

	public Departamento(int codigo, String nome) {
		super();
		setCodigo(codigo);
		setNome(nome);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!(nome == null) && !(nome.contentEquals("")))
			this.nome = nome;
	}

	@Override
	public String toString() {
		return "\n\t\tCodigo:" + codigo + "\n\t\tNome:" + nome;
	}

}
