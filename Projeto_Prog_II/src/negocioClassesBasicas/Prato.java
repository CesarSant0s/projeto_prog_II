package negocioClassesBasicas;

import excepitonRepositorioArray.QuantidadeIndisponívelException;

public class Prato {
	private String nome;
	private float peso;
	private float valorDoPrato;
	private int quantiadeDisponivel;

	public Prato(String nome, float peso, float valorDoPrato, int quantiadeDisponivel) {
		setNome(nome);
		setPeso(peso);
		setValorDoPrato(valorDoPrato);
		setQuantiadeDisponivel(quantiadeDisponivel);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		if (peso > 0)
			this.peso = peso;
	}

	public float getValorDoPrato() {
		return valorDoPrato;
	}

	public void setValorDoPrato(float valorDoPrato) {
		this.valorDoPrato = valorDoPrato;
	}

	public int getQuantiadeDisponivel() {
		return quantiadeDisponivel;
	}

	public void setQuantiadeDisponivel(int quantiadeDisponivel) {
		this.quantiadeDisponivel = quantiadeDisponivel;
	}
	
	public void retirarStock(int quantidade) throws QuantidadeIndisponívelException {
		if (quantidade > quantiadeDisponivel) {
			QuantidadeIndisponívelException e = new QuantidadeIndisponívelException();
			throw e;
		}
	}

}
