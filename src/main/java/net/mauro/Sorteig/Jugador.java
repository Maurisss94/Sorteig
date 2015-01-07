package net.mauro.Sorteig;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe jugador que implementa serialització.
 * @author mauro
 *
 */
public class Jugador implements Serializable{
  
  ArrayList<Carta> cartes;
  String nom;
  int monedes;
  
  /**
   * Constructor del juagador.
   * @param nomj nom del jugador.
   * @param monedesj monedes del jugador.
   */
  public Jugador(String nomj, int monedesj) {
    this.nom = nomj;
    this.monedes = monedesj;
  }
  /**
   * Getter de les cartes.
   * @return un array de cartes.
   */
  public ArrayList<Carta> getCartes() {
    return cartes;
  }
  /**
   * Setter de les cartes.
   * @param cartes cartes a aplicar.
   */
  public void setCartes(ArrayList<Carta> cartes) {
    this.cartes = cartes;
  }
  /**
   * getter del nom.
   * @return al nom del jugador.
   */
  public String getNom() {
    return nom;
  }
  /**
   * setter del nom.
   * @param nom del jugador.
   */
  public void setNom(String nom) {
    this.nom = nom;
  }
  /**
   * getter de les monedes.
   * @return el numero de monedes del jugador.
   */
  public int getMonedes() {
    return monedes;
  }
  /**
   * setting de les monedes.
   * @param el numero de monedes del jugador.
   */
  public void setMonedes(int monedes) {
    this.monedes = monedes;
  }
  
  
  
  

}
