package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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

	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1658, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
		
				JScrollPane scrollPane = new JScrollPane();
				contentPane.add(scrollPane);
				
						table = new JTable();
						table.setBackground(new Color(199, 199, 199));
						table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
								new String[] { "Nome do Evento", "Localização", "Descrição", "Data", "Hora", "Preço do Ingresso",
										"Categoria", "Avaliação Média", "Site Oficial", "Email de Contato", "Telefone de Contato",
										"Endereço", "Cidade", "Estado", "CEP" }));
						scrollPane.setViewportView(table);
						
						btnNewButton = new JButton("Cadastrar evento");
						contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
