package net.mauro.Sorteig;

import java.io.Serializable;
import java.util.ArrayList;

public class Baralla implements Serializable{
  
  int [] numeros = {1,2,3,4,5,6,7,8,9,10,11,12};
  ArrayList<Carta> arrayCartes;
  
  public Baralla(ArrayList<Carta> baralla){
    this.arrayCartes = baralla;
  }
  
  
  public ArrayList<Carta> generarBaralla(){
    ArrayList<Carta> arrayCartes = new ArrayList<Carta>();
    for(int i=0;i<numeros.length;i++){
      for(int j=0;j<4;j++){
        Carta cartes = new Carta(numeros[i]);
        arrayCartes.add(cartes);
      }
    }
    return arrayCartes;
    
  }
  


}
