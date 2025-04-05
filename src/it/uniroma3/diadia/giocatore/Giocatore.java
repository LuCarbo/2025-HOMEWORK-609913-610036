package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ambienti.Stanza;

public class Giocatore {
	private Stanza stanzaCorrente;
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();

	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void getBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
}
