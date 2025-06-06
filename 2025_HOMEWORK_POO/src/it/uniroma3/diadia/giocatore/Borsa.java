package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
	this(DEFAULT_PESO_MAX_BORSA);

	}

	public Borsa(int pesoMax) {
		
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>() ;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if(this.attrezzi.size() == 10)
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
		
	}
	
	public int getPesoMax() {
			return pesoMax;
	}
	/**
	 * Prende il riferimento ad un atrezzo nella borsa
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
				return this.attrezzi.get(nomeAttrezzo);
		}
		return null;
	}



	public int getPeso() {
		int pesoTotale = 0;
		for (Attrezzo a: this.attrezzi.values())
				pesoTotale += a.getPeso();
			return pesoTotale;
	}
			
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			return this.attrezzi.remove(nomeAttrezzo);
		}
		return null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for(Attrezzo a : this.attrezzi.values())
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
			return s.toString();
	}
}

