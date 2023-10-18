import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela frame = new janela();
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
	public janela() {
		setForeground(new Color(64, 0, 64));
		setFont(new Font("Old English Text MT", Font.BOLD, 40));
		setTitle("Olá Mundo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_olamundo = new JLabel("Olá Mundo");
		lbl_olamundo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Hi people");
			}
		});

		lbl_olamundo.setBounds(114, 35, 211, 60);
		lbl_olamundo.setBackground(new Color(255, 255, 255));
		lbl_olamundo.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		contentPane.add(lbl_olamundo);

		JButton btn_fechar = new JButton("Fechar");
		btn_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btn_fechar.setBounds(213, 196, 211, 54);
		btn_fechar.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		contentPane.add(btn_fechar);
		

		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		lbl_nome.setBounds(100, 106, 88, 60);
		contentPane.add(lbl_nome);

		txt_nome = new JTextField();
		txt_nome.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		txt_nome.setBounds(198, 106, 211, 60);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JButton btn_validar = new JButton("Validar");
		btn_validar.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		btn_validar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* pega texto(jopanetxt_nome)->mostra ele(jopane) */
				String nome = txt_nome.getText();
				JOptionPane.showMessageDialog(null, "Nome digitado: " + nome);
			}
		});
		btn_validar.setBounds(10, 196, 179, 50);
		contentPane.add(btn_validar);

		JButton btn_limpar = new JButton("Limpar");
		btn_limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_nome.setText("");
			}
		});
		btn_limpar.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		btn_limpar.setBounds(123, 261, 179, 50);
		contentPane.add(btn_limpar);

	}
}
