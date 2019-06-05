package repositorioArray;

import java.util.ArrayList;
import java.util.List;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioLoja;

public class RepositorioLojaArray implements RepositorioLoja {
	private Loja[] array;
	private int indice;
	private static final int TAMANHO = 100;
	

	public RepositorioLojaArray() {
		array = new Loja[TAMANHO];
	}

	@Override
	public void inserir(Loja loja) throws LojaVaziaException, LojaJaCadastradaException {

		if (loja == null) {

			LojaVaziaException e = new LojaVaziaException();

			throw e;

		} else {

			Loja resultadoBusca = null;
			for (int i = 0; i < indice; i++) {
				if (loja.getCnpj().equals(array[i].getCnpj())) {
					resultadoBusca = array[i];
				}
			}

			if (resultadoBusca != null) {

				LojaJaCadastradaException e = new LojaJaCadastradaException();
				throw e;
			} else {
				array[indice] = loja;
				indice++;
			}
		}
	}

	@Override
	public void remover(String cnpj) throws LojaNaoCadastradaException {

		buscar(cnpj);

		for (int i = 0, j = indice; i < j; i++) {
			if (cnpj.equals(array[i].getCnpj())) {
				array[i] = array[indice];
				array[--indice] = null;
				indice--;
			}
		}
	}

	@Override
	public Loja buscar(String cnpj) throws LojaNaoCadastradaException {

		Loja resultadoBusca = null;

		if (indice > 0) {
			for (int i = 0, j = indice; i < j; i++) {
				if (cnpj.equals(array[i].getCnpj())) {
					resultadoBusca = array[i];
				}
			}

		} else {
			resultadoBusca = null;
		}

		if (resultadoBusca == null) {
			LojaNaoCadastradaException e = new LojaNaoCadastradaException();
			throw e;
		} else {
			return resultadoBusca;
		}

	}

	@Override
	public void alterar(Loja novoLoja) throws LojaVaziaException, LojaNaoCadastradaException {

		if (novoLoja == null) {

			LojaVaziaException e = new LojaVaziaException();

			throw e;
		} else {

			buscar(novoLoja.getCnpj());

			for (int i = 0, j = indice; i < j; i++) {
				if (novoLoja.getCnpj().equals(array[i].getCnpj())) {
					array[i] = novoLoja;
				}
			}
		}

	}

public List listarLoja() {
		
		List lojas = new ArrayList();
		int i = 0;
		while(i < indice) {	
			lojas.add(array[i]);
			 i++;
			}
		return lojas;
	}

}
