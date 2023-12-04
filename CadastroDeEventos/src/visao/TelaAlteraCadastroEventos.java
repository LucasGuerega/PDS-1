package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

public class TelaAlteraCadastroEventos extends JFrame {
	private JPanel contentPane;
	private JTextField txt_NomeEvento;
	private JTextField txt_Localizacao;
	private CategoriaEvento categoriaSelecionada;
	ArrayList<CategoriaEvento> listaCategorias = new ArrayList<CategoriaEvento>();

	private JTextField txt_Desc;
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
	public TelaAlteraCadastroEventos(JTable table, ArrayList<Evento> listaEventos,Evento eventoSelecionado, TelaInicio janela) {
		carregarCategorias();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[461.00,grow][][][][][][grow][][][][][][][][][]", "[grow][][][][][][][grow][][][][][][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Cadastrar Evento");
		lblNewLabel.setForeground(new Color(237, 114, 38));
		lblNewLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 35));
		contentPane.add(lblNewLabel, "cell 6 0");

		JLabel lblNewLabel_1 = new JLabel("Nome do evento");
		contentPane.add(lblNewLabel_1, "cell 2 2");

		txt_NomeEvento = new JTextField();
		contentPane.add(txt_NomeEvento, "cell 4 2 11 1,growx");
		txt_NomeEvento.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Localização");
		contentPane.add(lblNewLabel_2, "cell 2 3");

		txt_Localizacao = new JTextField();
		contentPane.add(txt_Localizacao, "cell 4 3 11 1,growx");
		txt_Localizacao.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Descrição");
		contentPane.add(lblNewLabel_2_1, "cell 2 4");

		txt_Desc = new JTextField();
		txt_Desc.setColumns(10);
		contentPane.add(txt_Desc, "cell 4 4 11 1,growx");

		JLabel lblNewLabel_2_1_1 = new JLabel("Data");
		contentPane.add(lblNewLabel_2_1_1, "cell 2 5");
		txt_Data = new JFormattedTextField(setMascara("##/##/####"));
		txt_Data.setColumns(10);
		contentPane.add(txt_Data, "cell 4 5 11 1,growx");

		JLabel lblNewLabel_2_1_2 = new JLabel("Hora");
		contentPane.add(lblNewLabel_2_1_2, "cell 2 6");

		txt_Hora = new JFormattedTextField(setMascara("##:##:##"));
		txt_Hora.setColumns(10);
		contentPane.add(txt_Hora, "cell 4 6 11 1,growx");

		JLabel lblNewLabel_2_1_3 = new JLabel("Preço do ingresso");
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

		JLabel lblNewLabel_2_1_5 = new JLabel("Avaliação média");
		contentPane.add(lblNewLabel_2_1_5, "cell 2 9");

		txt_AvaliaMedia = new JTextField();
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
		
				JLabel lblNewLabel_3 = new JLabel("l");
				contentPane.add(lblNewLabel_3, "cell 15 0 1 19");
				lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Documents\\PDS-1\\CadastroDeEventos\\src\\LadoB2.png"));

		JLabel lblNewLabel_2_1_7_1 = new JLabel("Telefone de contato");
		contentPane.add(lblNewLabel_2_1_7_1, "cell 2 12");

		txt_Telefone = new JFormattedTextField(setMascara("+## (##) 9 ####-####"));
		txt_Telefone.setColumns(10);
		contentPane.add(txt_Telefone, "cell 4 12 11 1,growx");

		JLabel lblNewLabel_2_1_7_2 = new JLabel("Endereço");
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
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventoSelecionado.setNomeEvento(txt_NomeEvento.getText());
				String nomeEvento = txt_NomeEvento.getText();
				if (nomeEvento.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de nome é obrigatório!");
					return;
				}

				String localização = txt_Localizacao.getText();
				if (localização.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de localização é obrigatório!");
					return;
				}

				String descricao = txt_Desc.getText();
				if (descricao.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de descrição é obrigatório!");
					return;
				}

				String data = txt_Data.getText();
				String DataForm;

				if (data.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de data é obrigatório!");
					return;
				}
				try {
					// LocalDate dataD = LocalDate.now();
					DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
					DataForm = data.formatted(formatters);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Formato de data inválido. Use o formato dd(1-31)/MM(1-12)/yyyy(0>infinito).");
					return;
				}
				/*
				 * LocalDate date = LocalDate.now(); DateTimeFormatter formatters =
				 * DateTimeFormatter.ofPattern("d/MM/uuuu"); String text =
				 * date.format(formatters); LocalDate parsedDate = LocalDate.parse(text,
				 * formatters);
				 * 
				 * System.out.println("date: " + date); // date: 2016-09-25
				 * System.out.println("Text format " + text); // Text format 25/09/2016
				 * System.out.println("parsedDate: " + parsedDate); // parsedDate: 2016-09-25
				 */

