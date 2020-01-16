package datos;

import java.io.Serializable;

/**
 * Representa los jugadores en el ranking del juego.
 * 
 * @see ListaRanking
 */
public class JugadorEnRanking implements Comparable<JugadorEnRanking>,
		Serializable {
	private static final long serialVersionUID = 1L;

	/** Nombre del jugador. */
	private String jugador;
	/** Cantidad de diamantes obtenidos. */
	private int diamantes;
	/** Nivel en el que jugador esta. */
	private int nivel;
	/** Tiempo que consiguio el jugador. */
	private int tiempo;
	
	/**
	 * constructor de clase vacio
	 */

	public JugadorEnRanking(){
		
	}
	
	/**
	 * Constructor de clase, completo.
	 * @param jugador: nombre dle jugador
	 * @param diamantes : cantidad de diamantes obtenidos
	 * @param nivel : nivel alcanzado
	 * @param tiempo : tiempo restante.
	 */
	public JugadorEnRanking(String jugador, int diamantes, int nivel, int tiempo) {
		this.jugador = jugador;
		this.diamantes = diamantes*10;
		this.nivel = nivel;
		this.tiempo = tiempo;
	}



	/**
	 * Devuelve un arreglo con los datos del jugador.
	 * 
	 * @see ModeloRanking
	 */
	public Object[] getJugadorEnRanking() {
		Object[] jugadorEnRanking = new Object[4];

		jugadorEnRanking[0] = this.jugador;
		jugadorEnRanking[1] = this.diamantes;
		jugadorEnRanking[2] = this.nivel;
		jugadorEnRanking[3] = this.tiempo;

		return jugadorEnRanking;
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public int getDiamantes() {
		return diamantes;
	}

	public void setDiamantes(int diamantes) {
		this.diamantes = diamantes*10;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * Compara si un jugador debe ir arriba o abajo de otro en el ranking. No
	 * compara si dos jugadores son iguales porque no hace falta.
	 */
	@Override
	public int compareTo(JugadorEnRanking o) {
		if (this.nivel > o.nivel) {
			return 1;
		}
		if (this.nivel == o.nivel) {
			if (this.diamantes > o.diamantes) {
				return 1;
			}
		}
		return -1;
	}
}
