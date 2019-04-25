package main;

public class Professor {

	private int codigo;
	private String nome;
	private Data dataAdimissao;
	private Departamento departamento;

	public Professor(int codigo, String nome, Data dataAdimissao, Departamento departamento) {
		super();
		setCodigo(codigo);
		setNome(nome);
		setDataAdimissao(dataAdimissao);
		setDepartamento(departamento);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!(nome == null) && !(nome.contentEquals("")))
			this.nome = nome;

	}

	public Data getDataAdimissao() {
		return dataAdimissao;
	}

	public void setDataAdimissao(Data dataAdimissao) {
		if (!(dataAdimissao == null))
			this.dataAdimissao = dataAdimissao;

	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		if (!(departamento == null))
			this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Professor:\n\tCodigo:" + codigo + "\n\tNome:" + nome + "\n\tData de Adimissao:"
				+ dataAdimissao.toString() + "\n\tDepartamento:" + departamento.toString();
	}

}
