package teste;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;

public class InserirUsuarios {

	public static void main(String[] args) {
		/*
		try {
			
			Fachada.getInstance().inserirUsuarioEntregador("nome1", "12345678", "11", "placa1",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome2", "12345678", "12", "placa2",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome3", "12345678", "13", "placa3",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome4", "12345678", "14", "placa4",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome5", "12345678", "15", "placa5",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome6", "12345678", "16", "placa6",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome7", "12345678", "17", "placa7",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome8", "12345678", "18", "placa8",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome9", "12345678", "19", "placa9",
					"email.exemplo@gemail.com");
			Fachada.getInstance().inserirUsuarioEntregador("nome10", "12345678", "20", "placa10",
					"email.exemplo@gemail.com");
			
			
		} catch (UsuarioVazioException | UsuarioAnteriormenteCadastradoException | UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		 * try { Fachada.getInstance().inserirAdmnistrador(new Administrador("adm1",
		 * "123", 1)); Fachada.getInstance().inserirAdmnistrador(new
		 * Administrador("adm2", "123", 2));
		 * Fachada.getInstance().inserirAdmnistrador(new Administrador("adm3", "123",
		 * 3)); Fachada.getInstance().inserirAdmnistrador(new Administrador("adm4",
		 * "123", 4)); Fachada.getInstance().inserirAdmnistrador(new
		 * Administrador("adm5", "123", 5));
		 * Fachada.getInstance().inserirAdmnistrador(new Administrador("adm6", "123",
		 * 6)); Fachada.getInstance().inserirAdmnistrador(new Administrador("adm7",
		 * "123", 7)); Fachada.getInstance().inserirAdmnistrador(new
		 * Administrador("adm8", "123", 8));
		 * Fachada.getInstance().inserirAdmnistrador(new Administrador("adm9", "123",
		 * 9)); Fachada.getInstance().inserirAdmnistrador(new Administrador("adm10",
		 * "123", 10));
		 * 
		 * } catch (AdministradorVazioException | AdministradorJaCadastradoException e)
		 * { e.printStackTrace(); }
		 * 
		 * 
		 * try { Fachada.getInstance().inserirLoja("loja1", "12345678910", "1",
		 * "endereco1");
		 * 
		 * Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("1").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("1").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("1").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja2", "12345678910", "2", "endereco2");
		 * 
		 * Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("2").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("2").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("2").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja3", "12345678910", "3", "endereco3");
		 * 
		 * Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("3").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("3").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("3").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja4", "12345678910", "4", "endereco4");
		 * 
		 * Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("4").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("4").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("4").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja5", "12345678910", "5", "endereco5");
		 * 
		 * Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("5").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("5").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("5").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja6", "12345678910", "6", "endereco6");
		 * 
		 * Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("6").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("6").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("6").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja7", "12345678910", "7", "endereco7");
		 * 
		 * Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("7").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("7").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("7").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja8", "12345678910", "8", "endereco8");
		 * 
		 * Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("8").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("8").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("8").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja9", "12345678910", "9", "endereco9");
		 * 
		 * Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato2", 100,
		 * 20, 100)); Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato3",
		 * 100, 30, 100)); Fachada.getInstance().buscarLoja("9").inserir(new
		 * Prato("prato4", 100, 40, 100));
		 * Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato5", 100, 50,
		 * 100)); Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato6", 100,
		 * 60, 100)); Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato7",
		 * 100, 70, 100)); Fachada.getInstance().buscarLoja("9").inserir(new
		 * Prato("prato8", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato9", 100, 80,
		 * 100)); Fachada.getInstance().buscarLoja("9").inserir(new Prato("prato10",
		 * 100, 80, 100));
		 * 
		 * Fachada.getInstance().inserirLoja("loja10", "12345678910", "10",
		 * "endereco10");
		 * 
		 * Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato1", 100, 10,
		 * 100)); Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato2",
		 * 100, 20, 100)); Fachada.getInstance().buscarLoja("10").inserir(new
		 * Prato("prato3", 100, 30, 100));
		 * Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato4", 100, 40,
		 * 100)); Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato5",
		 * 100, 50, 100)); Fachada.getInstance().buscarLoja("10").inserir(new
		 * Prato("prato6", 100, 60, 100));
		 * Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato7", 100, 70,
		 * 100)); Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato8",
		 * 100, 80, 100)); Fachada.getInstance().buscarLoja("10").inserir(new
		 * Prato("prato9", 100, 80, 100));
		 * Fachada.getInstance().buscarLoja("10").inserir(new Prato("prato10", 100, 80,
		 * 100));
		 * 
		 * } catch (LojaVaziaException | LojaJaCadastradaException | PratoVazioException
		 * | PratoJaInseridoException | LojaNaoCadastradaException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * 
		 * System.out.println("Usuairos inseridos"); } catch (UsuarioVazioException |
		 * UsuarioAnteriormenteCadastradoException | UsuarioNaoCadastradoException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}

}
