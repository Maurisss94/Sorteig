package net.mauro.Sorteig;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc implements Serializable{
  
  /**
   * array de cartes que formen la baralla.
   */
  private ArrayList<Carta> baralla;
  
  /**
   * array que conté els jugadors.
   */
  private ArrayList<Jugador> jugadors;
  
  /**
   * semafor que controla si els jugadors s'han quedat sense monedes.
   */
  private transient boolean fi;
  
  /**
   * arxiu que conté la serialització del programa.
   */
  private File fitxerSerial = new File("participants");
  
  /**
   * número de ronda del joc.
   */
  private int ronda = 0;
  
  /**
   * constructor del joc.
   * @param jugadorsJ jugadors del joc.
   * @throws IOException excepció d'errors de input, output.
   */
  public Joc( ArrayList<Jugador> jugadorsJ) throws IOException {

    this.jugadors = jugadorsJ;
    this.baralla = generarBaralla();
  }
  
  /**
   * metode que inicia el joc.
   * @param jugadors jugadors del joc.
   * @throws IOException excepció d'errors de input, output.
   * @throws ClassNotFoundException excepció d'errors.
   */
  public void començarJoc(ArrayList <Jugador> jugadors) throws IOException, ClassNotFoundException {
    
    Scanner lector = new Scanner(System.in);
    
    System.out.println("Comença el joc: ");
   
    int monedes = 0;
    
    
    while (!fi) {
      
      ronda++;
      System.out.println("Comença la ronda " + ronda);
 
      
      for (int i = 0;i < jugadors.size();i++) {
        System.out.println("El jugador " + jugadors.get(i).getNom() + " quantes monedes aposta? ");
        monedes = lector.nextInt();
        int monedesApostades = apostarMonedes(jugadors, monedes, i);
        if ((jugadors.get(i).getMonedes() == 0) || (jugadors.get(i).getMonedes() < 0)) {
          fi = true;
        }
        repartirCartes(jugadors, i, monedesApostades);
        for (int j = 0;j < jugadors.get(i).getCartes().size();j++) {
          System.out.println("Les seves cartes són: " + jugadors.get(i)
              .getCartes().get(j).getNumero());
        }
      
      }
    
      System.out.print("El guanyador de la ronda " + ronda + " es:");
      int cartaAlta = comprovarCartaAlta(jugadors);
      comprovarGuanyador(cartaAlta, jugadors);
      Principal.serialitzarObjecte();
    
    }
    
    
  }
  /**
   * Metode que comprova el guanyador de la ronda.
   * @param cartaAlta numero de la carta més alta de la ma dels jugadors.
   * @param jugadors jugadors de la ronda.
   */
  public void comprovarGuanyador(int cartaAlta, ArrayList<Jugador> jugadors) {
    
    String guanyador = "";
    for (int i = 0;i < jugadors.size();i++) {
      for (int j = 0;j < jugadors.get(i).getCartes().size();j++) {
        if (jugadors.get(i).getCartes().get(j).getNumero() == cartaAlta) {
          guanyador = jugadors.get(i).getNom();
        }
      }
    }
    System.out.println(" " + guanyador);
  }
  /**
   * Metode on s'aposten les monedes.
   * @param jugadors jugadors de la ronda.
   * @param monedes monedes que aposten.
   * @param i iterador per saber quin jugador aposta.
   * @return monedes apostades.
   * @throws IOException expeció d'errors entrada sortida.
   */
  public int apostarMonedes(ArrayList<Jugador> jugadors, int monedes, int i) throws IOException {

    jugadors.get(i).setMonedes(jugadors.get(i).getMonedes() - monedes);
    System.out.println("te " + jugadors.get(i).getMonedes() + " monedes");
    Principal.serialitzarObjecte();
    return monedes;
      
    
    
  }
  
  /**
   * Metode que genera la baralla de cartes.
   * @return un array de cartes.
   * @throws IOException excepció d'errors.
   */
  public ArrayList<Carta> generarBaralla() throws IOException {
    
    Baralla barall = new Baralla(baralla);
    ArrayList<Carta> cartes = barall.generarBaralla();
    Principal.serialitzarObjecte();
    return cartes;
    
  }
  /**
   * Metode que genera un numero aleatori.
   * @return el numero aleatori que sera la posició del array de cartes.
   */
  public int generarAleatori() {

    Random rn = new Random();
    int numCarta = 0;
  
    numCarta = rn.nextInt(baralla.size());
       
    return numCarta;
    
    
  }
  /**
   * Metode que reparteix les cartes.
   * @param jugadors jugadors de la ronda.
   * @param i iterador dels jugadors.
   * @param monedes monedes apostades.
   * @throws IOException exepció d'error.s
   */
  public void repartirCartes(ArrayList<Jugador> jugadors, int i, int monedes) throws IOException {
    
    ArrayList<Carta> cartes = new ArrayList<Carta>();
    int cont = 0;
    while (cont < monedes) {
      cartes.add(baralla.get(generarAleatori()));
      jugadors.get(i).setCartes(cartes);
      cont++;
            
    }
      
    Principal.serialitzarObjecte();
    
  }
  
  /**
   * Metode que comprova la carta alta, la guanyadora.
   * @param jugadors de la ronda.
   * @return la carta mes alta.
   */
  public int comprovarCartaAlta(ArrayList<Jugador> jugadors) {
    
    int primeraCarta = jugadors.get(0).getCartes().get(0).getNumero();
   
    for (int i = 0;i < jugadors.size();i++) {
      
      for (int j = 0;j < jugadors.get(i).getCartes().size();j++) {
        if (primeraCarta < jugadors.get(i).getCartes().get(j).getNumero()) {
          primeraCarta = jugadors.get(i).getCartes().get(j).getNumero();;
          
        }
        
      }
      
    }
    
    return primeraCarta;
  }
  

}
