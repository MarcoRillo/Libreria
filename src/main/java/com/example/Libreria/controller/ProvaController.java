package com.example.Libreria.controller;

import com.example.Libreria.DTO.LibroDTO;
import com.example.Libreria.SERVICE.SERVICE;
import com.example.Libreria.MODEL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController

@RequestMapping(value = "/libreria")
public class ProvaController {


    @Autowired
    SERVICE s;

    @GetMapping(value = "/ciao")

    public String ciao() {

        return "{\"a\": \"b\"}";
    }

    @GetMapping(value = "/libri/genere/{genere}")
    public ArrayList<Libro> stampaPerGenere(@PathVariable String genere) {

        return s.cercaPerGenere(genere.toUpperCase());
    }

    @GetMapping(value = "/libri/autore")
    public ArrayList<Libro> stampaPerAutore(@RequestParam(defaultValue = "") String nome,
                                            @RequestParam(defaultValue = "") String cognome) {
        return s.cercaPerAutore(nome, cognome);
    }

    @GetMapping(value = "/libri/data/{anno}")
    public ArrayList<Libro> stampaPerData(@PathVariable int anno) {
        return s.cercaPerData(anno);
    }

    @GetMapping(value = "/libri/titolo/{titolo}")
    public ArrayList<Libro> stampaPerTitolo(@PathVariable String titolo) {
        return s.cercaPerTitolo(titolo);
    }

    @GetMapping(value = "/libri")
    public List<Libro> stampaElencoLibri() {
        return s.stampaElenco();
    }

    @PostMapping(value = "/libri/nuovo")
    public void aggiungiLibro(@RequestBody LibroDTO libroDTO) {
        s.aggiungiLibro(libroDTO);
    }

    @PutMapping(value = "/libri/modifica")
    public void modificaLibro(@RequestBody LibroDTO libroDTO){
        s.modificaLibro(libroDTO);
    }

    @DeleteMapping(value = "/libri/elimina/{isbn}")
    public void eliminaLibro(@PathVariable String isbn){
        s.eliminaLibro(isbn);
    }

    @GetMapping(value = "/libri/isbn/{isbn}")
    public ArrayList<Libro> cercaPerIsbn(@PathVariable String isbn){
        return s.cercaPerIsbn(isbn);
    }

    @PostMapping(value = "/libri/filtro")
    public ArrayList<Libro> filtroPer(@RequestBody LibroDTO libroDTO)  {
         return s.filtraPer(libroDTO);
    }

}


