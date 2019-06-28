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

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Prato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaAdministradorPedidoPrato extends JFrame {

	private static TelaAdministradorPedidoPrato instance;

	private JPanel contentPane;
	private JButton btnVoltar;
	private JPanel panelListar;

	public static TelaAdministradorPedidoPrato getInstance() {
		if (TelaAdministradorPedidoPrato.instance == null) {
			TelaAdministradorPedidoPrato.instance = new TelaAdministradorPedidoPrato(0);
		}
		return TelaAdministradorPedidoPrato.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorPedidoPrato frame = new TelaAdministradorPedidoPrato(0);
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

	public TelaAdministradorPedidoPrato(int codigo) {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorPedido tela = new TelaAdministradorPedido();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(328, 12, 127, 25);
		contentPane.add(btnVoltar);

		cabecalhoListagem();

		JButton btnListarCardapio = new JButton("Ver Cardapio");
		btnListarCardapio.setForeground(new Color(128, 0, 0));
		btnListarCardapio.setBackground(Color.WHITE);
		btnListarCardapio.addActionListener(new ActionListener() { // Aqui dentro e fora do construtor da
																	// TelaAdministrador
			public void actionPerformed(ActionEvent arg0) {
				panelListar.removeAll(); // Remove todos os elementos para nao ficarem duplicados
				cabecalhoListagem();

				ArrayList<Prato> arrayPratos = new ArrayList<Prato>();
				try {
					arrayPratos = Fachada.getInstance().buscarPedido(codigo).getPratosEscolhidos().listar();
				} catch (PedidoNaoCadastrado e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
					// e.printStackTrace();
				}

				for (Prato prato : arrayPratos) { /* Insere os elementos que estao no repositorio */
					panelListar.revalidate(); // Tem que revalidar a tela quando adicionar fora do construtor
					JPanel linha = new JPanel();
					linha.setLayout(new GridLayout(1, 2));
					JLabel nome = new JLabel(prato.getNome());
					JLabel valor = new JLabel(new String("" + prato.getValorDoPrato()));
					nome.setHorizontalAlignment(JLabel.CENTER);
					valor.setHorizontalAlignment(JLabel.CENTER);
					linha.add(nome);
					linha.add(valor);
					panelListar.add(linha);
					panelListar.add(Box.createRigidArea(new Dimension(0, 5)));
					panelListar.repaint(); // Repintar por garantia
				}

			}
		});
		btnListarCardapio.setBounds(328, 49, 127, 25);
		contentPane.add(btnListarCardapio);

		panelListar = new JPanel();
		panelListar.setBounds(39, 12, 277, 228);
		contentPane.add(panelListar);
		panelListar.setLayout(new BoxLayout(panelListar, BoxLayout.PAGE_AXIS));
		panelListar.setVisible(true);
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
		JLabel nome = new JLabel("NOME");
		JLabel valor = new JLabel("VALOR");
		nome.setVerticalAlignment(JLabel.TOP);
		nome.setHorizontalAlignment(JLabel.CENTER);
		valor.setVerticalAlignment(JLabel.TOP);
		valor.setHorizontalAlignment(JLabel.CENTER);
		titulo.add(nome);
		titulo.add(valor);
		panelListar.add(titulo);

	}

	public void cabecalhoListagem() { // Coloca o cabe\E7alho CNPJ e NOME no topo da listagem
		panelListar.revalidate();
		panelListar.repaint();

	}
}
