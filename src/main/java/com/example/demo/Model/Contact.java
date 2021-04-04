package com.example.demo.Model;

public class Contact {

    private int kontaktID;
    private String fornavn;
    private String efternavn;
    private String adresse;
    private int husNr;
    private int tlfnumb;

    public int getKontaktID() {
        return kontaktID;
    }

    public void setKontaktID(int kontaktID) {
        this.kontaktID = kontaktID;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getHusNr() {
        return husNr;
    }

    public void setHusNr(int husNr) {
        this.husNr = husNr;
    }

    public int getTlfnumb() {
        return tlfnumb;
    }

    public void setTlfnumb(int tlfnumb) {
        this.tlfnumb = tlfnumb;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "kontaktID=" + kontaktID +
                ", fornavn='" + fornavn + '\'' +
                ", efternavn='" + efternavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", husNr=" + husNr +
                ", tlfnumb=" + tlfnumb +
                '}';
    }
}
