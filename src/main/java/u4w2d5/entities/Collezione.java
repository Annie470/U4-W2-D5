package u4w2d5.entities;

import u4w2d5.exceptions.InputNonValido;
import u4w2d5.exceptions.NumeroGiocatoriNonConforme;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
                        boolean compTitolo = giochi.stream().map(Gioco::getTitolo).anyMatch(titoloFiltrato -> titoloFiltrato.trim().equalsIgnoreCase(titolo.trim())); // avevo inserito toLowerCase(), intellij propone equalsIgnoreCase
                        if (compTitolo){
                            throw new InputNonValido("Titolo gia inserito");
                        }

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
                            if (prezzo <= 0) {
                                throw new InputNonValido("Il prezzo deve essere un numero positivo");
                            }
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("SOLO NUMERI");
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
                            if (durataGioco <= 0) {
                                throw new InputNonValido("La durata gioco deve esseere maggiore di 0");
                            }
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
                        boolean compTitolo = giochi.stream().map(Gioco::getTitolo).anyMatch(titoloFiltrato -> titoloFiltrato.trim().equalsIgnoreCase(titolo.trim())); // avevo inserito toLowerCase(), intellij propone equalsIgnoreCase
                        if (compTitolo){
                            throw new InputNonValido("Titolo gia inserito");
                        }

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
                            if (prezzo <= 0) {
                                throw new InputNonValido("Il prezzo deve essere un numero positivo");
                            }
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("SOLO NUMERI");
                        }

                        System.out.println("Inserisci numero giocatori da 2 a 10: ");
                        int numeroGiocatori;
                        try {
                            numeroGiocatori = Integer.parseInt(scanner.nextLine());
                            if (numeroGiocatori < 2 || numeroGiocatori > 10) {
                                throw new InputNonValido("Numero giocatori deve essere tra 2 e 10");
                            }
                        } catch (NumberFormatException e) {
                            throw new InputNonValido("NUMERO GIOCATORI NON VALIDO");
                        }

                        System.out.println("Inserisci durata: ");
                        double durataPartita;
                        try {
                            durataPartita = Double.parseDouble(scanner.nextLine());
                            if (durataPartita <= 0) {
                                throw new InputNonValido("La durata gioco deve esseere maggiore di 0");
                            }
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
     List<Gioco> risultati = listaGiochi.stream().filter(gioco -> gioco.getPrezzo() <= prezzo).sorted(Comparator.comparing(Gioco::getPrezzo)).toList();
     if (risultati.isEmpty()){
         System.out.print("Nessun gioco presente \n");
     } else {
         risultati.forEach(System.out::println);
     }
}

    public void ricercarePerGiocatori(int nGiocat, List<Gioco> listaGiochi){
        List<GiocoTavolo> risultati = listaGiochi.stream().filter(gioco -> gioco.getClass() == GiocoTavolo.class).map(gioco -> (GiocoTavolo) gioco ).filter(giocoTavolo -> giocoTavolo.getNumeroGiocatori() == nGiocat).toList();
        if (risultati.isEmpty()){
            System.out.print("Nessun gioco presente \n");
        } else {
            risultati.forEach(System.out::println);
        }
    }

    public void rimuovereGioco(int id, List<Gioco> listaGiochi) {
        Iterator<Gioco> iterator = listaGiochi.iterator();
        while (iterator.hasNext()) {
            Gioco gioco = iterator.next();
            if (gioco.getId() == id ) {
                iterator.remove();
                System.out.println(gioco.getTitolo() + " rimosso");
            }
        }
    }

    public void stampareStatistiche(List<Gioco> listaGiochi){
        /*int sizeT = listaGiochi.size();
        int sizeV = listaGiochi.stream().filter(gioco -> gioco instanceof Videogioco).toList().size();
        String nG=  sizeT - sizeV + " Giochi da tavolo e " + sizeV + " Videogiochi";*/
        Optional<Gioco> gP = listaGiochi.stream().max(Comparator.comparing(Gioco::getPrezzo)); // avevo inserito .sorted(Comparator.comparing(Gioco::getPrezzo).reversed()).findFirst();
        /*double sGP = listaGiochi.stream().mapToDouble(Gioco::getPrezzo).sum(); // avevo inserito .collect(Collectors.summingDouble(Gioco::getPrezzo));
        double mG = sGP / sizeT;
        if(!listaGiochi.isEmpty() && gP.isPresent()){
            System.out.println(nG + "\n" + "Gioco più caro : " + gP.get().titolo + " "+ gP.get().getPrezzo() +"\n" + " Media prezzo: " + mG);
        }*/
        //HO IMPIEGATO TROPPO TEMPO PER POTERLO ELIMINARE.... HO RILETTO GLI APPUNTI -.-''

       DoubleSummaryStatistics stats = listaGiochi.stream().collect(Collectors.summarizingDouble(Gioco::getPrezzo));
        System.out.println("Giochi: " + stats.getCount() + "\nGioco piu caro: " + gP.get().getTitolo() + " - " + stats.getMax() + "\nMedia prezzo: " + stats.getAverage() );
    }

    public void setGiochi(List<Gioco> giochi) {
        this.giochi = giochi;
    }
}