package Elementos;

import Boulder.*;
import mapa.BDTile;

public abstract class Insecto extends Item {

	public Insecto(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Insecto() {
		
		// TODO Auto-generated constructor stub
	}

	private Direccion actual = new Direccion(DireccionEnum.IZQUIERDA);
	private boolean giroContrario = false;

	public boolean isGiro() {
		return giroContrario;
	}

	public void setGiro(boolean giro) {
		this.giroContrario = giro;
	}

	public Direccion getDireccion() {
		return actual;
	}

	public void setDireccion(Direccion actual) {
		this.actual = actual;
	}

	/**
	 * Reemplaza el item en la posicion dada por un elemento distinto,
	 * dependiendo del insecto.
	 */
	public abstract void reemplazoExplosion(Partida partida, PosXY posicion);

	/** Devuelve la direccion a la que va el insecto cuando gira. */
	public abstract Direccion girar();

	/**
	 * Devuelve la direccion a la que va el insecto cuando gira en sentido
	 * contrario al que debe ir.
	 */
	public abstract Direccion girarEnSentidoContrario();

	/** Retorna true si en la posicion a esta Rockford. */
	private boolean esRockford(Partida partida, PosXY posicion) {
		boolean aux = false;
		Mapa mapa = partida.getMapa();
		if (mapa.esDelTipo(posicion.getPosDir(DireccionEnum.ARRIBA),
				BDTile.PLAYER)
				|| mapa.esDelTipo(posicion.getPosDir(DireccionEnum.ABAJO),
						BDTile.PLAYER)
				|| mapa.esDelTipo(posicion.getPosDir(DireccionEnum.IZQUIERDA),
						BDTile.PLAYER)
				|| mapa.esDelTipo(posicion.getPosDir(DireccionEnum.DERECHA),
						BDTile.PLAYER)) {
			aux = true;
		}
		return aux;
	}

	/**
	 * Se encarga de evaluar si hay una explosion y producir el reemplazo de los
	 * casilleros.
	 */
	public boolean EvaluarExplotar(Partida partida, PosXY posicion) {
		Explosion explotar = new Explosion();
		boolean aux = false;
		aux = this.esRockford(partida, posicion);
		PosXY pos = new PosXY(new Integer(posicion.posX), new Integer(
				posicion.posY - 1));
		if ((aux)
				|| (!partida.getMapa().fueraDeRango(pos)
						&& (partida.getMapa().esDelTipo(pos,
								BDTile.FALLINGDIAMOND)) || (partida.getMapa()
						.esDelTipo(pos, BDTile.FALLINGROCK)))) {
			partida.reiniciarPartida();
			explotar.explotarInsecto(partida, posicion, this);
			return true;
		} else {
			return false;
		}
	}

	public void evaluar(Partida partida, PosXY posicion) {
		if (!EvaluarExplotar(partida, posicion)) {

			Mapa mapa = partida.getMapa();
			PosXY posEnDirActual = posicion.getPosDir(this.actual);
			Direccion dirGiroContrario = this.girarEnSentidoContrario();
			PosXY posEnDirGiroContrario = posicion.getPosDir(dirGiroContrario);

			if (mapa.esDelTipo(posEnDirGiroContrario, BDTile.EMPTY)) {
				mapa.moverEnDireccion(posicion, dirGiroContrario);
				this.actual = dirGiroContrario;
			} else {
				if (mapa.esDelTipo(posEnDirActual, BDTile.EMPTY)) {
					mapa.moverEnDireccion(posicion, actual);
				} else {
					this.actual = this.girar();
				}
			}
		}
	}
}