package it.uniroma3.diadia;
import java.util.Scanner;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;
	
	public DiaDia(IOConsole console) {
		this.io = console;
		this.partita = new Partita();
		}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));

	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome() == null) {
			io.mostraMessaggio("Non hai inserito alcun comando!");
			return false;
		}
		if (comandoDaEseguire.getNome().equals(null)) return false;
			
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa")) 
				this.posa(comandoDaEseguire.getParametro());
		else io.mostraMessaggio("Comando Sconosciuto");
		
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare?");	
		else{
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getGiocatore().getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				io.mostraMessaggio("Direzione inesistente");	
			else {
				this.partita.getGiocatore().setStanzaCorrente(prossimaStanza);
				int cfu = this.partita.getGiocatore().getCfu();
				this.partita.getGiocatore().setCfu(--cfu);
			}
		}
		io.mostraMessaggio(partita.getGiocatore().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Prendi", rimuove l'oggetto richiesto dalla stanza e 
	 * lo aggiunge alla borsa.
	 */
	private void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getGiocatore().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a != null) {
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getGiocatore().getStanzaCorrente().removeAttrezzo(a.getNome());	
		}
		else io.mostraMessaggio("oggetto non trovato");
	}
	
	/**
	 * Comando "posa" rimuove un attrezzo dalla borsa e lo aggiunge alla stanza corrente.
	 */
	private void posa(String nomeAttrezzo) {
		
		Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(a != null) {
			this.partita.getGiocatore().getStanzaCorrente().addAttrezzo(a);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
		}
		else io.mostraMessaggio("oggetto non trovato");

	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Partita terminata");  // si desidera smettere

}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
	
}