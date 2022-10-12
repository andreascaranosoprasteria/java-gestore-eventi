package eventi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class programmiEvento implements Comparator<Evento>{
	List<Evento> eventi;
	private String titolo;
	
	public programmiEvento(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<>();
	}
	
	public void addEvento(Evento evento) {
		eventi.add(evento);
	}

	public List<Evento> eventiPerData(LocalDate data){
		List<Evento> listaEventiPerData = new ArrayList<>();
		
		for (Evento evento : eventi) {
			if(ChronoUnit.DAYS.between(data, evento.getData()) == 0) {
				listaEventiPerData.add(evento);
			}
		}
		return listaEventiPerData;
	}
	
	public void rimuoviEventi() {
		for (Evento evento : eventi) {
			eventi.remove(evento);
		}
		System.out.println("Eliminazione completata");
	}
	
	//ORDINAMENTO NON FINITO RIVEDERE
	private void ordinaPerData() {
		for (int i = 0; i < eventi.size() - 1; i++) {
			for (int j = i+1; j < eventi.size(); j++) {
				
			}
		}
	}

	@Override
	public int compare(Evento o1, Evento o2) {
		if(o1.getData().isBefore(o2.getData())) {
			return -1;
		}
		else if(o2.getData().isBefore(o1.getData())) {
			return 1;
		}
		else 
		return 0;
	}
}
