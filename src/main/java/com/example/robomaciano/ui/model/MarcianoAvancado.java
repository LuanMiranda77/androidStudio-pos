package com.example.robomaciano.ui.model;

public class MarcianoAvancado extends Marciano {
    public String responda(String comando, Double oper1, Double oper2) {
        if (oper1 != null && oper2 != null) {
            Double res;
            switch (comando) {
                case "some":
                    res = oper1 + oper2;
                    break;
                case "subtraia":
                    res = oper1 - oper2;
                    break;
                case "multiplique":
                    res = oper1 * oper2;
                    break;
                case "divida":
                    res = oper1 / oper2;
                    break;
                default:
                    return "Ou não";
            }
            return "Essa eu sei. " + res;
        } else {
            return super.responda(comando);
        }
    }
}
