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
}
