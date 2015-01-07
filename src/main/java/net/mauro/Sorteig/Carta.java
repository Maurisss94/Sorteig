package net.mauro.Sorteig;

import java.io.Serializable;

public class Carta implements Serializable{
  
  /**
   * numero de la carta.
   */
  private int numero;
  
  /**
   * constructor de la carta.
   * @param numero de la carta.
   */
  public Carta(int numeroc) {
    this.numero = numeroc;
  }
  
  /**
   * getter del numero de la carta.
   * @return el numero de la carta.
   */
  public int getNumero() {
    return numero;
  }
  
  /**
   * setter del numero de la carta.
   * @param numero de la carta.
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }
  
  
  

}
