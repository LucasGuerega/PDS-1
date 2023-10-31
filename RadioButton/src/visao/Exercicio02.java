package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Calcular;
import modelo.Retangulo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Exercicio02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_num1;
	private JTextField txt_num2;
	private JRadioButton rdbnt_add;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbnt_sub;
	private JButton btnLimpar;
	private JButton btnFechar;
	private JLabel lblResultado;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_6;
	private JRadioButton rdbnt_multi;
	private JRadioButton rdbnt_divi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio02 frame = new Exercicio02();
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
	public Exercicio02() {
		setTitle("Carculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbl_num1 = new JLabel("Primeiro número inteiro: ");
		lbl_num1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lbl_num1);

		txt_num1 = new JTextField();
		txt_num1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(txt_num1);
		txt_num1.setColumns(10);

		JLabel lbl_num2 = new JLabel("Segundo número inteiro: ");
		lbl_num2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lbl_num2);

		txt_num2 = new JTextField();
		txt_num2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_num2.setColumns(10);
		contentPane.add(txt_num2);

		label = new JLabel("");
		contentPane.add(label);

		label_1 = new JLabel("");
		contentPane.add(label_1);

		rdbnt_add = new JRadioButton("+ Adição");
		rdbnt_add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(rdbnt_add);
		rdbnt_add.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(rdbnt_add);

		label_3 = new JLabel("");
		contentPane.add(label_3);

		rdbnt_sub = new JRadioButton("- Subtração");
		rdbnt_sub.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(rdbnt_sub);
		contentPane.add(rdbnt_sub);

		label_2 = new JLabel("");
		contentPane.add(label_2);

		rdbnt_multi = new JRadioButton("X Multiplicação");
		rdbnt_multi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(rdbnt_multi);
		buttonGroup.add(rdbnt_multi);

		label_4 = new JLabel("");
		contentPane.add(label_4);

		rdbnt_divi = new JRadioButton("/ Divisão");
		rdbnt_divi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(rdbnt_divi);
		buttonGroup.add(rdbnt_divi);


		label_5 = new JLabel("");
		contentPane.add(label_5);

		label_7 = new JLabel("");
		contentPane.add(label_7);

		JButton btn_calc = new JButton("Calcular");
		btn_calc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strNum1 = txt_num1.getText();
				String strNum2 = txt_num2.getText();
				if (strNum1.isEmpty() || strNum2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				}
				if (!rdbnt_add.isSelected() && !rdbnt_sub.isSelected() && !rdbnt_multi.isSelected()
						&& !rdbnt_divi.isSelected()) {
					JOptionPane.showMessageDialog(null, "Escolha pelo menos um!");
				}
				int num1 = Integer.valueOf(strNum1);
				int num2 = Integer.valueOf(strNum2);
				Calcular calc = new Calcular();
				if (rdbnt_add.isSelected()) {
					int soma = (int) calc.add(num1, num2);
					String txt_resultado = String.valueOf(soma);
					lblResultado.setText("Resultado: " + txt_resultado);
				}
				if (rdbnt_sub.isSelected()) {
					int menos = (int) calc.sub(num1, num2);
					String txt_resultado = String.valueOf(menos);
					lblResultado.setText("Resultado: " + txt_resultado);
				}
				if (rdbnt_multi.isSelected()) {
					int mult = (int) calc.multi(num1, num2);
					String txt_resultado = String.valueOf(mult);
					lblResultado.setText("Resultado: " + txt_resultado);
				}
				if (rdbnt_divi.isSelected()) {
					int divi = (int) calc.divi(num1, num2);
					String txt_resultado = String.valueOf(divi);
					lblResultado.setText("Resultado: " + txt_resultado);
				}
			}
		});

		label_6 = new JLabel("");
		contentPane.add(label_6);

		btn_calc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(btn_calc);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		contentPane.add(lblResultado);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_num1.setText("");
				txt_num2.setText("");
				lblResultado.setText("");
			}
		});
		btnLimpar.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnLimpar.setBounds(283, 290, 138, 23);
		contentPane.add(btnLimpar);

		btnFechar = new JButton("Fechar");
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(btnFechar);
	}
}
