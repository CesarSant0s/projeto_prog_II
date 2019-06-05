package guiCliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guiGeral.Programa;
import negocio.Fachada;
import negocioClassesBasicas.Loja;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaCompraClienteLojas extends JFrame {

	private JPanel contentPane;
	private JTable tableLojas;
	private ModeloTabelaLojas modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompraClienteLojas frame = new TelaCompraClienteLojas();
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
	public TelaCompraClienteLojas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modelo = new ModeloTabelaLojas();
		tableLojas = new JTable(modelo);
		tableLojas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableLojas.setBounds(68, 163, 100, 30);
		tableLojas.setPreferredScrollableViewportSize(new Dimension(500, 100));
		tableLojas.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tableLojas);
		scrollPane.setBounds(147, 12, 291, 187);
		contentPane.add(scrollPane);

		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (modelo.getRowCount() > 0) {
					modelo.removeLojaAt(0);
				}

				ArrayList<Loja> lista = new ArrayList();

				lista = (ArrayList<Loja>) Fachada.getInstance().listarLoja();
				modelo.addLojasList(lista);
			}
		});
		btnExibir.setBounds(22, 215, 114, 25);
		contentPane.add(btnExibir);
	}
}
