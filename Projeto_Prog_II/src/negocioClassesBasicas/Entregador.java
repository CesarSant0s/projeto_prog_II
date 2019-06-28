package negocioClassesBasicas;

import java.io.Serializable;

public class Entregador extends Usuario implements Serializable {

	private String placaVeiculo;
	private String email;

	public Entregador(String nome, String telefone, String cpf, String placaVeiculo, String email) {
		super(nome, telefone, cpf, email);
		setplacaVeiculo(placaVeiculo);
		setEmail(email);
	}

	@Override
	public boolean equals(Object obj) {
		Entregador entregador = (Entregador) obj;
		if (entregador.getCpf().equals(this.getCpf()) && entregador.getplacaVeiculo().equals(this.placaVeiculo)
				&& entregador.getNome().equals(this.getNome()) && entregador.getEmail().equals(this.email)
				&& entregador.getTelefone().equals(this.getTelefone())) {
			return true;
		}

		return false;
	}

	public String getplacaVeiculo() {
		return placaVeiculo;
	}

	public void setplacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
