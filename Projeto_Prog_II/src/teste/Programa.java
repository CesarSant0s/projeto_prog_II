package teste;

import dados.Cliente;
import dados.Loja;
import dados.Usuario;

public class Programa {

	public static void main(String[] args) {
		Usuario u1, u2;

		u1 = new Cliente("cesar.santos", "1234", "César Henrique Araújo dos Santos", "995082440", "70734014430",
				"Av. Bom Sucesso n 44");

		System.out.println(((Cliente) u1).getNome());
		System.out.println(((Cliente) u1).getEndereco());

		u2 = new Loja("laja1", "1234", "comida", "0000-0001", "0000-01", "avenida Boa vista n 1001");

		System.out.println(((Loja) u2).getNome());
		System.out.println(((Loja) u2).getEndereco());

	}

}
