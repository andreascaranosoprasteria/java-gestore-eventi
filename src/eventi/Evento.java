package eventi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;

	DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd-MM-yyyy",Locale.ITALY);

	public Evento() {}
	
	public Evento(String titolo, LocalDate data, int postiTotali) throws IOException {
		this.postiPrenotati = postiPrenotati;
		this.setTitolo(titolo);
		this.postiTotali = postiTotali;
		this.setData(data);
		controllaPostiTotali();
		
	}


	//controllo posti
	private void controllaPostiTotali() throws IOException {
		if(postiTotali <= 0) throw new IOException("I POSTI NON POSSONO ESSERE NEGATIVI O UGUALI A 0");
	}
	
	//controllo data
	private boolean controllaData() {
	if(ChronoUnit.DAYS.between(data, LocalDate.now()) < 0) return false;
	else return true;
	}
	
	//PRENOTA
	public void prenota(int pPostiPrenotati) throws Exception {
		controllaPostiTotali();
		if(((postiTotali - postiPrenotati) < 0) || !controllaData()) throw new Exception("Qualcosa è andato storto");
		else postiPrenotati += pPostiPrenotati;
	}
	
	//DISDICI
	//AVVERTENZA : LA CONSEGNA CHIEDE DI DECREMENTARE ESPLICITAMENTE DI 1 I POSTI PRENOTATI IN CASO DI DISDETTA
	//NONOSTANTE L'UTENTE NEL PROGRAMMA POTREBBE PRENOTARE PIU' POSTI IN UNA VOLTA SOLA
	public void disdici() throws Exception {
		if((postiPrenotati - 1 < 0) || !controllaData()) throw new Exception("Qualcosa è andato storto");
		else postiPrenotati -= 1;
	}
	
	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data.format(dtf)  + ", postiTotali=" + postiTotali + ", postiPrenotati="
				+ postiPrenotati + "]";
	}
	
	

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * @return the postiTotali
	 */
	public int getPostiTotali() {
		return postiTotali;
	}


	/**
	 * @return the postiPrenotati
	 */
	public int getPostiPrenotati() {
		return postiPrenotati;
	}

}
