package parteGraficaVisual;

import negocio.Cliente;
import negocio.Entregador;
import negocio.Fachada;
import negocio.Loja;
import negocio.Usuario;

public class Programa {

	Fachada f1 = new Fachada();

	public static void main(String[] args) {
		Usuario u1 = new Cliente("cesar.santos", "1234", "César Henrique Araújo dos Santos", "995082440", "70734014430",
				"Av. Bom Sucesso n 44");

		Loja loja1 = new Loja("adm1", "1234", "", "32546576", "32546576", "avenida tal tal");

		Usuario u2 = new Entregador("carlos.eduardo", "1234", "Carlos Eduardo arajo dos Santos", "32546578",
				"70735455215", "pCr - 5545");

		Fachada.getInstance().inserirLoja(loja1);
		Fachada.getInstance().inserirUsuario(u1);
		Fachada.getInstance().inserirUsuario(u2);

		System.out.println(Fachada.getInstance().buscarUsuario("70734014430").getNome());

	}

}
