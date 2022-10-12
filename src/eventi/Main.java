package eventi;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String scelta;
		Evento a = new Evento();
		String titolo;
		String giorno;
		String mese;
		String anno;
		int postiTotali;
		
		do {
			System.out.println(" [1]INSERISCI EVENTO \n [2]Prenota \n [3]Stampa \n [4] Disdici \n [5] Esci");
			scelta = sc.nextLine();
			if(scelta.equals("1")){
				System.out.println("Titolo");
				titolo = sc.nextLine();
				System.out.println("Data [Giorno - Mese - Anno]");
				giorno = sc.nextLine();
				mese = sc.nextLine();
				anno = sc.nextLine();
				System.out.println("Posti Totali");
				postiTotali = Integer.parseInt(sc.nextLine());
				try {
					a =  new Evento(titolo,LocalDate.of(Integer.parseInt(anno),Integer.parseInt(mese), Integer.parseInt(giorno)),postiTotali);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			else if(scelta.equals("2")) {
				System.out.println("Inserisci posti da prenotare:");
				try {
					a.prenota(sc.nextInt());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(scelta.equals("3")) {
				System.out.println("Totali: " + a.getPostiTotali() + "  Prenotati: " + a.getPostiPrenotati());
			}
			else if(scelta.equals("4")) {
				try {
					a.disdici();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("\n\n" + a.toString());
		}
		while(!scelta.equals("5"));
		sc.close();
	}

}
