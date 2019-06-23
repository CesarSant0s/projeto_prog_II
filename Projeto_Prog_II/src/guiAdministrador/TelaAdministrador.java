package guiAdministrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministrador frame = new TelaAdministrador();
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
	public TelaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrarcliente = new JButton("Cliente");
		btnCadastrarcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdministradorCliente tela = new TelaAdministradorCliente();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCadastrarcliente.setBounds(92, 45, 183, 25);
		contentPane.add(btnCadastrarcliente);

		JButton btnCadastrarEntregador = new JButton("Entregador");
		btnCadastrarEntregador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdministradorEntregador tela = new TelaAdministradorEntregador();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCadastrarEntregador.setBounds(92, 95, 183, 25);
		contentPane.add(btnCadastrarEntregador);

		JButton btnCadatrarLoja = new JButton("Loja");
		btnCadatrarLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdministradorLoja tela = new TelaAdministradorLoja();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCadatrarLoja.setBounds(92, 145, 183, 25);
		contentPane.add(btnCadatrarLoja);

		JButton btnPedido = new JButton("Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdministradorPedido tela = new TelaAdministradorPedido();
				tela.setVisible(true);
				dispose();
			}
		});
		btnPedido.setBounds(92, 196, 183, 25);
		contentPane.add(btnPedido);

	}
}
