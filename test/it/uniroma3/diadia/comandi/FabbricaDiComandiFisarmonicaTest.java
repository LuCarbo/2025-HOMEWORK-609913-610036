package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

class FabbricaDiComandiFisarmonicaTest {
	private IOConsole io;
	private Partita partita;
	private Comando comando;
	private FabbricaDiComandi fabbrica;
	@BeforeEach
	void setUp() throws Exception {
		this.io = new IOConsole();
		this.fabbrica = new FabbricaDiComandiFisarmonica();
		
	}

	@Test
	void testCostruisciComando_NonValido() {
		this.comando = new ComandoNonValido();
		assertEquals(this.comando.getNome(), this.fabbrica.costruisciComando("Cazzata").getNome());
	}
	@Test
	void testCostruisciComando_Funzionante() {
		this.comando = new ComandoFine();
		assertEquals(this.comando.getNome(), this.fabbrica.costruisciComando("fine").getNome());
	}
	
	@Test
	void testCostruisciComando_Parametro() {
		this.comando = fabbrica.costruisciComando("vai nord");
		String expected = "nord";
		assertEquals(this.comando.getNome(), this.fabbrica.costruisciComando("vai").getNome());
		assertEquals(this.comando.getParametro(), expected);
	}
}
