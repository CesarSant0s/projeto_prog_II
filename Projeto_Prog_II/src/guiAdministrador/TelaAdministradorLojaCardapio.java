package guiAdministrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepitonRepositorioArray.LojaJaCadastradaException;
import excepitonRepositorioArray.LojaNaoCadastradaException;
import excepitonRepositorioArray.LojaVaziaException;
import excepitonRepositorioArray.PratoJaInseridoException;
import excepitonRepositorioArray.PratoVazioException;
import negocio.Fachada;
import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Prato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaAdministradorLojaCardapio extends JFrame {

	private static TelaAdministradorLojaCardapio instance;

	private JPanel contentPane;
	private JTextField textNomePrato;
	private JTextField textValor;
	private JTextField textPeso;
	private JTextField textNumeroStock;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnLimpar;
	private JButton btnRemover;
	private JTextField textFieldCpefBusca;
	private JButton buttonBuscar;
	private JLabel labelCnpjBusca;
	private JLabel lblCardapioLoja;
	private JButton btnCardapio;
	private String cnpjLojaAtual;

	public static TelaAdministradorLojaCardapio getInstance() {
		if (TelaAdministradorLojaCardapio.instance == null) {
			TelaAdministradorLojaCardapio.instance = new TelaAdministradorLojaCardapio();
		}
		return TelaAdministradorLojaCardapio.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorLojaCardapio frame = new TelaAdministradorLojaCardapio();
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

	public TelaAdministradorLojaCardapio(String cnpj) {
		cnpjLojaAtual = cnpj;
	}

	public TelaAdministradorLojaCardapio() {
		setTitle("To com fome - O aplicativo de comida mais proximo de voce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomePrato = new JLabel("Nome do Prato:");
		lblNomePrato.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomePrato.setForeground(new Color(255, 255, 255));
		lblNomePrato.setBounds(49, 44, 116, 15);
		getContentPane().add(lblNomePrato);

		JLabel lblNumeroStock = new JLabel("Numero do stock:");
		lblNumeroStock.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNumeroStock.setForeground(new Color(255, 255, 255));
		lblNumeroStock.setBounds(33, 155, 140, 15);
		getContentPane().add(lblNumeroStock);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setBounds(122, 81, 43, 15);
		getContentPane().add(lblValor);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPeso.setForeground(new Color(255, 255, 255));
		lblPeso.setBounds(122, 118, 43, 15);
		getContentPane().add(lblPeso);

		labelCnpjBusca = new JLabel("Nome do Prato:");
		labelCnpjBusca.setForeground(Color.WHITE);
		labelCnpjBusca.setFont(new Font("Dialog", Font.BOLD, 13));
		labelCnpjBusca.setBounds(183, 242, 116, 15);
		contentPane.add(labelCnpjBusca);

		lblCardapioLoja = new JLabel("Cardapio da Loja");
		lblCardapioLoja.setForeground(Color.WHITE);
		lblCardapioLoja.setBounds(138, 12, 301, 15);
		contentPane.add(lblCardapioLoja);

		textNomePrato = new JTextField();
		textNomePrato.setBounds(170, 39, 160, 25);
		getContentPane().add(textNomePrato);
		textNomePrato.setColumns(10);

		textValor = new JTextField();
		textValor.setBounds(170, 76, 160, 25);
		getContentPane().add(textValor);
		textValor.setColumns(10);

		textPeso = new JTextField();
		textPeso.setBounds(170, 113, 160, 25);
		getContentPane().add(textPeso);
		textPeso.setColumns(10);

		textNumeroStock = new JTextField();
		textNumeroStock.setBounds(170, 150, 160, 25);
		getContentPane().add(textNumeroStock);
		textNumeroStock.setColumns(10);

		textFieldCpefBusca = new JTextField();
		textFieldCpefBusca.setColumns(10);
		textFieldCpefBusca.setBounds(299, 237, 160, 25);
		contentPane.add(textFieldCpefBusca);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setForeground(new Color(128, 0, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float peso = Float.parseFloat(textPeso.getText());

				int numeroStock = Integer.parseInt(textNumeroStock.getText());
				String nome = textNomePrato.getText();
				float valor = Float.parseFloat(textValor.getText());

				try {
					Fachada.getInstance().buscarLoja(cnpjLojaAtual).getCardapio()
							.inserir(new Prato(nome, peso, valor, numeroStock));
					JOptionPane.showMessageDialog(contentPane, "Loja Inserida com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (PratoVazioException | PratoJaInseridoException | LojaNaoCadastradaException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// e1.printStackTrace();
				}

			}
		});
		btnCadastrar.setBounds(358, 39, 101, 25);
		contentPane.add(btnCadastrar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Fachada.getInstance().removerLoja(textFieldCpefBusca.getText());
					JOptionPane.showMessageDialog(contentPane, "Loja Inserida com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (LojaNaoCadastradaException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
				
			}
		});
		btnRemover.setForeground(new Color(128, 0, 0));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(358, 76, 101, 25);
		contentPane.add(btnRemover);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cnpj = textPeso.getText();
				String endereco = textNumeroStock.getText();
				String nome = textNomePrato.getText();
				String telefone = textValor.getText();

				try {
					Fachada.getInstance().alterarLoja(nome, telefone, cnpj, endereco);
					JOptionPane.showMessageDialog(contentPane, "Loja Inserida com sucesso!!", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (LojaVaziaException | LojaNaoCadastradaException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setForeground(new Color(128, 0, 0));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(358, 116, 101, 25);
		contentPane.add(btnAtualizar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPeso.setText("");
				textNumeroStock.setText("");
				textNomePrato.setText("");
				textValor.setText("");

			}
		});
		btnLimpar.setForeground(new Color(128, 0, 0));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(358, 150, 101, 25);
		contentPane.add(btnLimpar);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Loja loja = Fachada.getInstance().buscarLoja(textFieldCpefBusca.getText());

					textPeso.setText(loja.getCnpj());
					textNumeroStock.setText(loja.getEndereco());
					textNomePrato.setText(loja.getNome());
					textValor.setText(loja.getTelefone());

				} catch (LojaNaoCadastradaException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
					// e.printStackTrace();
				}

			}
		});
		buttonBuscar.setForeground(new Color(128, 0, 0));
		buttonBuscar.setBackground(Color.WHITE);
		buttonBuscar.setBounds(358, 187, 101, 25);
		contentPane.add(buttonBuscar);

		btnCardapio = new JButton("Ver Cardapio");
		btnCardapio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnCardapio.setForeground(new Color(128, 0, 0));
		btnCardapio.setBackground(Color.WHITE);
		btnCardapio.setBounds(170, 187, 160, 25);
		contentPane.add(btnCardapio);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministrador tela = new TelaAdministrador();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(12, 237, 101, 25);
		contentPane.add(btnVoltar);

	}
}
