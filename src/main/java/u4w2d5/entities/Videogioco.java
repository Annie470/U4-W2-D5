package u4w2d5.entities;

import java.time.LocalDate;

public class Videogioco extends Gioco{
    private Piattaforma piattaforma;
    private double durataGioco;
    private Genere genere;

    public Videogioco(String titolo, LocalDate annoPubblicazione, double prezzo, Piattaforma piattaforma, double durataGioco, Genere genere){
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco=durataGioco < 1 ? 1 : durataGioco;
        this.genere= genere;
    }
    public Videogioco(int id, String titolo, LocalDate annoPubblicazione, double prezzo, Piattaforma piattaforma, double durataGioco, Genere genere){
        super(id,titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco=durataGioco < 1 ? 1 : durataGioco;
        this.genere= genere;
    }

    public Piattaforma getPiattaforma() {
        return piattaforma;
    }
    public double getDurataGioco() {
        return durataGioco;
    }
    public Genere getGenere() {
        return genere;
    }

    public void setPiattaforma(Piattaforma piattaforma) {
        this.piattaforma = piattaforma;
    }
    public void setDurataGioco(double durataGioco) {
        this.durataGioco = durataGioco < 1 ? 1 : durataGioco;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                ", piattaforma=" + piattaforma +
                ", durataGioco=" + durataGioco +
                ", genere=" + genere +
                '}';
    }
}
