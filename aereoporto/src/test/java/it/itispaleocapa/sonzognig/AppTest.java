package it.itispaleocapa.sonzognig;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    Aereoporto aereoporto = new Aereoporto();
    @Test
    void testCliente() {
        Cliente cliente = new Cliente("Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1));
        assertEquals("Giovanni", cliente.getNome());
        assertEquals("Sonzogni", cliente.getCognome());
        assertEquals("Italia", cliente.getNazioneNascita());
        assertEquals("Bergamo", cliente.getCittaNascita());
        assertEquals(LocalDate.of(2000, 1, 1), cliente.getDataNascita());
        assertEquals(1, cliente.getCodiceCliente());
    }

    void testVolo() {
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100);
        assertEquals("Bergamo", volo.getPartenza());
        assertEquals("Roma", volo.getDestinazione());
        assertEquals(LocalDate.of(2021, 1, 1), volo.getData());
        assertEquals(LocalTime.of(12, 0), volo.getOra());
        assertEquals(100, volo.getCodiceVolo());
    }

    void testPrentazione() {
        Prenotazione prenotazione = new Prenotazione(1, 1, 1, 1);
        assertEquals(1, prenotazione.getCodiceCliente());
        assertEquals(1, prenotazione.getCodiceVolo());
        assertEquals(1, prenotazione.getCodicePrenotazione());
    }

    void testAggiungiCliente() {
        Cliente cliente = new Cliente("Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1));
        aereoporto.aggiungiCliente(cliente);
        assertEquals(aereoporto.clienti.size(), 1);
    }

    void testEliminaCliente() {
        Cliente cliente = new Cliente("Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1));
        aereoporto.aggiungiCliente(cliente);
        aereoporto.eliminaCliente(cliente.getCodiceCliente());
        assertEquals(aereoporto.clienti.size(), 0);
    }

    void testModificaCliente() {
        Cliente cliente = new Cliente("Luca", "Galizzi", "Pakistan", "Baku", LocalDate.of(2001, 1, 1));
        aereoporto.aggiungiCliente(cliente);
        aereoporto.modificaCliente(cliente.getCodiceCliente(), "Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1));
        assertEquals(aereoporto.clienti.get(cliente.getCodiceCliente()).getNome(), "Giovanni");
        assertEquals(aereoporto.clienti.get(cliente.getCodiceCliente()).getCognome(), "Sonzogni");
        assertEquals(aereoporto.clienti.get(cliente.getCodiceCliente()).getNazioneNascita(), "Italia");
        assertEquals(aereoporto.clienti.get(cliente.getCodiceCliente()).getCittaNascita(), "Bergamo");
        assertEquals(aereoporto.clienti.get(cliente.getCodiceCliente()).getDataNascita(), LocalDate.of(2000, 1, 1));
    }

    void testGetClienteByCode() {
        Cliente cliente = new Cliente("Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1));
        aereoporto.aggiungiCliente(cliente);
        assertEquals(aereoporto.getClienteByCode(cliente.getCodiceCliente()), cliente);
    }

    void testGetClientiByName() {
        Cliente cliente = new Cliente("Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1));
        aereoporto.aggiungiCliente(cliente);
        assertEquals(aereoporto.getClientiByName("Giovanni", "Sonzogni").get(0), cliente);
    }

    void aggiungiVoloTest() {
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100);
        aereoporto.aggiungiVolo(volo);
        assertEquals(aereoporto.voli.size(), 1);
    }

    void eliminaVoloTest() {
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100);
        aereoporto.aggiungiVolo(volo);
        aereoporto.eliminaVolo(volo.getCodiceVolo());
        assertEquals(aereoporto.voli.size(), 0);
    }

    void modificaVoloTest() {
        Volo volo = new Volo("Milano", "Napoli", LocalDate.of(2021, 2, 1), LocalTime.of(12, 0), LocalTime.of(15, 0), 110, 10);
        aereoporto.aggiungiVolo(volo);
        aereoporto.modificaVolo(volo.getCodiceVolo(), "Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100);
        assertEquals(aereoporto.voli.get(volo.getCodiceVolo()).getPartenza(), "Bergamo");
        assertEquals(aereoporto.voli.get(volo.getCodiceVolo()).getDestinazione(), "Roma");
        assertEquals(aereoporto.voli.get(volo.getCodiceVolo()).getData(), LocalDate.of(2021, 1, 1));
        assertEquals(aereoporto.voli.get(volo.getCodiceVolo()).getOra(), LocalTime.of(12, 0));
    }

    void getVoloByCodeTest() {
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100);
        aereoporto.aggiungiVolo(volo);
        assertEquals(aereoporto.getVoloByCode(volo.getCodiceVolo()), volo);
    }

    void getVoloByDatiTest() {
        Volo volo = new Volo("Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100);
        aereoporto.aggiungiVolo(volo);
        assertEquals(aereoporto.getVoloByDati("Roma", "Bergamo", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0)), volo);
    }

    void aggiungiPrenotazioneTest() {
        Prenotazione prenotazione = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione);
        assertEquals(aereoporto.prenotazioni.size(), 1);
    }
    
    void eliminaPrenotazioneTest() {
        Prenotazione prenotazione = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione);
        aereoporto.eliminaPrenotazione(prenotazione.getCodiceCliente(), prenotazione.getCodiceVolo());
        assertEquals(aereoporto.prenotazioni.size(), 0);
    }

    void modificaPrenotazioneTest() {
        Prenotazione prenotazione = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione);
        aereoporto.modificaPrenotazione(prenotazione.getCodiceCliente(), prenotazione.getCodiceVolo(), 1, 1);
        assertEquals(aereoporto.prenotazioni.get(prenotazione.getCodicePrenotazione()).getnBagagli(), 1);
        assertEquals(aereoporto.prenotazioni.get(prenotazione.getCodicePrenotazione()).getPesoBagagli(), 1);
    }

    void getPrenotazioniByClienteTest() {
        Prenotazione prenotazione = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione);
        Prenotazione prenotazione2 = new Prenotazione(2, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione2);
        Prenotazione prenotazione3 = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione3);
        assertEquals(aereoporto.getPrenotazioniByCliente(1).size(), 2);
    }

    void getPrenotazioniByVoloTest() {
        Prenotazione prenotazione = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione);
        Prenotazione prenotazione2 = new Prenotazione(1, 2, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione2);
        Prenotazione prenotazione3 = new Prenotazione(1, 1, 1, 1);
        aereoporto.aggiungiPrenotazione(prenotazione3);
        assertEquals(aereoporto.getPrenotazioniByVolo(1).size(), 2);
    }
    
    void testClienteNonEsistenteException() {
        assertThrows(ClienteNonEsistenteException.class, () -> aereoporto.getClienteByCode(1));
        assertThrows(ClienteNonEsistenteException.class, () -> aereoporto.eliminaCliente(1));
        assertThrows(ClienteNonEsistenteException.class, () -> aereoporto.modificaCliente(1, "Giovanni", "Sonzogni", "Italia", "Bergamo", LocalDate.of(2000, 1, 1)));
        assertThrows(ClienteNonEsistenteException.class, () -> aereoporto.getClientiByName("Giovanni", "Sonzogni"));
    }

    void testVoloNonEsistenteException() {
        assertThrows(VoloNonEsistenteException.class, () -> aereoporto.getVoloByCode(1));
        assertThrows(VoloNonEsistenteException.class, () -> aereoporto.eliminaVolo(1));
        assertThrows(VoloNonEsistenteException.class, () -> aereoporto.modificaVolo(1, "Bergamo", "Roma", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0), LocalTime.of(13, 0), 100, 100));
        assertThrows(VoloNonEsistenteException.class, () -> aereoporto.getVoloByDati("Roma", "Bergamo", LocalDate.of(2021, 1, 1), LocalTime.of(12, 0)));
    }

    void testPrenotazioneNonEsistenteException() {
        assertThrows(PrenotazioneNonEsistenteException.class, () -> aereoporto.eliminaPrenotazione(1, 1));
        assertThrows(PrenotazioneNonEsistenteException.class, () -> aereoporto.modificaPrenotazione(1, 1, 1, 1));
    }

    void testNessunaPrenotazioneException() {
        assertThrows(NessunaPrenotazioneException.class, () -> aereoporto.getPrenotazioniByCliente(1));
        assertThrows(NessunaPrenotazioneException.class, () -> aereoporto.getPrenotazioniByVolo(1));
    }
}
