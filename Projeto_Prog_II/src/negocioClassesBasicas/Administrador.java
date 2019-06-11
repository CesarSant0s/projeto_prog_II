package negocioClassesBasicas;

import java.io.Serializable;

public class Administrador implements Serializable {

	private String login;
	private String senha;
	private int id;

	public Administrador(String login, String senha, int id) {
		this.login = login;
		this.senha = senha;
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
