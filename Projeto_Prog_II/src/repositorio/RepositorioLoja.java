package repositorio;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocioClassesBasicas.Loja;

public interface RepositorioLoja {

	public void inserir(Loja loja) throws LojaVaziaException, LojaJaCadastradaException;

	public void remover(String cnpj) throws LojaNaoCadastradaException;

	public Loja buscar(String cnpj) throws LojaNaoCadastradaException;

	public void alterar(Loja novoLoja) throws LojaVaziaException, LojaNaoCadastradaException;

	public Loja[] listarLoja();
}
