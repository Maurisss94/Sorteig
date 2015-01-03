package net.mauro.Sorteig;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc implements Serializable{
  
  ArrayList<Carta> baralla;
  ArrayList<Jugador> Jugadors;
  transient boolean fi;
  private File fitxerSerial = new File("participants");
  
  public Joc( ArrayList<Jugador> Jugadorsj) throws IOException{

    this.Jugadors = Jugadorsj;
    this.baralla = generarBaralla();
  }
  
  
  public void començarJoc(ArrayList<Jugador> jugadors) throws IOException, ClassNotFoundException{
    
    Scanner lector = new Scanner(System.in);
    
    if(fitxerSerial.exists()){
      Principal.deserialitzacioObjecte();
    }else{
      
    
    System.out.println("Comença el joc: ");
   
    int monedes=0;
    int ronda = 0;
    while(!fi){
      
      ronda++;
      System.out.println("Comença la ronda "+ ronda);
 
      
    for(int i=0;i<jugadors.size();i++){
      System.out.println("El jugador "+ jugadors.get(i).getNom() + " quantes monedes aposta? ");
      monedes= lector.nextInt();
      int monedesApostades =apostarMonedes(jugadors, monedes, i);
      if((jugadors.get(i).getMonedes() == 0) ||(jugadors.get(i).getMonedes()<0)){
        fi = true;
      }
      repartirCartes(jugadors, i, monedesApostades);
      for(int j=0;j<jugadors.get(i).getCartes().size();j++){
        System.out.println("Les seves cartes són: "+ jugadors.get(i).getCartes().get(j).getNumero());
      }
      
    }
    System.out.print("El guanyador de la ronda "+ronda+ " es:");
    int cartaAlta = comprovarCartaAlta(jugadors);
    comprovarGuanyador(cartaAlta, jugadors);
    
    
    
    }
    }
    
    
    
  }
  public void comprovarGuanyador(int cartaAlta, ArrayList<Jugador> jugadors){
    
    for(int i=0;i<jugadors.size();i++){
      for(int j=0;j<jugadors.get(i).getCartes().size();j++){
        if(jugadors.get(i).getCartes().get(j).getNumero() == cartaAlta){
          System.out.println(" " + jugadors.get(i).getNom()+" ");
        }
      }
    }
  }
  public int apostarMonedes(ArrayList<Jugador> jugadors, int monedes, int i) throws IOException{

      jugadors.get(i).setMonedes(jugadors.get(i).getMonedes() - monedes);
      System.out.println("te "+ jugadors.get(i).getMonedes()+ " monedes");
      Principal.serialitzarObjecte();
      return monedes;
      
    
    
  }
  
  public ArrayList<Carta> generarBaralla() throws IOException{
    
    Baralla barall = new Baralla(baralla);
    ArrayList<Carta> cartes =barall.generarBaralla();
    Principal.serialitzarObjecte();
    return cartes;
    
  }
  public int generarAleatori( int monedes){

    Random rn = new Random();
    int numCarta=0;
  
    numCarta =rn.nextInt(baralla.size());
       
    return numCarta;
    
    
  }
  public void repartirCartes(ArrayList<Jugador> jugadors, int i, int monedes) throws IOException{
    
    ArrayList<Carta> cartes = new ArrayList<Carta> ();
    int cont =0;
      while(cont<monedes){
            cartes.add(baralla.get(generarAleatori(monedes)));
            jugadors.get(i).setCartes(cartes);
            cont++;
      }
      Principal.serialitzarObjecte();
    
  }
  
  public int comprovarCartaAlta(ArrayList<Jugador> jugadors){
    
   int primeraCarta = jugadors.get(0).getCartes().get(0).getNumero();
   
    for(int i=0;i<jugadors.size();i++){
      
      for(int j=0;j<jugadors.get(i).getCartes().size();j++){
        if(primeraCarta <jugadors.get(i).getCartes().get(j).getNumero()){
          primeraCarta = jugadors.get(i).getCartes().get(j).getNumero();;
          
        }
        
      }
      
     
      
    }
    
    
    return primeraCarta;
  }
  

}
