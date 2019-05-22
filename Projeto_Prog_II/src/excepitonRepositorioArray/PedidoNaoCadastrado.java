package excepitonRepositorioArray;

public class PedidoNaoCadastrado extends Exception {

	public PedidoNaoCadastrado() {
		super("O pedido não foi cadastrado");
	}

}
