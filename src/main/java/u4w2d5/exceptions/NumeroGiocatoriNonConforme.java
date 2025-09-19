package u4w2d5.exceptions;

public class NumeroGiocatoriNonConforme extends Exception { //è checked? try/Catch nel main al momento di inserimento n giocatori
    public NumeroGiocatoriNonConforme(String message) {
        super(message);
    }
}
