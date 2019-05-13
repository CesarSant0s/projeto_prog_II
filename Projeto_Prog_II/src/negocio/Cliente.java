package dados;

public class Cliente extends Usuario {

	private String cpf;
	private String endereco;

	public Cliente(String nomeUsuario, String senha, String nome, String telefone, String cpf, String endereco) {
		super(nomeUsuario, senha, nome, telefone);
		setCpf(cpf);
		setEndereco(endereco);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (!(cpf == null) && !(cpf.equals("")))
			this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (!(endereco == null) && !(endereco.equals("")))
			this.endereco = endereco;
	}

}