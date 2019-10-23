package com.example.Libreria.SERVICE;

import com.example.Libreria.DTO.LibroDTO;
import com.example.Libreria.MODEL.Libro;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SERVICE {

    String stampaLibro(ArrayList<Libro> lista);

    List<Libro> stampaElenco();

    ArrayList<Libro> cercaPerAutore(String n, String c);

    ArrayList<Libro> cercaPerGenere(String genere);

    ArrayList<Libro> cercaPerTitolo(String titolo);

    ArrayList<Libro> cercaPerIsbn(String isbn);

    ArrayList<Libro> cercaPerData(int year);

    void aggiungiLibro(LibroDTO libroDTO);

    void modificaLibro(LibroDTO libroDTO);

    void eliminaLibro(@PathVariable String isbn);

    ArrayList<String> stampaGeneri();

    ArrayList<Libro> filtraPer(LibroDTO libroDTO);




}
