package repositorioArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocioClassesBasicas.Usuario;
import repositorio.RepositorioUsuario;

public class RepositorioUsuarioArray implements RepositorioUsuario, Serializable {

	private Usuario[] array;
	private int indice;
	private int TAMANHO = 100;
	private static RepositorioUsuarioArray instance;

	public RepositorioUsuarioArray() {
		array = new Usuario[TAMANHO];
		indice = 0;
	}

	public static RepositorioUsuarioArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static RepositorioUsuarioArray lerDoArquivo() {
		RepositorioUsuarioArray instanciaLocal = null;
		// Criando um arquivo e passando o nome dele
		File in = new File("Usuario.dat");
		// criando um arquivo .dat na pasta do projeto

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioUsuarioArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioUsuarioArray();
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

			File out = new File("Usuario.dat");
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
	public void inserir(Usuario usuario) throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException {

		if (usuario == null) {

			UsuarioVazioException e = new UsuarioVazioException();
			throw e;

		} else {

			Usuario resultadoBusca = null;
			for (int i = 0; i < indice; i++) {
				if (usuario.getCpf().equals(array[i].getCpf())) {
					resultadoBusca = array[i];
				}
			}

			if (resultadoBusca != null) {
				UsuarioAnteriormenteCadastradoException e = new UsuarioAnteriormenteCadastradoException(usuario);
				throw e;
			} else {
				array[indice] = usuario;
				indice++;
			}

		}

	}

	@Override
	public void atualizar(Usuario usuario) throws UsuarioVazioException, UsuarioNaoCadastradoException {

		if (usuario == null) {
			UsuarioVazioException e = new UsuarioVazioException();
			throw e;
		} else {
			buscar(usuario.getCpf());
			for (int i = 0, j = indice; i < j; i++) {
				if (usuario.getCpf().equals(array[i].getCpf())) {
					array[i] = usuario;

				}
			}
		}

	}

	@Override
	public Usuario buscar(String cpf) throws UsuarioNaoCadastradoException {

		Usuario resulUsuario = null;

		if (indice > 0) {
			for (int i = 0; i < indice; i++) {
				if (cpf.equals(array[i].getCpf())) {
					resulUsuario = array[i];
				}
			}
		} else {
			resulUsuario = null;
		}

		if (resulUsuario == null) {
			UsuarioNaoCadastradoException e = new UsuarioNaoCadastradoException(cpf);
			throw e;
		} else {
			return resulUsuario;
		}

	}

	@Override
	public void remover(String cpf) throws UsuarioNaoCadastradoException {

		buscar(cpf);

		for (int i = 0; i < indice; i++) {

			if (cpf.equals(array[i].getCpf())) {

				array[i] = array[indice - 1];
				array[indice - 1] = null;
				indice--;
			}

		}

	}

	@Override
	public ArrayList<Usuario> listar() {

		ArrayList<Usuario> resultado = new ArrayList<Usuario>();

		for (Usuario u : array) {
			resultado.add(u);
		}

		return resultado;
	}

}
