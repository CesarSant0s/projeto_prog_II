
package guiAdministrador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import negocio.Fachada;
import negocioClassesBasicas.Loja;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class TelaAdministradorLoja extends JFrame {

	private static final long serialVersionUID = 1L;

	private static TelaAdministradorLoja instance;

	private JPanel contentPane;
	private JTextField textNomeLoja;
	private JTextField textTelefone;
	private JTextField textCnpj;
	private JTextField textEndereco;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnLimpar;
	private JButton btnRemover;
	private JTextField textFieldCpefBusca;
	private JButton buttonBuscar;
	private JLabel labelCnpjBusca;
	private JLabel lblAdministrarEntregador;
	private JButton btnCardapio;
	private JLabel lblCardapio;
	private JPanel panelListar;

	public static TelaAdministradorLoja getInstance() {
		if (TelaAdministradorLoja.instance == null) {
			TelaAdministradorLoja.instance = new TelaAdministradorLoja();
		}
		return TelaAdministradorLoja.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorLoja frame = new TelaAdministradorLoja();
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
	public TelaAdministradorLoja() {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeLoja = new JLabel("Nome da Loja:");
		lblNomeLoja.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeLoja.setForeground(new Color(255, 255, 255));
		lblNomeLoja.setBounds(32, 44, 106, 15);
		getContentPane().add(lblNomeLoja);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEndereco.setForeground(new Color(255, 255, 255));
		lblEndereco.setBounds(65, 155, 73, 15);
		getContentPane().add(lblEndereco);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(69, 81, 69, 15);
		getContentPane().add(lblTelefone);

		JLabel lblCnpj = new JLabel("Cnpj:");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCnpj.setForeground(new Color(255, 255, 255));
		lblCnpj.setBounds(101, 118, 37, 15);
		getContentPane().add(lblCnpj);

		labelCnpjBusca = new JLabel("Cnpj para busca:");
		labelCnpjBusca.setForeground(Color.WHITE);
		labelCnpjBusca.setFont(new Font("Dialog", Font.BOLD, 13));
		labelCnpjBusca.setBounds(170, 242, 129, 15);
		contentPane.add(labelCnpjBusca);

		lblAdministrarEntregador = new JLabel("Administrar Loja");
		lblAdministrarEntregador.setForeground(Color.WHITE);
		lblAdministrarEntregador.setBounds(138, 12, 192, 15);
		contentPane.add(lblAdministrarEntregador);

		lblCardapio = new JLabel("Cardapio:");
		lblCardapio.setForeground(Color.WHITE);
		lblCardapio.setBounds(72, 192, 66, 15);
		contentPane.add(lblCardapio);

		textNomeLoja = new JTextField();
		textNomeLoja.setBounds(144, 39, 160, 25);
		getContentPane().add(textNomeLoja);
		textNomeLoja.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setBounds(144, 76, 160, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		textCnpj = new JTextField();
		textCnpj.setBounds(144, 113, 160, 25);
		getContentPane().add(textCnpj);
		textCnpj.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(144, 150, 160, 25);
		getContentPane().add(textEndereco);
		textEndereco.setColumns(10);

		textFieldCpefBusca = new JTextField();
		textFieldCpefBusca.setColumns(10);
		textFieldCpefBusca.setBounds(299, 237, 160, 25);
		contentPane.add(textFieldCpefBusca);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setForeground(new Color(128, 0, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cnpj = textCnpj.getText();
				String endereco = textEndereco.getText();
				String nome = textNomeLoja.getText();
				String telefone = textTelefone.getText();

				try {
					Fachada.getInstance().inserirLoja(nome, telefone, cnpj, endereco);
					JOptionPane.showMessageDialog(contentPane, "Loja Inserida com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (LojaVaziaException | LojaJaCadastradaException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}

			}
		});
		btnCadastrar.setBounds(358, 39, 101, 25);
		contentPane.add(btnCadastrar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Fachada.getInstance().removerLoja(textFieldCpefBusca.getText());
					JOptionPane.showMessageDialog(contentPane, "Loja removida com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (LojaNaoCadastradaException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
		});
		btnRemover.setForeground(new Color(128, 0, 0));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(358, 76, 101, 25);
		contentPane.add(btnRemover);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cnpj = textCnpj.getText();
				String endereco = textEndereco.getText();
				String nome = textNomeLoja.getText();
				String telefone = textTelefone.getText();

				try {
					Fachada.getInstance().alterarLoja(nome, telefone, cnpj, endereco);
					JOptionPane.showMessageDialog(contentPane, "Loja atualizada com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (LojaVaziaException | LojaNaoCadastradaException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setForeground(new Color(128, 0, 0));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(358, 116, 101, 25);
		contentPane.add(btnAtualizar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCnpj.setText("");
				textEndereco.setText("");
				textNomeLoja.setText("");
				textTelefone.setText("");

			}
		});
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(358, 150, 101, 25);
		contentPane.add(btnLimpar);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Loja loja = Fachada.getInstance().buscarLoja(textFieldCpefBusca.getText());

					textCnpj.setText(loja.getCnpj());
					textEndereco.setText(loja.getEndereco());
					textNomeLoja.setText(loja.getNome());
					textTelefone.setText(loja.getTelefone());

				} catch (LojaNaoCadastradaException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// e.printStackTrace();
				}

			}
		});
		buttonBuscar.setForeground(new Color(128, 0, 0));
		buttonBuscar.setBackground(Color.WHITE);
		buttonBuscar.setBounds(358, 187, 101, 25);
		contentPane.add(buttonBuscar);

		btnCardapio = new JButton("Editar");
		btnCardapio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textFieldCpefBusca.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Insira o cnpj da loja que voce deseja entrar.", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Fachada.getInstance().buscarLoja(textFieldCpefBusca.getText());
					} catch (LojaNaoCadastradaException e) {
						JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
						// e.printStackTrace();
					}
					TelaAdministradorLojaCardapio tela = new TelaAdministradorLojaCardapio(
							textFieldCpefBusca.getText());
					tela.setVisible(true);
					dispose();

				}

			}
		});
		btnCardapio.setForeground(new Color(128, 0, 0));
		btnCardapio.setBackground(Color.WHITE);
		btnCardapio.setBounds(144, 187, 160, 25);
		contentPane.add(btnCardapio);

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
		btnVoltar.setBounds(12, 237, 101, 25);
		contentPane.add(btnVoltar);

		panelListar = new JPanel();
		panelListar.setLayout(new BoxLayout(panelListar, BoxLayout.PAGE_AXIS));
		panelListar.setVisible(true);

		cabecalhoListagem();

		JScrollPane scrollPane = new JScrollPane(panelListar);
		scrollPane.setBounds(487, 25, 280, 231);
		contentPane.add(scrollPane);

		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(128, 0, 0));
		btnListar.setBackground(Color.WHITE);
		btnListar.addActionListener(new ActionListener() { // Aqui dentro \E9 fora do construtor da TelaAdministrador
			public void actionPerformed(ActionEvent arg0) {
				panelListar.removeAll(); // Remove todos os elementos para n\E3o ficarem duplicados
				cabecalhoListagem();
				for (Loja loja : Fachada.getInstance().listarLoja()) { // Insere os elementos que est\E3o no repositorio
					panelListar.revalidate(); // Tem que revalidar a tela quando adicionar fora do construtor
					JPanel linha = new JPanel();
					linha.setLayout(new GridLayout(1, 2));
					JLabel cnpj = new JLabel(loja.getCnpj());
					JLabel nome = new JLabel(loja.getNome());
					cnpj.setHorizontalAlignment(JLabel.CENTER);
					nome.setHorizontalAlignment(JLabel.CENTER);
					linha.add(cnpj);
					linha.add(nome);
					panelListar.add(linha);
					panelListar.add(Box.createRigidArea(new Dimension(0, 5)));
					panelListar.repaint(); // Repintar por garantia
				}

			}
		});
		btnListar.setBounds(358, 7, 101, 25);
		contentPane.add(btnListar);

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
		JLabel cnpj = new JLabel("CNPJ");
		JLabel nome = new JLabel("NOME");
		cnpj.setVerticalAlignment(JLabel.TOP);
		cnpj.setHorizontalAlignment(JLabel.CENTER);
		nome.setVerticalAlignment(JLabel.TOP);
		nome.setHorizontalAlignment(JLabel.CENTER);
		titulo.add(cnpj);
		titulo.add(nome);
		panelListar.add(titulo);
		panelListar.repaint();
	}

}
