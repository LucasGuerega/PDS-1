package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

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
	private JTextField textField;
	private JTextField txt_qntDias;

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
		setTitle("Posto de Combustivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[268.00,grow][][253.00,grow][]", "[101.00,grow][56.00,grow][101.00,grow][]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tabela de Preco do Combustivel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		panel_2.setBorder(new TitledBorder(null, "Tabela de Preco do Oleo Motor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
				panel_4.add(lblNewLabel_4, "cell 1 0,alignx center");
		
				JComboBox<String> comboBoxString = new JComboBox<String>();
				panel_4.add(comboBoxString, "cell 2 0,alignx center");
				//Opções foram adicionadas pelo windowbuilder (propriedade Model do componente combobox)
				comboBoxString.setModel(new DefaultComboBoxModel<String>(new String[] {"Oleo Disel", "Gas. Comum", "Gas. Aditivada", "Etanol"}));
				comboBoxString.setBounds(20, 46, 171, 22);
				
				JLabel lblNewLabel_4_1 = new JLabel("Quantidade Litros:");
				panel_4.add(lblNewLabel_4_1, "cell 1 1,alignx center");
				
				textField = new JTextField();
				textField.setText("");
				panel_4.add(textField, "cell 2 1,alignx center");
				textField.setColumns(10);
				
				JLabel lblNewLabel_4_2 = new JLabel("Total Combustivel:");
				panel_4.add(lblNewLabel_4_2, "cell 1 2,alignx center");
				
				JLabel lbl_tcomb = new JLabel("-");
				panel_4.add(lbl_tcomb, "cell 2 2,alignx center");
				
				JButton btnNewButton = new JButton("Mostrar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Pega a posicao do item selecionado no comboBoxString
						int posicao = comboBoxString.getSelectedIndex();
						// Pega o item selecionado no comboBoxString
						String item = (String) comboBoxString.getSelectedItem();
					}
				});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Formas de Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_5, "cell 2 2 2 1,grow");
		panel_5.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u00C0 Vista");
		rdbtnNewRadioButton.setBounds(6, 23, 109, 23);
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPrazo = new JRadioButton("\u00C0 Prazo");
		rdbtnPrazo.setBounds(6, 65, 109, 23);
		panel_5.add(rdbtnPrazo);
		
		txt_qntDias = new JTextField();
		txt_qntDias.setBounds(190, 43, 67, 20);
		panel_5.add(txt_qntDias);
		txt_qntDias.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dias:");
		lblNewLabel_5.setBounds(161, 46, 46, 14);
		panel_5.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Total a pagar:");
		lblNewLabel_4_2_1.setBounds(52, 95, 89, 14);
		panel_5.add(lblNewLabel_4_2_1);
		
		JLabel lbl_tcomb_1 = new JLabel("-");
		lbl_tcomb_1.setBounds(151, 95, 20, 14);
		panel_5.add(lbl_tcomb_1);
		
		JButton btn_calc = new JButton("Calcular");
		panel.add(btn_calc, "cell 0 3");
		
		JButton bnt_limpar = new JButton("Novo Calculo");
		panel.add(bnt_limpar, "cell 1 3");
		
		JButton bnt_exit = new JButton("Fechar");
		panel.add(bnt_exit, "cell 3 3");
		
	}
}
