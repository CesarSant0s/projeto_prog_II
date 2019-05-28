package parteGraficaVisual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private static TelaPrincipal instance;
	private JPanel contentPane;

	public TelaPrincipal getInstance() {
		if (TelaPrincipal.instance == null) {
			TelaPrincipal.instance = new TelaPrincipal();
		}
		return TelaPrincipal.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLoginCliente = new JButton("Login Cliente");
		btnLoginCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLoginUsuario.getInstance().setVisible(true);
				dispose();
			}
		});
		btnLoginCliente.setBounds(37, 42, 144, 25);
		contentPane.add(btnLoginCliente);
	}
}
