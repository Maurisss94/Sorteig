package net.mauro.Sorteig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal implements Serializable{
  
  /**
   * Array que consta dels jugadors.
   */
  private static ArrayList<Jugador> array;
  
  /**
   * Fitxer de serialització.
   */
  private static File fitxerSerialitzacio = new File("participants");
 

  /**
   * Metode principal on es crean els jugadors i el joc.
   * @param args arguments.
   * @throws IOException generació d'errors.
   * @throws ClassNotFoundException generació d'errors.
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    if (!fitxerSerialitzacio.exists()) {
      
      array = crearJugadors();
      Joc joc = new Joc(array);
      joc.començarJoc(array);
    } else {
      deserialitzacioObjecte();
      Joc joc = new Joc(array);
      joc.començarJoc(array);
    }
    

  }
  /**
   * Metode que crea els jugadors.
   * @return un array amb els jugadors.
   * @throws IOException generació d'errors.
   * @throws ClassNotFoundException generació d'errors.
   */
  public static ArrayList<Jugador> crearJugadors() throws IOException, ClassNotFoundException {
    
    Scanner lector = new Scanner(System.in);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    
    System.out.println("Quants jugadors hi ha? ");
    int numJugadors = lector.nextInt();
    
    for (int i = 0;i < numJugadors;i++) {
      System.out.println("Escriu el nom del jugador: ");
      String nomJugador = lector.next();
      Jugador jugador = new Jugador(nomJugador, 10);
      
      jugadors.add(jugador);
    }
    
    serialitzarObjecte();
    
    
    return jugadors;
  }
  
  /**
   * Metode que serialitza el programa.
   * @throws IOException generació d'errors.
   */
  public static void serialitzarObjecte() throws IOException {
    FileOutputStream file = new FileOutputStream("participants");
    ObjectOutputStream out = new ObjectOutputStream(file);
    out.writeObject(array);
    System.out.println("Serialitzat");
  }
  /**
   * Metode que recupera la serialitzacio del programa.
   * @throws IOException generació d'errors.
   * @throws ClassNotFoundException generació d'errors.
   */
  public static void deserialitzacioObjecte() throws IOException, ClassNotFoundException {
    
    FileInputStream file = new FileInputStream("participants");
    ObjectInputStream in = new ObjectInputStream(file);
    array = (ArrayList<Jugador>) in.readObject();
    
  }
  
 

}
