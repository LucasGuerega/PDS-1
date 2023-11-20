package visao;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import modelo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lbl_nome;
	private JTextField txt_nome;
	private JLabel lbl_cpf;
	private JTextField txt_cpf;
	ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private JButton btnNewButton_2;
	private JLabel lbl_telefone;
	private JTextField txt_telefone;
	private JLabel lbl_idade;
	private JLabel lbl_peso;
	private JLabel lbl_altura;
	private JTextField txt_idade;
	private JTextField txt_peso;
	private JTextField txt_altura;

	String nome = "";
	String cpf = "";
	String telefone = "";
	String idade = "";
	Float peso = (float) 0.0;
	Float altura = (float) 0.0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setTitle("Tela de cadastro e de verificação de cadastrados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[45.00px,grow][-22.00px][46px][25px][][][47.00px,grow][][11px,grow]",
				"[14px][20px][][][25.00px][192.00px][][][]"));

		txt_telefone = new JTextField();
		txt_telefone.setColumns(10);
		contentPane.add(txt_telefone, "cell 8 1,growx");

		lbl_idade = new JLabel("Idade");
		contentPane.add(lbl_idade, "cell 0 3");

		lbl_peso = new JLabel("Peso (Kg)");
		contentPane.add(lbl_peso, "cell 6 3");

		lbl_altura = new JLabel("Altura (m)");
		contentPane.add(lbl_altura, "cell 8 3");

		txt_idade = new JTextField();
		txt_idade.setColumns(10);
		contentPane.add(txt_idade, "cell 0 4,growx");

		txt_peso = new JTextField();
		txt_peso.setColumns(10);
		contentPane.add(txt_peso, "cell 6 4,growx");

		txt_altura = new JTextField();
		txt_altura.setColumns(10);
		contentPane.add(txt_altura, "cell 8 4,growx");

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 5 9 1,alignx right,growy");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linha = table.getSelectedRow();
				Pessoa pessoaSelecionada = listaPessoas.get(linha);
				JOptionPane.showMessageDialog(null, "Pessoa Selecionada: " + pessoaSelecionada.getNome());
			}
		});
		atualizarJTableModel();
		scrollPane.setViewportView(table);

		lbl_nome = new JLabel("Nome");
		contentPane.add(lbl_nome, "cell 0 0,alignx left,aligny top");

		txt_nome = new JTextField();
		contentPane.add(txt_nome, "cell 0 1 3 1,growx,aligny top");
		txt_nome.setColumns(10);

		lbl_cpf = new JLabel("CPF");
		contentPane.add(lbl_cpf, "flowx,cell 6 0,alignx left,aligny top");

		txt_cpf = new JTextField();
		contentPane.add(txt_cpf, "cell 6 1 2 1,alignx left,aligny top");
		txt_cpf.setColumns(10);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = new Pessoa();
				nome = txt_nome.getText();
				cpf = txt_cpf.getText();
				telefone = txt_telefone.getText();
			    idade = txt_idade.getText();
				peso = Float.parseFloat(txt_peso.getText());
				altura = Float.parseFloat(txt_altura.getText());
				p.setNome(nome);
				p.setCpf(Integer.parseInt(cpf));
				p.setTelefone(Integer.parseInt(telefone));
				p.setIdade(Integer.parseInt(idade));
				p.setPeso(peso);
				p.setAltura(altura);
				listaPessoas.add(p);

				atualizarJTableModel();
				limparCampos();

			}
		});
		contentPane.add(btnNewButton, "cell 0 8,growx,aligny top");

		btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int linhaSelecionada = table.getSelectedRow();

		        if (linhaSelecionada != -1) {
		            Pessoa pessoaSelecionada = listaPessoas.get(linhaSelecionada);

		            pessoaSelecionada.setNome(txt_nome.getText());
		            pessoaSelecionada.setCpf(Integer.parseInt(txt_cpf.getText()));
		            pessoaSelecionada.setTelefone(Integer.parseInt(txt_telefone.getText()));
		            pessoaSelecionada.setIdade(Integer.parseInt(txt_idade.getText()));
		            pessoaSelecionada.setPeso(Float.parseFloat(txt_peso.getText()));
		            pessoaSelecionada.setAltura(Float.parseFloat(txt_altura.getText()));

		            limparCampos();
		            atualizarJTableModel();
		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para editar.");
		        }
		    }
		});

		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx_linha = table.getSelectedRow();
				listaPessoas.remove(idx_linha);
				atualizarJTableModel();
				limparCampos();
			}
		});
		contentPane.add(btnNewButton_1, "cell 3 8 4 1,growx,aligny top");
		contentPane.add(btnNewButton_2, "cell 8 8,growx,aligny top");

		lbl_telefone = new JLabel("Telefone");
		contentPane.add(lbl_telefone, "cell 8 0");
	}

	public void atualizarJTableModel() {
		table.setModel(new PessoaJTableModel(listaPessoas));

	}

	public void limparCampos() {
		txt_nome.setText("");
		txt_cpf.setText("");
		txt_telefone.setText("");
		txt_idade.setText("");
		txt_peso.setText("");
		txt_altura.setText("");
	}
}
