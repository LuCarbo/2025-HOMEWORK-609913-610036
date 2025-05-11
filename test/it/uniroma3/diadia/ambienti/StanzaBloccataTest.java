package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Attrezzo oggettoChiave;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBloccata = new StanzaBloccata("Casa", "Soffitta", "Ariete");
		this.oggettoChiave = new Attrezzo("Ariete", 8);
		}

	@Test
	void testStanzaAdiacente_stanzaBloccataSenzaOggettoChiave() {
		assertEquals(this.stanzaBloccata.getStanzaAdiacente("Soffitta"), this.stanzaBloccata);
	}
	
	@Test
	void testStanzaAdiacente_stanzaBloccataConOggettoChiave() {
		this.stanzaBloccata.addAttrezzo(oggettoChiave);
		assertNotEquals(this.stanzaBloccata.getStanzaAdiacente("Soffitta"), this.stanzaBloccata);
	}
}
