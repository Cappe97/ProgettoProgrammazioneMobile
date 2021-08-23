package com.unitn.lpsmt.group13.pommidori.db;

import java.util.Date;

public class TablePomodoroModel {

    //Variabili tabella Pomodori
    public static final String TABLE_NAME = "pommodoro";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOME_ACTIVITY = "nome_attivita";
    public static final String COLUMN_DATA = "data_pmodoro";
    public static final String COLUMN_DURATA = "durata_pomodoro";

    public static final String queryCreate =
            "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOME_ACTIVITY + " TEXT, " +
                    COLUMN_DATA + " DATATIME, " +
                    COLUMN_DURATA + " TIME, " +
                    "FOREIGN KEY (" + COLUMN_NOME_ACTIVITY +") REFERENCES " + TableActivityModel.TABLE_NAME + "(" + TableActivityModel.COLUMN_NOME +"));";

    //Modello
    private String name;
    private Date scadenza;
    private Date durata;

    //Costrutori
    public TablePomodoroModel() {
    }
    public TablePomodoroModel(String name, Date scadenza, Date durata) {
        this.name = name;
        this.scadenza = scadenza;
        this.durata = durata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public Date getDurata() {
        return durata;
    }

    public void setDurata(Date durata) {
        this.durata = durata;
    }
}