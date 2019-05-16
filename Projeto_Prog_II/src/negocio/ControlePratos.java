package negocio;

import repositorio.RepositorioPratos;
import repositorio.RepositorioPratosArray;

public class ControlePratos {

	RepositorioPratos pratos = new RepositorioPratosArray();

	public void inserir(Prato prato) {
		// Incluir validacoes e regras de negocio
		pratos.inserir(prato);
	}

	public void remover(String nome) {
		// Incluir validacoes e regras de negocio
		pratos.remover(nome);
	}

	public Prato buscar(String nome) {
		// Incluir validacoes e regras de negocio
		return pratos.buscar(nome);
	}

	public void alterar(Prato prato) {
		// Incluir validacoes e regras de negocio
		pratos.alterar(prato);
	}

	public Prato[] listar() {
		// Incluir validacoes e regras de negocio
		return pratos.listar();
	}
}
