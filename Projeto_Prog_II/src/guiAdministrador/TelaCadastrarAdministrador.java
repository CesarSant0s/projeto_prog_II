package guiAdministrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaCadastrarAdministrador extends JFrame {

	private static TelaCadastrarAdministrador instance;

	private JPanel contentPane;
	private JTextField textNomeDeLogin;
	private JPasswordField pwdSenha;
	private JTextField textNomeCompleto;
	private JTextField textTelefone;
	private JTextField textCpf;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnLimpar;

	public static TelaCadastrarAdministrador getInstance() {
		if (TelaCadastrarAdministrador.instance == null) {
			TelaCadastrarAdministrador.instance = new TelaCadastrarAdministrador();
		}
		return TelaCadastrarAdministrador.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAdministrador frame = new TelaCadastrarAdministrador();
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
	public TelaCadastrarAdministrador() {
		setTitle("Tô com fome - O aplicativo de comida mais próximo de você");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNomeDeLogin = new JTextField();
		textNomeDeLogin.setBounds(151, 12, 160, 25);
		getContentPane().add(textNomeDeLogin);
		textNomeDeLogin.setColumns(10);

		JLabel lblNomeDeLogin = new JLabel("Nome de Login:");
		lblNomeDeLogin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeDeLogin.setForeground(new Color(255, 255, 255));
		lblNomeDeLogin.setBounds(50, 16, 151, 15);
		getContentPane().add(lblNomeDeLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBounds(100, 53, 49, 15);
		getContentPane().add(lblSenha);

		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(151, 49, 160, 25);
		getContentPane().add(pwdSenha);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setBounds(45, 93, 104, 15);
		getContentPane().add(lblNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(151, 89, 160, 25);
		getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(92, 127, 57, 20);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(151, 126, 160, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(124, 167, 25, 15);
		getContentPane().add(lblNewLabel);

		textCpf = new JTextField();
		textCpf.setBounds(151, 163, 160, 25);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(250, 272, 114, 25);
		contentPane.add(btnVoltar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAtualizar.setForeground(new Color(128, 0, 0));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(250, 236, 114, 25);
		contentPane.add(btnAtualizar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCpf.setText("");
				textNomeCompleto.setText("");
				textNomeDeLogin.setText("");
				textTelefone.setText("");
				pwdSenha.setText("");

			}
		});
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(124, 272, 114, 25);
		contentPane.add(btnLimpar);

	}
}
