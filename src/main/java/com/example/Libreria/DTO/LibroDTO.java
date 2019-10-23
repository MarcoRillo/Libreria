package com.example.Libreria.DTO;

import com.example.Libreria.MODEL.Autore;
import com.example.Libreria.MODEL.GenereEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class LibroDTO {

    @Id
    private String isbn;
    private String titolo;
    private List<AutoreDTO> autore = new ArrayList<>();
    private LocalDate pubblicazione;
    private List<String> genere = new ArrayList<>();


}