package Elementos;

import datos.ReproductorSonido;
import datos.SonidoEnum;
import Boulder.*;
import mapa.BDTile;

public abstract class ItemCaible extends Item {

	public ItemCaible(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public ItemCaible() {
		
		// TODO Auto-generated constructor stub
	}

	private boolean cayendo = false;

	/**
	 * Lleva a cabo el comportamiento del item cuando este cae sobre el jugador.
	 */
	public abstract void caeSobreRockford(Partida partida, PosXY posicion);

	public DireccionEnum caeALosCostados(Partida partida, PosXY posicion) {

		Mapa mapa = partida.getMapa();

		BDTile elemDebajo = mapa.getElemento(
				posicion.getPosDir(DireccionEnum.ABAJO)).getTipo();

		if (elemDebajo == BDTile.TITANIUM || elemDebajo == BDTile.ROCK
				|| elemDebajo == BDTile.WALL || elemDebajo == BDTile.DIAMOND) {

			BDTile elemIzq = mapa.getElemento(
					posicion.getPosDir(DireccionEnum.IZQUIERDA)).getTipo();

			PosXY auxIzq = posicion.getPosDir(DireccionEnum.IZQUIERDA)
					.getPosDir(DireccionEnum.ABAJO);

			if (elemIzq == BDTile.EMPTY
					&& mapa.getElemento(auxIzq).getTipo() == BDTile.EMPTY) {

				return DireccionEnum.IZQUIERDA;

			} else {

				BDTile elemDer = mapa.getElemento(
						posicion.getPosDir(DireccionEnum.DERECHA)).getTipo();

				PosXY auxDer = posicion.getPosDir(DireccionEnum.DERECHA)
						.getPosDir(DireccionEnum.ABAJO);

				if (elemDer == BDTile.EMPTY
						&& mapa.getElemento(auxDer).getTipo() == BDTile.EMPTY) {

					return DireccionEnum.DERECHA;

				} else

					return null;

			}

		} else

			return null;

	}

	public void evaCayendo(Partida partida, PosXY posicion) {

		Mapa mapa = partida.getMapa();

		BDTile elemDebajo = mapa.getElemento(
				posicion.getPosDir(DireccionEnum.ABAJO)).getTipo();

		if (elemDebajo == BDTile.EMPTY) {

			mapa.moverAbajo(posicion);

		}

		else {

			DireccionEnum dir = this.caeALosCostados(partida, posicion);

			if (dir != null) {

				mapa.moverEnDireccion(posicion, new Direccion(dir));

				ReproductorSonido.reproducirSonido(SonidoEnum.MUEVEROCA);

			}

			else {

				if (elemDebajo == BDTile.PLAYER) {

					this.caeSobreRockford(partida, posicion);
				}

				else {

					ReproductorSonido.reproducirSonido(SonidoEnum.MUEVEROCA);

					this.cayendo = false;

				}

			}

		}

	}

	public void evaNoCayendo(Partida partida, PosXY posicion) {

		Mapa mapa = partida.getMapa();

		BDTile elemDebajo = mapa.getElemento(
				posicion.getPosDir(DireccionEnum.ABAJO)).getTipo();

		if (elemDebajo == BDTile.EMPTY) {

			this.cayendo = true;

		} else {

			DireccionEnum dir = this.caeALosCostados(partida, posicion);

			if (dir != null) {

				this.cayendo = true;

			}

		}

	}

	public void evaluar(Partida partida, PosXY posicion) {

		if (this.cayendo) {

			this.evaCayendo(partida, posicion);

		} else {

			this.evaNoCayendo(partida, posicion);

		}
	}

	public boolean isCayendo() {
		return cayendo;
	}

	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
	}

}