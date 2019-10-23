package com.example.Libreria.MODEL;

import java.util.*;


public class Libreria{


    public static ArrayList<Libro> listaLibri = new ArrayList<Libro>();
    private static Scanner input = new Scanner(System.in);


    /*
    public void  popolaLibreria() {


        //Titolo1
        ArrayList<GenereEnum> gen1 = new ArrayList<>();
        gen1.add(GenereEnum.FANTASY);
        ArrayList<Autore> listaAutori1 = new ArrayList<>();
        listaAutori1.add(new Autore("Marcello", "Lippoli", LocalDate.of(1950, 4, 7)));


        //Titolo 2
        ArrayList<GenereEnum> gen2 = new ArrayList<>();
        gen2.add(GenereEnum.STORICO);
        gen2.add(GenereEnum.NARRATIVA);
        ArrayList<Autore> listaAutori2 = new ArrayList<>();

        listaAutori2.add(new Autore("Federico", "DeGasperi", LocalDate.of(1948, 6, 2)));
        listaAutori2.add(new Autore("Marcello", "Lippoli", LocalDate.of(1950, 4, 7)));

        //Titolo3
        ArrayList<GenereEnum> gen3 = new ArrayList<>();
        gen3.add(GenereEnum.GIALLO);
        ArrayList<Autore> listaAutori3 = new ArrayList<>();
        listaAutori3.add(new Autore("Marcello", "Lippoli", LocalDate.of(1950, 4, 7)));

        //Titolo4
        ArrayList<GenereEnum> gen4 = new ArrayList<>();
        gen4.add(GenereEnum.HORROR);
        ArrayList<Autore> listaAutori4 = new ArrayList<>();
        listaAutori4.add(new Autore("Pippo", "Pippis", LocalDate.of(1940, 1, 1)));

        //Titolo5
        ArrayList<GenereEnum> gen5 = new ArrayList<>();
        gen5.add(GenereEnum.FANTASY);
        ArrayList<Autore> listaAutori5 = new ArrayList<>();
        listaAutori5.add(new Autore("Giovanni", "Impastato", LocalDate.of(1985, 1, 1)));

        /*
        //lista libri
        listaLibri.add(new Libro("012356789abc", "1", listaAutori1,1990,1,1 , gen1));
        listaLibri.add(new Libro("012356789def","2", listaAutori2, 1987, 1, 1, gen2));
        listaLibri.add(new Libro("0123456789ghi","3", listaAutori3, 1995, 1, 1, gen3));
        listaLibri.add(new Libro("0123456789lmn","4", listaAutori4, 1965, 1, 1, gen4));
        listaLibri.add(new Libro("012356789opq","5", listaAutori5, 1999, 1, 1, gen5));
        */
        //String lista = "";
        //stampaLibro(listaLibri);
        //return lista;
        //lista =stampaLibroPerAutore(listaLibri);
        //stampaPerGenere(listaLibri);
        //stampaPerData(listaLibri);
        //System.out.println(listaLibri.toString());
        //run();
        //return stampaPerGenere(listaLibri);

    /*
    public void popolaAutori(){

        //Libro1
        ArrayList<Autore> listaAutori1 = new ArrayList<>();
        listaAutori1.add(new Autore("Marcello", "Lippoli", 1950, 4, 7));

        //Libro2
        ArrayList<Autore> listaAutori2 = new ArrayList<>();
        listaAutori2.add(new Autore("Federico", "DeGasperi", 1948, 6, 2));
        listaAutori2.add(new Autore("Marcello", "Lippoli", 1950, 4, 7));

        //Libro3
        ArrayList<Autore> listaAutori3 = new ArrayList<>();
        listaAutori3.add(new Autore("Marcello", "Lippoli", 1950, 4, 7));

        //Libro4
        ArrayList<Autore> listaAutori4 = new ArrayList<>();
        listaAutori4.add(new Autore("Pippo", "Pippis", 1940, 1, 1));

        //Libro5
        ArrayList<Autore> listaAutori5 = new ArrayList<>();
        listaAutori5.add(new Autore("Giovanni", "Impastato", 1985, 1, 1));

    }

     */

    public void popolaGeneri(){

        //Libro1
        ArrayList<GenereEnum> gen1 = new ArrayList<>();
        gen1.add(GenereEnum.FANTASY);

        //Libro2
        ArrayList<GenereEnum> gen2 = new ArrayList<>();
        gen2.add(GenereEnum.STORICO);
        gen2.add(GenereEnum.NARRATIVA);

        //Libro3
        ArrayList<GenereEnum> gen3 = new ArrayList<>();
        gen3.add(GenereEnum.GIALLO);

        //Libro4
        ArrayList<GenereEnum> gen4 = new ArrayList<>();
        gen4.add(GenereEnum.HORROR);

        //Libro5
        ArrayList<GenereEnum> gen5 = new ArrayList<>();
        gen5.add(GenereEnum.FANTASY);
    }

