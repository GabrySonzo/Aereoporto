package it.itispaleocapa.sonzognig;

import java.time.LocalDate;
import java.time.LocalTime;

public class Volo {
    static int codiceVolo=0;
    String partenza;
    String destinazione;
    LocalDate dataVolo;
    LocalTime oraPartenza;
    LocalTime oraArrivo;
    int posti;
    int costoBiglietto;
    public Volo(String partenza, String destinazione, LocalDate dataVolo, LocalTime oraPartenza, LocalTime oraArrivo, int posti, int costoBiglietto) {
        codiceVolo++;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.dataVolo = dataVolo;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.posti = posti;
        this.costoBiglietto = costoBiglietto;
    }

    public int getCodiceVolo() {
        return codiceVolo;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public LocalDate getData() {
        return dataVolo;
    }

    public LocalTime getOra() {
        return oraPartenza;
    }

    public void setDati (String partenza, String destinazione, LocalDate dataVolo, LocalTime oraPartenza, LocalTime oraArrivo, int posti, int costoBiglietto) {
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.dataVolo = dataVolo;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.posti = posti;
        this.costoBiglietto = costoBiglietto;
    }
}
