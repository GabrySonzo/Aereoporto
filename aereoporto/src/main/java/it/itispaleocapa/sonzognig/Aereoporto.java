package it.itispaleocapa.sonzognig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Aereoporto {
    
    HashMap<Integer, Volo> voli;
    HashMap<Integer, Cliente> clienti;
    HashMap<Integer, Prenotazione> prenotazioni;

    public Aereoporto() {
        voli = new HashMap<Integer, Volo>();
        clienti = new HashMap<Integer, Cliente>();
        prenotazioni = new HashMap<Integer, Prenotazione>();
    }

    public void aggiungiCliente(Cliente cliente) {
        clienti.put(cliente.getCodiceCliente(), cliente);
    }

    public void eliminaCliente(int codiceCliente) {
        if(!clienti.containsKey(codiceCliente))
            throw new ClienteNonEsistenteException();
        clienti.remove(codiceCliente);
    }

    public void modificaCliente(int codiceCliente, String nome, String cognome, String nazioneNascita, String cittaNascita, LocalDate dataNascita) {
        if(!clienti.containsKey(codiceCliente))
            throw new ClienteNonEsistenteException();
        clienti.get(codiceCliente).setDati(nome, cognome, nazioneNascita, cittaNascita, dataNascita);
    }

    public Cliente getClienteByCode(int codiceCliente) {
        if(!clienti.containsKey(codiceCliente))
            throw new ClienteNonEsistenteException();
        return clienti.get(codiceCliente);
    }

    public LinkedList<Cliente> getClientiByName(String nome, String cognome) {
        LinkedList<Cliente> clientiByName = new LinkedList<Cliente>();
        clienti.values().stream().filter(c -> c.getNome().equals(nome) && c.getCognome().equals(cognome)).forEach(c -> clientiByName.add(c));
        if(clientiByName.isEmpty())
            throw new ClienteNonEsistenteException();
        return clientiByName;
    }

    public void aggiungiVolo(Volo volo) {
        voli.put(volo.getCodiceVolo(), volo);
    }

    public void eliminaVolo(int codiceVolo) {
        if(!voli.containsKey(codiceVolo))
            throw new VoloNonEsistenteException();
        voli.remove(codiceVolo);
    }

    public void modificaVolo(int codiceVolo, String partenza, String destinazione, LocalDate dataVolo, LocalTime oraPartenza, LocalTime oraArrivo, int posti, int costoBiglietto) {
        if(!voli.containsKey(codiceVolo))
            throw new VoloNonEsistenteException();
        voli.get(codiceVolo).setDati(partenza, destinazione, dataVolo, oraPartenza, oraArrivo, posti, costoBiglietto);
    }

    public Volo getVoloByCode(int codiceVolo) {
        if(!voli.containsKey(codiceVolo))
            throw new VoloNonEsistenteException();
        return voli.get(codiceVolo);
    }

    public Volo getVoloByDati(String destinazione, String partenza, LocalDate dataVolo, LocalTime oraPartenza) {
        if(!voli.values().stream().anyMatch(v -> v.getDestinazione().equals(destinazione) && v.getPartenza().equals(partenza) && v.getData().equals(dataVolo) && v.getOra().equals(oraPartenza)))
            throw new VoloNonEsistenteException();
        return voli.values().stream().filter(v -> v.getDestinazione().equals(destinazione) && v.getPartenza().equals(partenza) && v.getData().equals(dataVolo) && v.getOra().equals(oraPartenza)).findFirst().get();
    }

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazioni.put(prenotazione.getCodicePrenotazione(), prenotazione);
    }

    public void eliminaPrenotazione(int codiceCliente, int codiceVolo) {
        if(!prenotazioni.values().stream().anyMatch(p -> p.getCodiceCliente() == codiceCliente && p.getCodiceVolo() == codiceVolo))
            throw new PrenotazioneNonEsistenteException();
        prenotazioni.remove(prenotazioni.values().stream().filter(p -> p.getCodiceCliente() == codiceCliente && p.getCodiceVolo() == codiceVolo).findFirst().get().getCodicePrenotazione());
    }

    public void modificaPrenotazione(int codiceCliente, int codiceVolo, int nBagagli, int pesoBagagli) {
        if(!prenotazioni.values().stream().anyMatch(p -> p.getCodiceCliente() == codiceCliente && p.getCodiceVolo() == codiceVolo))
            throw new PrenotazioneNonEsistenteException();
        prenotazioni.values().stream().filter(p -> p.getCodiceCliente() == codiceCliente && p.getCodiceVolo() == codiceVolo).findFirst().get().setBagagli(nBagagli, pesoBagagli);
    }

    public LinkedList<Prenotazione> getPrenotazioniByCliente(int codiceCliente) {
        if(!clienti.containsKey(codiceCliente))
            throw new ClienteNonEsistenteException();
        LinkedList<Prenotazione> prenotazioniByCliente = new LinkedList<Prenotazione>();
        prenotazioni.values().stream().filter(p -> p.getCodiceCliente() == codiceCliente).forEach(p -> prenotazioniByCliente.add(p));
        if(prenotazioniByCliente.isEmpty())
            throw new NessunaPrenotazioneException();
        return prenotazioniByCliente;
    }

    public LinkedList<Prenotazione> getPrenotazioniByVolo(int codiceVolo) {
        if(!voli.containsKey(codiceVolo))
            throw new VoloNonEsistenteException();
        LinkedList<Prenotazione> prenotazioniByVolo = new LinkedList<Prenotazione>();
        prenotazioni.values().stream().filter(p -> p.getCodiceVolo() == codiceVolo).forEach(p -> prenotazioniByVolo.add(p));
        if(prenotazioniByVolo.isEmpty())
            throw new NessunaPrenotazioneException();
        return prenotazioniByVolo;
    }
}