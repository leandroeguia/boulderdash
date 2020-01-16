package Elementos;

import java.util.Random;

import Boulder.*;
import mapa.BDTile;

public class Ameba extends Item {

	public Ameba(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Ameba() {
		
	}

	private static int vel = 60;

	private Random r = new Random();

	/**
	 * Evalua si es se expandira o no la ameba.
	 */
	@Override
	public void evaluar(Partida partida, PosXY posicion) {
		if (r.nextInt(vel) == 0) {
			this.expandirseAPosAleatoria(partida.getMapa(), posicion);
		}
	}

	/**
	 * Crea una nueva ameba en una direccion aleatoria contigua a la ameba
	 * original.
	 */
	private void expandirseAPosAleatoria(Mapa mapa, PosXY posicion) {
		int direccion = r.nextInt(4);

		PosXY posNueva = null;

		switch (direccion) {
		case 0: // ARRIBA

			posNueva = new PosXY(posicion.getPosDir(DireccionEnum.ARRIBA));

			break;

		case 1: // ABAJO

			posNueva = new PosXY(posicion.getPosDir(DireccionEnum.ABAJO));

			break;

		case 2: // DERECHA

			posNueva = new PosXY(posicion.getPosDir(DireccionEnum.DERECHA));

			break;

		case 3: // IZQUIERDA

			posNueva = new PosXY(posicion.getPosDir(DireccionEnum.IZQUIERDA));

			break;
		}

		if (puedeCrearAmebaEnPos(mapa, posNueva)) {

			if (vel > 1)

				vel--;

			System.out.print("La ameba en " + posicion + " se expandi� ");

			mapa.setElemento(posNueva, new Ameba());

			switch (direccion) {
			case 0: // ARRIBA

				System.out.println(DireccionEnum.ARRIBA);

				break;

			case 1: // ABAJO

				System.out.println(DireccionEnum.ABAJO);

				break;

			case 2: // DERECHA

				System.out.println(DireccionEnum.DERECHA);

				break;

			case 3: // IZQUIERDA

				System.out.println(DireccionEnum.IZQUIERDA);

				break;
			}

		}
	}

	/** Retorna true si puede crear una ameba nueva en la posicion dada por pos. */
	private boolean puedeCrearAmebaEnPos(Mapa mapa, PosXY pos) {
		return ((!mapa.fueraDeRango(pos)) && ((mapa.getElemento(pos).getTipo() == BDTile.DIRT) || (mapa
				.getElemento(pos).getTipo() == BDTile.EMPTY)));
	}

	
	/**
	 * retorna el tipo de ameba.
	 */
	@Override
	public BDTile getTipo() {

		return BDTile.AMOEBA;
	}

}
