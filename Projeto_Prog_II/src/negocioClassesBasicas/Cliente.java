package negocioClassesBasicas;

public class Cliente extends Usuario {

	private String endereco;
	private String nomeUsuario;
	private String senha;

	public Cliente(String nomeUsuario, String senha, String nome, String telefone, String cpf, String endereco) {
		super(nome, telefone, cpf);
		setEndereco(endereco);
		setNomeUsuario(nomeUsuario);
		setSenha(senha);
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}