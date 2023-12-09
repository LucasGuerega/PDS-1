package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modelo.CategoriaEvento;
import modelo.Evento;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.GridLayout;

public class TelaAlteraCadastroEventos extends JFrame {
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
	 */
	public TelaAlteraCadastroEventos(JTable table, ArrayList<Evento> listaEventos, Evento eventoSelecionado,
			TelaInicio janela) {
		carregarCategorias();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[97px][63px,grow][146px][346px][486px]",
				"[45px][40px][20px][4px][20px][4px][20px,grow][5px][20px][6px][20px][11px][20px][11px][22px][4px][20px][4px][20px][4px][20px][4px][20px][4px][20px][4px][20px][4px][20px][4px][20px][45px][23px]"));

		JPanel LadoJanela = new JPanel();
		contentPane.add(LadoJanela, "cell 4 0 1 33,grow");
		LadoJanela.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("l");
		lblNewLabel_3.setIcon(
				new ImageIcon("C:\\Users\\lugui\\OneDrive\\Documentos\\PDS-1\\CadastroDeEventos\\src\\LadoB2.png"));
		LadoJanela.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Alterar Dados  do Evento");
		lblNewLabel.setForeground(new Color(237, 114, 38));
		lblNewLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 35));
		contentPane.add(lblNewLabel, "cell 1 0 3 1,alignx center,aligny top");

		JLabel lblNewLabel_1 = new JLabel("Nome do evento");
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx left,aligny center");

		txt_NomeEvento = new JTextField();
		contentPane.add(txt_NomeEvento, "cell 1 2 3 1,growx,aligny top");
		txt_NomeEvento.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Localizacão");
		contentPane.add(lblNewLabel_2, "cell 0 4,alignx left,aligny center");

		txt_Localizacao = new JTextField();
		contentPane.add(txt_Localizacao, "cell 1 4 3 1,growx,aligny top");
		txt_Localizacao.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Descricão");
		contentPane.add(lblNewLabel_2_1, "cell 0 6,alignx left,aligny center");

		JTextArea txt_desc = new JTextArea();
		txt_desc.setToolTipText("Descricão de seu evento");
		contentPane.add(txt_desc, "cell 1 6 3 1,grow");

		JLabel lblNewLabel_2_1_1 = new JLabel("Data");
		contentPane.add(lblNewLabel_2_1_1, "cell 0 8,alignx left,aligny center");
		txt_Data = new JFormattedTextField(setMascara("##/##/####"));
		txt_Data.setColumns(10);
		contentPane.add(txt_Data, "cell 1 8 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_2 = new JLabel("Hora");
		contentPane.add(lblNewLabel_2_1_2, "cell 0 10,alignx left,aligny center");

		txt_Hora = new JFormattedTextField(setMascara("##:##:##"));
		txt_Hora.setColumns(10);
		contentPane.add(txt_Hora, "cell 1 10 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_3 = new JLabel("Preco do ingresso");
		contentPane.add(lblNewLabel_2_1_3, "cell 0 12,alignx left,aligny center");

		txt_PrecIngresso = new JFormattedTextField(setMascara("#####.##"));
		txt_PrecIngresso.setColumns(10);
		contentPane.add(txt_PrecIngresso, "cell 1 12 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_4 = new JLabel("Categoria");
		contentPane.add(lblNewLabel_2_1_4, "cell 0 14,alignx left,aligny center");

		JComboBox<CategoriaEvento> comboBoxCategorias = new JComboBox<CategoriaEvento>();
		for (int i = 0; i < listaCategorias.size(); i++) {
			comboBoxCategorias.addItem(listaCategorias.get(i));
		}
		contentPane.add(comboBoxCategorias, "cell 1 14 3 1,growx,aligny top");

		CategoriaEvento combusSelecinada = (CategoriaEvento) comboBoxCategorias.getSelectedItem();

		JLabel lblNewLabel_2_1_5 = new JLabel("Avaliacão média");
		contentPane.add(lblNewLabel_2_1_5, "cell 0 16,alignx left,aligny center");

		txt_AvaliaMedia = new JTextField();
		txt_AvaliaMedia.setColumns(10);
		contentPane.add(txt_AvaliaMedia, "cell 1 16 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_6 = new JLabel("Site oficial");
		contentPane.add(lblNewLabel_2_1_6, "cell 0 18,alignx left,aligny center");

		txt_SiteOfi = new JTextField();
		txt_SiteOfi.setColumns(10);
		contentPane.add(txt_SiteOfi, "cell 1 18 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_7 = new JLabel("Email de contato");
		contentPane.add(lblNewLabel_2_1_7, "cell 0 20,alignx left,aligny center");

		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		contentPane.add(txt_Email, "cell 1 20 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_7_1 = new JLabel("Telefone de contato");
		contentPane.add(lblNewLabel_2_1_7_1, "cell 0 22,alignx left,aligny center");

		txt_Telefone = new JFormattedTextField(setMascara("+## (##) 9 ####-####"));
		txt_Telefone.setColumns(10);
		contentPane.add(txt_Telefone, "cell 1 22 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_7_2 = new JLabel("Endereco");
		contentPane.add(lblNewLabel_2_1_7_2, "cell 0 24,alignx left,aligny center");

		txt_Endereco = new JTextField();
		txt_Endereco.setColumns(10);
		contentPane.add(txt_Endereco, "cell 1 24 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_7_2_1 = new JLabel("Cidade");
		contentPane.add(lblNewLabel_2_1_7_2_1, "cell 0 26,alignx left,aligny center");

		txt_Cidade = new JTextField();
		txt_Cidade.setColumns(10);
		contentPane.add(txt_Cidade, "cell 1 26 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_7_2_2 = new JLabel("Estado");
		contentPane.add(lblNewLabel_2_1_7_2_2, "cell 0 28,alignx left,aligny center");

		txt_Estado = new JTextField();
		txt_Estado.setColumns(10);
		contentPane.add(txt_Estado, "cell 1 28 3 1,growx,aligny top");

		JLabel lblNewLabel_2_1_7_2_3 = new JLabel("CEP");
		contentPane.add(lblNewLabel_2_1_7_2_3, "cell 0 30,alignx left,aligny center");

		txt_CEP = new JFormattedTextField(setMascara("#####-###"));
		txt_CEP.setColumns(10);
		contentPane.add(txt_CEP, "cell 1 30 3 1,growx,aligny top");

		JButton btnNewButton1 = new JButton("Salvar");
		btnNewButton1.setForeground(new Color(237, 114, 38));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventoSelecionado.setNomeEvento(txt_NomeEvento.getText());
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
				eventoSelecionado.setNomeEvento(nomeEvento);
				eventoSelecionado.setLocalizacão(localizacão);
				eventoSelecionado.setData(DataForm);
				eventoSelecionado.setHora(tempoT);
				eventoSelecionado.setTelefoneContato(telefone);
				eventoSelecionado.setEmailContato(email);
				eventoSelecionado.setCEP(cep);
				eventoSelecionado.setPrecoIngresso(precoIngressoFloat);
				eventoSelecionado.setAvaliacãoMédia(avaliacaoFloat);
				eventoSelecionado.setCidade(cidade);
				eventoSelecionado.setEndereco(endereco);
				eventoSelecionado.setSiteOficial(siteOficial);
				eventoSelecionado.setDescricão(descricao);
				eventoSelecionado.setEstado(estado);
				eventoSelecionado.setCategoria(categoriaSelecionada);

				janela.atualizarDadosEvento(eventoSelecionado);
				dispose();

			}
		});
		contentPane.add(btnNewButton1, "cell 1 32 2 1,growx,aligny top");
		String NomeString = String.valueOf(eventoSelecionado.getNomeEvento());
		txt_NomeEvento.setText(NomeString);
		String LocalString = String.valueOf(eventoSelecionado.getLocalizacão());
		txt_Localizacao.setText(LocalString);
		String DescString = String.valueOf(eventoSelecionado.getDescricão());
		txt_desc.setText(DescString);
		String DataString = String.valueOf(eventoSelecionado.getData());
		txt_Data.setText(DataString);
		String HoraString = String.valueOf(eventoSelecionado.getHora());
		txt_Hora.setText(HoraString);
		String PrecoString = String.valueOf(eventoSelecionado.getPrecoIngresso());
		txt_PrecIngresso.setText(PrecoString);
		String AvaMedString = String.valueOf(eventoSelecionado.getAvaliacãoMédia());
		txt_AvaliaMedia.setText(AvaMedString);
		String SiteString = String.valueOf(eventoSelecionado.getSiteOficial());
		txt_SiteOfi.setText(SiteString);
		String EmailCttString = String.valueOf(eventoSelecionado.getEmailContato());
		txt_Email.setText(EmailCttString);
		String TelefonaString = String.valueOf(eventoSelecionado.getCEP());
		txt_Telefone.setText(TelefonaString);
		String EnderecoString = String.valueOf(eventoSelecionado.getEndereco());
		txt_Endereco.setText(EnderecoString);
		String CidadeString = String.valueOf(eventoSelecionado.getCidade());
		txt_Cidade.setText(CidadeString);
		String EstadoString = String.valueOf(eventoSelecionado.getEstado());
		txt_Estado.setText(EstadoString);
		String CEPString = String.valueOf(eventoSelecionado.getCEP());
		txt_CEP.setText(CEPString);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setForeground(new Color(237, 114, 38));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton, "cell 3 32,growx");
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
