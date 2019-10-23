package com.example.Libreria.MODEL;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyException extends RuntimeException{

    public MyException(String messaggio){super (messaggio);}
}
