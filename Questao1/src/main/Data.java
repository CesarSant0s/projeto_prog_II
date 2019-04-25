package main;

public class Data {
	private int dia;
	private int mes;
	private int ano;

	public Data(int dia, int mes, int ano) {
		super();
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if (dia >= 1 && dia <= 31)
			this.dia = dia;

	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if (mes >= 1 && mes <= 12)
			this.mes = mes;

	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano >= 2000)
			this.ano = ano;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

}
