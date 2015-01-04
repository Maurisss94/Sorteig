package net.mauro.Sorteig;

import java.io.Serializable;

public class Carta implements Serializable{
  
  int numero;
  
  public Carta(int numeroc){
    this.numero = numeroc;
  }
  
  public int getNumero() {
    return numero;
  }
  public void setNumero(int numero) {
    this.numero = numero;
  }
  
  
  

}
