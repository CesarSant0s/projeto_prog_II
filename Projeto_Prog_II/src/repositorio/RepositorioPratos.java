package repositorio;

import classesBasicasNegocio.Prato;

public interface RepositorioPratos {

	public void inserir(Prato prato);

	public void remover(String nomePrato);

	public Prato buscar(String nomePrato);

	public void alterar(Prato novoPrato);

	public Prato[] listar();

}
