package com.example.robomaciano.ui.model;

import java.util.function.Function;

interface MarcianoInterface {
    String agir();
}

public class Marciano {
    String pergunta = "Certamente";
    String grito = "Opa! Calma aí!";
    String pergunta_grito = "Relaxa, eu sei o que estou fazendo!";
    String eu = "A responsabilidade é sua";
    String vazio = "Não me incomode";
    String outro = "Tudo bem, como quiser";

    public String responda(String comando) {
        if (comando == null || comando.equals("")) {
            return vazio;
        } else if (comando.contains("eu") || comando.contains("Eu") || comando.contains("EU")) {
            return eu;
        } else if (comando.contains("?") && comando.equals(comando.toUpperCase())) {
            return pergunta_grito;
        } else if (comando.split(" ").equals(comando.toUpperCase())) {
            return grito;
        } else if (comando.contains("?")) {
            return pergunta;
        } else {
            return outro;
        }
    }
}

//public class Main {
//    public static void main(String[] args) {
//        MarcianoPremium marciano = new MarcianoPremium(() -> "Ação personalizada");
//        System.out.println(marciano.responda("Como você se chama?"));
//        System.out.println(marciano.responda("Olá MARCIANO"));
//        System.out.println(marciano.responda("Olá Eu MARCIANO"));
//        System.out.println(marciano.responda("some", 2.0, 3.0));
//        System.out.println(marciano.responda("agir"));
//    }
//}


