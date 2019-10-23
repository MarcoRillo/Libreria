package com.example.Libreria.MAPPER;

import com.example.Libreria.DTO.AutoreDTO;
import com.example.Libreria.DTO.LibroDTO;
import com.example.Libreria.MODEL.Autore;
import com.example.Libreria.MODEL.GenereEnum;
import com.example.Libreria.MODEL.Libro;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class LibroMapper {

    @Autowired
    AutoreMapper autoreMapper;

    public Libro DTOToEntity(LibroDTO libroDTO){

        Libro libro = new Libro();

        libro.setIsbn(libroDTO.getIsbn());
        libro.setTitolo(libroDTO.getTitolo());
        libro.setAutore(generaElencoAutori(libroDTO.getAutore()));
        libro.setPubblicazione(libroDTO.getPubblicazione());
        libro.setGenere(generiToGeneri(libroDTO.getGenere()));

        return libro;
    }


    public void EntityToDTO(){}

    public List<Autore> generaElencoAutori(List<AutoreDTO> autoreDTO){

        List<Autore> autore = new ArrayList<>();
        for (AutoreDTO a : autoreDTO){
            autore.add(autoreMapper.DTOToEntity(a));

        }

         return autore;
    }

    public List<GenereEnum>  generiToGeneri(List<String> generi) {
        List<GenereEnum> gen = new ArrayList<>();

        for(String g : generi){
            if(("EPICA").contains(g.toUpperCase())){
                gen.add(GenereEnum.EPICA);
            }
            if(("GIALLO").contains(g.toUpperCase())){
                gen.add(GenereEnum.GIALLO);
            }
            if(("HORROR").contains((g.toUpperCase()))){
                gen.add(GenereEnum.HORROR);
            }
            if(("SAGGIO").contains(g.toUpperCase())){
                gen.add(GenereEnum.SAGGIO);
            }
            if(("FANTASY").contains(g.toUpperCase())){
                gen.add(GenereEnum.FANTASY);
            }
            if(("STORICO").contains(g.toUpperCase())){
                gen.add(GenereEnum.STORICO);
            }
            if(("BIOGRAFIA").contains(g.toUpperCase())){
                gen.add(GenereEnum.BIOGRAFIA);
            }
            if(("NARRATIVA").contains(g.toUpperCase())){
                gen.add(GenereEnum.NARRATIVA);
            }
            if(("FANTASCIENZA").contains(g.toUpperCase())){
                gen.add(GenereEnum.FANTASCIENZA);
            }
        }


        /*
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

         */

        return gen;
    }


}
