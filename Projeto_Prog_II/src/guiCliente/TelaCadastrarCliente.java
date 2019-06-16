package guiCliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaCadastrarCliente extends JFrame {

	private static TelaCadastrarCliente instance;

	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textTelefone;
	private JTextField textCpf;
	private JTextField textNomeLogin;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JTextField textSenha;
	private JLabel lblCadastrarCliente;
	private JLabel label;
	private JTextField textEndereco;

	public static TelaCadastrarCliente getInstance() {
		if (TelaCadastrarCliente.instance == null) {
			TelaCadastrarCliente.instance = new TelaCadastrarCliente();
		}
		return TelaCadastrarCliente.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCliente frame = new TelaCadastrarCliente();
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
	public TelaCadastrarCliente() {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 286);
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
		textNomeCompleto.setBounds(144, 40, 160, 25);
		getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(69, 80, 69, 15);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(144, 75, 160, 25);
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
		textCpf.setBounds(144, 110, 160, 25);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);

		textNomeLogin = new JTextField();
		textNomeLogin.setBounds(144, 145, 160, 25);
		getContentPane().add(textNomeLogin);
		textNomeLogin.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginCliente tela = new TelaLoginCliente();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(343, 211, 101, 25);
		contentPane.add(btnVoltar);

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
		btnLimpar.setBounds(343, 176, 101, 25);
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
					TelaCompraClienteLojas tela = new TelaCompraClienteLojas(cpf);
					tela.setVisible(true);
					dispose();
				} catch (UsuarioVazioException | UsuarioAnteriormenteCadastradoException
						| UsuarioNaoCadastradoException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCadastrar.setBounds(343, 141, 101, 25);
		contentPane.add(btnCadastrar);

		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(144, 180, 160, 25);
		contentPane.add(textSenha);

		JLabel labelEmail = new JLabel("Senha:");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		labelEmail.setBounds(88, 192, 50, 15);
		contentPane.add(labelEmail);

		lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setForeground(Color.WHITE);
		lblCadastrarCliente.setBounds(148, 12, 123, 15);
		contentPane.add(lblCadastrarCliente);

		label = new JLabel("Endereco:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(69, 221, 73, 15);
		contentPane.add(label);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(144, 215, 160, 25);
		contentPane.add(textEndereco);

	}
}
