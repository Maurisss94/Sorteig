package net.mauro.Sorteig;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{
  
  ArrayList<Carta> cartes;
  String nom;
  int monedes;
  
  public Jugador(String nomj, int monedesj){
    this.nom = nomj;
    this.monedes = monedesj;
  }
  public ArrayList<Carta> getCartes() {
    return cartes;
  }
  public void setCartes(ArrayList<Carta> cartes) {
    this.cartes = cartes;
  }
  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  public int getMonedes() {
    return monedes;
  }
  public void setMonedes(int monedes) {
    this.monedes = monedes;
  }
  
  
  
  

}
