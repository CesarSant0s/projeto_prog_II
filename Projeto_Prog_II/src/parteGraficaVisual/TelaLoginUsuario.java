package parteGraficaVisual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.UsuarioNaoCadastradoException;
import exception.CpfNaoCadastradoException;
import exception.SenhaIncorretaException;
import negocio.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaLoginUsuario extends JFrame {

	private static TelaLoginUsuario instance;

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;

	public static TelaLoginUsuario getInstance() {
		if (TelaLoginUsuario.instance == null) {
			TelaLoginUsuario.instance = new TelaLoginUsuario();
		}
		return TelaLoginUsuario.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginUsuario frame = new TelaLoginUsuario();
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
	public TelaLoginUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(121, 110, 51, 15);
		contentPane.add(lblLogin);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(178, 108, 160, 19);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(121, 136, 51, 15);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(237, 164, 101, 25);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		contentPane.add(btnEntrar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(121, 165, 101, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.getInstance().login(textFieldLogin.getText(), new String(passwordFieldSenha.getPassword()));
					JOptionPane.showMessageDialog(contentPane, "Login Efetuado com Sucesso!", "",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (UsuarioNaoCadastradoException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				} catch (CpfNaoCadastradoException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				} catch (SenhaIncorretaException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		contentPane.add(btnCadastrar);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(178, 134, 160, 19);
		contentPane.add(passwordFieldSenha);
	}
}
