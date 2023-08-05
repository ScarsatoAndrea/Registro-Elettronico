package com.example.registro;

import java.util.Date;

public class Voto {
    private int voto;
    private String descrizione;
    private Date data;

    public Voto (int voto, String descrizione, Date data){
        this.voto = voto;
        this.descrizione = descrizione;
        this.data = data;
    }
}
