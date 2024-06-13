package com.dede.flashcard.model;

public enum Nivel {

    FACIL(1),
    MEDIO(2),
    DIFICIL(3);

    private final int valor;

    Nivel(int valor){
        this.valor = valor;
    }
    public static Nivel fromInteger(Integer number) {

        for (Nivel nivel: Nivel.values()) {
            if(nivel.valor == number){
                return nivel;
            }
        }
        throw new IllegalArgumentException("Nenhum nivel encontrado para o numero fornecido: " + number);
    }
    public int getValor() {
        return valor;
    }
}
