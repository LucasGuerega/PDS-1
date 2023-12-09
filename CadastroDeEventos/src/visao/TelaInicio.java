package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.CategoriaEvento;
import modelo.Evento;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	ArrayList<Evento> listaEventos = new ArrayList<Evento>();
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;

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
		setTitle("Tela de Eventos ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1658, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable();
		atualizarJTableModel();
		scrollPane.setViewportView(table);
		TelaInicio estaJanela = this;

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		btnNewButton = new JButton("Cadastrar evento");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(210, 210, 210));
		btnNewButton.setBackground(new Color(237, 114, 38));
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("Alterar evento");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
				Evento eventoSelecionada = listaEventos.get(linha);
				TelaAlteraCadastroEventos janelaAlterar = new TelaAlteraCadastroEventos(table, listaEventos,
						eventoSelecionada, estaJanela);
				janelaAlterar.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(237, 114, 38));
		btnNewButton_1.setForeground(new Color(210, 210, 210));
		panel.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Excluir evento");
		btnNewButton_2.setForeground(new Color(210, 210, 210));
		btnNewButton_2.setBackground(new Color(237, 114, 38));
		btnNewButton_2.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx_linha = table.getSelectedRow();
				if (idx_linha < 0) {
					JOptionPane.showMessageDialog(null, "Selecione o evento para excluir!");
					return;
				}

				listaEventos.remove(idx_linha);
				atualizarJTableModel();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// atualizarJTableModel();
			}
		});
		panel.add(btnNewButton_2);

		lblNewLabel = new JLabel("Eventos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(237, 114, 38));
		lblNewLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 99));
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\Aluno\\Documents\\PDS-1\\CadastroDeEventos\\src\\WalktourLogo.png"));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroEventos janelaAlterar = new TelaCadastroEventos(table, listaEventos, estaJanela);
				janelaAlterar.setVisible(true);
			}
		});
	}

	public void atualizarJTableModel() {
		table.setModel(new EventoJTableModel(listaEventos));

	}

	public void atualizarDadosEvento(Evento evento) {
		int linhaSelecionada = table.getSelectedRow();
		listaEventos.set(linhaSelecionada, evento); // Atualizar os dados da pessoa
		atualizarJTableModel();
	}
}
