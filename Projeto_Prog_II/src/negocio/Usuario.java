package dados;

public abstract class Usuario {

	private String nomeUsuario;
	private String senha;
	private String nome;
	private String telefone;

	public Usuario(String nomeUsuario, String senha, String nome, String telefone) {
		setNomeUsuario(nomeUsuario);
		setSenha(senha);
		setNome(nome);
		setTelefone(telefone);
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		if (!(nomeUsuario == null) && !(nomeUsuario.equals("")))
			this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (!(senha == null) && !(senha.equals("")))
			this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!(nome == null) && !(nome.equals("")))
			this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (!(telefone == null) && !(telefone.equals("")))
			this.telefone = telefone;
	}

}
