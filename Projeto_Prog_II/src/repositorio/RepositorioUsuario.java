package repositorio;

import negocioClassesBasicas.Usuario;

public interface RepositorioUsuario {
	public void inserir(Usuario usuario);

	public void atualizar(Usuario usuario);

	public Usuario buscar(String cpf);

	public void remover(String cpf);

	public Usuario[] listar();
}
