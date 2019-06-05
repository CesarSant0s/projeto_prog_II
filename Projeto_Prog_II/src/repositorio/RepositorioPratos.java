package repositorio;

import java.util.ArrayList;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Prato;

public interface RepositorioPratos {

	public void inserir(Prato prato) throws PratoVazioException, PratoJaInseridoException;

	public void remover(String nomePrato) throws PratoNaoEncontradoException;

	public Prato buscar(String nomePrato) throws PratoNaoEncontradoException;

	public void alterar(Prato novoPrato) throws PratoVazioException, PratoNaoEncontradoException;

	public ArrayList<Prato> listar();

}
