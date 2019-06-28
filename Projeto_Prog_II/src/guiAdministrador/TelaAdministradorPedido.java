package guiAdministrador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Pedido;
import negocioClassesBasicas.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaAdministradorPedido extends JFrame {

	private static TelaAdministradorPedido instance;

	private JPanel contentPane;
	private JTextField textNomeCliente;
	private JTextField textNomeLoja;
	private JTextField textcodigo;
	private JTextField textValorTotal;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JTextField textCodigoParaBusca;
	private JButton buttonBuscar;
	private JLabel labelCpfBusca;
	private JLabel lblAdministrarPedido;
	private JPanel panelListar;

	public static TelaAdministradorPedido getInstance() {
		if (TelaAdministradorPedido.instance == null) {
			TelaAdministradorPedido.instance = new TelaAdministradorPedido();
		}
		return TelaAdministradorPedido.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorPedido frame = new TelaAdministradorPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAdministradorPedido() {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCliente.setForeground(new Color(255, 255, 255));
		lblNomeCliente.setBounds(15, 44, 123, 15);
		getContentPane().add(lblNomeCliente);

		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(144, 39, 160, 25);
		getContentPane().add(textNomeCliente);
		textNomeCliente.setColumns(10);

		JLabel lblTelefone = new JLabel("Nome Loja:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(37, 81, 101, 15);
		getContentPane().add(lblTelefone);

		textNomeLoja = new JTextField();
		textNomeLoja.setBounds(144, 76, 160, 25);
		getContentPane().add(textNomeLoja);
		textNomeLoja.setColumns(10);

		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(69, 118, 69, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNomeLogin = new JLabel("Valor Total:");
		lblNomeLogin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeLogin.setForeground(new Color(255, 255, 255));
		lblNomeLogin.setBounds(37, 155, 101, 15);
		getContentPane().add(lblNomeLogin);

		textcodigo = new JTextField();
		textcodigo.setBounds(144, 113, 160, 25);
		getContentPane().add(textcodigo);
		textcodigo.setColumns(10);

		textValorTotal = new JTextField();
		textValorTotal.setBounds(144, 150, 160, 25);
		getContentPane().add(textValorTotal);
		textValorTotal.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministrador tela = new TelaAdministrador();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(12, 275, 101, 25);
		contentPane.add(btnVoltar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textcodigo.setText("");
				textValorTotal.setText("");
				textNomeCliente.setText("");
				textNomeLoja.setText("");

			}
		});
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(358, 76, 101, 25);
		contentPane.add(btnLimpar);

		textCodigoParaBusca = new JTextField();
		textCodigoParaBusca.setColumns(10);
		textCodigoParaBusca.setBounds(299, 275, 160, 25);
		contentPane.add(textCodigoParaBusca);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Pedido p = Fachada.getInstance().buscarPedido(Integer.parseInt(textCodigoParaBusca.getText()));
					textcodigo.setText("" + p.getCodigo());
					textValorTotal.setText("" + p.getValorTotal());
					textNomeCliente.setText(p.getCliente().getNome());
					textNomeLoja.setText(p.getLoja().getNome());

				} catch (NumberFormatException | PedidoNaoCadastrado e) {

					JOptionPane.showMessageDialog(contentPane, "Pedido nao encotrado", "", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

			}
		});

		buttonBuscar.setForeground(new Color(128, 0, 0));
		buttonBuscar.setBackground(Color.WHITE);
		buttonBuscar.setBounds(358, 113, 101, 25);
		contentPane.add(buttonBuscar);

		labelCpfBusca = new JLabel("Codigo para busca:");
		labelCpfBusca.setForeground(Color.WHITE);
		labelCpfBusca.setFont(new Font("Dialog", Font.BOLD, 13));
		labelCpfBusca.setBounds(158, 280, 141, 15);
		contentPane.add(labelCpfBusca);

		lblAdministrarPedido = new JLabel("Administrar Pedido");
		lblAdministrarPedido.setForeground(Color.WHITE);
		lblAdministrarPedido.setBounds(148, 12, 192, 15);
		contentPane.add(lblAdministrarPedido);

		panelListar = new JPanel();
		panelListar.setLayout(new BoxLayout(panelListar, BoxLayout.PAGE_AXIS));
		panelListar.setVisible(true);

		cabecalhoListagem();

		JScrollPane scrollPane = new JScrollPane(panelListar);
		scrollPane.setBounds(487, 25, 280, 231);
		contentPane.add(scrollPane);

		JButton btnListarCardapio = new JButton("Listar");
		btnListarCardapio.setForeground(new Color(128, 0, 0));
		btnListarCardapio.setBackground(Color.WHITE);
		btnListarCardapio.addActionListener(new ActionListener() { // Aqui dentro e fora do construtor da
																	// TelaAdministrador
			public void actionPerformed(ActionEvent arg0) {
				panelListar.removeAll(); // Remove todos os elementos para nao ficarem duplicados
				cabecalhoListagem();

				Pedido[] arrayPedido = null;
				try {
					arrayPedido = Fachada.getInstance().listarPedido();

					ArrayList<Pedido> list = new ArrayList<Pedido>();

					for (int i = 0; i < arrayPedido.length; i++) {
						list.add(arrayPedido[i]);
					}

					for (Pedido p : list) { /* Insere os elementos que estao no repositorio */

						panelListar.revalidate(); // Tem que revalidar a tela quando adicionar fora do construtor
						JPanel linha = new JPanel();
						linha.setLayout(new GridLayout(1, 2));
						JLabel codigo = new JLabel("" + p.getCodigo());
						JLabel nome = new JLabel(p.getCliente().getNome());
						codigo.setHorizontalAlignment(JLabel.CENTER);
						nome.setHorizontalAlignment(JLabel.CENTER);
						linha.add(codigo);
						linha.add(nome);
						panelListar.add(linha);
						panelListar.add(Box.createRigidArea(new Dimension(0, 5)));
						panelListar.repaint(); // Repintar por garantia

					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Não existem pedidos cadastrados", "error",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnListarCardapio.setBounds(358, 39, 101, 25);
		contentPane.add(btnListarCardapio);

		JButton btnVerPratos = new JButton("Ver Pratos");
		btnVerPratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					TelaAdministradorPedidoPrato tela = new TelaAdministradorPedidoPrato(
							Integer.parseInt(textCodigoParaBusca.getText()));
					tela.setVisible(true);
					dispose();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Pedido nao encontrado", "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnVerPratos.setForeground(new Color(128, 0, 0));
		btnVerPratos.setBackground(Color.WHITE);
		btnVerPratos.setBounds(144, 195, 160, 25);
		contentPane.add(btnVerPratos);

	}

	public void cabecalhoListagem() { // Coloca o cabe\E7alho CNPJ e NOME no topo da listagem
		panelListar.revalidate();
		panelListar.add(Box.createRigidArea(new Dimension(0, 5)));
		JPanel titulo = new JPanel() { // Classe an\F4nima
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) { // M\E9todo para desenhar no painel
				super.paintComponent(g);
				g.drawLine(0, 0, 280, 0);
				g.drawLine(0, 16, 280, 16);
			}
		};
		titulo.setLayout(new GridLayout(1, 2));
		JLabel codigo = new JLabel("CODIGO");
		JLabel CLIENTE = new JLabel("CLIENTE");
		codigo.setVerticalAlignment(JLabel.TOP);
		codigo.setHorizontalAlignment(JLabel.CENTER);
		CLIENTE.setVerticalAlignment(JLabel.TOP);
		CLIENTE.setHorizontalAlignment(JLabel.CENTER);
		titulo.add(codigo);
		titulo.add(CLIENTE);
		panelListar.add(titulo);
		panelListar.repaint();

	}
}
