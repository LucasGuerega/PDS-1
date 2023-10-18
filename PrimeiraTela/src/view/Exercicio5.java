package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CalcValorPrato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Exercicio5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_precoQuilo;
	private JTextField txt_pesoPrato;
	private JButton btn_calc;
	private JLabel lbl_precoQuilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio5 frame = new Exercicio5();
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
	public Exercicio5() {
		setTitle("Fomelândia Pesador de Prato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_pesoPrato = new JLabel("Peso Prato:");
		lbl_pesoPrato.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_pesoPrato.setBounds(35, 52, 155, 29);
		contentPane.add(lbl_pesoPrato);
		
		JLabel lbl_precoQuilo2 = new JLabel("Preço Quilo:");
		lbl_precoQuilo2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_precoQuilo2.setBounds(35, 110, 167, 29);
		contentPane.add(lbl_precoQuilo2);
		
		txt_precoQuilo = new JTextField();
		txt_precoQuilo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_precoQuilo.setBounds(185, 109, 149, 30);
		contentPane.add(txt_precoQuilo);
		txt_precoQuilo.setColumns(10);
		
		txt_pesoPrato = new JTextField();
		txt_pesoPrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_pesoPrato.setColumns(10);
		txt_pesoPrato.setBounds(185, 51, 149, 30);
		contentPane.add(txt_pesoPrato);
		
		btn_calc = new JButton("Calcular");
		btn_calc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pesoPratoDigi = txt_pesoPrato.getText();
				String precoKiloDigi = txt_precoQuilo.getText();
				if (pesoPratoDigi.isEmpty() || precoKiloDigi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!"
							);
				} else {
					float pesoPt = Float.valueOf(pesoPratoDigi);
					float precoKg = Float.valueOf(precoKiloDigi);
					CalcValorPrato calc = new CalcValorPrato();
		            float valorPrato = calc.calcValorPrato(precoKg, pesoPt);
					JOptionPane.showMessageDialog(null, 
							"Valor do seu prato: R$" 
									+ valorPrato + "\nPague se não te enxotamos sem a comida!" );
				}
			}
		});
		btn_calc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_calc.setBounds(126, 150, 140, 29);
		contentPane.add(btn_calc);
		
		lbl_precoQuilo = new JLabel("Preço Quilo: R$9,95");
		lbl_precoQuilo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_precoQuilo.setBounds(66, 11, 259, 29);
		contentPane.add(lbl_precoQuilo);
	}

}
