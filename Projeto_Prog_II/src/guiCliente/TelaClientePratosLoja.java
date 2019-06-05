package guiCliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import guiGeral.Programa;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Prato;
import negocio.Fachada;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaClientePratosLoja extends JFrame {

	private JPanel contentPane;
	private JTable tableLojas;
	private ModeloTabelaPratos modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClientePratosLoja frame = new TelaClientePratosLoja("001");
					frame.setVisible(true);

					Programa.inserirLoja();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaClientePratosLoja(String cnpj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modelo = new ModeloTabelaPratos();
		tableLojas = new JTable(modelo);
		tableLojas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableLojas.setBounds(68, 163, 100, 30);
		tableLojas.setPreferredScrollableViewportSize(new Dimension(500, 100));
		tableLojas.setFillsViewportHeight(true);

		JScrollPane scrollPaneLojas = new JScrollPane(tableLojas);
		scrollPaneLojas.setBounds(103, 53, 250, 145);
		contentPane.add(scrollPaneLojas);

		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (modelo.getRowCount() > 0) {
					modelo.removePratoAt(0);
				}

				ArrayList<Prato> lista = new ArrayList();

				try {
					lista = (ArrayList<Prato>) Fachada.getInstance().buscarLoja(cnpj).getCardapio().listar();
					modelo.addPratoList(lista);
				} catch (LojaNaoCadastradaException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

			}
		});
		btnExibir.setBounds(102, 199, 114, 25);
		contentPane.add(btnExibir);

	}
}
