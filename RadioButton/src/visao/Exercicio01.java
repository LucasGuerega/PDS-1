package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class Exercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_base;
	private JTextField txt_altura;
	private JRadioButton rdbnt_area;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbnt_perimetro;
	private JButton btnLimpar;
	private JButton btnFechar;
	private JLabel lblPerimetro;
	private JLabel lblArea;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio01 frame = new Exercicio01();
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
	public Exercicio01() {
		setTitle("Retângulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lbl_base = new JLabel("Base:");
		lbl_base.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lbl_base);

		label = new JLabel("");
		contentPane.add(label);

		JLabel lbl_altura = new JLabel("Altura: ");
		lbl_altura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lbl_altura);

		txt_base = new JTextField();
		txt_base.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(txt_base);
		txt_base.setColumns(10);

		label_1 = new JLabel("");
		contentPane.add(label_1);

		txt_altura = new JTextField();
		txt_altura.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_altura.setColumns(10);
		contentPane.add(txt_altura);

		rdbnt_area = new JRadioButton("Área");
		rdbnt_area.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(rdbnt_area);
		rdbnt_area.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(rdbnt_area);

		label_2 = new JLabel("");
		contentPane.add(label_2);

		rdbnt_perimetro = new JRadioButton("Perímetro");
		rdbnt_perimetro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(rdbnt_perimetro);
		contentPane.add(rdbnt_perimetro);

		label_3 = new JLabel("");
		contentPane.add(label_3);

		label_4 = new JLabel("");
		contentPane.add(label_4);

		label_5 = new JLabel("");
		contentPane.add(label_5);

		lblArea = new JLabel("");
		lblArea.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		contentPane.add(lblArea);

		label_7 = new JLabel("");
		contentPane.add(label_7);

		lblPerimetro = new JLabel("");
		lblPerimetro.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		contentPane.add(lblPerimetro);

		JButton btn_calc = new JButton("Calcular");
		btn_calc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String baseDigi = txt_base.getText();
				String alturaDigi = txt_altura.getText();
				if (baseDigi.isEmpty() || alturaDigi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				}
				if (!rdbnt_area.isSelected() && !rdbnt_perimetro.isSelected()) {
					JOptionPane.showMessageDialog(null, "Escolha pelo menos um!");
				}
				float base = Float.valueOf(baseDigi);
				float altura = Float.valueOf(alturaDigi);

				Retangulo calc = new Retangulo();
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				if (rdbnt_area.isSelected()) {
					float areaCalc = calc.calcArea(base, altura);
					decimalFormat.format(areaCalc);
					String txt_area = String.valueOf(areaCalc);
					lblArea.setText("Área: " + txt_area);

				} else if (rdbnt_perimetro.isSelected()) {
					float perimetroCalc = calc.calcPerimetro(base, altura);
					decimalFormat.format(perimetroCalc);
					String txt_area = String.valueOf(perimetroCalc);
					lblPerimetro.setText("Perímetro: " + txt_area);
				}
			}
		});

		btn_calc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(btn_calc);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_base.setText("");
				txt_altura.setText("");
				lblArea.setText("");
				lblPerimetro.setText("");
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
