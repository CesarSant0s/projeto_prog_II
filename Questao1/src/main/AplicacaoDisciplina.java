package main;

import java.util.Scanner;

public class AplicacaoDisciplina {
	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		Disciplina disciplina;
		Professor professor;
		Departamento departamento;
		Data data;

		int quantidadeAlunos, codigo, dia, mes, ano;
		String nome, curso, nome1;

		System.out.println("Insira a data de adimissao do professro:\nDia:");
		dia = input.nextInt();
		System.out.println("Mes:");
		mes = input.nextInt();
		System.out.println("Ano:");
		ano = input.nextInt();

		data = new Data(dia, mes, ano);

		System.out.println("Insira o Codigo do departamento do Professor");
		codigo = input.nextInt();
		input.nextLine();
		System.out.println("Informe o Nome do departamento do Professor");
		nome1 = input.next();

		departamento = new Departamento(codigo, nome1);

		System.out.println("Insira o Codigo do Professor");
		codigo = input.nextInt();
		input.nextLine();
		System.out.println("Informe o Nome do Professor");
		nome1 = input.nextLine();

		professor = new Professor(codigo, nome1, data, departamento);

		System.out.println("Insira o nome da Disciplina:");
		nome = input.nextLine();
		System.out.println("Insira o Curso");
		curso = input.nextLine();
		System.out.println("Insira a quantidade de Alunos");
		quantidadeAlunos = input.nextInt();

		disciplina = new Disciplina(nome, curso, professor, quantidadeAlunos);

		int menu;
		boolean teste = false;

		do {

			System.out.println("1. Alterar Dados Gerais");
			System.out.println("2. Alterar Professor");
			System.out.println("3. Imprimir Disciplina");
			System.out.println("4. Sair");

			System.out.println("-->");
			menu = input.nextInt();

			switch (menu) {

			case 1:
				AplicacaoDisciplina.alteraDadosGerais(disciplina);
				break;

			case 2:
				AplicacaoDisciplina.aterarProfessor(disciplina);
				break;

			case 3:
				AplicacaoDisciplina.imprime(disciplina);
				break;

			case 4:
				teste = true;
				break;

			default:
				break;
			}

		} while (!teste);

	}

	public static void alteraDadosGerais(Disciplina d) {

		System.out.println("Informe o NOVO nome da disciplina");
		d.setNome(input.next());

		System.out.println("Insira o NOVO nome do Curso");
		d.setCurso(input.next());

		System.out.println("Informe a NOVA quantidade de alunos");
		d.setQuantidadeAlunos(input.nextInt());

	}

	public static void aterarProfessor(Disciplina d) {

		int aux;
		String aux1;

		System.out.println("Insira a data de adimissao do professro:\nDia:");
		aux = input.nextInt();
		d.getProfessor().getDataAdimissao().setDia(aux);
		System.out.println("Mes:");
		aux = input.nextInt();
		d.getProfessor().getDataAdimissao().setMes(aux);
		System.out.println("Ano:");
		aux = input.nextInt();
		d.getProfessor().getDataAdimissao().setAno(aux);

		System.out.println("Insira o Codigo do departamento do Professor");
		aux = input.nextInt();
		d.getProfessor().setCodigo(aux);
		System.out.println("Informe o Nome do departamento do Professor");
		aux1 = input.next();
		d.getProfessor().getDepartamento().setNome(aux1);

		System.out.println("Insira o Codigo do Professor");
		aux = input.nextInt();
		d.getProfessor().getDepartamento().setCodigo(aux);
		System.out.println("Informe o Nome do Professor");
		aux1 = input.next();
		d.getProfessor().setNome(aux1);

	}

	public static void imprime(Disciplina d) {
		System.out.println(d.toString());
	}

}
