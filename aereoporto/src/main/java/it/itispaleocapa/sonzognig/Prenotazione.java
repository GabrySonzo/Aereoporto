package it.itispaleocapa.sonzognig;

public class Prenotazione {
    int codiceCliente;
    int codiceVolo;
    int nBagagli;
    int pesoBagagli;

    public Prenotazione(int codiceCliente, int codiceVolo, int nBagagli, int pesoBagagli) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.nBagagli = nBagagli;
        this.pesoBagagli = pesoBagagli;
    }
}
