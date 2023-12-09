package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.html.parser.Parser;

import modelo.CategoriaEvento;
import modelo.Evento;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class TelaCadastroEventos extends JFrame {
	private JPanel contentPane;
	private JTextField txt_NomeEvento;
	private JTextField txt_Localizacao;
	private CategoriaEvento categoriaSelecionada;
	ArrayList<CategoriaEvento> listaCategorias = new ArrayList<CategoriaEvento>();
	private JTextField txt_Data;
	private JTextField txt_Hora;
	private JTextField txt_PrecIngresso;
	private JTextField txt_AvaliaMedia;
	private JTextField txt_SiteOfi;
	private JTextField txt_Email;
	private JTextField txt_Telefone;
	private JTextField txt_Endereco;
	private JTextField txt_Cidade;
	private JTextField txt_Estado;
	private JTextField txt_CEP;

	/**
	 * Create the frame.
	 * 
	 * @param table
	 * @param listaEventos
	 */
	public TelaCadastroEventos(JTable table, ArrayList<Evento> listaEventos, TelaInicio janela) {
		setTitle("Cadastro Evento");
		carregarCategorias();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[461.00,grow][][grow][][grow][][grow][][][][][][][][][]", "[grow][][][][grow][][][grow][][][][][][][][][][][]"));

		JPanel LadoJanela = new JPanel();
		contentPane.add(LadoJanela, "cell 0 0 1 19,grow");
		LadoJanela.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("l");
		lblNewLabel_3.setBounds(-115, 0, 612, 461);
		lblNewLabel_3.setIcon(
				new ImageIcon("C:\\Users\\lugui\\OneDrive\\Documentos\\PDS-1\\CadastroDeEventos\\src\\LadoA2.png"));
		LadoJanela.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Cadastrar Evento");
		lblNewLabel.setForeground(new Color(237, 114, 38));
		lblNewLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 35));
		contentPane.add(lblNewLabel, "cell 6 0");

		JLabel lblNewLabel_1 = new JLabel("Nome do evento");
		contentPane.add(lblNewLabel_1, "cell 2 2");

		txt_NomeEvento = new JTextField();
		contentPane.add(txt_NomeEvento, "cell 4 2 11 1,growx");
		txt_NomeEvento.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Localizacão");
		contentPane.add(lblNewLabel_2, "cell 2 3");

		txt_Localizacao = new JTextField();
		contentPane.add(txt_Localizacao, "cell 4 3 11 1,growx");
		txt_Localizacao.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Descricão");
		contentPane.add(lblNewLabel_2_1, "cell 2 4");

		JTextArea txt_desc = new JTextArea();
		txt_desc.setToolTipText("Descricão de seu evento");
		contentPane.add(txt_desc, "cell 4 4 11 1,grow");

		JLabel lblNewLabel_2_1_1 = new JLabel("Data");
		contentPane.add(lblNewLabel_2_1_1, "cell 2 5");
		txt_Data = new JFormattedTextField(setMascara("##/##/####"));
		txt_Data.setColumns(10);
		contentPane.add(txt_Data, "cell 4 5 11 1,growx");

		JLabel lblNewLabel_2_1_2 = new JLabel("Hora");
		contentPane.add(lblNewLabel_2_1_2, "cell 2 6");

		txt_Hora = new JFormattedTextField(setMascara("##:##"));
		txt_Hora.setColumns(10);
		contentPane.add(txt_Hora, "cell 4 6 11 1,growx");

		JLabel lblNewLabel_2_1_3 = new JLabel("Preco do ingresso");
		contentPane.add(lblNewLabel_2_1_3, "cell 2 7");

		txt_PrecIngresso = new JFormattedTextField(setMascara("#####.##"));
		txt_PrecIngresso.setColumns(10);
		contentPane.add(txt_PrecIngresso, "cell 4 7 11 1,growx");

		JLabel lblNewLabel_2_1_4 = new JLabel("Categoria");
		contentPane.add(lblNewLabel_2_1_4, "cell 2 8");

		JComboBox<CategoriaEvento> comboBoxCategorias = new JComboBox<CategoriaEvento>();
		for (int i = 0; i < listaCategorias.size(); i++) {
			comboBoxCategorias.addItem(listaCategorias.get(i));
		}
		contentPane.add(comboBoxCategorias, "cell 4 8 11 1,growx");

		CategoriaEvento combusSelecinada = (CategoriaEvento) comboBoxCategorias.getSelectedItem();

		JLabel lblNewLabel_2_1_5 = new JLabel("Avaliacão média");
		contentPane.add(lblNewLabel_2_1_5, "cell 2 9");

		txt_AvaliaMedia = new JFormattedTextField(setMascara("#.#"));
		txt_AvaliaMedia.setColumns(10);
		contentPane.add(txt_AvaliaMedia, "cell 4 9 11 1,growx");

		JLabel lblNewLabel_2_1_6 = new JLabel("Site oficial");
		contentPane.add(lblNewLabel_2_1_6, "cell 2 10");

		txt_SiteOfi = new JTextField();
		txt_SiteOfi.setColumns(10);
		contentPane.add(txt_SiteOfi, "cell 4 10 11 1,growx");

		JLabel lblNewLabel_2_1_7 = new JLabel("Email de contato");
		contentPane.add(lblNewLabel_2_1_7, "cell 2 11");

		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		contentPane.add(txt_Email, "cell 4 11 11 1,growx");

		JLabel lblNewLabel_2_1_7_1 = new JLabel("Telefone de contato");
		contentPane.add(lblNewLabel_2_1_7_1, "cell 2 12");

		txt_Telefone = new JFormattedTextField(setMascara("+## (##) 9 ####-####"));
		txt_Telefone.setColumns(10);
		contentPane.add(txt_Telefone, "cell 4 12 11 1,growx");

		JLabel lblNewLabel_2_1_7_2 = new JLabel("Endereco");
		contentPane.add(lblNewLabel_2_1_7_2, "cell 2 13");

		txt_Endereco = new JTextField();
		txt_Endereco.setColumns(10);
		contentPane.add(txt_Endereco, "cell 4 13 11 1,growx");

		JLabel lblNewLabel_2_1_7_2_1 = new JLabel("Cidade");
		contentPane.add(lblNewLabel_2_1_7_2_1, "cell 2 14");

		txt_Cidade = new JTextField();
		txt_Cidade.setColumns(10);
		contentPane.add(txt_Cidade, "cell 4 14 11 1,growx");

		JLabel lblNewLabel_2_1_7_2_2 = new JLabel("Estado");
		contentPane.add(lblNewLabel_2_1_7_2_2, "cell 2 15");

		txt_Estado = new JTextField();
		txt_Estado.setColumns(10);
		contentPane.add(txt_Estado, "cell 4 15 11 1,growx");

		JLabel lblNewLabel_2_1_7_2_3 = new JLabel("CEP");
		contentPane.add(lblNewLabel_2_1_7_2_3, "cell 2 16");

		txt_CEP = new JFormattedTextField(setMascara("#####-###"));
		txt_CEP.setColumns(10);
		contentPane.add(txt_CEP, "cell 4 16 11 1,growx");

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setForeground(new Color(237, 114, 38));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
				JButton btnNewButton_2 = new JButton("Salvar");
				btnNewButton_2.setForeground(new Color(237, 114, 38));
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent x) {

						String nomeEvento = txt_NomeEvento.getText();
						if (nomeEvento.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de nome é obrigatório!");
							return;
						}

						String localizacão = txt_Localizacao.getText();
						if (localizacão.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de localizacão é obrigatório!");
							return;
						}

						String descricao = txt_desc.getText();
						if (descricao.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de descricão é obrigatório!");
							return;
						}

						String data = txt_Data.getText();
						String DataForm;

						if (data.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de data é obrigatório!");
							return;
						}

						try {
							DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
							LocalDate dataD = LocalDate.parse(data, formatters);

							if (dataD.getDayOfMonth() < 1 || dataD.getDayOfMonth() > 31 || dataD.getMonthValue() < 1
									|| dataD.getMonthValue() > 12 || dataD.getYear() < 2024) {
								JOptionPane.showMessageDialog(null,
										"Data inválida! Verifique o dia (1-31), mês (1-12) e ano (a partir de 2024).");
								return;
							}

							DataForm = dataD.format(formatters);
						} catch (DateTimeParseException e1) {
							JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
							return;
						}

						String tempo = txt_Hora.getText();
						Time tempoT = null;

						if (tempo.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo de tempo é obrigatório!");
							return;
						}

						try {
							LocalTime hora = LocalTime.parse(tempo, DateTimeFormatter.ofPattern("HH:mm"));

							tempoT = Time.valueOf(hora);
						} catch (DateTimeParseException e1) {
							JOptionPane.showMessageDialog(null, "Formato de tempo inválido. Use o formato HH(0-23):mm(0-59).");
							return;
						}

						String siteOficial = txt_SiteOfi.getText();
						if (siteOficial.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de site é obrigatório!");
							return;
						}

						String email = txt_Email.getText();
						if (email.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo de email é obrigatório!");
							return;
						}

						// Verifica o formato do e-mail usando uma expressão regular
						String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
						if (!email.matches(regex)) {
							JOptionPane.showMessageDialog(null,
									"Formato de email inválido. Insira um email válido!Exempo:3xempl0@email.com tudo deve estar em minusculo");
							return;
						}

						String endereco = txt_Endereco.getText();
						if (endereco.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de endereco é obrigatório!");
							return;
						}

						String cidade = txt_Cidade.getText();
						if (cidade.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de cidade é obrigatório!");
							return;
						}
						if (!cidade.matches("^[a-zA-Z]*$")) {
							JOptionPane.showMessageDialog(null, "Campo de cidade deve conter apenas letras!");
							return;
						}

						String estado = txt_Estado.getText();
						if (estado.length() == 0) {
							JOptionPane.showMessageDialog(null, "Campo de cidade é obrigatório!");
							return;
						}
						if (!estado.matches("^[a-zA-Z]*$")) {
							JOptionPane.showMessageDialog(null, "Campo de estado deve conter apenas letras!");
							return;
						}

						String avaliacaoMedia = txt_AvaliaMedia.getText();
						float avaliacaoFloat = 0.0f;

						if (avaliacaoMedia.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo de avaliação é obrigatório!");
							return;
						}

						try {
							avaliacaoFloat = Float.parseFloat(avaliacaoMedia);

							if (avaliacaoFloat < 1.0 || avaliacaoFloat > 5.0) {
								JOptionPane.showMessageDialog(null,
										"Avaliação inválida! A avaliação deve estar entre 1.0 e 5.0");
								return;
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null,
									"Avaliação inválida! Insira um número válido para a avaliação.");
							return;
						}

						String precoIngresso = txt_PrecIngresso.getText();
						Float precoIngressoFloat = (float) 0.0;
						try {
							precoIngressoFloat = Float.parseFloat(precoIngresso);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Preco do ingresso Inválido! Digite apenas números");
							return;
						}
						String cep = txt_CEP.getText().replaceAll("[^0-9]", "");

						if (cep.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo de CEP é obrigatório!");
							return;
						}

						if (cep.length() != 8) {
							JOptionPane.showMessageDialog(null, "Formato de CEP inválido! Insira 8 dígitos.");
							return;
						}

						String telefone = txt_Telefone.getText().replaceAll("[^0-9]", "");

						if (telefone.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo de telefone é obrigatório!");
							return;
						}

						if (telefone.length() < 12 || telefone.length() > 13) {
							JOptionPane.showMessageDialog(null, "Formato de telefone inválido! Insira entre 12 e 13 dígitos.");
							return;
						}

						CategoriaEvento categoriaSelecionada = (CategoriaEvento) comboBoxCategorias.getSelectedItem();
						Evento novoEvento = new Evento();
						novoEvento.setNomeEvento(nomeEvento);
						novoEvento.setLocalizacão(localizacão);
						novoEvento.setData(DataForm);
						novoEvento.setHora(tempoT);
						novoEvento.setTelefoneContato(telefone);
						novoEvento.setEmailContato(email);
						novoEvento.setCEP(cep);
						novoEvento.setPrecoIngresso(precoIngressoFloat);
						novoEvento.setAvaliacãoMédia(avaliacaoFloat);
						novoEvento.setCidade(cidade);
						novoEvento.setEndereco(endereco);
						novoEvento.setSiteOficial(siteOficial);
						novoEvento.setDescricão(descricao);
						novoEvento.setEstado(estado);
						novoEvento.setCategoria(categoriaSelecionada);

						listaEventos.add(novoEvento);
						janela.atualizarJTableModel();
						dispose();

					}
				});
				
						contentPane.add(btnNewButton_2, "cell 4 18 3 1,growx");
		contentPane.add(btnNewButton, "cell 8 18 7 1,growx");
	}

	private void carregarCategorias() {
		CategoriaEvento c1 = new CategoriaEvento();
		c1.setCodigo(1);
		c1.setNome("Não definido");
		listaCategorias.add(c1);

		CategoriaEvento c2 = new CategoriaEvento();
		c2.setCodigo(2);
		c2.setNome("Evento social");
		listaCategorias.add(c2);

		CategoriaEvento c3 = new CategoriaEvento();
		c3.setCodigo(3);
		c3.setNome("Evento corporativo");
		listaCategorias.add(c3);

		CategoriaEvento c4 = new CategoriaEvento();
		c4.setCodigo(4);
		c4.setNome("Evento religioso");
		listaCategorias.add(c4);

		CategoriaEvento c5 = new CategoriaEvento();
		c5.setCodigo(5);
		c5.setNome("Evento acadêmico e educacional");
		listaCategorias.add(c5);

		CategoriaEvento c6 = new CategoriaEvento();
		c6.setCodigo(6);
		c6.setNome("Evento cultural e de entretenimento");
		listaCategorias.add(c6);

		CategoriaEvento c7 = new CategoriaEvento();
		c7.setCodigo(7);
		c7.setNome("Evento esportivo");
		listaCategorias.add(c7);

	}

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
		}
		return mask;
	}
}
