package fachada;

import negocio.Cliente;
import negocio.Loja;
import negocio.Usuario;

public class Programa {

	public static void main(String[] args) {
		Usuario u1 = new Cliente("cesar.santos", "1234", "César Henrique Araújo dos Santos", "995082440", "70734014430",
				"Av. Bom Sucesso n 44");

		System.out.println(((Cliente) u1).getNome());
		System.out.println(((Cliente) u1).getEndereco());

	}

}
