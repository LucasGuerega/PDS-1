package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Retangulo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Exercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_base;
	private JTextField txt_altura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio3 frame = new Exercicio3();
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
	public Exercicio3() {
		setTitle("Calcular Per/Are Retângulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_base = new JTextField();
		txt_base.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txt_base.setBounds(126, 11, 131, 32);
		contentPane.add(txt_base);
		txt_base.setColumns(10);
		
		JLabel lbl_base = new JLabel("Base:");
		lbl_base.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_base.setBounds(63, 11, 86, 32);
		contentPane.add(lbl_base);
		
		JLabel lbl_altura = new JLabel("Altura: ");
		lbl_altura.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_altura.setBounds(43, 45, 86, 29);
		contentPane.add(lbl_altura);
		
		txt_altura = new JTextField();
		txt_altura.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txt_altura.setColumns(10);
		txt_altura.setBounds(126, 43, 131, 32);
		contentPane.add(txt_altura);
		
		JButton btn_calc = new JButton("Calcular");
		btn_calc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String baseDigi = txt_base.getText();
				String alturaDigi = txt_altura.getText();
				if (baseDigi.isEmpty()||alturaDigi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				}
				float base = Float.valueOf(baseDigi);
				float altura = Float.valueOf(alturaDigi);
				Retangulo calc = new Retangulo();
	            float perimetroCalc = calc.calcPerimetro(base, altura);
	            float areaCalc = calc.calcArea(base, altura);
				JOptionPane.showMessageDialog(null, "Perímetro do retângulo: " + perimetroCalc + 
													"\nÁrea do retângulo: " + areaCalc);
			}
		});
		btn_calc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_calc.setBounds(63, 85, 165, 43);
		contentPane.add(btn_calc);
	}
}
