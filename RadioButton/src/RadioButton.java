import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RadioButton extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButton frame = new RadioButton();
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
	public RadioButton() {
		setTitle("JRadioButton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbOp1 = new JRadioButton("Opção 1");
		buttonGroup.add(rdbOp1);
		rdbOp1.setBounds(78, 27, 109, 23);
		contentPane.add(rdbOp1);
		
		JRadioButton rdbOp2 = new JRadioButton("Opção 2");
		buttonGroup.add(rdbOp2);
		rdbOp2.setBounds(78, 53, 109, 23);
		contentPane.add(rdbOp2);
		
		JRadioButton rdbOp3 = new JRadioButton("Opção 3");
		buttonGroup.add(rdbOp3);
		rdbOp3.setBounds(78, 79, 109, 23);
		contentPane.add(rdbOp3);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(103, 177, 155, 14);
		contentPane.add(lblResultado);
		
		JButton btnNewButton = new JButton("Verifica");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbOp1.isSelected()) {
					lblResultado.setText("Opção 1 Selecionada");
					JOptionPane.showMessageDialog(null, "Opção 1 Selecionada");
					
				}else if(rdbOp2.isSelected()) {
					JOptionPane.showMessageDialog(null, "Opção 2 Selecionada");
					lblResultado.setText("Opção 2 Selecionada");
				}else if(rdbOp3.isSelected()) {
					JOptionPane.showMessageDialog(null, "Opção 3 Selecionada");
					lblResultado.setText("Opção 3 Selecionada");
				}
				
				
			}
		});
		btnNewButton.setBounds(79, 121, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
