package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IOConsole io;
	private final static String NOME = "Guarda";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getGiocatore().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU:" + partita.getGiocatore().getCfu());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
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
