package it.itispaleocapa.sonzognig;

import java.util.HashMap;
import java.util.LinkedList;

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
        clienti.remove(codiceCliente);
    }

    public void modificaCliente(int codiceCliente, Cliente cliente) {
        cliente.setCodiceCliente(codiceCliente);
        clienti.put(codiceCliente, cliente);
    }

    public Cliente getClienteCodice(int codiceCliente) {
        return clienti.get(codiceCliente);
    }

    public LinkedList<Cliente> getClientiByName(String nome, String cognome) {
        LinkedList<Cliente> clientiByName = new LinkedList<Cliente>();
        clienti.values().stream().filter(c -> c.getNome().equals(nome) && c.getCognome().equals(cognome)).forEach(c -> clientiByName.add(c));
        return clientiByName;
    }
    public void aggiungiVolo(Volo volo) {
        voli.put(volo.getCodiceVolo(), volo);
    }

}