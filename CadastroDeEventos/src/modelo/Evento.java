package modelo;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Evento {

	private String NomeEvento;
	private String Localizacão;
	private String Descricão;
	private String Data;
	private Time Hora;
	private Float PrecoIngresso;
	private CategoriaEvento categoria;
	private Float AvaliacaMedia;
	private String SiteOficial;
	private String EmailContato;
	private String TelefoneContato;
	private String Endereco;
	private String Cidade;
	private String Estado;
	private String CEP;

	public CategoriaEvento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEvento categoria) {
		this.categoria = categoria;
	}

	public String getNomeEvento() {
		return NomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		NomeEvento = nomeEvento;
	}

	public String getLocalizacão() {
		return Localizacão;
	}

	public void setLocalizacão(String localizacão) {
		Localizacão = localizacão;
	}

	public String getDescricão() {
		return Descricão;
	}

	public void setDescricão(String descricão) {
		Descricão = descricão;
	}

	public String getData() {
		return Data;
	}

	public void setData(String dataForm) {
		Data = dataForm;
	}

	public Time getHora() {
		return Hora;
	}

	public void setHora(Time hora) {
		Hora = hora;
	}

	public Float getPrecoIngresso() {
		return PrecoIngresso;
	}

	public void setPrecoIngresso(Float precoIngresso) {
		PrecoIngresso = precoIngresso;
	}

	public Float getAvaliacãoMédia() {
		return AvaliacaMedia;
	}

	public void setAvaliacãoMédia(Float avaliacaoMedia) {
		AvaliacaMedia = avaliacaoMedia;
	}

	public String getSiteOficial() {
		return SiteOficial;
	}

	public void setSiteOficial(String siteOficial) {
		SiteOficial = siteOficial;
	}

	public String getEmailContato() {
		return EmailContato;
	}

	public void setEmailContato(String emailContato) {
		EmailContato = emailContato;
	}

	public String getTelefoneContato() {
		return TelefoneContato;
	}

	public void setTelefoneContato(String telefone) {
		TelefoneContato = telefone;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
	// Métodos de formatacão

	public String formatarHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(this.Hora);
	}

	public void parseHora(String hora) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		this.Hora = new Time(sdf.parse(hora).getTime());
	}
}
