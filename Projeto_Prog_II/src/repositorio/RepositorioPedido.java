package repositorio;

import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import negocioClassesBasicas.Pedido;

public interface RepositorioPedido {

	public void inserir(Pedido pedido) throws PedidoJaInseridoException, PedidoVazioException;

	public void remover(int codigo) throws PedidoNaoCadastrado;

	public Pedido buscar(int codigo) throws PedidoNaoCadastrado;

	public void alterar(Pedido pedido) throws PedidoVazioException, PedidoNaoCadastrado;

	public Pedido[] listar();

}
