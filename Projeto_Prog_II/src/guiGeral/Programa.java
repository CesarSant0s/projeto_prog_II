package guiGeral;

import javax.swing.JOptionPane;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoVazioException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Prato;
import negocioClassesBasicas.Usuario;

public class Programa {

	public static void inserirLoja() {

		try {
			Fachada.getInstance().inserirLoja("nome.entregador1", "1234", "nome1", "00001", "001", "001");
			Fachada.getInstance().inserirLoja("nome.loja2", "1234", "loja2", "32546576", "002", "loja2");
		} catch (LojaVaziaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		} catch (LojaJaCadastradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Fachada.getInstance().buscarLoja("001").getCardapio().inserir(new Prato("lasanha", 2, 40, 10));
			Fachada.getInstance().buscarLoja("001").getCardapio().inserir(new Prato("cachorro-quente", 50, 40, 10));
			Fachada.getInstance().buscarLoja("001").getCardapio().inserir(new Prato("pizza", 50, 40, 10));
			Fachada.getInstance().buscarLoja("001").getCardapio().inserir(new Prato("coxinha", 50, 40, 10));
		} catch (PratoVazioException | PratoJaInseridoException | LojaNaoCadastradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	Fachada f1 = new Fachada();

	public static void main(String[] args) throws UsuarioVazioException {

		Usuario u3 = new Cliente("nome.cliente3", "1234", "nome3", "003", "003", "casa3");
		Usuario u4 = new Cliente("nome.cliente5", "1234", "nome4", "004", "004", "casa4");
		Usuario u5 = new Cliente("nome.cliente5", "1234", "nome5", "005", "005", "casa5");

		Loja loja1 = new Loja("nome.loja1", "1234", "loja1", "32546576", "32546576", "loja1");
		Loja loja2 = new Loja("nome.loja2", "1234", "loja2", "32546576", "32546576", "loja2");

		Usuario uE1 = new Entregador("1234", "nome1", "00001", "001", "001");
		Usuario uE2 = new Entregador("1234", "nome2", "00002", "002", "002");

		try {
			System.out.println(Fachada.getInstance().buscarLoja("001").getNome());
			System.out.println(Fachada.getInstance().buscarLoja("002").getNome());
		} catch (LojaNaoCadastradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

}
