package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IOConsole io;
	private final static String NOME = "Vai";

	@Override
	public void esegui(Partita partita) {  
	    Stanza stanzaCorrente = partita.getGiocatore().getStanzaCorrente();
	    Stanza prossimaStanza = null;
	    
	    if(direzione == null) {
	        
	        io.mostraMessaggio("Dove vuoi andare? (Specificare una direzione)");
	        return;
	        
	    }
	    
	    prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
	    if(prossimaStanza == null) {
	        
	    	io.mostraMessaggio("Direzione inesistente");
	        return;
	        
	    }
	    
	    partita.getGiocatore().setStanzaCorrente(prossimaStanza);
	    partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	    io.mostraMessaggio(partita.getGiocatore().getStanzaCorrente().getNome());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
}