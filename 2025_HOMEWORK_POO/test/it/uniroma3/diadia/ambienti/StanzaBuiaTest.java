package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBuia = new StanzaBuia("Oscura", "Cerino");
		this.attrezzo = new Attrezzo("Cerino", 2);
	}

	@Test
	void testGetDescrizione_attrezzoMancante() {
		assertFalse(this.stanzaBuia.hasAttrezzo("Cerino"));
	}
	
	@Test
	void testGetDescrizione_attrezzoPresente() {
		this.stanzaBuia.addAttrezzo(this.attrezzo);
		assertTrue(this.stanzaBuia.hasAttrezzo("Cerino"));
	}

}
