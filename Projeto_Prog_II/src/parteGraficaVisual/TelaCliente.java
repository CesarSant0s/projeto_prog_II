package parteGraficaVisual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

public class TelaCliente extends JFrame {

	private static TelaCliente instance;

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 52, 15);
		contentPane.add(lblNome);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(64, 12, 180, 15);
		contentPane.add(lblNewLabel);
	}
}
