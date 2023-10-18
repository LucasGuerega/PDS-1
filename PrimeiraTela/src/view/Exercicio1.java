package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ConversaoTemperatura;

public class Exercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_tempF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio1 frame = new Exercicio1();
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
	public Exercicio1() {
		setTitle("Conversor Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_tempF = new JLabel("Temp F°");
		lbl_tempF.setBounds(65, 31, 46, 14);
		contentPane.add(lbl_tempF);

		txt_tempF = new JTextField();
		txt_tempF.setBounds(121, 28, 86, 20);
		contentPane.add(txt_tempF);
		txt_tempF.setColumns(10);

		JButton btn_calcular = new JButton("Calcular");
		btn_calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * pegar temp->conveter pra float->cria obj da calsse convtemp-.chama metodo
				 * conv->mostra temp
				 */
				String tempDigi = txt_tempF.getText();
				if (tempDigi.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha tudo!");
				}
				float tempF = Float.valueOf(tempDigi);
				ConversaoTemperatura conv = new ConversaoTemperatura();
				float tempC = conv.convFtC(tempF);
				JOptionPane.showMessageDialog(null, "Temperatura em celcius(C°): " + tempC + "C°");
			}
		});
		btn_calcular.setBounds(87, 56, 89, 23);
		contentPane.add(btn_calcular);
	}
}
