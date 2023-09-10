package it.itispaleocapa.sonzognig;

public class Prenotazione {
    int codiceCliente;
    int codiceVolo;
    static int codicePrenotazione=0;
    int nBagagli;
    int pesoBagagli;

    public Prenotazione(int codiceCliente, int codiceVolo, int nBagagli, int pesoBagagli) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.nBagagli = nBagagli;
        this.pesoBagagli = pesoBagagli;
        codicePrenotazione++;
    }

    public int getCodicePrenotazione() {
        return codicePrenotazione;
    }

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public int getCodiceVolo() {
        return codiceVolo;
    }

    public int getnBagagli() {
        return nBagagli;
    }

    public int getPesoBagagli() {
        return pesoBagagli;
    }

    public void setBagagli(int nBagagli, int pesoBagagli) {
        this.nBagagli = nBagagli;
        this.pesoBagagli = pesoBagagli;
    }
}
