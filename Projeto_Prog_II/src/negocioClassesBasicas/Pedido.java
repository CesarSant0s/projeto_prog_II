package negocioClassesBasicas;

import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;

public class Pedido {

	private int codigo;

	private Cliente cliente;
	private Loja loja;
	private Entregador entregador;

	private RepositorioPratos pratosEscolhidos;
	private float valorTotal;

	public Pedido(Cliente cliente, Loja loja, Entregador entregador) {
		super();
		this.cliente = cliente;
		this.loja = loja;
		this.entregador = entregador;
		setPratosEscolhidos(new RepositorioPratosArray());
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

	// duvida sobre o projeto
	public void inserirPratoPedido(Prato prato) {

		valorTotal += prato.getValorDoPrato();

		pratosEscolhidos.inserir(prato);

	}

	public void RemoverPratoPedido(Prato prato) {

		valorTotal -= prato.getValorDoPrato();
		
		pratosEscolhidos.remover(prato.getNome());
		
	}

	public RepositorioPratos getPratosEscolhidos() {
		return pratosEscolhidos;
	}

	public void setPratosEscolhidos(RepositorioPratos pratosEscolhidos) {
		this.pratosEscolhidos = pratosEscolhidos;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

}
