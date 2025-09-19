package u4w2d5.entities;

import u4w2d5.exceptions.InputNonValido;
import u4w2d5.exceptions.NumeroGiocatoriNonConforme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Collezione {
    private List<Gioco> giochi = new ArrayList<>();

    public Collezione(List<Gioco> listagiochi){
        this.giochi = listagiochi;
    }

    Scanner scanner = new Scanner(System.in);

    public void aggiungereElemento(List<Gioco> giochi) {
        do {
            try {
                System.out.println("Inserisci GT per gioco da tavolo, V per videogioco o 0 per uscire: ");
                String scelta = scanner.nextLine().trim().toUpperCase();
                if (scelta.equals("0")) {
                    break;
                }

                switch (scelta) {
                    case "V": {
                        System.out.println("Inserisci titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.println("Inserisci anno di pubblicazione es(2025-10-03): ");
                        LocalDate annoPubblicazione;
                        try {
                            annoPubblicazione = LocalDate.parse(scanner.nextLine());
                        } catch (Exception e) {
                            throw new InputNonValido("USA FORMATO anno-mese-giorno! ");
                        }

                        System.out.println("Inserisci prezzo: ");
                        double prezzo;
                        try {
                            prezzo = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("SOLO NUMERI INTERI O CON LA VIRGOLA");
                        }

                        System.out.println("Inserisci piattaforma tra ps4, ps5, xbox, pc, switch: ");
                        Piattaforma piattaforma;
                        try {
                            piattaforma = Piattaforma.valueOf(scanner.nextLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            throw new InputNonValido("SOLO PIATTAFORME INDICATE.");
                        }

                        System.out.println("Inserisci durata gioco: ");
                        double durataGioco;
                        try {
                            durataGioco = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("SOLO NUMERI");
                        }

                        System.out.println("Inserisci genere tra horror, mmorpg, shooter, pointclick, puzzle: ");
                        Genere genere;
                        try {
                            genere = Genere.valueOf(scanner.nextLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            throw new InputNonValido("SOLO GENERI INDICATI");
                        }

                        Videogioco videogioco = new Videogioco(titolo, annoPubblicazione, prezzo, piattaforma, durataGioco, genere);
                        giochi.add(videogioco);
                        System.out.println("Operazione completata");
                        break;
                    }

                    case "GT": {
                        System.out.println("Inserisci titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.println("Inserisci anno di pubblicazione es(2025-10-03): ");
                        LocalDate annoPubblicazione;
                        try {
                            annoPubblicazione = LocalDate.parse(scanner.nextLine());
                        } catch (Exception e) {
                            throw new InputNonValido("USA FORMATO anno-mese-giorno! ");
                        }

                        System.out.println("Inserisci prezzo: ");
                        double prezzo;
                        try {
                            prezzo = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("SOLO NUMERI INTERI O CON LA VIRGOLA");
                        }

                        System.out.println("Inserisci numero giocatori da 2 a 10: ");
                        int numeroGiocatori;
                        try {
                            numeroGiocatori = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("NUMERO GIOCATORI NON VALIDO");
                        }

                        System.out.println("Inserisci durata: ");
                        double durataPartita;
                        try {
                            durataPartita = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("INSERISCI SOLO NUMERI");
                        }

                        GiocoTavolo giocoTavolo = new GiocoTavolo(titolo, annoPubblicazione, prezzo, numeroGiocatori, durataPartita);
                        giochi.add(giocoTavolo);
                        System.out.println("Operazione completata");
                        break;
                    }

                    default:
                        throw new InputNonValido("Input non valido");
                }

            } catch (InputNonValido | NumeroGiocatoriNonConforme e) { //AAAAAAAAAAAAAAAAAAAAAH HO BUTTATO UN'ORA
                System.out.println(e.getMessage() + " ");
            }

        } while (true);
    }

    public void ricercarePerID(int id, List<Gioco> listaGiochi){
        Optional<Gioco> risultato = giochi.stream().filter(gioco -> gioco.getId() == id).findFirst();

        if (risultato.isPresent()) {
            System.out.println(risultato.get());
        } else {
            System.out.println("ID errato");
        }
    }

   public void ricercarePerPrezzo(double prezzo, List<Gioco> listaGiochi){
     List<Gioco> risultati = listaGiochi.stream().filter(gioco -> gioco.getPrezzo() <= prezzo).toList();
     if (risultati.isEmpty()){
         System.out.print("Nessun gioco presente \n");
     } else {
         risultati.forEach(System.out::println);
     }
}

    public void setGiochi(List<Gioco> giochi) {
        this.giochi = giochi;
    }
}