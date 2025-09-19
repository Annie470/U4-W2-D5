package u4w2d5;

import u4w2d5.entities.*;
import u4w2d5.exceptions.InputNonValido;
import u4w2d5.exceptions.NumeroGiocatoriNonConforme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws NumeroGiocatoriNonConforme {
        List<Gioco> giochi = new ArrayList<>();
        Collezione collezione = new Collezione(giochi);
        Scanner scanner = new Scanner(System.in);


        //inserisco almeno due2 elementi con il secondo costruttore con id senza count
        Videogioco v1= new Videogioco(1, "MonkeyIsland", LocalDate.of(1990, 1,1), 15, Piattaforma.PC, 130, Genere.POINTCLICK  );
        giochi.add(v1);
        GiocoTavolo g1 = new GiocoTavolo(2, "Kragmortha", LocalDate.of(2007, 3,1), 25, 10,20);
        giochi.add(g1);


        // collezione.aggiungereElemento(giochi);
        //System.out.println(giochi);

        //collezione.ricercarePerID(2, giochi);
        //FIN QUI FUNZIONA

        System.out.println("INSERISCI: ");
        boolean valoreWhile = false;
        while (!valoreWhile) {
            System.out.println("1 -> AGGIUNGERE GIOCO ");
            System.out.println("2 -> RICERCA PER ID ");
            System.out.println("3 -> RICERCA PER PREZZO ");
            System.out.println("4 -> RICERCA PER NUMERO GIOCATORI ");
            System.out.println("5 -> RIMUOVERE GIOCO ");
            System.out.println("6 -> STATISTICHE COLLEZIONE ");
            System.out.println("9 -> TERMINA ");

            int scelta = Integer.parseInt(scanner.nextLine());
            try {
                switch (scelta){
                    case 1:
                        collezione.aggiungereElemento(giochi);
                        break;
                    case 2:
                        System.out.println("Inserisci ID");
                        try {
                            int id = Integer.parseInt(scanner.nextLine());
                            collezione.ricercarePerID(id, giochi);
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("ID solo numerico!");
                        }
                        break;
                    case 3:
                        System.out.println("Inserisci prezzo");
                        double prezzo = Double.parseDouble(scanner.nextLine());
                        if(prezzo >=1){
                            collezione.ricercarePerPrezzo(prezzo, giochi);
                            break;
                        } else {
                            throw new InputNonValido("Il prezzo non può essere negativo!");
                        }
                    case 4:
                        System.out.println("Inserisci num giocatori");
                        int nGiocat = Integer.parseInt(scanner.nextLine());
                        if(nGiocat >= 2 && nGiocat <= 10){
                            collezione.ricercarePerGiocatori(nGiocat, giochi);
                            break;
                        } else {
                            throw  new InputNonValido("Il numero dei giocatori deve essere tra 2-10");
                        }
                    case 5:
                        System.out.println("Inserisci ID");
                        int idR = Integer.parseInt(scanner.nextLine());
                        collezione.rimuovereGioco(idR, giochi);
                        break;
                    case 6:
                        collezione.stampareStatistiche(giochi);
                        break;
                    case 9:
                        valoreWhile = true;
                        break;
                    default:
                        System.out.println("Scelta non valida");
                }
            } catch (InputNonValido e) {
            System.out.println(e.getMessage());
        }


        }

    }
}
