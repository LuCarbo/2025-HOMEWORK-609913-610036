package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	private Partita partita;
	private Comando comando;
	private String parametro;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoPosa();
		this.parametro = "bastone";
		this.attrezzo = new Attrezzo("spada", 3);
	}

	@Test
	void testEsegui_OggettoInesistente() {
		assertNull(partita.getGiocatore().getStanzaCorrente().getAttrezzo(parametro));
		comando.setParametro(parametro);
		comando.esegui(partita);
		assertNull(partita.getGiocatore().getStanzaCorrente().getAttrezzo(parametro));
		
	}
	
	@Test
	void testEsegui_OggettoAggiunto() {
		assertNull(partita.getGiocatore().getStanzaCorrente().getAttrezzo(parametro));
		this.partita.getGiocatore().getStanzaCorrente().addAttrezzo(this.attrezzo);
		comando.setParametro("spada");
		comando.esegui(partita);
		assertEquals(this.attrezzo, this.partita.getGiocatore().getStanzaCorrente().getAttrezzo("spada"));
	}
}
