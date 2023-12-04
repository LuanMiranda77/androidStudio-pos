package com.example.robomaciano.ui.model;

public class MarcianoPremium extends MarcianoAvancado {
    private MarcianoInterface acao;

    public MarcianoPremium() {
        this.acao = acao;
    }

    @Override
    public String responda(String comando) {
        if (comando.equals("agir")) {
            return "É pra já!\n" + acao.agir();
        } else {
            return super.responda(comando);
        }
    }
}
