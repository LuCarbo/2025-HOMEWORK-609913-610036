package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Comando "posa" rimuove un attrezzo dalla borsa e lo aggiunge alla stanza corrente.
 */
public class ComandoPosa implements Comando {
	private IOConsole io;
	private String attrezzo;
	private final static String NOME = "Posa";
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
		if(a != null) {
			partita.getGiocatore().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
			io.mostraMessaggio("Attrezzo posato");
		}
		else io.mostraMessaggio("oggetto non trovato");

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;

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
