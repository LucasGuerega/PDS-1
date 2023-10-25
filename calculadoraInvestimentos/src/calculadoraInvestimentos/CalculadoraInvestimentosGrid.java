package calculadoraInvestimentos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class CalculadoraInvestimentosGrid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_depMen;
	private JTextField txt_numMes;
	private JTextField txt_jurosMes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraInvestimentosGrid frame = new CalculadoraInvestimentosGrid();
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
	public CalculadoraInvestimentosGrid() {
		setTitle("CalcIvest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 251);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mn_meni = new JMenu("Ajuda");
		menuBar.add(mn_meni);

		JButton btn_sobre = new JButton("Sobre");
		btn_sobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormSobre frame = new FormSobre();
				frame.setVisible(true);
			}
		});
		btn_sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_meni.add(btn_sobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbl_depMen = new JLabel("Déposito mensal R$:");
		contentPane.add(lbl_depMen);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_2.setLayout(fl_panel_2);

		txt_depMen = new JTextField();
		panel_2.add(txt_depMen);
		txt_depMen.setColumns(10);

		JLabel lbl_numMes = new JLabel("Num. de meses:");
		contentPane.add(lbl_numMes);

		JPanel panel_2_1 = new JPanel();
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txt_numMes = new JTextField();
		panel_2_1.add(txt_numMes);
		txt_numMes.setColumns(10);

		JLabel lbl_jurosMes = new JLabel("Juros ao mês %:");
		contentPane.add(lbl_jurosMes);

		JPanel panel_2_2 = new JPanel();
		contentPane.add(panel_2_2);
		panel_2_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txt_jurosMes = new JTextField();
		panel_2_2.add(txt_jurosMes);
		txt_jurosMes.setColumns(10);

		JLabel lbl_toInvest = new JLabel("Total investido + juros R$:");
		contentPane.add(lbl_toInvest);

		JLabel lbl_total = new JLabel("");

		contentPane.add(lbl_total);

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JButton btn_calc = new JButton("Calcular");
		btn_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String dDepMen = txt_depMen.getText();
				String dNumMes = txt_numMes.getText();
				String dJurosMes = txt_jurosMes.getText();

				if (dDepMen.isEmpty() || dDepMen.isEmpty() || dDepMen.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				}

				int depMen = Integer.valueOf(dDepMen);
				double numMes = Double.valueOf(dNumMes);
				double jurosMes = Double.valueOf(dJurosMes);

				Investimento calc = new Investimento(depMen, jurosMes, jurosMes);
				double total = calc.calculaTotal(depMen, jurosMes, jurosMes);
				String txt_total = String.valueOf(total);

				lbl_total.setText(txt_total);
			}
		});
		contentPane.add(btn_calc);

	}
}
