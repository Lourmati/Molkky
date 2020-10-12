package com.example.labo1;

public class Joueur {
    String nom;
    int strike;
    int point;


    public Joueur(String nom, int strike, int point) {
        this.nom = nom;
        this.strike = strike;
        this.point = point;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
