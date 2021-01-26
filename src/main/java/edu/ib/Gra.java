package edu.ib;

import java.util.ArrayList;

public interface Gra {
    /*
    okresla jakie ruchy sa dostepne
    gracza maja karty stol tez ma karty

        metoda ruchu



        metoda która okresla co moze gracz wykonac
            reguly gry czyli zgodnosc, osemki, kolory, liczba
            co ten ruch robi czyli usuwanie i dodawanie do miejsc stosownych

        metoda zwyciestwa


    okresla kto teraz rozgrywa
     */




    public static Gracz zagrajKarta(Gracz g1, Karta karta, Stol stol){   //usuwa karte z reki i dodaje jako aktywna.
        ArrayList<Karta> r1 = g1.getKarty();
        int id =-1;
        for (int i=0; i<r1.size(); i++) {
            if (karta.sameKarta(r1.get(i)))     //sprawdza czy w rece jest taka karta jak podana
                id = i;   //id karty w rece;
        }

        String kKolor = karta.getKolor();
        String kRanga = karta.getRanga();

        String aktRanga = stol.getAktywna().getRanga();
        String aktKolor = stol.getAktywna().getKolor();

        boolean w = false;
        if (kKolor.equals(aktKolor)) w=true;
        else if(kRanga.equals(aktRanga)) w = true;


        if (id!=-1 && w==true) {
            ArrayList<Karta> wylozone = stol.getWylozone();
            wylozone.add(karta);
            stol.setWylozone(wylozone);
            stol.setAktywna(karta);
            r1.remove(id);
            g1.setKarty(r1);
            return g1;
        } else if (w==false){
            System.out.println("Wbrew zasadom.");
            return g1;
        } else {
            System.out.println("Brak takiej karty w rece");
            return g1;
        }

    }

    public static Gracz dobierzKarte(Gracz g1, Karta k, Stol stol){
        ArrayList<Karta> r1 = g1.getKarty();
        ArrayList<Karta> oczekujace = stol.getOczekujace();
        int ile = oczekujace.size();
        r1.add(oczekujace.get(ile-1));
        oczekujace.remove(ile-1);
        g1.setKarty(r1);
        stol.setOczekujace(oczekujace);
        return g1;
    }

    public static Stol uzupelnij(Stol stol){
        ArrayList<Karta> wyl = stol.getWylozone();
        Karta akt = stol.getAktywna();
        ArrayList<Karta> oczekujace = stol.getOczekujace();

        for (int i =0; i<wyl.size(); i++){
            oczekujace.add(wyl.get(i));
        }


        ArrayList<Karta> noweWyl = new ArrayList<>();
        noweWyl.add(akt);

        DystrybucjaKart.tasowansko(oczekujace);

        stol.setOczekujace(oczekujace);
        stol.setAktywna(akt);
        stol.setWylozone(noweWyl);

        return stol;

    }


}