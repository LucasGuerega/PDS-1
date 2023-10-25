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

public class Exercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_base;
	private JTextField txt_altura;
	private JRadioButton rdbnt_area;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbnt_perimetro;

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
		setBounds(100, 100, 619, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[86px][58px][86px]", "[32px][32px][43px][][][][][][][]"));
		
		JLabel lbl_altura = new JLabel("Altura: ");
		lbl_altura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lbl_altura, "cell 1 0,grow");
		
		txt_base = new JTextField();
		txt_base.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(txt_base, "cell 0 1,grow");
		txt_base.setColumns(10);
		
		JLabel lbl_base = new JLabel("Base:");
		lbl_base.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lbl_base, "cell 0 0,grow");
		
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
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
	            float perimetroCalc = calc.calcPerimetro(base, altura);
	            float areaCalc = calc.calcArea(base, altura);
	            String perimetroCalcFormat = decimalFormat.format(perimetroCalc);
	            String areaCalcFormat = decimalFormat.format(areaCalc);
				JOptionPane.showMessageDialog(null, "Perímetro do retângulo: " + perimetroCalcFormat + 
													"\nÁrea do retângulo: " + areaCalcFormat);
			}
		});
		
		txt_altura = new JTextField();
		txt_altura.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_altura.setColumns(10);
		contentPane.add(txt_altura, "cell 1 1,grow");
		
		rdbnt_area = new JRadioButton("Área");
		buttonGroup.add(rdbnt_area);
		rdbnt_area.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(rdbnt_area, "cell 0 3");
		
		rdbnt_perimetro = new JRadioButton("Perímetro");
		buttonGroup.add(rdbnt_perimetro);
		contentPane.add(rdbnt_perimetro, "cell 1 3");
		
		btn_calc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(btn_calc, "cell 1 9,alignx center,aligny top");
	}
}
