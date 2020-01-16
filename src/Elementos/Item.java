package Elementos;

import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

/** Representa todos los items que pueden existir en el mapa del juego. */
public abstract class Item {

	private boolean yaSeActualizo = false;
	
	private PosXY ubicacion;
	
	public Item(int x, int y) {
		// TODO Auto-generated constructor stub
		setUbicacion(new PosXY(x,y));
	}
	public Item() {
		// TODO Auto-generated constructor stub
		
	}

	public void SetSeActualizo(boolean yaSeActualizo) {

		this.yaSeActualizo = yaSeActualizo;

	}

	public boolean getSeActualizo() {

		return this.yaSeActualizo;
	}

	/**
	 * Evalua y ejecuta las acciones que puede realizar el item en un ciclo.
	 * 
	 * @see Partida#ciclo
	 */
	public abstract void evaluar(Partida partida, PosXY posicion);

	/** Devuelve el tipo de item en forma de enumerativo BDTile. */
	public abstract BDTile getTipo();

	/**
	 * Convierte una instancia de Item a un formato legible, basado en el
	 * enumerativo BDTile.
	 */
	public String toString() {
		return this.getTipo().toString();
	}

	public PosXY getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(PosXY ubicacion) {
		this.ubicacion = ubicacion;
	}
}