				String tempo = txt_Hora.getText();
				Time tempoT = null;

				// Verifica se o campo de tempo é obrigatório
				if (tempo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo de tempo é obrigatório!");
					return;
				}

				try {
					// Tenta converter a string de tempo para um objeto Time
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					java.util.Date date = sdf.parse(tempo);
					tempoT = new Time(date.getTime());
				} catch (ParseException e1) {
					// Se houver um erro de formato, trate a exceção
					JOptionPane.showMessageDialog(null, "Formato de tempo inválido. Use o formato HH:mm:ss.");
					return;
				}

				String siteOficial = txt_SiteOfi.getText();
				if (siteOficial.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de site é obrigatório!");
					return;
				}

				String email = txt_Email.getText();
				if (email.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de email é obrigatório!");
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

				String estado = txt_Estado.getText();
				if (estado.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo de cidade é obrigatório!");
					return;
				}

				String avaliacaMedia = txt_AvaliaMedia.getText();
				float AVF = (float) 0.0;
				try {
					float avaliacaMediaFloat = Float.parseFloat(avaliacaMedia);
					if ((avaliacaMediaFloat > 0.9) && (avaliacaMediaFloat <5.1)) {
						 AVF = avaliacaMediaFloat;

					} else {
						JOptionPane.showMessageDialog(null,
								"Avaliação Inválido! Avaliação deve ser um número entre 1 e 5");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Avaliação Inválido! Avaliação deve ser um número entre 1 e 5");
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
				String cep = null;
				try {
					cep = txt_CEP.getText();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "CEP Inválido! Digite apenas números");
					return;
				}
				String telefone;
				try {
					telefone = txt_Telefone.getText();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Telefone Inválido! Digite apenas números");
					return;
				}

				CategoriaEvento categoriaSelecionada = (CategoriaEvento) comboBoxCategorias.getSelectedItem();
				Evento novoEvento = new Evento();
				novoEvento.setNomeEvento(nomeEvento);
				novoEvento.setLocalização(localização);
				novoEvento.setData(DataForm);
				novoEvento.setHora(tempoT);
				novoEvento.setTelefoneContato(telefone);
				novoEvento.setEmailContato(email);
				novoEvento.setCEP(cep);
				novoEvento.setPreçoIngresso(precoIngressoFloat);
				novoEvento.setAvaliaçãoMédia(AVF);
				novoEvento.setCidade(cidade);
				novoEvento.setEndereço(endereco);
				novoEvento.setSiteOficial(siteOficial);
				novoEvento.setDescrição(descricao);
				novoEvento.setEstado(estado);
				novoEvento.setCategoria(categoriaSelecionada);

				listaEventos.add(novoEvento);
				janela.atualizarDadosEvento(eventoSelecionado);
				dispose();
				
			}
		});
		contentPane.add(btnNewButton, "cell 6 5");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		contentPane.add(btnNewButton_1, "cell 9 5");
		String CEPString = String.valueOf(eventoSelecionado.getCEP());
		txt_CEP.setText(CEPString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String NomeString = String.valueOf(eventoSelecionado.getNomeEvento());
		txt_NomeEvento.setText(NomeString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String TelefonaString = String.valueOf(eventoSelecionado.getCEP());
		txt_Telefone.setText(TelefonaString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String AvaMedString = String.valueOf(eventoSelecionado.getNomeEvento());
		txt_AvaliaMedia.setText(AvaMedString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String CEPString = String.valueOf(eventoSelecionado.getCEP());
		txt_CEP.setText(CEPString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String NomeString = String.valueOf(eventoSelecionado.getNomeEvento());
		txt_NomeEvento.setText(NomeString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String CEPString = String.valueOf(eventoSelecionado.getCEP());
		txt_CEP.setText(CEPString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String NomeString = String.valueOf(eventoSelecionado.getNomeEvento());
		txt_NomeEvento.setText(NomeString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String CEPString = String.valueOf(eventoSelecionado.getCEP());
		txt_CEP.setText(CEPString);
		
		contentPane.add(btnNewButton_1, "cell 9 5");
		String NomeString = String.valueOf(eventoSelecionado.getNomeEvento());
		txt_NomeEvento.setText(NomeString);
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
