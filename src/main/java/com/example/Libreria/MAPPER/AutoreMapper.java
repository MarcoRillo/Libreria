package com.example.Libreria.MAPPER;

import com.example.Libreria.DTO.AutoreDTO;
import com.example.Libreria.MODEL.Autore;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
@Data
public class AutoreMapper {


    public Autore DTOToEntity(AutoreDTO autoreDTO){

        if(autoreDTO != null){

            Autore autore = new Autore();

            autore.setNome(autoreDTO.getNome());
            autore.setCognome(autoreDTO.getCognome());
            autore.setAnno(autoreDTO.getAnno());

            return autore;
        }
       return null;
    }


    public void EntityToDTO(){}


}
