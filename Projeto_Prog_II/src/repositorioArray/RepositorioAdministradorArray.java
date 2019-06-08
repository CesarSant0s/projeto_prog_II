package repositorioArray;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocioClassesBasicas.Administrador;
import negocioClassesBasicas.Loja;
import repositorio.RepositorioAdministrador;

public class RepositorioAdministradorArray implements RepositorioAdministrador {
	private Administrador[] array;
	private int indice;
	private static final int TAMANHO = 100;
	private static RepositorioAdministradorArray instance;

	public static RepositorioAdministradorArray getInstance() {
		if (instance == null) {
			instance = new RepositorioAdministradorArray();
		}
		return instance;
	}

	@Override
	public void inserir(Administrador administrador)
			throws AdministradorVazioException, AdministradorJaCadastradoException {
		if (administrador == null) {

			AdministradorVazioException e = new AdministradorVazioException();
			throw e;

		} else {

			Administrador resultadoBusca = null;
			for (int i = 0; i < indice; i++) {
				if (administrador.getId() == array[i].getId()) {
					resultadoBusca = array[i];
				}
			}

			if (resultadoBusca != null) {

				AdministradorJaCadastradoException e = new AdministradorJaCadastradoException();
				throw e;
			} else {
				array[indice] = administrador;
				indice++;
			}
		}
	}

	@Override
	public void remover(int id) throws AdministradorNaoEncotradoException {
		buscar(id);

		for (int i = 0, j = indice; i < j; i++) {
			if (id == array[i].getId()) {
				array[i] = array[indice];
				array[--indice] = null;
				indice--;
			}
		}

	}

	@Override
	public Administrador buscar(int id) throws AdministradorNaoEncotradoException {
		Administrador resultadoBusca = null;

		if (indice > 0) {
			for (int i = 0, j = indice; i < j; i++) {
				if (id == array[i].getId()) {
					resultadoBusca = array[i];
				}
			}

		} else {
			resultadoBusca = null;
		}

		if (resultadoBusca == null) {
			AdministradorNaoEncotradoException e = new AdministradorNaoEncotradoException();
			throw e;
		} else {
			return resultadoBusca;
		}

	}

	@Override
	public void alterar(Administrador novoAdministrador)
			throws AdministradorVazioException, AdministradorNaoEncotradoException {
		if (novoAdministrador == null) {

			AdministradorVazioException e = new AdministradorVazioException();

			throw e;
		} else {

			buscar(novoAdministrador.getId());

			for (int i = 0, j = indice; i < j; i++) {
				if (novoAdministrador.getId() == array[i].getId()) {
					array[i] = novoAdministrador;
				}
			}
		}

	}

	@Override
	public Administrador[] listarAdministrador() {
		return array;
	}

}
