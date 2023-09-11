package it.itispaleocapa.sonzognig;

import java.time.LocalDate;
import java.time.LocalTime;

public class Volo {
    
    private int codiceVolo;
    private String partenza;
    private String destinazione;
    private LocalDate dataVolo;
    private LocalTime oraPartenza;
    private LocalTime oraArrivo;
    private int posti;
    private int costoBiglietto;
    private static int counter=0;

    public Volo(String partenza, String destinazione, LocalDate dataVolo, LocalTime oraPartenza, LocalTime oraArrivo, int posti, int costoBiglietto) {
        counter++;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.dataVolo = dataVolo;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.posti = posti;
        this.costoBiglietto = costoBiglietto;
        codiceVolo = counter;
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
