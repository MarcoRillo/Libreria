package com.example.Libreria.SERVICE;

import com.example.Libreria.DTO.LibroDTO;
import com.example.Libreria.MAPPER.LibroMapper;
import com.example.Libreria.MODEL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.*;

@Service
public class ServiceImpl implements SERVICE {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    LibroMapper libroMapper;

    public static ArrayList<Libro> listaLibri = new ArrayList<Libro>();

    @Override
    public String stampaLibro(ArrayList<Libro> lista) {
        return listaLibri.toString();
    }

    @Override
    public List<Libro> stampaElenco() {
        return mongoTemplate.findAll(Libro.class);
    }


    @Override
    public ArrayList<Libro> cercaPerAutore(String n, String c) {

        Query query = new Query();
        if (!n.equals("")) {
            query.addCriteria(Criteria.where(Libro.OggLibro.autore.getValue()+"."+Autore.OggAutore.nome.getValue()).is(n));
        }
        if (!c.equals("")) {
            query.addCriteria(Criteria.where(Libro.OggLibro.autore.getValue()+"."+Autore.OggAutore.cognome.getValue()).is(c));
        }
        return (ArrayList<Libro>) mongoTemplate.find(query, Libro.class);
    }

    @Override
    public ArrayList<Libro> cercaPerGenere(String genere) {

        Query query = new Query();
        query.addCriteria(Criteria.where(Libro.OggLibro.genereEnum.getValue()).is(genere));
        return (ArrayList<Libro>) mongoTemplate.find(query, Libro.class);
    }


    @Override
    public ArrayList<Libro> cercaPerTitolo(String titolo) {

        Query query = new Query();
        query.addCriteria(Criteria.where(Libro.OggLibro.titolo.getValue()).is(titolo));
        System.out.println(titolo);
        return (ArrayList<Libro>) mongoTemplate.find(query, Libro.class);

    }

    @Override
    public ArrayList<Libro> cercaPerIsbn(String isbn) {

        Query query = new Query();
        query.addCriteria(Criteria.where(Libro.OggLibro.isbn.getValue()).is(isbn));
        return (ArrayList<Libro>) mongoTemplate.find(query, Libro.class);
    }

    @Override
    public ArrayList<Libro> cercaPerData(int year) {

        int y, m, d;
        y = year;
        m = 1;
        d = 1;
        LocalDate dataDacercare = LocalDate.of(y, m, d);

        Query query = new Query();
        query.addCriteria(Criteria.where(Libro.OggLibro.annoPubb.getValue()).lte(dataDacercare));
        return (ArrayList<Libro>) mongoTemplate.find(query, Libro.class);

    }

    @Override
    public void aggiungiLibro(LibroDTO libroDTO) {

        Libro nuovoLibro = libroMapper.DTOToEntity(libroDTO);

        mongoTemplate.save(nuovoLibro);
    }


    @Override
    public void modificaLibro(LibroDTO libroDTO) {

        Query query = new Query();
        query.addCriteria(Criteria.where(Libro.OggLibro.isbn.getValue()).is(libroDTO.getIsbn()));
        Libro libroModificato = mongoTemplate.findOne(query, Libro.class);

        if(libroDTO.getAutore() != null){
            libroModificato.setAutore(libroMapper.DTOToEntity(libroDTO).getAutore());
        }
        if(libroDTO.getPubblicazione() != null){
            libroModificato.setPubblicazione(libroMapper.DTOToEntity(libroDTO).getPubblicazione());
        }
        if(libroDTO.getGenere() != null){
            libroModificato.setGenereEnum((ArrayList<GenereEnum>) libroMapper.DTOToEntity(libroDTO).getGenere());
        }
        if(libroDTO.getTitolo() != null){
            libroModificato.setTitolo(libroMapper.DTOToEntity(libroDTO).getTitolo());
        }

        mongoTemplate.save(libroModificato);


    }

