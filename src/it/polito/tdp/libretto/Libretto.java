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
	 */
	public void add(Voto v) {
		voti.add(v);
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
}
