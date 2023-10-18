package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CalcQuantLitros;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class Exercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_precoLitro;
	private JTextField txt_valorFinal;
	private JButton btn_calc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio4 frame = new Exercicio4();
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
	public Exercicio4() {
		setTitle("Abastecimento veículo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_valorFinal = new JLabel("Valor Final:");
		lbl_valorFinal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_valorFinal.setBounds(10, 51, 140, 29);
		contentPane.add(lbl_valorFinal);
		
		JLabel lbl_precoLitro = new JLabel("Preço Litro:");
		lbl_precoLitro.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_precoLitro.setBounds(10, 9, 140, 29);
		contentPane.add(lbl_precoLitro);
		
		txt_precoLitro = new JTextField();
		txt_precoLitro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_precoLitro.setBounds(148, 9, 149, 30);
		contentPane.add(txt_precoLitro);
		txt_precoLitro.setColumns(10);
		
		txt_valorFinal = new JTextField();
		txt_valorFinal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_valorFinal.setColumns(10);
		txt_valorFinal.setBounds(148, 50, 149, 30);
		contentPane.add(txt_valorFinal);
		
		btn_calc = new JButton("Calcular");
		btn_calc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String valFinDigi = txt_valorFinal.getText();
				String precLitDigi = txt_precoLitro.getText();
				if (valFinDigi.isEmpty() || precLitDigi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				} else {
					float preco = Float.valueOf(precLitDigi);
					float valorFim = Float.valueOf(valFinDigi);
					CalcQuantLitros calc = new CalcQuantLitros();
					DecimalFormat decimalFormat = new DecimalFormat("0.00");
		            float quantLitros = calc.calcQuantLitros(preco, valorFim);
		            String quantLitrosFormatted = decimalFormat.format(quantLitros);
					JOptionPane.showMessageDialog(null, 
							"Quantidade de litros que se colocará no tanque: " 
									+ quantLitrosFormatted + "L" );
				}
			}
		});
		btn_calc.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn_calc.setBounds(89, 91, 140, 29);
		contentPane.add(btn_calc);
	}

}
