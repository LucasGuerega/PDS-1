package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrimeiroNome;
	private JTextField txtSobrenome;
	private JButton btnLimparTudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio2 frame = new Exercicio2();
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
	public Exercicio2() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 188, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrimeiroNome = new JLabel("Primeiro nome");
		lblPrimeiroNome.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrimeiroNome.setBounds(21, 80, 171, 26);
		contentPane.add(lblPrimeiroNome);
		
		txtPrimeiroNome = new JTextField();
		txtPrimeiroNome.setBounds(193, 46, 207, 60);
		contentPane.add(txtPrimeiroNome);
		txtPrimeiroNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblSobrenome.setBounds(61, 193, 131, 26);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(193, 159, 207, 60);
		txtSobrenome.setColumns(10);
		contentPane.add(txtSobrenome);
		
		JButton btnNewButton = new JButton("Confirma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtPrimeiroNome.getText();
				String sobrenome = txtSobrenome.getText();
				if (nome.isEmpty()||sobrenome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				}else {
					Pessoa p = new Pessoa();
					p.setPrimeiroNome(nome);
					p.setSobrenome(sobrenome);
					String msg = "Cadastrado com sucesso!!\n"+"Você cadastrou:"+p.getPrimeiroNome()+" "+p.getSobrenome();
					JOptionPane.showMessageDialog(null, msg);
				}
				
				

			}
		});
		btnNewButton.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		btnNewButton.setBounds(163, 290, 110, 23);
		contentPane.add(btnNewButton);
		
		btnLimparTudo = new JButton("Limpar Tudo");
		btnLimparTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPrimeiroNome.setText("");
				txtSobrenome.setText("");

				
			}
		});
		btnLimparTudo.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		btnLimparTudo.setBounds(283, 290, 138, 23);
		contentPane.add(btnLimparTudo);
	}
}
