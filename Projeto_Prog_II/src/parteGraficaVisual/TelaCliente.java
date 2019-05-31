package parteGraficaVisual;

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
import javax.swing.JLabel;
import javax.swing.JList;

public class TelaCliente extends JFrame {

	private static TelaCliente instance;

	private JPanel contentPane;
	private JTextField textNomeDeLogin;
	private JPasswordField pwdSenha;
	private JTextField textNomeCompleto;
	private JTextField textTelefone;
	private JTextField textCpf;
	private JTextField textEndereco;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnLimpar;

	public static TelaCliente getInstance() {
		if (TelaCliente.instance == null) {
			TelaCliente.instance = new TelaCliente();
		}
		return TelaCliente.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
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
		lblNomeDeLogin.setBounds(36, 17, 151, 15);
		getContentPane().add(lblNomeDeLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBounds(86, 54, 71, 15);
		getContentPane().add(lblSenha);

		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(151, 49, 160, 25);
		getContentPane().add(pwdSenha);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setBounds(29, 94, 133, 15);
		getContentPane().add(lblNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(151, 89, 160, 25);
		getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(82, 131, 90, 15);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(151, 126, 160, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(121, 168, 66, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Endereço:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(78, 205, 83, 15);
		getContentPane().add(lblNewLabel_2);

		textCpf = new JTextField();
		textCpf.setBounds(151, 163, 160, 25);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(151, 200, 160, 25);
		getContentPane().add(textEndereco);
		textEndereco.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(250, 285, 114, 25);
		contentPane.add(btnVoltar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(new Color(128, 0, 0));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(250, 248, 114, 25);
		contentPane.add(btnAtualizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(121, 285, 114, 25);
		contentPane.add(btnLimpar);
		
		
	}
}
