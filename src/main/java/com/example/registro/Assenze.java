package com.example.registro;

import java.util.Date;

public class Assenze {
    private static final String RITARDO = "ABR0";
    private static final String ASSENZA = "ABA0";
    private static final String RITARDO_BREVE = "ABR1";
    private String data;
    private boolean giustificata;
    private String tipologia;

    public Assenze(String data, boolean giustificata, String tipologia) {
        this.data = data;
        this.giustificata = giustificata;
        this.tipologia = tipologia;
    }
}
