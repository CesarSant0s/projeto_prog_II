package negocioClassesBasicas;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {

	private String endereco;
	private String nomeUsuario;
	private String senha;

	public Cliente(String nome, String telefone, String cpf, String email, String endereco, String nomeUsuario,
			String senha) {
		super(nome, telefone, cpf, email);
		this.endereco = endereco;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {
		Cliente cliente = (Cliente) obj;
		if (cliente.getCpf().equals(this.getCpf()) && cliente.getEndereco().equals(this.endereco)
				&& cliente.getNome().equals(this.getNome()) && cliente.getNomeUsuario().equals(this.nomeUsuario)
				&& cliente.getSenha().equals(this.senha) && cliente.getTelefone().equals(this.getTelefone())) {
			return true;
		}

		return false;
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