    @Override
    public void eliminaLibro(String isbn) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Libro.OggLibro.isbn.getValue()).is(isbn));
        mongoTemplate.remove(query, Libro.class);
    }


    @Override
    public ArrayList<String> stampaGeneri() {

        List<GenereEnum> gene = Arrays.asList(GenereEnum.values());
        ArrayList<String> listaGeneri = new ArrayList<>();
        for (GenereEnum genereEnum : gene) {
            listaGeneri.add(genereEnum.toString());
        }
        return listaGeneri;
    }


    @Override
    public ArrayList<Libro> filtraPer(LibroDTO libroDTO) {
        Query query = new Query();
        List<Criteria> listaCriteria = new ArrayList<>();
        Libro libro = libroMapper.DTOToEntity(libroDTO);
        if (libro.getIsbn() != null) {
            listaCriteria.add(Criteria.where(Libro.OggLibro.isbn.getValue()).is(libro.getIsbn()));
        }
        if (libro.getTitolo() != null) {
            listaCriteria.add(Criteria.where(Libro.OggLibro.titolo.getValue()).regex(libro.getTitolo(), "i"));
        }
        if(libro.getAutore() != null){
            for (Autore a : libro.getAutore()){
                if(a.getNome() != null){
                    listaCriteria.add(Criteria.where(Libro.OggLibro.autore.getValue()+"."+Autore.OggAutore.nome.getValue()).regex(a.getNome()));
                }
                if(a.getCognome() != null){
                    listaCriteria.add(Criteria.where(Libro.OggLibro.autore.getValue()+"."+Autore.OggAutore.cognome.getValue()).regex(a.getCognome()));
                }
            }
        }
            /*
            for (LinkedHashMap map : (List<LinkedHashMap>) libroDTO.get(Libro.OggLibro.autore.getValue())){
                if(map.get(Autore.OggAutore.nome.getValue()) != null){
                    listaCriteria.add((Criteria.where(Libro.OggLibro.autore.getValue()+"."+Autore.OggAutore.nome.getValue()).regex((String)
                            map.get(Autore.OggAutore.nome.getValue()),"i")));
                }
                if(map.get(Autore.OggAutore.cognome.getValue()) != null){
                    listaCriteria.add((Criteria.where(Libro.OggLibro.autore.getValue()+"."+Autore.OggAutore.cognome.getValue()).regex((String)
                            map.get(Autore.OggAutore.cognome.getValue()),"i")));
                }
            }
            //query.addCriteria(new Criteria().orOperator(listaCriteria.toArray(new Criteria[listaCriteria.size()])));
        }

             */

        if (libro.getPubblicazione() != null) {
           // LocalDate dataDacercare = LocalDate.parse((CharSequence) libroDTO.get(Libro.OggLibro.annoPubb.getValue()));
            listaCriteria.add(Criteria.where(Libro.OggLibro.annoPubb.getValue()).lte(libro.getPubblicazione()));
        }

        if (libro.getGenere() !=null){
            for (GenereEnum g:  libro.getGenere()) {
                listaCriteria.add(Criteria.where(Libro.OggLibro.genereEnum.getValue()).in(g));
            }
        }
        query.addCriteria(new Criteria().andOperator(listaCriteria.toArray(new Criteria[listaCriteria.size()])));
        return (ArrayList<Libro>) mongoTemplate.find(query, Libro.class);
    }

    public void generiToGeneri(List<String> generi, List<GenereEnum> gen) {
        for (String a : generi) {

            switch (a.toUpperCase()) {
                case "EPICA":
                    gen.add(GenereEnum.EPICA);
                    break;
                case "GIALLO":
                    gen.add(GenereEnum.GIALLO);
                    break;
                case "HORROR":
                    gen.add(GenereEnum.HORROR);
                    break;
                case "SAGGIO":
                    gen.add(GenereEnum.SAGGIO);
                    break;
                case "FANTASY":
                    gen.add(GenereEnum.FANTASY);
                    break;
                case "STORICO":
                    gen.add(GenereEnum.STORICO);
                    break;
                case "BIOGRAFIA":
                    gen.add(GenereEnum.BIOGRAFIA);
                    break;
                case "NARRATIVA":
                    gen.add(GenereEnum.NARRATIVA);
                    break;
                case "FANTASCIENZA":
                    gen.add(GenereEnum.FANTASCIENZA);
                    break;
            }
        }
    }
}



