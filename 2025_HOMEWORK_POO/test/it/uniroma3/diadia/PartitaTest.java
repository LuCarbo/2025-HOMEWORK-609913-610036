package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
	private Partita partita;

	
	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();

	}

	@Test
	void testNuovaPartita_Vinta() {
		this.partita.getGiocatore().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testPartita_Persa() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testPartita_Finita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testPartita_NonFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	

}
