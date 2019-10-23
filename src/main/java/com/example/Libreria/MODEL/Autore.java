package com.example.Libreria.MODEL;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.Documented;
import java.time.LocalDate;
@Document(collection = "Libro")
@Getter
@Setter
public class Autore {


    public enum OggAutore{

        nome ("nome"),
        cognome ("cognome"),
        anno ("anno");

        private String value;

        OggAutore (String value){this.value = value;}

        public String getValue(){return value;}


    }

    private String nome = "";
    private String cognome = "";
    @DateTimeFormat
    private LocalDate anno;




    public Autore(String nom, String cogn, LocalDate data){

        setNome(nom);
        setCognome(cogn);
        setAnno(data);

    }

    public Autore(){}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /*
    public void setAnno(String annoNascita) {
        this.anno = LocalDate.parse(annoNascita);
    }

     */

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getAnno() {
        return anno;
    }

    @Override
    public String toString(){
        return "{\n\"Nome\": "+"\""+this.getNome()+"\","+"\n\"Cognome\": "+"\""+this.getCognome()+"\","
                +"\n\"Anno\": "+"\""+this.getAnno()+"\"\n}";
    }
}
