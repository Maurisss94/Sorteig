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
  
  static ArrayList<Jugador> array;
  
  static File fitxerSerialitzacio = new File("participants");
 

  public static void main(String[] args) throws IOException, ClassNotFoundException{
    
    if(!fitxerSerialitzacio.exists()){
      
    array= crearJugadors();
    Joc joc = new Joc(array);
    joc.començarJoc(array);
    }else{
      deserialitzacioObjecte();
      Joc joc = new Joc(array);
      joc.començarJoc(array);
    }
    

  }
  public static ArrayList<Jugador> crearJugadors() throws IOException, ClassNotFoundException{
    
    Scanner lector = new Scanner(System.in);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    
    System.out.println("Quants jugadors hi ha? ");
    int numJugadors = lector.nextInt();
    
    for(int i=0;i<numJugadors;i++){
      System.out.println("Escriu el nom del jugador: ");
      String nomJugador = lector.next();
      Jugador jugador = new Jugador(nomJugador, 10);
      
      jugadors.add(jugador);
    }
    
    serialitzarObjecte();
    
    
    return jugadors;
  }
  
  public static void serialitzarObjecte() throws IOException{
    FileOutputStream file = new FileOutputStream("participants");
    ObjectOutputStream out = new ObjectOutputStream(file);
    out.writeObject(array);
    System.out.println("Serialitzat");
  }
  public static void deserialitzacioObjecte() throws IOException, ClassNotFoundException{
    
    FileInputStream file = new FileInputStream("participants");
    ObjectInputStream in = new ObjectInputStream(file);
    array= (ArrayList<Jugador>) in.readObject();
    
  }
  
 

}
