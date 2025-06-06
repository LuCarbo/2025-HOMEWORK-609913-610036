package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Comando "Prendi", rimuove l'oggetto richiesto dalla stanza e 
 * lo aggiunge alla borsa.
 */
public class ComandoPrendi implements Comando {
	private IOConsole io;
	private String parametro;
	private final static String NOME = "Prendi";

	@Override
	public void esegui(Partita partita) {
		
		Attrezzo a = partita.getGiocatore().getStanzaCorrente().getAttrezzo(parametro);
		if(a != null) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getGiocatore().getStanzaCorrente().removeAttrezzo(a.getNome());	
			io.mostraMessaggio("Attrezzo preso");
		}
		else io.mostraMessaggio("oggetto non trovato");
	}
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
		
	}
	@Override
	public String getNome() {
		return NOME ;
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