    public static String stampaAutore(ArrayList<Autore> lista) {
        String listaAutore = "";
        Autore nuovoA = null;
        listaAutore += "[";
        for (int i = 0; i < lista.size() - 1; i++) {
            nuovoA = lista.get(i);
            listaAutore += "\"" + nuovoA.getNome() + " " + nuovoA.getCognome() + " " + nuovoA.getAnno().getYear() + "\"" + ",";
        }
        nuovoA = lista.get(lista.size() - 1);
        listaAutore += "\"" + nuovoA.getNome() + " " + nuovoA.getCognome() + " " + nuovoA.getAnno().getYear() + "\"" + "]" + ",";
        return listaAutore;
    }

    public  String stampaLibro(ArrayList<Libro> lista) {

        String listaCompleta = "";
        listaCompleta += "[";
        for (Libro nuovoL : lista) {
            listaCompleta += "{";
            listaCompleta += "\"ISBN\"" + ":" + "\"" + nuovoL.getIsbn() + "\"" + ",";
            listaCompleta += "\"Titolo\"" + ":" + "\"" + nuovoL.getTitolo() + "\"" + ",";
            listaCompleta += "\"Autore\"" + ":" + "\"";
            //listaCompleta += stampaAutore(nuovoL.getAutore());
            //listaCompleta += "\"Anno di pubblicazine\"" + ":" + "\"" + nuovoL.getAnnoPubb() + "\"" + ",";
            //listaCompleta += "\"GenereEnum\"" + ":" + "\"" + nuovoL.getGenereEnum() + "\"" + ",";
            listaCompleta += "}" + ",";
        }
        return listaCompleta+="]";
    }

    public static ArrayList<Libro> stampaElenco(){

        return listaLibri;
    }

    public static ArrayList<Libro> stampaLibroPerAutore(String n, String c) {
        /*
        ArrayList<Libro> lista = new ArrayList<Libro>();
        String nome = "", cognome = "", autoreNom = "", autoreCogn = "";
        autoreNom = n; //input.nextLine();
        autoreCogn = c; //input.nextLine();

        for (Libro libro : listaLibri) {
            libro.getAutore();
            for (int k = 0; k < libro.getAutore().size(); k++) {
                nome = libro.getAutore().get(k).getNome();
                cognome = libro.getAutore().get(k).getCognome();
                if(nome.equals(autoreNom) && autoreCogn.equals("")){
                    lista.add(libro);
                }else if (autoreNom.equals("") && cognome.equals(autoreCogn)){
                    lista.add(libro);
                }else if (nome.equals(autoreNom) && cognome.equals(autoreCogn)) {
                    lista.add(libro);
                }
            }
        }*/
        return null;
    }

    public static ArrayList<Libro> stampaPerGenere(String genere) {
        /*
        ArrayList<Libro> listaPerGenere = new ArrayList<Libro>();
        //System.out.println("Inserisci il genere da cercare fra:  BIOGRAFIA,GIALLO,FANTASCIENZA,FANTASY,NARRATIVA,STORICO,EPICA,SAGGIO,HORROR; ");
        //String genere = "FANTASY";
        for (Libro libro : listaLibri) {

            if (libro.getGenereEnum().toString().contains(genere)) {
                listaPerGenere.add(libro);
            }
        }

         */
        return null;
    }

    public static ArrayList<Libro> stampaPerTitolo(String titolo){

        ArrayList<Libro> listaPerTitolo = new ArrayList<Libro>();
        for(Libro libro : listaLibri){

            if(libro.getTitolo().contains(titolo)){
                listaPerTitolo.add(libro);

            }
        }
        //System.out.println(listaPerTitolo.toString());
        return listaPerTitolo;
    }

    public  ArrayList<Libro> cercaPerIsbn(String isbn){

        ArrayList<Libro> listaPerIsbn = new ArrayList<>();
        for(Libro libro : listaLibri){
            if(libro.getIsbn().equals((isbn))){
                listaPerIsbn.add(libro);
            }
        }
        return listaPerIsbn;
    }

