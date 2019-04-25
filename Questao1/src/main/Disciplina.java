package main;

public class Disciplina {

	private String nome;
	private String curso;
	private Professor professor;
	private int quantidadeAlunos;

	public Disciplina(String nome, String curso, Professor professor, int quantidadeAlunos) {
		super();
		setNome(nome);
		setCurso(curso);
		setProfessor(professor);
		setQuantidadeAlunos(quantidadeAlunos);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!(nome == null) && !(nome.contentEquals("")))
			this.nome = nome;

	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		if (!(curso == null) && !(curso.contentEquals("")))
			this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		if (!(professor == null))
			this.professor = professor;

	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public void setQuantidadeAlunos(int quantidadeAlunos) {
		if (quantidadeAlunos >= 30)
			this.quantidadeAlunos = quantidadeAlunos;
	}

	@Override
	public String toString() {
		return "Disciplina:\n\tNome:" + nome + "\n\tCurso:" + curso + "\n" + professor.toString()
				+ "\nQuantidadeAlunos:" + quantidadeAlunos;
	}

}
