package repositorio;

import classesBasicasNegocio.Pedido;

public interface RepositorioPedido {

	public void inserir(Pedido pedido);

	public void remover(int codigo);

	public Pedido buscar(int codigo);

	public void alterar(Pedido pedido);

	public Pedido[] listar();

}
