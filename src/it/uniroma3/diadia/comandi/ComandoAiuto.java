package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto implements Comando {	
	private IOConsole io;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	private final static String NOME = "Aiuto";
	@Override
	public void esegui(Partita partita) {
		for(int i = 0; i<elencoComandi.length; i++) {
			io.mostraMessaggio(elencoComandi[i] + " ");
		}
		io.mostraMessaggio("\n");
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public String getNome() {
		
		return NOME;
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
