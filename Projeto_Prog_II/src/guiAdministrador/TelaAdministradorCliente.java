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

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Cliente;
import negocioClassesBasicas.Entregador;
import negocioClassesBasicas.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaAdministradorCliente extends JFrame {

	private static TelaAdministradorCliente instance;

	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textTelefone;
	private JTextField textCpf;
	private JTextField textNomeLogin;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnLimpar;
	private JButton btnRemover;
	private JTextField textSenha;
	private JTextField textFieldCpfBusca;
	private JButton buttonBuscar;
	private JLabel labelCpfBusca;
	private JLabel lblAdministrarCliente;
	private JPanel panelListar;
	private JTextField textEndereco;

	public static TelaAdministradorCliente getInstance() {
		if (TelaAdministradorCliente.instance == null) {
			TelaAdministradorCliente.instance = new TelaAdministradorCliente();
		}
		return TelaAdministradorCliente.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorCliente frame = new TelaAdministradorCliente();
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
	public TelaAdministradorCliente() {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setBounds(15, 44, 123, 15);
		getContentPane().add(lblNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(144, 39, 160, 25);
		getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(69, 81, 69, 15);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(144, 76, 160, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(108, 118, 30, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNomeLogin = new JLabel("Nome de Login:");
		lblNomeLogin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeLogin.setForeground(new Color(255, 255, 255));
		lblNomeLogin.setBounds(21, 155, 117, 15);
		getContentPane().add(lblNomeLogin);

		textCpf = new JTextField();
		textCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textCpf.setBounds(144, 113, 160, 25);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);

		textNomeLogin = new JTextField();
		textNomeLogin.setBounds(144, 150, 160, 25);
		getContentPane().add(textNomeLogin);
		textNomeLogin.setColumns(10);

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

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = textCpf.getText();
				String nomeUsuario = textNomeLogin.getText();
				String nome = textNomeCompleto.getText();
				String telefone = textTelefone.getText();
				String senha = textSenha.getText();
				String endereco = textEndereco.getText();

				try {
					Fachada.getInstance().atualizarUsuarioCliente(nomeUsuario, senha, nome, telefone, cpf, endereco);
					JOptionPane.showMessageDialog(contentPane, "Cliente atualizado com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (UsuarioVazioException | UsuarioNaoCadastradoException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAtualizar.setForeground(new Color(128, 0, 0));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(358, 148, 101, 25);
		contentPane.add(btnAtualizar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCpf.setText("");
				textNomeLogin.setText("");
				textNomeCompleto.setText("");
				textTelefone.setText("");
				textSenha.setText("");
				textEndereco.setText("");

			}
		});
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(358, 182, 101, 25);
		contentPane.add(btnLimpar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setForeground(new Color(128, 0, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = textCpf.getText();
				String nomeUsuario = textNomeLogin.getText();
				String nome = textNomeCompleto.getText();
				String telefone = textTelefone.getText();
				String senha = textSenha.getText();
				String endereco = textEndereco.getText();

				try {
					Fachada.getInstance().inserirUsuarioCliente(nomeUsuario, senha, nome, telefone, cpf, endereco);
					JOptionPane.showMessageDialog(contentPane, "Cliente cadastrado com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (UsuarioVazioException | UsuarioAnteriormenteCadastradoException
						| UsuarioNaoCadastradoException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCadastrar.setBounds(358, 71, 101, 25);
		contentPane.add(btnCadastrar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Fachada.getInstance().removerUsuario(textFieldCpfBusca.getText());
					JOptionPane.showMessageDialog(contentPane, "Cliente removido com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (UsuarioNaoCadastradoException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// e.printStackTrace();
				}
			}
		});
		btnRemover.setForeground(new Color(128, 0, 0));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(358, 108, 101, 25);
		contentPane.add(btnRemover);

		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(144, 190, 160, 25);
		contentPane.add(textSenha);

		JLabel labelEmail = new JLabel("Senha:");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		labelEmail.setBounds(88, 192, 50, 15);
		contentPane.add(labelEmail);

		textFieldCpfBusca = new JTextField();
		textFieldCpfBusca.setColumns(10);
		textFieldCpfBusca.setBounds(299, 275, 160, 25);
		contentPane.add(textFieldCpfBusca);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Cliente cliente = (Cliente) Fachada.getInstance().buscarUsuario(textFieldCpfBusca.getText());
					textCpf.setText(cliente.getCpf());
					textNomeLogin.setText(cliente.getNomeUsuario());
					textNomeCompleto.setText(cliente.getNome());
					textTelefone.setText(cliente.getTelefone());
					textSenha.setText(cliente.getSenha());
					textEndereco.setText(cliente.getEndereco());

				} catch (UsuarioNaoCadastradoException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonBuscar.setForeground(new Color(128, 0, 0));
		buttonBuscar.setBackground(Color.WHITE);
		buttonBuscar.setBounds(358, 219, 101, 25);
		contentPane.add(buttonBuscar);

		labelCpfBusca = new JLabel("Cpf para busca:");
		labelCpfBusca.setForeground(Color.WHITE);
		labelCpfBusca.setFont(new Font("Dialog", Font.BOLD, 13));
		labelCpfBusca.setBounds(182, 280, 117, 15);
		contentPane.add(labelCpfBusca);

		lblAdministrarCliente = new JLabel("Administrar Cliente");
		lblAdministrarCliente.setForeground(Color.WHITE);
		lblAdministrarCliente.setBounds(148, 12, 192, 15);
		contentPane.add(lblAdministrarCliente);

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

				ArrayList<Usuario> arrayEntregador = new ArrayList<Usuario>();

				arrayEntregador = (ArrayList<Usuario>) Fachada.getInstance().listarUsuario();

				for (Usuario usuario : arrayEntregador) { /* Insere os elementos que estao no repositorio */

					if (usuario instanceof Cliente) {
						panelListar.revalidate(); // Tem que revalidar a tela quando adicionar fora do construtor
						JPanel linha = new JPanel();
						linha.setLayout(new GridLayout(1, 2));
						JLabel nome = new JLabel(usuario.getNome());
						JLabel cpf = new JLabel(usuario.getCpf());
						nome.setHorizontalAlignment(JLabel.CENTER);
						cpf.setHorizontalAlignment(JLabel.CENTER);
						linha.add(nome);
						linha.add(cpf);
						panelListar.add(linha);
						panelListar.add(Box.createRigidArea(new Dimension(0, 5)));
						panelListar.repaint(); // Repintar por garantia
					}

				}

			}
		});
		btnListarCardapio.setBounds(358, 39, 101, 25);
		contentPane.add(btnListarCardapio);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(144, 227, 160, 25);
		contentPane.add(textEndereco);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEndereco.setBounds(69, 229, 73, 15);
		contentPane.add(lblEndereco);

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
		JLabel nome = new JLabel("NOME");
		JLabel CPF = new JLabel("CPF");
		nome.setVerticalAlignment(JLabel.TOP);
		nome.setHorizontalAlignment(JLabel.CENTER);
		CPF.setVerticalAlignment(JLabel.TOP);
		CPF.setHorizontalAlignment(JLabel.CENTER);
		titulo.add(nome);
		titulo.add(CPF);
		panelListar.add(titulo);
		panelListar.repaint();

	}
}
