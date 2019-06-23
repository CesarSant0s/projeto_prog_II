package negocioClassesBasicas;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {

	private String endereco;
	private String nomeUsuario;
	private String senha;

	public Cliente(String nomeUsuario, String senha, String nome, String telefone, String cpf, String endereco) {
		super(nome, telefone, cpf);
		setEndereco(endereco);
		setNomeUsuario(nomeUsuario);
		setSenha(senha);
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