package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;//List è una interfaccia e per ora non è definita una classe concreta 
							// che potrà essere una LinkedList o una ArrayList e la si dovrà definire
							// quando si andrà a definire un oggetto della classe

	public Libretto() {
		this.voti=new ArrayList<Voto>();
	}
	
	
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * @param v {@link Voto} da aggiungere
	 * @return {@code true} nel caso normale, {#code false} 
	 */
	public void add(Voto v) {
		if(!this.esisteGiaVoto(v)&& !this.votoConflitto(v)) {
			voti.add(v);
		} else {
			
		}
	}
	
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il puntegio specificato
	 * @param punti punteggio da ricercare
	 * @return lista di {@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int punti){
		List<Voto> result=new ArrayList<Voto>();
		
		for(Voto v: this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		
		return result;	
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente oppure {@code null} se non esistente
	 */
	
	public Voto cercaEsame(String nomeEsame) {
		
		Voto voto = new Voto(0, nomeEsame, null); //creazione di un oggetto voto incompleto necessario per fare la ricerca 
		int pos = this.voti.indexOf(voto); //metodo già esistente indexOf per andare a cercare un oggetto (voto definito sopra) 
		if(pos==-1)
			return null; 
		else 
			return this.voti.get(pos);
	}
	
	/**
	 * Dato un {@link Voto} determina se esiste già un voto con uguale corso e punteggio
	 * @param v
	 * @return {@code true} se ha trovato un corso e un punteggio uguali
	 * 		   {@code false} se non ha trovato il corso e/o un punteggio uguali
	 */
	
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else {
			return v.getPunti() == this.voti.get(pos).getPunti();
				}
		
		/* MEDOTO DIVERSO CHE NON USA UN METODO GIA' ESISTENTE
		Voto trovato = this.cercaEsame(v.getCorso()); //il metodo cercaEsame mi restituisce l'esame uguale
		if(trovato==null)
			return false;
		if(trovato.getPunti()==v.getPunti()) { //contronto i punteggi se ho trovato lo stesso esame prima
			return true;
		} else {
			return false;
		}*/
		
	}
	
	
	/**
	 * Mi dice se il {@link Voto} {code v} è in conflitto con uno dei voti esistenti. 
	 * Se il voto non esiste non c'è conflitto, se esiste !!!!DA CONCLUDERE!!!
	 * @param v
	 * @return
	 */
	public boolean votoConflitto (Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else {
			return v.getPunti() == this.voti.get(pos).getPunti();
		}
		
	}
	public String toString() {
			return this.voti.toString();
	}
		
	public Libretto LibrettoMigliorato() {
		Libretto nuovo = new Libretto(); //creo un nuovo oggetto a cui aggiungerci i voti esistenti
		for(Voto v: this.voti) {
			nuovo.add(v.clone());
		}
		//sul libretto nuovo incremento i voti di 1
		for(Voto v: this.voti) {
			int punti = v.getPunti();
			if(punti<24)
				punti=punti+1;
			else if(punti<28)
				punti= punti+2;
			
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	//non si può eliminare un elemento della lista durante una iterazione
	public void cancellaVotiScarsi() {
		List<Voto> cancellare = new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getPunti()<24) {
				cancellare.add(v);
			}
		}
	
	 this.voti.removeAll(cancellare);
}
}
