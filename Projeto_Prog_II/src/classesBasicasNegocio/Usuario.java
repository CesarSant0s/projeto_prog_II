package classesBasicasNegocio;

public abstract class Usuario {

	private String nomeUsuario;
	private String senha;
	private String nome;
	private String telefone;
	private String cpf;

	public Usuario(String nomeUsuario, String senha, String nome, String telefone, String cpf) {
		setNomeUsuario(nomeUsuario);
		setSenha(senha);
		setNome(nome);
		setTelefone(telefone);
		setCpf(cpf);
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
