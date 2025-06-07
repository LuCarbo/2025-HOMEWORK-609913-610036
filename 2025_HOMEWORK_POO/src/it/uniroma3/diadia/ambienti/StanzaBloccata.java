package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String chiave;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String chiave) {
		super(nome);
		this.chiave = chiave;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir.equals(this.direzioneBloccata)) {
			if(this.hasAttrezzo(this.chiave))
				return super.getStanzaAdiacente(this.direzioneBloccata);
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = new String("La stanza è bloccata nella direzione: "+ direzioneBloccata +"\nPrendi " + this.chiave + " e posalo nella stanza");
		if(this.hasAttrezzo(this.chiave))
			return super.getDescrizione();
		return bloccata;
	}
}
