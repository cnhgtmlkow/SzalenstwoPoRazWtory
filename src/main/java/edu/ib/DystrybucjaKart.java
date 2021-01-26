package edu.ib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public interface DystrybucjaKart {
    /*
    okresla kto ma jakie karty na dany moment
    gracz1
    gracz2
    stol - talia do pobrania i wylozone karty
     */
    public static ArrayList<Karta> talia(){
        ArrayList<Karta> talia = new ArrayList<Karta>();
        int [] ran = new int [13];
        int [] kol = new int [4];
        String[] Kolory =  {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] Rangi = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for(int i = 0; i<Rangi.length; i++){
            for(int j = 0; j<Kolory.length; j++){
                Karta karta = new Karta(Kolory[j], Rangi[i]);
                talia.add(karta);
                System.out.println(karta.toString());
            }
        }
        return talia;
    }
    public static ArrayList<Karta> tasowansko(ArrayList<Karta> talia){
        Collections.shuffle(talia);
        for (int i = 0; i<talia.size(); i++){
            System.out.println(talia.get(i));
        }
        return talia;
    }

    public static void rozdanie(ArrayList<Karta> talia, int liczbaGraczy, Gracz [] gracz, Stol stol) {
        tasowansko(talia);
        ArrayList<Karta> kupka = new ArrayList<Karta>();
        kupka = talia;
        for (int i = 0; i<liczbaGraczy;i++){ //daje po osiem kart graczom
            ArrayList<Karta> dlaGracza = new ArrayList<Karta>(8);
            for (int j = 0 + i*8; j<8+i*8; j++){
                dlaGracza.add(talia.get(j+8*i));
                kupka.remove(j+8*i);
            }
            gracz[i].setKarty(dlaGracza);

        }
        stol.setAktywna(talia.get(liczbaGraczy*8));
        kupka.remove(liczbaGraczy*8);
        stol.setOczekujace(kupka);
//        AbstractMethodError


    }
}

