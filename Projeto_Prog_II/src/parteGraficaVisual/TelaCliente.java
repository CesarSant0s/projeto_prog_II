package parteGraficaVisual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente {

	private JFrame TelaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente(null);
					window.TelaCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCliente(String cpfCliente) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TelaCliente = new JFrame();
		TelaCliente.setBounds(100, 100, 400, 300);
		TelaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TelaCliente.getContentPane().setLayout(null);

		JButton btnLojas = new JButton("Lojas");
		btnLojas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLojas.setBounds(12, 50, 127, 25);
		TelaCliente.getContentPane().add(btnLojas);

		JButton btnDadosCliente = new JButton("ExibirDados");
		btnDadosCliente.setBounds(12, 85, 127, 25);
		TelaCliente.getContentPane().add(btnDadosCliente);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(12, 120, 127, 25);
		TelaCliente.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(12, 155, 127, 25);
		TelaCliente.getContentPane().add(btnNewButton_3);
	}
}
