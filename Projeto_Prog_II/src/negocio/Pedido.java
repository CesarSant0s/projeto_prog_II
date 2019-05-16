package negocio;

public class Pedido {
	private int codigo;
	
	private Cliente cliente;
	private Loja loja;
	private Entregador entregador;

	public Pedido(Cliente cliente, Loja loja, Entregador entregador) {
		super();
		this.cliente = cliente;
		this.loja = loja;
		this.entregador = entregador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (!(cliente == null))
			this.cliente = cliente;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		if (!(loja == null))
			this.loja = loja;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		if (!(entregador == null))
			this.entregador = entregador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
	}
}
