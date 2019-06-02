package negocio;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PedidoVazioException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import excepitonRepositorioArray.QuantidadeIndisponivelException;
import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import exception.CnpjNaoCadastradoException;
import exception.CpfNaoCadastradoException;
import exception.SenhaIncorretaException;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Pedido;
import negocioClassesBasicas.Prato;
import negocioClassesBasicas.Usuario;

public class Fachada {

	private static Fachada instance;
	private ControleUsuario usuarios;
	private ControleLoja lojas;
	private ControlePedidos pedidos;
	private ControlePratos pratos;
	private ControleLogin login;

	public Fachada() {
		usuarios = new ControleUsuario();
		lojas = new ControleLoja();
		pedidos = new ControlePedidos();
		pratos = new ControlePratos();
		login = new ControleLogin();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	// ControleLogin

	public void loginUsuario(String cpf, String senha)
			throws UsuarioNaoCadastradoException, CpfNaoCadastradoException, SenhaIncorretaException {
		login.getInstance().loginUsuario(cpf, senha);
	}

	public void loginLoja(String cnpj, String senha)
			throws LojaNaoCadastradaException, CnpjNaoCadastradoException, SenhaIncorretaException {
		login.getInstance().lojaLogin(cnpj, senha);
	}

	// Controle Pratos
	public void inserirPrato(String nome, float peso, float valorDoPrato, int quantiadeDisponivel)
			throws PratoVazioException, PratoJaInseridoException {
		pratos.inserir(new Prato(nome, peso, valorDoPrato, quantiadeDisponivel));
	}

	public void removerPrato(String nome) throws PratoNaoEncontradoException {
		pratos.remover(nome);
	}

	public Prato buscarPrato(String nome) throws PratoNaoEncontradoException {
		return pratos.buscar(nome);
	}

	public void alterarPrato(String nome, float peso, float valorDoPrato, int quantiadeDisponivel)
			throws PratoVazioException, PratoNaoEncontradoException {

		pratos.alterar(new Prato(nome, peso, valorDoPrato, quantiadeDisponivel));

	}

	public Prato[] listar() {
		return pratos.listar();
	}

	// Controle Pedido
	public void FazerPedido(String cpfCliente, String cpfEntregador, String cnpjLoja) throws PedidoJaInseridoException,
			PedidoVazioException, UsuarioNaoCadastradoException, LojaNaoCadastradaException {

		Cliente cliente = (Cliente) getInstance().buscarUsuario(cpfCliente);
		Entregador entregador = (Entregador) getInstance().buscarUsuario(cpfEntregador);
		Loja loja = getInstance().buscarLoja(cnpjLoja);
		pedidos.FazerPedido(new Pedido(cliente, loja, entregador));

	}

	public void FinalizarPedido(int codigo) throws PedidoNaoCadastrado, PratoNaoEncontradoException,
			LojaNaoCadastradaException, QuantidadeIndisponivelException {
		pedidos.finalizarPedido(codigo);
	}

	public Pedido buscarPedido(int codigo) throws PedidoNaoCadastrado {
		return pedidos.buscar(codigo);
	}

	public void alterarPedido(Pedido pedido) throws PedidoVazioException, PedidoNaoCadastrado {

		pedidos.alterar(pedido);
	}

	public Pedido[] listarPedido() {
		return pedidos.listar();
	}

	// Controle Loja

	public void inserirLoja(String nomeUsuario, String senha, String nome, String telefone, String cnpj,
			String endereco) throws LojaVaziaException, LojaJaCadastradaException {
		lojas.inserir(new Loja(nomeUsuario, senha, nome, telefone, cnpj, endereco));
	}

	public void removerLoja(String cnpj) throws LojaNaoCadastradaException {
		lojas.remover(cnpj);
	}

	public Loja buscarLoja(String cnpj) throws LojaNaoCadastradaException {
		return lojas.buscar(cnpj);
	}

	public void alterarLoja(String nomeUsuario, String senha, String nome, String telefone, String cnpj,
			String endereco) throws LojaVaziaException, LojaNaoCadastradaException {
		lojas.alterar(new Loja(nomeUsuario, senha, nome, telefone, cnpj, endereco));
	}

	public Loja[] listarLoja() {
		return lojas.listar();
	}

	// Controle Usuario
	public void inserirUsuarioCliente(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String endereco)
			throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException, UsuarioNaoCadastradoException {

		usuarios.inserir(new Cliente(nomeUsuario, senha, nome, telefone, cpf, endereco));

	}

	public void inserirUsuarioEntregador(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String placaVeiculo)
			throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException, UsuarioNaoCadastradoException {

		usuarios.inserir(new Entregador(nomeUsuario, senha, nome, telefone, cpf, placaVeiculo));

	}

	public void removerUsuario(String cpf) throws UsuarioNaoCadastradoException {

		usuarios.remover(cpf);

	}

	public Usuario buscarUsuario(String cpf) throws UsuarioNaoCadastradoException {

		return usuarios.buscar(cpf);

	}

	public void atualizarUsuarioEntregador(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String placaVeiculo) throws UsuarioVazioException, UsuarioNaoCadastradoException {

		usuarios.atualizar(new Entregador(nomeUsuario, senha, nome, telefone, cpf, placaVeiculo));
	}

	public void atualizarUsuarioCliente(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String endereco) throws UsuarioVazioException, UsuarioNaoCadastradoException {

		usuarios.atualizar(new Cliente(nomeUsuario, senha, nome, telefone, cpf, endereco));
	}

	public Usuario[] listarUsuario() {
		return usuarios.listar();
	}

}
