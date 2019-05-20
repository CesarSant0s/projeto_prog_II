package negocioClassesBasicas;

public class Cliente extends Usuario {

	private String endereco;

	public Cliente(String nomeUsuario, String senha, String nome, String telefone, String cpf, String endereco) {
		super(nomeUsuario, senha, nome, telefone, cpf);
		setEndereco(endereco);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (!(endereco == null) && !(endereco.equals("")))
			this.endereco = endereco;
	}

}