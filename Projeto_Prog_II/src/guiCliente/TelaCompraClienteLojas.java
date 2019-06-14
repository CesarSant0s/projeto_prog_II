package guiCliente;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import negocioClassesBasicas.Loja;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class TelaCompraClienteLojas extends JFrame {

	private JPanel contentPane;
	private JTable tableLojas;
	private ModeloTabelaLojas modelo;
	private JTextField textIndice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompraClienteLojas frame = new TelaCompraClienteLojas("");
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
	public TelaCompraClienteLojas(String cpfCliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
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
		scrollPane.setBounds(12, 12, 426, 187);
		contentPane.add(scrollPane);

		JButton btnExibir = new JButton("Exibir lojas");
		btnExibir.setForeground(new Color(128, 0, 0));
		btnExibir.setBackground(Color.WHITE);
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				while (modelo.getRowCount() > 0) {
					modelo.removeLojaAt(0);
				}
				ArrayList<Loja> lista = new ArrayList<Loja>();
				lista = (ArrayList<Loja>) Fachada.getInstance().listarLoja();
				modelo.addLojasList(lista);

			}
		});
		btnExibir.setBounds(303, 211, 134, 25);
		contentPane.add(btnExibir);

		JButton btnNewButton = new JButton("Escolher loja");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Loja> lista = new ArrayList<Loja>();
				lista = (ArrayList<Loja>) Fachada.getInstance().listarLoja();
				String cnpj = lista.get(Integer.parseInt(textIndice.getText())).getCnpj();

				TelaCompraClienteLojaPratos tela = new TelaCompraClienteLojaPratos(cnpj, cpfCliente);
				tela.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(157, 211, 134, 25);
		contentPane.add(btnNewButton);

		textIndice = new JTextField();
		textIndice.setBounds(215, 248, 76, 19);
		contentPane.add(textIndice);
		textIndice.setColumns(10);

		JLabel lblIndice = new JLabel("Indice:");
		lblIndice.setForeground(Color.WHITE);
		lblIndice.setBounds(167, 250, 66, 15);
		contentPane.add(lblIndice);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLoginCliente tela = new TelaLoginCliente();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(12, 211, 134, 25);
		contentPane.add(btnVoltar);
	}
}
