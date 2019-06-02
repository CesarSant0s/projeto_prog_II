package guiEntregador;

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

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaCadastrarEntregador extends JFrame {

	private static TelaCadastrarEntregador instance;

	private JPanel contentPane;
	private JTextField textNomeDeLogin;
	private JPasswordField pwdSenha;
	private JTextField textNomeCompleto;
	private JTextField textTelefone;
	private JTextField textCpf;
	private JTextField textPlacaVeiculo;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnLimpar;

	public static TelaCadastrarEntregador getInstance() {
		if (TelaCadastrarEntregador.instance == null) {
			TelaCadastrarEntregador.instance = new TelaCadastrarEntregador();
		}
		return TelaCadastrarEntregador.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarEntregador frame = new TelaCadastrarEntregador();
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
	public TelaCadastrarEntregador() {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
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
		lblNomeDeLogin.setBounds(47, 16, 99, 15);
		getContentPane().add(lblNomeDeLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBounds(95, 53, 51, 15);
		getContentPane().add(lblSenha);

		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(151, 49, 160, 25);
		getContentPane().add(pwdSenha);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setBounds(42, 93, 104, 15);
		getContentPane().add(lblNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(151, 89, 160, 25);
		getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(89, 130, 57, 15);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(151, 126, 160, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(121, 168, 25, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblPlacaVeiculo = new JLabel("Placa do Veiculo:");
		lblPlacaVeiculo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPlacaVeiculo.setForeground(new Color(255, 255, 255));
		lblPlacaVeiculo.setBounds(37, 204, 109, 15);
		getContentPane().add(lblPlacaVeiculo);

		textCpf = new JTextField();
		textCpf.setBounds(151, 163, 160, 25);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);

		textPlacaVeiculo = new JTextField();
		textPlacaVeiculo.setBounds(151, 200, 160, 25);
		getContentPane().add(textPlacaVeiculo);
		textPlacaVeiculo.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(250, 285, 114, 25);
		contentPane.add(btnVoltar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = textCpf.getText();
				String placaVeiculo = textPlacaVeiculo.getText();
				String nome = textNomeCompleto.getText();
				String nomeUsuario = textNomeDeLogin.getText();
				String telefone = textTelefone.getText();
				String senha = new String(pwdSenha.getPassword());

				try {
					Fachada.getInstance().atualizarUsuarioEntregador(nomeUsuario, senha, nome, telefone, cpf,
							placaVeiculo);
				} catch (UsuarioVazioException | UsuarioNaoCadastradoException e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAtualizar.setForeground(new Color(128, 0, 0));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(250, 248, 114, 25);
		contentPane.add(btnAtualizar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCpf.setText("");
				textPlacaVeiculo.setText("");
				textNomeCompleto.setText("");
				textNomeDeLogin.setText("");
				textTelefone.setText("");
				pwdSenha.setText("");

			}
		});
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(121, 285, 114, 25);
		contentPane.add(btnLimpar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = textCpf.getText();
				String placaVeiculo = textPlacaVeiculo.getText();
				String nome = textNomeCompleto.getText();
				String nomeUsuario = textNomeDeLogin.getText();
				String telefone = textTelefone.getText();
				String senha = new String(pwdSenha.getPassword());

				try {
					Fachada.getInstance().inserirUsuarioEntregador(nomeUsuario, senha, nome, telefone, cpf,
							placaVeiculo);
				} catch (UsuarioVazioException | UsuarioAnteriormenteCadastradoException
						| UsuarioNaoCadastradoException e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCadastrar.setBounds(121, 248, 114, 25);
		contentPane.add(btnCadastrar);

	}
}
