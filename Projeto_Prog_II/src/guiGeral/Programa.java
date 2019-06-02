package guiGeral;

import javax.swing.JOptionPane;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Usuario;

public class Programa {

	Fachada f1 = new Fachada();

	public static void main(String[] args) throws UsuarioVazioException {

		Usuario u3 = new Cliente("nome.cliente3", "1234", "nome3", "003", "003", "casa3");
		Usuario u4 = new Cliente("nome.cliente5", "1234", "nome4", "004", "004", "casa4");
		Usuario u5 = new Cliente("nome.cliente5", "1234", "nome5", "005", "005", "casa5");

		Loja loja1 = new Loja("nome.loja1", "1234", "loja1", "32546576", "32546576", "loja1");

		Usuario uE1 = new Entregador("nome.entregador1", "1234", "nome1", "00001", "001", "001");
		Usuario uE2 = new Entregador("nome.entregador2", "1234", "nome2", "00002", "002", "002");

		try {
			Fachada.getInstance().inserirLoja("nome.entregador1", "1234", "nome1", "00001", "001", "001");
		} catch (LojaVaziaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		} catch (LojaJaCadastradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Fachada.getInstance().inserirUsuarioCliente("nome.cliente2", "1234", "nome2",
		// "002", "002", "casa2");
	}

}
