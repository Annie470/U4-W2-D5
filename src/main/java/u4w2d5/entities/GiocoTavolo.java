package u4w2d5.entities;

import u4w2d5.exceptions.NumeroGiocatoriNonConforme;

import java.time.LocalDate;

public class GiocoTavolo extends Gioco{
    private int numeroGiocatori;
    private double durataPartita;

    public GiocoTavolo(String titolo, LocalDate annoPubblicazione, double prezzo, int numeroGiocatori, double durataPartita ) throws NumeroGiocatoriNonConforme {
        super(titolo, annoPubblicazione, prezzo);
        setNumeroGiocatori(numeroGiocatori); //avevo messo l 'if ripetuto qui, intellij mi propone di inserire direttamente il setter, funzionerà?
        this.durataPartita= durataPartita < 1 ? 1 : durataPartita;
    }
    public GiocoTavolo(int id, String titolo, LocalDate annoPubblicazione, double prezzo, int numeroGiocatori, double durataPartita ) throws NumeroGiocatoriNonConforme {
        super(id,titolo, annoPubblicazione, prezzo);
        setNumeroGiocatori(numeroGiocatori);
        this.durataPartita= durataPartita < 1 ? 1 : durataPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }
    public double getDurataPartita() {
        return durataPartita;
    }

    public void setNumeroGiocatori(int numeroGiocatori) throws NumeroGiocatoriNonConforme {
        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new NumeroGiocatoriNonConforme("Consentito solo da 2 a 10 giocatori");
        }
        this.numeroGiocatori = numeroGiocatori;
    }
    public void setDurataPartita(double durataPartita) {
        this.durataPartita = durataPartita < 1 ? 1 : durataPartita;
    }

    @Override
    public String toString() {
        return "GiocoTavolo{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                ", numeroGiocatori=" + numeroGiocatori +
                ", durataPartita=" + durataPartita +
                '}';
    }
}
