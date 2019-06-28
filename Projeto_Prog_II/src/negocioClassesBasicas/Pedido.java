package negocioClassesBasicas;

import java.io.Serializable;

import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class Pedido implements Serializable {

	private int codigo;

	private Cliente cliente;
	private Loja loja;
	private Entregador entregador;

	// Define se o pedido esta aberto ou fechadao.
	private boolean status;

	private RepositorioPratos pratosEscolhidos;
	private float valorTotal;

	@Override
	public boolean equals(Object obj) {
		Pedido pedido = (Pedido) obj;
		if ((pedido.getCodigo() == this.codigo) && pedido.getCliente().equals(this.cliente)
				&& pedido.getLoja().equals(this.loja) && pedido.getEntregador().equals(this.entregador)) {
			return true;
		}

		return false;
	}

	public Pedido(int codigo) {
		super();
		this.codigo = codigo;
		this.cliente = null;
		this.loja = null;
		this.entregador = null;
		this.status = true;
		this.pratosEscolhidos = new RepositorioPratosArray();
		this.valorTotal = 0;
	}

	public Pedido(Cliente cliente, Loja loja) {
		super();
		this.cliente = cliente;
		this.loja = loja;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public RepositorioPratos getPratosEscolhidos() {
		return pratosEscolhidos;
	}

	public float getValorTotal() {

		for (Prato p : pratosEscolhidos.listar()) {
			valorTotal += p.getValorDoPrato();
		}

		return valorTotal;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
