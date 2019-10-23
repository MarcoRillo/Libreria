package com.example.Libreria.DTO;

import lombok.Data;

import java.time.LocalDate;


@Data
public class AutoreDTO {



    private String nome;
    private String cognome;
    private LocalDate anno;


}
