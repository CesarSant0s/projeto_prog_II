package negocio;

import java.util.List;

import excepitonRepositorioArray.AdministradorJaCadastradoException;
import excepitonRepositorioArray.AdministradorNaoEncotradoException;
import excepitonRepositorioArray.AdministradorVazioException;
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
import exception.CpfNaoCadastradoException;
import exception.IdNaoCadastradoException;
import exception.SenhaIncorretaException;
import negocioClassesBasicas.Administrador;
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
	private ControleAdiministrador adiministrador;

	public Fachada() {
		usuarios = new ControleUsuario();
		lojas = new ControleLoja();
		pedidos = new ControlePedidos();
		pratos = new ControlePratos();
		login = new ControleLogin();
		adiministrador = new ControleAdiministrador();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	// ControleLogin

	public void loginCliente(String cpf, String senha)
			throws UsuarioNaoCadastradoException, CpfNaoCadastradoException, SenhaIncorretaException {
		login.getInstance().loginCliente(cpf, senha);
	}

	public void login(int id, String senha) throws AdministradorNaoEncotradoException, IdNaoCadastradoException {
		login.getInstance().loginAdministrador(id, senha);
	}

	// ControleAdministrador

	public void inserirAdmnistrador(Administrador adm)
			throws AdministradorVazioException, AdministradorJaCadastradoException {
		adiministrador.inserirAdmnistrador(adm);
	}

	public void removerAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		adiministrador.removerAdmnistrador(id);
	}

	public Administrador buscarAdmnistrador(int id) throws AdministradorNaoEncotradoException {
		return adiministrador.buscarAdmnistrador(id);
	}

	public void alterarAdministrador(Administrador adm)
			throws AdministradorVazioException, AdministradorNaoEncotradoException {
		adiministrador.alterarAdministrador(adm);
	}

	public Administrador[] listarAdiministrador() {
		return adiministrador.listarAdministrador();
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

	public List<Prato> listar() {
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

	public void inserirLoja(String nome, String telefone, String cnpj, String endereco)
			throws LojaVaziaException, LojaJaCadastradaException {
		lojas.inserir(new Loja(nome, telefone, cnpj, endereco));
	}

	public void removerLoja(String cnpj) throws LojaNaoCadastradaException {
		lojas.remover(cnpj);
	}

	public Loja buscarLoja(String cnpj) throws LojaNaoCadastradaException {
		return lojas.buscar(cnpj);
	}

	public void alterarLoja(String nome, String telefone, String cnpj, String endereco)
			throws LojaVaziaException, LojaNaoCadastradaException {
		lojas.alterar(new Loja(nome, telefone, cnpj, endereco));
	}

	public List<Loja> listarLoja() {
		return lojas.listar();
	}

	// Controle Usuario
	public void inserirUsuarioCliente(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String endereco)
			throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException, UsuarioNaoCadastradoException {
		usuarios.inserir(new Cliente(nomeUsuario, senha, nome, telefone, cpf, endereco));
	}

	public void inserirUsuarioEntregador(String nome, String telefone, String cpf, String placaVeiculo, String email)
			throws UsuarioVazioException, UsuarioAnteriormenteCadastradoException, UsuarioNaoCadastradoException {
		usuarios.inserir(new Entregador(nome, telefone, cpf, placaVeiculo, email));

	}

	public void removerUsuario(String cpf) throws UsuarioNaoCadastradoException {
		usuarios.remover(cpf);
	}

	public Usuario buscarUsuario(String cpf) throws UsuarioNaoCadastradoException {
		return usuarios.buscar(cpf);
	}

	public void atualizarUsuarioEntregador(String nome, String telefone, String cpf, String placaVeiculo, String email)
			throws UsuarioVazioException, UsuarioNaoCadastradoException {
		usuarios.atualizar(new Entregador(nome, telefone, cpf, placaVeiculo, email));
	}

	public void atualizarUsuarioCliente(String nomeUsuario, String senha, String nome, String telefone, String cpf,
			String endereco) throws UsuarioVazioException, UsuarioNaoCadastradoException {
		usuarios.atualizar(new Cliente(nomeUsuario, senha, nome, telefone, cpf, endereco));
	}

	public Usuario[] listarUsuario() {
		return usuarios.listar();
	}

}
