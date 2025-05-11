package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		this.stanza = new Stanza("n11");
		this.attrezzo = new Attrezzo("spada", 10);
	}
	
	
	
// Test metodo hasAttrezzo
	@Test
	void testHasAttrezzo() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertTrue(this.stanza.hasAttrezzo("spada"));

	}
	
	@Test
	void testHasAttrezzo_StanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test 
	void testHasAttrezzo_Null() {
		assertFalse(this.stanza.hasAttrezzo(null));
	}

	
	
// Test metodo removeAttrezzo
	@Test
	void testRemoveAttrezzo() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertTrue(this.stanza.removeAttrezzo("spada"));
	}
	
	@Test
	void testRemoveAttrezzo_NonTrovato() {
		assertFalse(this.stanza.removeAttrezzo("spada"));
	}
	
	@Test 
	void testRemoveAttrezzo_Null() {
		assertFalse(this.stanza.removeAttrezzo(null));
	}
	
	
	
// Test metodo addAttrezzo
	@Test
	void testAddAttrezzo() {
		assertTrue(this.stanza.addAttrezzo(this.attrezzo));
	}
	
	@Test
	void testAddAttrezzo_StanzaPiena() {
		for(int i = 0; i<=10; i++)
			this.stanza.addAttrezzo(this.attrezzo);
		assertFalse(this.stanza.addAttrezzo(this.attrezzo));
	}
	
	@Test 
	void testAddAttrezzo_Null() {
		assertFalse(this.stanza.addAttrezzo(null));
	}
	
	
	
//Test metodo getAttrezzo
	@Test
	void testGetAttrezzo_StanzaVuota() {
		assertNull(this.stanza.getAttrezzo("spada"));
	}
	
	@Test
	void testGetAttrezzo() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertEquals(this.attrezzo, this.stanza.getAttrezzo("spada"));
	}
	
	@Test
	void testGetAttrezzo_AttrezzoNonTrovato() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertNull(this.stanza.getAttrezzo("AttrezzoNonPresente"));
	}
//Test metodo impostaStanzaAdiacente
	@Test
	void testImpostaStanzaAdiacente() {
		Stanza stanzaAdiacente = new Stanza("n12");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		assertEquals(stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacente_StanzaAdiacente_Vuota() {
		assertNull(this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacente_CambiaStanzaEsistente() {
			Stanza stanzaAdiacente1 = new Stanza("stanzaAdiacente");
			Stanza stanzaAdiacente2 = new Stanza("stanzaAdiacente");
			this.stanza.impostaStanzaAdiacente("nord" , stanzaAdiacente1);
			this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente2);
		assertEquals(stanzaAdiacente2, this.stanza.getStanzaAdiacente("nord"));
	}
	
	
	
}
