package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class LabirintoBuilderTest {

    LabirintoBuilder lb;

    @Before
    public void setUp() throws Exception {
        lb = new LabirintoBuilder();
    }


    @Test
    public void testGetLabirinto() {
        assertNotNull(lb.getLabirinto());
        assertEquals(Labirinto.class, lb.getLabirinto().getClass());
    }

    @Test
    public void testAddStanza() {
        lb.addStanza("stanzetta");
        Stanza expected = new Stanza("stanzetta");
        assertEquals(expected, lb.getStanze().get(0));
    }

    @Test
    public void testAddAttrezzoSenzaUltimaStanzaAggiunta(){

        lb.addAttrezzo("cacciavite", 3);
        Attrezzo expected = new Attrezzo("cacciavite", 3);
        assertEquals(LabirintoBuilder.class, lb.addAttrezzo("cacciavite", 3).getClass());
    }

    @Test
    public void testAddAttrezzoConUltimaStanzaAggiunta(){
        lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
        Attrezzo expected = new Attrezzo("cacciavite", 3);
        assertEquals(expected, lb.getUltimaStanzaAggiunta().getAttrezzo("cacciavite"));
    }
    
}