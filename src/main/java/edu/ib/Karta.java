package edu.ib;

public class Karta {
    /*
    okresla wlasciwosci karty - kolor i range
     */
    private String kolor;
    private String ranga;

    public Karta(String kolor, String ranga) {
        this.kolor = kolor;
        this.ranga = ranga;
    }
    public String getKolor() {
        return kolor;
    }

    public String getRanga() {
        return ranga;
    }
    public boolean sameKarta (Karta innaKarta) {
        return ranga.equals(innaKarta.ranga) &&
                kolor.equals(innaKarta.kolor);
    }


    @Override
    public String toString() {
        return "Karta{" +
                "kolor='" + kolor + '\'' +
                ", ranga='" + ranga + '\'' +
                '}';
    }
}
