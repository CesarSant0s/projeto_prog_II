package guiCliente;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.PedidoJaInseridoException;
import excepitonRepositorioArray.PedidoVazioException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;
import negocio.Fachada;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCompraClienteLojaPratos extends JFrame {

	private JPanel contentPane;
	private JTable tableLojas;
	private ModeloTabelaPratos modeloPratoCardapio;
	private ModeloTabelaPratos modeloPratoPratoEscolhido;
	private JButton buttonIndice;
	private JButton btnExibir;
	private JLabel lblInidice;
	private JTextField textIndice;
	private JButton button;
	private JTable tabelaPrato;

	private RepositorioPratos pratosEscolhidos;
	private JTextField textFieldValorTotal;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompraClienteLojaPratos frame = new TelaCompraClienteLojaPratos("", "");
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

	public TelaCompraClienteLojaPratos(String cnpj, String cpf) {

		pratosEscolhidos = new RepositorioPratosArray();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modeloPratoCardapio = new ModeloTabelaPratos();
		tableLojas = new JTable(modeloPratoCardapio);
		tableLojas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableLojas.setBounds(68, 163, 100, 30);
		tableLojas.setPreferredScrollableViewportSize(new Dimension(500, 100));
		tableLojas.setFillsViewportHeight(true);

		JScrollPane scrollPaneLojas = new JScrollPane(tableLojas);
		scrollPaneLojas.setBounds(12, 33, 426, 165);
		contentPane.add(scrollPaneLojas);

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCompraClienteLojas tela = new TelaCompraClienteLojas(cpf);
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(450, 173, 147, 25);
		contentPane.add(btnVoltar);

		buttonIndice = new JButton("Adicionar prato");
		buttonIndice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Prato pratoNovo = Fachada.getInstance().buscarLoja(cnpj).listar()
							.get(Integer.parseInt(textIndice.getText()) - 1);
					pratosEscolhidos.inserir(pratoNovo);

				} catch (NumberFormatException | LojaNaoCadastradaException | PratoVazioException
						| PratoJaInseridoException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}
				float valorTotal = 0;

				for (Prato p : pratosEscolhidos.listar()) {
					valorTotal += p.getValorDoPrato();
				}

				textFieldValorTotal.setText("ValorTotal:" + valorTotal);
				exibirPratosEscolhidos();

			}
		});
		buttonIndice.setForeground(new Color(128, 0, 0));
		buttonIndice.setBackground(Color.WHITE);
		buttonIndice.setBounds(450, 244, 147, 25);
		contentPane.add(buttonIndice);

		btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				while (modeloPratoCardapio.getRowCount() > 0) {
					modeloPratoCardapio.removePratoAt(0);
				}

				try {
					ArrayList<Prato> cardapio = new ArrayList<Prato>();
					cardapio = (ArrayList<Prato>) Fachada.getInstance().buscarLoja(cnpj).listar();
					modeloPratoCardapio.addPratoList(cardapio);
				} catch (LojaNaoCadastradaException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

			}
		});
		btnExibir.setForeground(new Color(128, 0, 0));
		btnExibir.setBackground(Color.WHITE);
		btnExibir.setBounds(450, 33, 147, 25);
		contentPane.add(btnExibir);

		lblInidice = new JLabel("Inidice:");
		lblInidice.setForeground(Color.WHITE);
		lblInidice.setBackground(Color.WHITE);
		lblInidice.setBounds(615, 246, 50, 15);
		contentPane.add(lblInidice);

		JLabel lblCardapio = new JLabel("Cardapio:");
		lblCardapio.setForeground(Color.WHITE);
		lblCardapio.setBounds(12, 6, 66, 15);
		contentPane.add(lblCardapio);

		JLabel lblNewLabel = new JLabel("Pratos Escolhidos:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 218, 124, 15);
		contentPane.add(lblNewLabel);

		textIndice = new JTextField();
		textIndice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "987654321";

				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		textIndice.setBounds(615, 281, 75, 25);
		contentPane.add(textIndice);
		textIndice.setColumns(10);

		button = new JButton("Remover prato");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pratosEscolhidos
							.remover(pratosEscolhidos.listar().get(Integer.parseInt(textIndice.getText())).getNome());
				} catch (NumberFormatException | PratoNaoEncontradoException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
				exibirPratosEscolhidos();

			}
		});
		button.setForeground(new Color(128, 0, 0));
		button.setBackground(Color.WHITE);
		button.setBounds(450, 281, 147, 25);
		contentPane.add(button);

		JButton btnFinalizarPedido = new JButton("Fazer Pedido");
		btnFinalizarPedido.setForeground(new Color(128, 0, 0));
		btnFinalizarPedido.setBackground(Color.WHITE);
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Cliente clientePedido = null;
				Loja lojaPedido = null;
				try {
					clientePedido = (Cliente) Fachada.getInstance().buscarUsuario(cpf);
					lojaPedido = Fachada.getInstance().buscarLoja(cnpj);
					int codigo = Fachada.getInstance().fazerPedido(clientePedido, lojaPedido,
							pratosEscolhidos.listar());

					TelaCompraClienteFinalizacao tela = new TelaCompraClienteFinalizacao(codigo);
					tela.setVisible(true);
					dispose();
				} catch (UsuarioNaoCadastradoException | LojaNaoCadastradaException | PedidoJaInseridoException
						| PedidoVazioException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
					// e.printStackTrace();
				}

			}
		});
		btnFinalizarPedido.setBounds(450, 385, 147, 25);
		contentPane.add(btnFinalizarPedido);

		modeloPratoPratoEscolhido = new ModeloTabelaPratos();
		tabelaPrato = new JTable(modeloPratoPratoEscolhido);
		tabelaPrato.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelaPrato.setBounds(68, 163, 100, 30);
		tabelaPrato.setPreferredScrollableViewportSize(new Dimension(500, 100));
		tabelaPrato.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabelaPrato);
		scrollPane.setBounds(12, 245, 426, 165);
		contentPane.add(scrollPane);

		textFieldValorTotal = new JTextField();
		textFieldValorTotal.setBounds(450, 320, 147, 25);
		contentPane.add(textFieldValorTotal);
		textFieldValorTotal.setColumns(10);

	}

	public void exibirPratosEscolhidos() {

		while (modeloPratoPratoEscolhido.getRowCount() > 0) {
			modeloPratoPratoEscolhido.removePratoAt(0);
		}
		modeloPratoPratoEscolhido.addPratoList(pratosEscolhidos.listar());
	}
}
