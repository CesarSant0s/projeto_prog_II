package repositorio;

import classesBasicasNegocio.Loja;

public interface RepositorioLoja {

	public void inserir(Loja loja);

	public void remover(String cnpj);

	public Loja buscar(String cnpj);

	public void alterar(Loja novoLoja);

	public Loja[] listarLoja();
}