    public static ArrayList<Libro> stampaPerData(int year) {
        /*
        ArrayList<Libro> listaLibriCercati = new ArrayList<>();
        int y, m, d;
        //System.out.println("Inserisci l'anno");
        y = year;

        m = 1;

        d = 1;
        LocalDate dataDacercare = LocalDate.of(y, m, d);

        for (Libro libro : listaLibri) {
            LocalDate dataLibro = libro.getAnnoPubb();
            if (dataLibro.isBefore(dataDacercare)) {
                listaLibriCercati.add(libro);
            }
        }

         */
        return null;
    }
    /*
    public  void aggiungiLibro() {
        input = new Scanner(System.in);

        boolean inserisciAutore = true;
        boolean inserisciGenere = true;
        String titoloL = "", nomeAut = "", cognomeAut = "";
        int yearL, monthL, dayL, yearA, monthA, dayA;
        monthL = 1;
        dayL = 1;
        ArrayList<Autore> autore = new ArrayList<>();
        ArrayList<GenereEnum> genereEnum = new ArrayList<>();
        System.out.print("Inserisci l'ISBN: ");
        String isbn = input.nextLine();
        System.out.print("Inserisci il Titolo del libro: ");
        titoloL = input.nextLine();
        System.out.print("Inserisci l'anno di pubblicazione: ");
        yearL = input.nextInt();
        while (inserisciAutore) {
            System.out.print("Inserisci il nome dell'autore: ");
            nomeAut = input.next();
            System.out.print("Insrisci il cognome dell'autore: ");
            cognomeAut = input.next();
            System.out.print("Inserisci l'anno di nascita dell'autore: ");
            yearA = input.nextInt();
            System.out.print("Inerisci il mese di nacita dell'autore: ");
            monthA = input.nextInt();
            System.out.print("Inserisci il giorno di nascita dell'autore: ");
            dayA = input.nextInt();

            System.out.print("Vuoi inserire altri autori? si, no: ");
            String risposta = input.next();
            if (risposta.equals("no")) {
                inserisciAutore = false;
            }
            autore.add(new Autore(nomeAut, cognomeAut, LocalDate.of(yearA, monthA, dayA)));
        }

        while (inserisciGenere) {
            System.out.println("Inserisci il genere: 1-Biografia 2-Giallo\n3-Fantascienza 4-Fantasy\n5-Narrativa " +
                    "6-Storico\n7-Epica 8-Saggio\n9-Horror 10-continua");

            int scelta = input.nextInt();
            switch (scelta) {
                case 1:
                    genereEnum.add(GenereEnum.BIOGRAFIA);
                    break;
                case 2:
                    genereEnum.add(GenereEnum.GIALLO);
                    break;
                case 3:
                    genereEnum.add(GenereEnum.FANTASCIENZA);
                    break;
                case 4:
                    genereEnum.add(GenereEnum.FANTASY);
                    break;
                case 5:
                    genereEnum.add(GenereEnum.NARRATIVA);
                    break;
                case 6:
                    genereEnum.add(GenereEnum.STORICO);
                    break;
                case 7:
                    genereEnum.add(GenereEnum.EPICA);
                    break;
                case 8:
                    genereEnum.add(GenereEnum.SAGGIO);
                    break;
                case 9:
                    genereEnum.add(GenereEnum.HORROR);
                    break;
                case 10:
                    inserisciGenere = false;
                    break;
            }

        }
        //listaLibri.add(new Libro(isbn, titoloL, autore, yearL, monthL, dayL, genereEnum));

    }

    public static ArrayList<String> stampaGeneri(){

        List<GenereEnum> gene =  Arrays.asList(GenereEnum.values());
        ArrayList<String> listaGeneri = new ArrayList<>();
        for(GenereEnum genereEnum : gene){
            listaGeneri.add(genereEnum.toString());
        }
        return listaGeneri;
    }

    public static void stampaMenu() {


        System.out.println("1 per stampare tutti i libri");
        System.out.println("2 per cercare i libri di un determinato autore");
        System.out.println("3 per cercare i libri precedenti a una data");
        System.out.println("4 per cercare i libri di un determinato genere");
        System.out.println("5 per aggingere un libro");
        System.out.println("Premere 0 per uscire");
    }

    public static void run() {

        Scanner input = new Scanner(System.in);
        String scelta = "100";
        String parolaDaCercare = "";
        System.out.println("Benvenuto in Libreria");
        while (Integer.parseInt(scelta) != 0) {
            //mostra menu

            stampaMenu();
            //richiedi oerazione da fare
            scelta = input.nextLine();

            //eseguire la funzione scelta
            //eseguiRicerca(Integer.parseInt(scelta));
        }
        System.out.println("Grazie er aver utilizzato questa libreria, arrivederci!");
    }
    /*
    public static void eseguiRicerca(int selezione) {

        switch (selezione) {
            case 1:
                stampaLibro(listaLibri);
                break;
            case 2:
                stampaLibroPerAutore(listaLibri);
                break;
            case 3:
                stampaPerData(listaLibri);
                break;
            case 4:
                stampaPerGenere(listaLibri);
                break;
            case 5:
                aggiungiLibro();
        }
    }
     */
}
