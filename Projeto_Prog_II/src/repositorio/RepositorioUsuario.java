package repositorio;

import negocio.Usuario;

public interface RepositorioUsuario {
	public void inserir(Usuario usuario);

	public void atualizar(Usuario usuario);

	public Usuario procurar(String cpf);

	public void remover(String cpf);

	public Usuario[] listar();
}
