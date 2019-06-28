package guiCliente;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.PedidoNaoCadastrado;
import excepitonRepositorioArray.PratoNaoEncontradoException;
import excepitonRepositorioArray.PratoVazioException;
import negocioClassesBasicas.Prato;
import repositorio.RepositorioPratos;
import repositorioArray.RepositorioPratosArray;
import negocio.Fachada;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaCompraClienteFinalização extends JFrame {

	private JPanel contentPane;
	private ModeloTabelaPratos modeloPratoCardapio;
	private ModeloTabelaPratos modeloPratoPratoEscolhido;

	private RepositorioPratos pratosEscolhidos;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TelaCompraClienteFinalização frame = new TelaCompraClienteFinalização(0);
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

	public TelaCompraClienteFinalização(int codigo) {

		pratosEscolhidos = new RepositorioPratosArray();

		exibirPratosEscolhidos(codigo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modeloPratoCardapio = new ModeloTabelaPratos();

		JLabel lblNewLabel = new JLabel("Pratos Escolhidos:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 12, 124, 15);
		contentPane.add(lblNewLabel);

		JButton btnFinalizarPedido = new JButton("Finalizar Pedido");
		btnFinalizarPedido.setForeground(new Color(128, 0, 0));
		btnFinalizarPedido.setBackground(Color.WHITE);
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Fachada.getInstance().finalizarPedido(Fachada.getInstance().buscarPedido(codigo));
				} catch (LojaNaoCadastradaException | PratoNaoEncontradoException | PratoVazioException
						| PedidoNaoCadastrado e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

			}
		});
		btnFinalizarPedido.setBounds(171, 148, 147, 25);
		contentPane.add(btnFinalizarPedido);

		modeloPratoPratoEscolhido = new ModeloTabelaPratos();

		JLabel lblEnderecoPedido;
		try {
			lblEnderecoPedido = new JLabel(
					"Endereco de Entrega:" + Fachada.getInstance().buscarPedido(codigo).getCliente().getEndereco());
			lblEnderecoPedido.setForeground(Color.WHITE);
			lblEnderecoPedido.setBounds(12, 47, 426, 15);
			contentPane.add(lblEnderecoPedido);
		} catch (PedidoNaoCadastrado e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		JLabel lblValorTotalDoPedido;
		try {
			lblValorTotalDoPedido = new JLabel(
					"Valor total do pedido:" + Fachada.getInstance().buscarPedido(codigo).getValorTotal());
			lblValorTotalDoPedido.setForeground(Color.WHITE);
			lblValorTotalDoPedido.setBounds(12, 74, 426, 15);
			contentPane.add(lblValorTotalDoPedido);
		} catch (PedidoNaoCadastrado e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		JLabel lblNumeroDoPedido = new JLabel("Numero do pedido:" + codigo);
		lblNumeroDoPedido.setForeground(Color.WHITE);
		lblNumeroDoPedido.setBounds(12, 101, 426, 15);
		contentPane.add(lblNumeroDoPedido);

		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					TelaCompraClienteLojas tela = new TelaCompraClienteLojas(
							Fachada.getInstance().buscarPedido(codigo).getCliente().getCpf());
					tela.setVisible(true);
					dispose();
				} catch (PedidoNaoCadastrado e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnCancelarPedido.setForeground(new Color(128, 0, 0));
		btnCancelarPedido.setBackground(Color.WHITE);
		btnCancelarPedido.setBounds(12, 148, 147, 25);
		contentPane.add(btnCancelarPedido);

	}

	public void exibirPratosEscolhidos(int codigo) {

		

	}
}
