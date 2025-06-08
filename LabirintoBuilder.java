package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;

public class LabirintoBuilder extends Labirinto{
	
	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	
	public Stanza getUltimaStanzaAggiunta() {
		return this.ultimaAggiunta;
	}
	
	public void setUltimaStanzaAggiunta(Stanza s) {
		this.ultimaAggiunta = s;
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	 public LabirintoBuilder() {
	        this.labirinto = new Labirinto();
	 }
	 
	 public LabirintoBuilder addStanza(String nome) {
		 Stanza s = new Stanza(nome);
		 
		 this.setUltimaStanzaAggiunta(s);
		 this.labirinto.getStanze().add(s);
		 
		 return this;
	 }
	 
	 public LabirintoBuilder addStanzaIniziale(String nome) {
		 Stanza s = new Stanza(nome);
		 
		 this.labirinto.getStanze().add(s);
		 this.labirinto.setStanzaIniziale(s);
		 
		 return this;
	 }
	 
	 public LabirintoBuilder addStanzaVincente(String nome) {
		 Stanza s = new Stanza(nome);
		 
		 this.labirinto.getStanze().add(s);
		 this.labirinto.setStanzaVincente(s);
		 
		 return this;
	 }
	 
	 public LabirintoBuilder addAttrezzo(String nome, int peso) {
		 Attrezzo a = new Attrezzo(nome, peso);
		 
		 this.getUltimaStanzaAggiunta().addAttrezzo(a);
		 
		 return this;
	 }
	 
	 public LabirintoBuilder addAdiacenza(String stanzaDa, String stanzaA, String direzione) {
		 Iterator<Stanza> its = this.labirinto.getStanze().iterator();

		 int indexDa = 0;
		 int indexA = 0;
		 
		 while(its.hasNext()) {
			 Stanza s = its.next();
			 if(s.getNome().equals(stanzaDa)) {
				 indexDa = this.labirinto.getStanze().indexOf(s);
			 }
			 if(s.getNome().equals(stanzaA)) {
				 indexA = this.labirinto.getStanze().indexOf(s);
			 }
		 }
		 
		 this.labirinto.getStanze().get(indexDa).impostaStanzaAdiacente(direzione, this.labirinto.getStanze().get(indexA));
		 
		 return this;
	 }
}
