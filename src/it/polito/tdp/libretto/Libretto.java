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
	
	//meno dipendenze ci sono tra una classe e l'altra e meglio è
	/*
	public void add(int voto, String corso, LocalDate data) {
		
	} */
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * aggiunge un nuovo voto al libretto
	 * @param v
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	//public void StampaVoti(int voto){	}
	
	
	//public String StampaVoti2(int voto) {
	//	return null;	}
	
	
	public List<Voto> cercaVoti(int punti){
		List<Voto> result=new ArrayList<Voto>();
		
		for(Voto v: this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		
		return result;	}
	
	/**
	 * Ricerca un voto relativo al corso di cui è specificato il nome 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il voto corrispondente oppure null
	 */
	
	public Voto cercaEsame(String nomeEsame) {
		
		for(Voto v: this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
	 return null; }
	
	/**
	 * Dato un voto determina se esiste già un voto con uguale corso e punteggio
	 * @param v
	 * @return true se ha trovato un corso e un punteggio uguali
	 * 		   false se non ha trovato il corso e/o un punteggio uguali
	 */
	
	public boolean esisteGiaVoto(Voto v) {
		Voto trovato = this.cercaEsame(v.getCorso());
		if(trovato==null)
			return false;
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		} else {
			return false;
		}
		
	}
}
