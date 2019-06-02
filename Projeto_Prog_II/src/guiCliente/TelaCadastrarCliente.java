package guiCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import guiGeral.TelaLoginUsuario;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaCadastrarCliente {

	public JFrame Cadastro;
	private JTextField textNomeDeLogin;
	private JPasswordField pwdSenha;
	private JTextField textNomeCompleto;
	private JTextField textTelefone;
	private JTextField textCpf;
	private JTextField textEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCliente window = new TelaCadastrarCliente();
					window.Cadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Cadastro = new JFrame();
		Cadastro.getContentPane().setBackground(new Color(128, 0, 0));
		Cadastro.setTitle("Tô com fome - O aplicativo de comida mais próximo de você");
		Cadastro.setBounds(100, 100, 400, 350);
		Cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cadastro.getContentPane().setLayout(null);

		textNomeDeLogin = new JTextField();
		textNomeDeLogin.setBounds(151, 12, 160, 25);
		Cadastro.getContentPane().add(textNomeDeLogin);
		textNomeDeLogin.setColumns(10);

		JLabel lblNomeDeLogin = new JLabel("Nome de Login:");
		lblNomeDeLogin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeDeLogin.setForeground(new Color(255, 255, 255));
		lblNomeDeLogin.setBounds(50, 16, 99, 15);
		Cadastro.getContentPane().add(lblNomeDeLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBounds(94, 53, 55, 15);
		Cadastro.getContentPane().add(lblSenha);

		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(151, 49, 160, 25);
		Cadastro.getContentPane().add(pwdSenha);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setBounds(45, 93, 104, 15);
		Cadastro.getContentPane().add(lblNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(151, 89, 160, 25);
		Cadastro.getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(92, 130, 57, 15);
		Cadastro.getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(151, 126, 160, 25);
		Cadastro.getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(122, 167, 25, 15);
		Cadastro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Endereco:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(83, 204, 66, 15);
		Cadastro.getContentPane().add(lblNewLabel_2);

		textCpf = new JTextField();
		textCpf.setBounds(151, 163, 160, 25);
		Cadastro.getContentPane().add(textCpf);
		textCpf.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(151, 200, 160, 25);
		Cadastro.getContentPane().add(textEndereco);
		textEndereco.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color(255, 255, 255));
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textCpf.setText("");
				textEndereco.setText("");
				textNomeCompleto.setText("");
				textNomeDeLogin.setText("");
				textTelefone.setText("");
				pwdSenha.setText("");
			}
		});

		btnLimpar.setBounds(238, 248, 114, 25);
		Cadastro.getContentPane().add(btnLimpar);

		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.setForeground(new Color(128, 0, 0));
		btnCadastrarCliente.setBackground(new Color(255, 255, 255));
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cpf = textCpf.getText();
				String senha = new String(pwdSenha.getPassword());
				String telefone = textTelefone.getText();
				String nomeUsuario = textNomeDeLogin.getText();
				String nome = textNomeCompleto.getText();
				String endereco = textEndereco.getText();

				try {
					Fachada.getInstance().inserirUsuarioCliente(nomeUsuario, senha, nome, telefone, cpf, endereco);
					JOptionPane.showMessageDialog(Cadastro, "Cadastrado com Sucesso.", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (UsuarioVazioException | UsuarioAnteriormenteCadastradoException
						| UsuarioNaoCadastradoException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(Cadastro, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnCadastrarCliente.setBounds(112, 248, 114, 25);
		Cadastro.getContentPane().add(btnCadastrarCliente);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLoginUsuario.getInstance().setVisible(true);
				Cadastro.dispose();
			}
		});
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(238, 285, 114, 25);
		Cadastro.getContentPane().add(btnVoltar);
	}
}
