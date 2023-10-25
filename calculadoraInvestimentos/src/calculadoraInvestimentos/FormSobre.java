package calculadoraInvestimentos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class FormSobre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSobre frame = new FormSobre();
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
	public FormSobre() {
		setTitle("Sobre o CalcInvest");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CalcInvest - Calculadora de Investimentos");
		lblNewLabel.setBounds(12, 12, 203, 14);
		contentPane.add(lblNewLabel);

		JButton btn_oK = new JButton("OK");
		btn_oK.setBounds(112, 136, 67, 23);
		btn_oK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Versão: 1.1");
		lblNewLabel_1.setBounds(12, 37, 79, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Autor: Lucas Guerega");
		lblNewLabel_2.setBounds(12, 64, 105, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Contato: lugui2108@gmail.com.br");
		lblNewLabel_1_1.setBounds(12, 88, 216, 14);
		contentPane.add(lblNewLabel_1_1);
		contentPane.add(btn_oK);
	}

}
