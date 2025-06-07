package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

	/**
 * Comando "Fine".
 */
public class ComandoFine implements Comando {
	private IOConsole io;
	private final static String NOME = "Fine";
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Partita terminata");  // si desidera smettere
		partita.setFinita();

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
