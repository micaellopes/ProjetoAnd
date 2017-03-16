package com.example.andrey.projetoand.Controller;

/**
 * Created by Andrey on 15/03/2017.
 */

public class Controller {

    private static Controller instance = null;
    private String value;

    private Controller(){

    }

    //Só pode instanciar usando o getInstace, se instance for null ele cria e passa
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

