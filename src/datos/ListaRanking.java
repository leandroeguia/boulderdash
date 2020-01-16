package datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Lista que contiene los jugadores en el ranking. Solo puede haber una sola
 * instancia de la lista, que se llama a traves de getInstance().
 * 
 * @author Bonansea Nahuel Eguia Leandro
 * 
 * @see JugadorEnRanking
 */
public class ListaRanking {

	private static ListaRanking listaRanking;
	/**
	 * Determina donde se guarda o se lee la lista. Usado por los metodos save()
	 * y load().
	 */
	private static String filename = "ranking.ser";

	private ArrayList<JugadorEnRanking> lista;
	private final int TAMANIO_MAXIMO = 10;

	/** Devuelve la unica instancia de la lista, o la crea si no existe. */
	public static ListaRanking getInstance() {
		if (listaRanking == null) {
			listaRanking = new ListaRanking();
		}
		return listaRanking;
	}

	/**
	 * Constructor de clase
	 */
	private ListaRanking() {
		lista = new ArrayList<JugadorEnRanking>();
	}

	/**
	 * Agrega un jugador al ranking de forma ordenada. Si la cantidad de
	 * jugadores en el ranking nuevo supera la cantidad maxima permitida, se
	 * elimina el ultimo jugador.
	 */
	public void add(JugadorEnRanking jugador) {
		lista.add(jugador);
		Collections.sort(lista, Collections.reverseOrder());
		if (lista.size() > TAMANIO_MAXIMO) {
			lista.remove(lista.size() - 1);
		}
	}
	
	/**
	 * 
	 * @return Retorna el tamaño de la lista
	 */

	public int size() {
		return lista.size();
	}

	public JugadorEnRanking get(int i) {
		return (i >= 0 || i < lista.size()) ? lista.get(i) : null;
	}

	/**
	 * Guarda la lista en un archivo (cuyo nombre esta dado por filename) como
	 * un objeto. Si el archivo no existe, se crea un archivo que contiene la
	 * lista vacia.
	 */
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lista);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lee la lista como un objeto desde un archivo (cuyo nombre esta dado por
	 * filename) y reemplaza la instancia actual por la del archivo. Si el
	 * archivo no existe, se llama a save().
	 */
	@SuppressWarnings("unchecked")
	public void load() {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			lista = (ArrayList<JugadorEnRanking>) ois.readObject();
			ois.close();
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir " + filename
					+ ". Se crea un archivo vacio");
			this.save();
		} catch (StreamCorruptedException e) {
			System.out.println("El archivo " + filename
					+ " esta corrompido. Se crea un archivo vacio");
			this.save();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
