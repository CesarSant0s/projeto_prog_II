package parteGraficaVisual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import excepitonRepositorioArray.UsuarioAnteriormenteCadastradoException;
import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import excepitonRepositorioArray.UsuarioVazioException;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarCliente {

	private JFrame Cadastro;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente window = new CadastrarCliente();
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
	public CadastrarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Cadastro = new JFrame();
		Cadastro.setBounds(100, 100, 400, 600);
		Cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cadastro.getContentPane().setLayout(null);

		textNomeDeLogin = new JTextField();
		textNomeDeLogin.setBounds(127, 12, 134, 20);
		Cadastro.getContentPane().add(textNomeDeLogin);
		textNomeDeLogin.setColumns(10);

		JLabel lblNomeDeLogin = new JLabel("Nome de Login:");
		lblNomeDeLogin.setBounds(12, 12, 110, 15);
		Cadastro.getContentPane().add(lblNomeDeLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(12, 37, 60, 15);
		Cadastro.getContentPane().add(lblSenha);

		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(72, 37, 189, 20);
		Cadastro.getContentPane().add(pwdSenha);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(12, 62, 121, 15);
		Cadastro.getContentPane().add(lblNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(127, 62, 134, 20);
		Cadastro.getContentPane().add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 87, 66, 15);
		Cadastro.getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(82, 87, 179, 20);
		Cadastro.getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setBounds(12, 112, 66, 15);
		Cadastro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Endereço:");
		lblNewLabel_2.setBounds(12, 137, 72, 15);
		Cadastro.getContentPane().add(lblNewLabel_2);

		textCpf = new JTextField();
		textCpf.setBounds(43, 110, 218, 20);
		Cadastro.getContentPane().add(textCpf);
		textCpf.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(82, 135, 179, 20);
		Cadastro.getContentPane().add(textEndereco);
		textEndereco.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
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

		btnLimpar.setBounds(12, 164, 114, 25);
		Cadastro.getContentPane().add(btnLimpar);

		JButton btnCadastrarCliente = new JButton("Cadastrar");
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

		btnCadastrarCliente.setBounds(147, 164, 114, 25);
		Cadastro.getContentPane().add(btnCadastrarCliente);
	}
}
