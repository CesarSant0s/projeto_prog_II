package negocioClassesBasicas;

public class Entregador extends Usuario {

	private String placaVeiculo;
	private String email;

	public Entregador(String nome, String telefone, String cpf, String placaVeiculo, String email) {
		super(nome, telefone, cpf);
		setplacaVeiculo(placaVeiculo);
		setEmail(email);
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
