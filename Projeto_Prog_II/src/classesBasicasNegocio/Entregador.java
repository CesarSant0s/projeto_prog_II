package classesBasicasNegocio;

public class Entregador extends Usuario {

	private String placaVeiculo;

	public Entregador(String nomeUsuario, String senha, String nome, String telefone, String cpf, String placaVeiculo) {
		super(nomeUsuario, senha, nome, telefone, cpf);
		setplacaVeiculo(placaVeiculo);
	}

	public String getplacaVeiculo() {
		return placaVeiculo;
	}

	public void setplacaVeiculo(String placaVeiculo) {
		if (!(placaVeiculo == null) && !(placaVeiculo.equals("")))
			this.placaVeiculo = placaVeiculo;
	}

}
