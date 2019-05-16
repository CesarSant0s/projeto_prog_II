package negocio;

import repositorio.RepositorioUsuario;
import repositorio.RepositorioUsuarioArray;

public class ControleUsuario {

	RepositorioUsuario usuarios = new RepositorioUsuarioArray();

	public void inserir(Usuario usuario) {
		// Incluir validacoes e regras de negocio
		usuarios.inserir(usuario);
	}

	public void remover(String cpf) {
		// Incluir validacoes e regras de negocio
		usuarios.remover(cpf);
	}

	public Usuario buscar(String cpf) {
		// Incluir validacoes e regras de negocio
		return usuarios.buscar(cpf);
	}

	public void atualizar(Usuario usuario) {
		// Incluir validacoes e regras de negocio
		usuarios.atualizar(usuario);
	}

	public Usuario[] listar() {
		// Incluir validacoes e regras de negocio
		return usuarios.listar();
	}
}
