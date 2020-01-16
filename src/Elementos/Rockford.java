package Elementos;

import datos.EstadoJuego;
import datos.ReproductorSonido;
import datos.SonidoEnum;
import Boulder.Direccion;
import Boulder.DireccionEnum;
import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

public class Rockford extends Item {
	
	private int diamantes = 0;

	public Rockford(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Rockford() {
		
		// TODO Auto-generated constructor stub
	}



	public int getDiamantes() {

		return this.diamantes;
	}

	public void setDiamantes(int diamantes) {
		this.diamantes = diamantes;
	}

	public void evaluar(Partida partida, PosXY posicion) {
	}

	/**
	 * Determina si Rockford puede moverse o no, si se mueve sobre un diamante
	 * (lo recoge) o sobre una roca (la mueve o no). (Como lo primero que se
	 * hace en un ciclo es el movimiento de Rockford, se usa este metodo aparte
	 * de evaluar).
	 */
	public PosXY mover(Direccion dir, PosXY posicion, Partida part) {

		PosXY posAux = posicion; // Se usa para devolver la posicion final

		if (!(part.getMapa().fueraDeRango(posicion.getPosDir(dir)))) {

			BDTile aux = part.getMapa().getElemento(posicion.getPosDir(dir))
					.getTipo();

			if (aux == BDTile.EXIT && part.getExit()) {

				part.guardarRanking();

				EstadoJuego estado = EstadoJuego.crearEstadoJuego();

				estado.setPuntaje(estado.getPuntaje() + estado.getTiempo());

				part.finalizarPartida();

				part.getMapa().setElemento(posicion, new Vacio());

			} else {

				if ((aux == BDTile.EMPTY) || (aux == BDTile.DIAMOND)
						|| (aux == BDTile.DIRT)) {

					if (aux == BDTile.DIAMOND) {

						this.diamantes++;

						ReproductorSonido.reproducirSonido(SonidoEnum.DIAMANTE);

						EstadoJuego.crearEstadoJuego()
								.setPuntaje(
										EstadoJuego.crearEstadoJuego()
												.getPuntaje() + 10);
					} else {
						ReproductorSonido.reproducirSonido(SonidoEnum.PASO);
					}

					ReproductorSonido.reproducirSonido(SonidoEnum.PASO);

					part.getMapa().moverEnDireccion(posicion, dir); // Se mueve
																	// a
																	// una
					// posicion vacia o
					// con diamante

					posAux = posicion.getPosDir(dir);

				} else {// //Evalua si puede mover una roca

					if (dir.getDireccionEnum() == DireccionEnum.IZQUIERDA
							|| (dir.getDireccionEnum() == DireccionEnum.DERECHA)
							&& (part.getMapa()
									.getElemento(posicion.getPosDir(dir))
									.getTipo() == BDTile.ROCK)) {

						PosXY posRoca = posicion.getPosDir(dir); // Posicion de
																	// la
																	// roca

						if (part.getMapa().posicionSiguienteVacio(posRoca, dir)) {

							part.getMapa().moverEnDireccion(posRoca, dir);

							part.getMapa().moverEnDireccion(posicion, dir);

							ReproductorSonido
									.reproducirSonido(SonidoEnum.MUEVEROCA);

							posAux = posRoca;

						}

					}

				}

			}

		}

		return posAux;
	}

	public BDTile getTipo() {
		return BDTile.PLAYER;
	}

	public String toString() {
		return "Rockford";
	}

}