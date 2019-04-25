package dados;

public class Entregador extends Usuario {

	private String cpf;
	private String placaVeiculo;

	public Entregador(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String placaVeiculo) {
		super(nomeUsuario, senha, nome, telefone);
		setCpf(cpf);
		setplacaVeiculo(placaVeiculo);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (!(cpf == null) && !(cpf.equals("")))
			this.cpf = cpf;
	}

	public String getplacaVeiculo() {
		return placaVeiculo;
	}

	public void setplacaVeiculo(String placaVeiculo) {
		if (!(placaVeiculo == null) && !(placaVeiculo.equals("")))
			this.placaVeiculo = placaVeiculo;
	}

}
