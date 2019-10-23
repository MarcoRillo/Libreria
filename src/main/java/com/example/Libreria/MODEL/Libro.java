package com.example.Libreria.MODEL;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Document(collection = "Libro")
@Getter
@Setter

public class Libro {

    public enum OggLibro {

        isbn ("isbn"),
        titolo ("titolo"),
        autore ("autore"),
        annoPubb ("pubblicazione"),
        genereEnum ("genere");

        private String value;

        OggLibro (String value){this.value = value;}

        public String getValue(){return value;}


    }

    @Id
    private String isbn;
    private String titolo;

    private List<Autore> autore = new ArrayList<>();
    @DateTimeFormat
    private LocalDate pubblicazione = null;
    private List<GenereEnum> genere = new ArrayList<>();



    public Libro(String isbn, String titolo, ArrayList<Autore> autore,  LocalDate date, ArrayList<GenereEnum> genere ){

        setIsbn(isbn);
        setTitolo(titolo);
        setPubblicazione(date);
        setAutore(autore);
        setGenereEnum(genere);

    }

    public Libro(){}




    //generazione ISBN
    public static String getRandomString(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST0123456789".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomStr = sb.toString();

        return randomStr;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setGenereEnum(ArrayList<GenereEnum> genereEnum) {
        this.genere = genereEnum;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }



    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


}
