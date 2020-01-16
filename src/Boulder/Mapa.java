package Boulder;

import Elementos.Item;
import Elementos.Vacio;
import mapa.BDTile;

/** 
 * @author Bonansea Nahuel, Eguia Leandro
 * Almacena el tablero en forma de matriz de instancias de clases Item. */
public class Mapa {

	private static Mapa mapa = null;

	private Mapa() {

	}

	public static Mapa crearMapa() {

		if (mapa == null) {

			mapa = new Mapa();

		}

		return mapa;

	}

	public Item[][] matriz;

	private int tamañoY;

	private int tamañoX;
	
	/**
	 *
	 * @return Retorna el tamaño en alto del mapa
	 */

	public int getTamañoY() {
		return tamañoY;
	}
	
	/**
	 * Cambia el alto del mapa
	 * @param Nuevo alto
	 */

	public void setTamañoY(int tamañoY) {
		this.tamañoY = tamañoY;
	}

	/**
	 *
	 * @return Retorna el tamaño en ancho del mapa
	 */
	
	public int getTamañoX() {
		return tamañoX;
	}

	/**
	 * Cambia el ancho del mapa
	 * @param Nuevo ancho
	 */
	
	public void setTamañoX(int tamañoX) {
		this.tamañoX = tamañoX;
	}

	/** Modifica el elemento en una posicion dada del tablero. */
	public void setElemento(PosXY pos, Item elemento) {

		this.matriz[pos.posX][pos.posY] = elemento;

	}

	/**
	 * Cambia el mapa actual por uno nuevo que viene por parametro
	 * @param matriz: Nuevo mapa
	 */
	public void setMapa(Item[][] matriz) {

		this.matriz = matriz;

	}

	/** Obtiene el elemento en una posicion dada del tablero */
	public Item getElemento(PosXY elem) {

		Item aux = this.getMapa()[elem.posX][elem.posY];

		return aux;

	}

	/**
	 * 
	 * @return retorna la matriz del mapa
	 */
	public Item[][] getMapa() {

		return matriz;

	}

	/** Evalua si una posicion esta fuera de las dimensiones de la matriz. */
	public boolean fueraDeRango(PosXY pos) {

		if ((pos.posX < 0) || (pos.posX > this.tamañoX) || (pos.posY < 0)
				|| (pos.posY > this.tamañoY)) {

			return true;

		} else {

			return false;
		}

	}

	/**
	 * Si la posicioo abajo de la posicion dada existe en la matriz y esta
	 * vacia, devuelve true.
	 */
	public boolean abajoVacio(PosXY a) {
		return ((a.getPosY() < tamañoY - 1) && (this.getElemento(
				a.getPosDir(DireccionEnum.ABAJO)).getTipo() == BDTile.EMPTY));
	}

	/**
	 * Dada una posicion original, se mueve el elemento en esa posicion a la
	 * posicion de arriba y se deja en la posicion original un casillero vacio.
	 * La posicion debe estar dentro de la matriz.
	 */
	public Item moverArriba(PosXY b) {

		Item aux = matriz[b.getPosX()][b.getPosY() - 1];

		System.out.println("Se mueve " + this.getElemento(b) + " en " + b
				+ " hacia arriba");

		matriz[b.getPosX()][b.getPosY() - 1] = matriz[b.getPosX()][b.getPosY()];

		matriz[b.getPosX()][b.getPosY()] = new Vacio();

		return aux;

	}

	/**
	 * Dada una posicion original, se mueve el elemento en esa posicion a la
	 * posicion de abajo y se deja en la posicion original un casillero vacio.
	 * La posicion debe estar dentro de la matriz.
	 */
	public Item moverAbajo(PosXY b) {

		Item aux = matriz[b.getPosX()][b.getPosY() + 1];

		System.out.println("Se mueve " + this.getElemento(b) + " en " + b
				+ " hacia abajo");

		matriz[b.getPosX()][b.getPosY() + 1] = matriz[b.getPosX()][b.getPosY()];

		matriz[b.getPosX()][b.getPosY()] = new Vacio();

		return aux;
	}

	/**
	 * Dada una posicion original, se mueve el elemento en esa posicion a la
	 * posicion a su derecha y se deja en la posicion original un casillero
	 * vacio. La posicion debe estar dentro de la matriz.
	 */
	public Item moverDerecha(PosXY b) {

		Item aux = matriz[b.getPosX() + 1][b.getPosY()];

		System.out.println("Se mueve " + this.getElemento(b) + " en " + b
				+ " hacia derecha");

		matriz[b.getPosX() + 1][b.getPosY()] = matriz[b.getPosX()][b.getPosY()];

		matriz[b.getPosX()][b.getPosY()] = new Vacio();

		return aux;

	}

	/**
	 * Dada una posicion original, se mueve el elemento en esa posicion a la
	 * posicion a su izquierda y se deja en la posicion original un casillero
	 * vacio. La posicion debe estar dentro de la matriz.
	 */
	public Item moverIzquierda(PosXY b) {

		Item aux = matriz[b.getPosX() - 1][b.getPosY()];

		System.out.println("Se mueve " + this.getElemento(b) + " en " + b
				+ " hacia izquierda");

		matriz[b.getPosX() - 1][b.getPosY()] = matriz[b.getPosX()][b.getPosY()];

		matriz[b.getPosX()][b.getPosY()] = new Vacio();

		return aux;

	}

	/**
	 * Retorna true si el objeto en la posicion dada de la matriz es el
	 * especificado por tipo.
	 */
	public boolean esDelTipo(PosXY a, BDTile tipo) {

		if (!this.fueraDeRango(a))

			return (this.getElemento(a).getTipo() == tipo);

		else

			return false;

	}

	/**
	 * Si la posicion en la direccion dada respecto de la posicion a esta vacia
	 * (y existe en la matriz) devuelve true.
	 */
	public boolean posicionSiguienteVacio(PosXY a, Direccion b) {

		boolean auxi = false;

		switch (b.getDireccionEnum()) {

		case ABAJO:

			if (this.abajoVacio(a))

				auxi = true;

			break;

		case ARRIBA:

			PosXY aux = new PosXY(a.posX, a.posY - 1);

			if (!this.fueraDeRango(aux) && this.esDelTipo(aux, BDTile.EMPTY))

				auxi = true;

			break;

		case DERECHA:

			aux = new PosXY(a.posX + 1, a.posY);

			if (!this.fueraDeRango(aux) && this.esDelTipo(aux, BDTile.EMPTY))

				auxi = true;

			break;

		case IZQUIERDA:

			aux = new PosXY(a.posX - 1, a.posY);

			if (!this.fueraDeRango(aux) && this.esDelTipo(aux, BDTile.EMPTY))

				auxi = true;

			break;

		default:

			break;

		}

		return auxi;

	}

	/**
	 * Llama a los metodos que permiten mover al elemento en a de acuerdo a la
	 * direccion b.
	 */
	public void moverEnDireccion(PosXY a, Direccion b) {

		switch (b.getDireccionEnum()) {

		case ABAJO:

			this.moverAbajo(a);

			break;

		case ARRIBA:

			this.moverArriba(a);

			break;

		case DERECHA:

			this.moverDerecha(a);

			break;

		case IZQUIERDA:

			this.moverIzquierda(a);

			break;

		default:

			break;

		}

	}
}