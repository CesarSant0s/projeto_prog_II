package negocio;

public class Fachada {

	private static Fachada instance;
	private ControleUsuario usuarios;
	private ControleLoja lojas;
	private ControlePedidos pedidos;
	private ControlePratos pratos;

	public Fachada() {
		usuarios = new ControleUsuario();
		lojas = new ControleLoja();
		pedidos = new ControlePedidos();
		pratos = new ControlePratos();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	// Controle Pratos
	public void inserirPrato(Prato prato) {
		pratos.inserir(prato);
	}

	public void removerPrato(String nome) {
		pratos.remover(nome);
	}

	public Prato buscarPrato(String nome) {
		return pratos.buscar(nome);
	}

	public void alterarPrato(Prato prato) {
		pratos.alterar(prato);
	}

	public Prato[] listar() {
		return pratos.listar();
	}

	// Controle Pedido
	public void inserirPedido(Pedido pedido) {
		pedidos.inserir(pedido);
	}

	public void removerPedido(int codigo) {
		pedidos.remover(codigo);
	}

	public Pedido buscarPedido(int codigo) {
		return pedidos.buscar(codigo);
	}

	public void alterarPedido(Pedido pedido) {
		pedidos.alterar(pedido);
	}

	public Pedido[] listarPedido() {
		return pedidos.listar();
	}

	// Controle Loja
	public void inserirLoja(Loja loja) {
		lojas.inserir(loja);
	}

	public void removerLoja(String cnpj) {
		lojas.remover(cnpj);
	}

	public Loja buscarLoja(String cnpj) {
		return lojas.buscar(cnpj);
	}

	public void alterarLoja(Loja loja) {
		lojas.alterar(loja);
	}

	public Loja[] listarLoja() {
		return lojas.listar();
	}

	// Controle Usuario
	public void inserirUsuario(Usuario usuario) {
		usuarios.inserir(usuario);
	}

	public void removerUsuario(String cpf) {
		usuarios.remover(cpf);
	}

	public Usuario buscarUsuario(String cpf) {
		return usuarios.buscar(cpf);
	}

	public void atualizarUsuario(Usuario usuario) {
		usuarios.atualizar(usuario);
	}

	public Usuario[] listarUsuario() {
		return usuarios.listar();
	}

}
