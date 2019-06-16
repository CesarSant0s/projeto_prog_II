package repositorioArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocioClassesBasicas.Loja;
import repositorio.RepositorioLoja;

public class RepositorioLojaArray implements RepositorioLoja, Serializable {
	private Loja[] array;
	private int indice;
	private int TAMANHO = 100;
	private static RepositorioLojaArray instance;

	public RepositorioLojaArray() {
		array = new Loja[TAMANHO];
		indice = 0;
	}

	public static RepositorioLojaArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static RepositorioLojaArray lerDoArquivo() {
		RepositorioLojaArray instanciaLocal = null;
		// Criando um arquivo e passando o nome dele
		File in = new File("lojas.dat");// criando um arquivo .dat na pasta do projeto

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioLojaArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioLojaArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (!(instance == null)) {

			File out = new File("lojas.dat");
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream(out);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(instance);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
					}
				}
			}
		}
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

		for (int i = 0, j = indice; i < j; i++) {
			if (array[i] != null && cnpj.equals(array[i].getCnpj())) {
				resultadoBusca = array[i];
			}
		}

		if (resultadoBusca == null) {
			LojaNaoCadastradaException e = new LojaNaoCadastradaException();
			throw e;
		}
		return resultadoBusca;

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

	public ArrayList<Loja> listarLoja() {

		ArrayList<Loja> lojas = new ArrayList<Loja>();
		int i = 0;
		while (i < indice) {
			lojas.add(array[i]);
			i++;
		}
		return lojas;
	}

}
