package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ComboBoxUI;

import modelo.Calculos;
import modelo.Combustiveis;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TelaSistemaDePostoDeCombustivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txt_disel;
	private JTextField txt_gCom;
	private JTextField txt_gAdd;
	private JTextField txt_etn;
	private JTextField txt_500ml;
	private JTextField txt_1l;
	private JTextField txt_qnt500ml;
	private JTextField txt_qnt1l;
	private JTextField txt_qntL;
	private JTextField txt_qntDias;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<Combustiveis> listaCombustiveis = new ArrayList<Combustiveis>();
	Calculos calc = new Calculos();
	float digiDisel = (float) 0.00;
	float digiGCom = (float) 0.00;
	float digiGAdd = (float) 0.00;
	float digiEtanol = (float) 0.00;
	float digiFrasco500ml = (float) 0.00;
	float digiFrasco1L = (float) 0.00;
	float digiQntL = (float) 0.00;
	float digiQntFrasco1L = (float) 0.00;
	float digiQntFrasco500mL = (float) 0.00;
	int digiDias = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSistemaDePostoDeCombustivel frame = new TelaSistemaDePostoDeCombustivel();
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
	public TelaSistemaDePostoDeCombustivel() {
		carregarCombustiveis();
		setTitle("Posto de Combustivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(
				new MigLayout("", "[268.00,grow][][253.00,grow][]", "[101.00,grow][56.00,grow][101.00,grow][]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tabela de Preco do Combustivel", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[46px][][][86px,grow]", "[20px][][][][]"));

		JLabel lbl_OleoDisel = new JLabel("Oleo Disel:");
		lbl_OleoDisel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lbl_OleoDisel, "cell 1 0,alignx center,aligny center");

		txt_disel = new JTextField();
		panel_1.add(txt_disel, "cell 3 0,alignx left,aligny top");
		txt_disel.setColumns(10);

		JLabel lblGasComum = new JLabel("Gas. Comum:");
		panel_1.add(lblGasComum, "cell 1 1,alignx center");

		txt_gCom = new JTextField();
		txt_gCom.setColumns(10);
		panel_1.add(txt_gCom, "cell 3 1,alignx left,growy");

		JLabel lblGasAditivada = new JLabel("Gas. Aditivada:");
		panel_1.add(lblGasAditivada, "cell 1 2,alignx center");

		txt_gAdd = new JTextField();
		txt_gAdd.setColumns(10);
		panel_1.add(txt_gAdd, "cell 3 2,alignx left");

		JLabel lblEtanol = new JLabel("Etanol:");
		panel_1.add(lblEtanol, "cell 1 3,alignx center");

		txt_etn = new JTextField();
		txt_etn.setColumns(10);
		panel_1.add(txt_etn, "cell 3 3,alignx left");

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Tabela de Preco do Oleo Motor", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_2, "cell 1 0 3 1,grow");
		panel_2.setLayout(new MigLayout("", "[][][][][grow]", "[][][]"));

		JLabel lbl_frasco500ml = new JLabel("Frasco 500ml");
		lbl_frasco500ml.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lbl_frasco500ml, "cell 2 0,alignx center");

		txt_500ml = new JTextField();
		txt_500ml.setColumns(10);
		panel_2.add(txt_500ml, "cell 4 0,alignx center");

		JLabel lbl_frasco1l = new JLabel("Frasco 1L");
		lbl_frasco1l.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lbl_frasco1l, "cell 2 2");

		txt_1l = new JTextField();
		txt_1l.setColumns(10);
		panel_2.add(txt_1l, "cell 4 2,alignx center");

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Oleo Motor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, "cell 0 1 4 1,grow");
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Valor a pagar");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Total Oleo");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);

		JLabel lblFrascoDeml = new JLabel("Frasco de 500mL");
		lblFrascoDeml.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFrascoDeml);

		txt_qnt500ml = new JTextField();
		panel_3.add(txt_qnt500ml);
		txt_qnt500ml.setColumns(10);

		JLabel lbl_f500ml = new JLabel("-");
		lbl_f500ml.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lbl_f500ml);

		JLabel lbl_toleo = new JLabel("-");
		lbl_toleo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lbl_toleo);

		JLabel lblFrascoDel = new JLabel("Frasco de1L");
		lblFrascoDel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFrascoDel);

		txt_qnt1l = new JTextField();
		txt_qnt1l.setColumns(10);
		panel_3.add(txt_qnt1l);

		JLabel lbl_f1l = new JLabel("-");
		lbl_f1l.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lbl_f1l);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Abastecimento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_4, "cell 0 2 2 1,grow");
		panel_4.setLayout(new MigLayout("", "[][][grow]", "[][][]"));

		JLabel lblNewLabel_4 = new JLabel("Combustivel:");
		panel_4.add(lblNewLabel_4, "cell 1 0,alignx trailing");

		JComboBox<Combustiveis> comboBoxCombustiveis = new JComboBox<Combustiveis>();
		for (int i = 0; i < listaCombustiveis.size(); i++) {
			comboBoxCombustiveis.addItem(listaCombustiveis.get(i));
		}
		panel_4.add(comboBoxCombustiveis, "cell 2 0,growx");

		/* JComboBox comboBox = new JComboBox(); */

		JLabel lblNewLabel_4_1 = new JLabel("Quantidade Litros:");
		panel_4.add(lblNewLabel_4_1, "cell 1 1,alignx center");

		txt_qntL = new JTextField();
		txt_qntL.setText("");
		panel_4.add(txt_qntL, "cell 2 1,alignx center");
		txt_qntL.setColumns(10);


		JLabel lblNewLabel_4_2 = new JLabel("Total Combustivel:");
		panel_4.add(lblNewLabel_4_2, "cell 1 2,alignx center");

		JLabel lbl_tcomb = new JLabel("-");
		panel_4.add(lbl_tcomb, "cell 2 2,alignx center");

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "Formas de Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_5, "cell 2 2 2 1,grow");
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));

		JRadioButton rdbtn_Vista = new JRadioButton("\u00C0 Vista");
		buttonGroup.add(rdbtn_Vista);
		panel_5.add(rdbtn_Vista);
				
				JLabel label = new JLabel("");
				panel_5.add(label);
		
				txt_qntDias = new JTextField();
				panel_5.add(txt_qntDias);
				txt_qntDias.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_5.add(label_2);

		JLabel lblNewLabel_5 = new JLabel("Dias:");
		panel_5.add(lblNewLabel_5);
		
				JRadioButton rdbtn_Prazo = new JRadioButton("\u00C0 Prazo");
				buttonGroup.add(rdbtn_Prazo);
				panel_5.add(rdbtn_Prazo);
		
		JLabel label_3 = new JLabel("");
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel_5.add(label_4);

		JLabel lblNewLabel_4_2_1 = new JLabel("Total a pagar:");
		panel_5.add(lblNewLabel_4_2_1);

		JLabel lbl_tcomb_1 = new JLabel("-");
		lbl_tcomb_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lbl_tcomb_1);
		
		JLabel label_5 = new JLabel("");
		panel_5.add(label_5);

		JButton btn_calc = new JButton("Calcular");
		btn_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!rdbtn_Vista.isSelected() && !rdbtn_Prazo.isSelected()) {
					JOptionPane.showMessageDialog(null, "Escolha pelo menos uma opçaõ de pagamento!");
				}
				

				try {
					digiQntL = Float.parseFloat(txt_qntL.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Quantidade de litros deve ser um numero(float)");
					return;
				}
				try {
					digiDisel = Float.parseFloat(txt_disel.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor do diesel deve ser um numero(float)");
					return;
				}
				try {
					digiGCom = Float.parseFloat(txt_gCom.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor da gasolina comum deve ser um numero(float)");
					return;
				}
				try {
					digiGAdd = Float.parseFloat(txt_gAdd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor da gasolina aditivada deve ser um numero(float)");
					return;
				}
				try {
					digiEtanol = Float.parseFloat(txt_etn.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor do etanol deve ser um numero(float)");
					return;
				}
				try {
					digiFrasco500ml = Float.parseFloat(txt_500ml.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor de 500mL de oleo deve ser um numero(float)");
					return;
				}
				try {
					digiFrasco1L = Float.parseFloat(txt_1l.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor de 1L de oleo deve ser um numero(float)");
					return;
				}
				try {
					digiQntFrasco1L = Float.parseFloat(txt_qnt1l.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Quantidade de litros deve ser um numero(float)");
					return;
				}
				try {
					digiQntFrasco500mL = Float.parseFloat(txt_qnt500ml.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Quantidade de litros deve ser um numero(float)");
					return;
				}
				try {
					digiDias =  Integer.parseInt(txt_qntDias.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Quantidade de dias deve ser um numero(inteiro)");
					return;
				}
				

				Combustiveis combusSelecinada = (Combustiveis) comboBoxCombustiveis.getSelectedItem();
				float totalComb = calc.totPagComb(digiQntL, combusSelecinada, digiDisel, digiGCom, digiGAdd,
						digiEtanol);
				String txt_tcomb = String.valueOf(totalComb);
				lbl_tcomb.setText("R$" + txt_tcomb);

				Float[] valoresOleo = calc.totPagOleo(digiFrasco1L, digiFrasco500ml, digiQntFrasco1L,
						digiQntFrasco500mL);
				lbl_f500ml.setText(String.valueOf("R$" + valoresOleo[0]));
				lbl_f1l.setText(String.valueOf("R$" + valoresOleo[1]));
				lbl_toleo.setText(String.valueOf("R$" + valoresOleo[2]));

				float totalPagar = calc.totPag(totalComb, valoresOleo[2], rdbtn_Vista, rdbtn_Prazo, digiDias);
				String txt_totalPagar = String.valueOf(totalPagar);
				lbl_tcomb_1.setText("R$" + txt_totalPagar);
			}

		});
		panel.add(btn_calc, "cell 0 3");

		JButton bnt_limpar = new JButton("Novo Calculo");
		bnt_limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txt_disel.setText("");
				txt_gCom.setText("");
				txt_gAdd.setText("");
				txt_etn.setText("");
				txt_500ml.setText("");
				txt_1l.setText("");
				txt_qnt500ml.setText("");
				txt_qnt1l.setText("");
				txt_qntL.setText("");
				txt_qntDias.setText("");
				lbl_tcomb.setText(" ");
				lbl_f500ml.setText(" ");
				lbl_f1l.setText(" ");
				lbl_toleo.setText(" ");

			}
		});
		panel.add(bnt_limpar, "cell 1 3");

		JButton bnt_exit = new JButton("Fechar");
		bnt_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		panel.add(bnt_exit, "cell 3 3");

	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	private void carregarCombustiveis() {
		// Cria lista de cidades e coloca dentro de um ArrayList
		Combustiveis c1 = new Combustiveis();
		c1.setCodigo(1);
		c1.setNome("Oleo Disel");
		listaCombustiveis.add(c1);

		Combustiveis c2 = new Combustiveis();
		c2.setCodigo(2);
		c2.setNome("Gas. Comum");
		listaCombustiveis.add(c2);
		Combustiveis c3 = new Combustiveis();
		c3.setCodigo(2);
		c3.setNome("Gas. Aditivada");
		listaCombustiveis.add(c3);

		Combustiveis c4 = new Combustiveis();
		c4.setCodigo(2);
		c4.setNome("Etanol");
		listaCombustiveis.add(c4);

	}
}
