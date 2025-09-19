package u4w2d5.entities;
import java.time.LocalDate;

public abstract class Gioco {
    protected int id;
    protected String titolo;
    protected LocalDate annoPubblicazione;
    protected  double prezzo;
    protected static int count= 100;

    public Gioco(String titolo, LocalDate annoPubblicazione, double prezzo) {
        this.id = count++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo= prezzo < 1 ? 1 : prezzo; //non fa mai male un controllo in piu
    }

    public Gioco(int id, String titolo, LocalDate annoPubblicazione, double prezzo) { //mi serve per app cosi aggiungo almeno qualche elemento
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo= prezzo < 1 ? 1 : prezzo; //non fa mai male un controllo in piu
    }

    public int getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public double getPrezzo() {
        return prezzo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo < 1 ? 1 : prezzo;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
