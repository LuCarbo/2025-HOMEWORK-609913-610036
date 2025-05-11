package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private Partita partita;
	private Comando comando;
	private String parametro;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoP;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.partita = new Partita();
		 this.comando = new ComandoPrendi();
		 this.parametro = "osso";
		 this.attrezzo = new Attrezzo("spada", 3);
		 this.attrezzoP = new Attrezzo("incudine", 90);
		 
		  
	}

	@Test
	void testEsegui_OggettoNonTrovato() {
		comando.esegui(partita);
		comando.setParametro(parametro);
		assertNull(this.partita.getGiocatore().getBorsa().getAttrezzo(parametro));
	}
	
	@Test
	void testEsegui_OggettoPreso() {
		this.partita.getGiocatore().getStanzaCorrente().addAttrezzo(this.attrezzo);
		comando.setParametro("spada");
		comando.esegui(partita);
		assertNull(this.partita.getGiocatore().getStanzaCorrente().getAttrezzo("spada"));
	}
	
}
