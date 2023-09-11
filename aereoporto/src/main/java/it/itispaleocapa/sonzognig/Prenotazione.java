package it.itispaleocapa.sonzognig;

public class Prenotazione {

    private int codicePrenotazione;
    private int codiceCliente;
    private int codiceVolo;
    private int nBagagli;
    private int pesoBagagli;
    private static int counter=0;
    
    public Prenotazione(int codiceCliente, int codiceVolo, int nBagagli, int pesoBagagli) {
        counter++;
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.nBagagli = nBagagli;
        this.pesoBagagli = pesoBagagli;
        codicePrenotazione = counter;
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
