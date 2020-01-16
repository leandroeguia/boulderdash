package Elementos;

import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

public class Puerta extends Muro {

	public Puerta(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Puerta() {
		
		// TODO Auto-generated constructor stub
	}

	private boolean puerta = false;

	public void evaluar(Partida partida, PosXY posicion) {
		if (partida.getNumeroDiamantes() == partida.getJugador().getDiamantes()) {
			puerta = true;
		}
	}

	@Override
	public BDTile getTipo() {
		if (!puerta) {
			return BDTile.TITANIUM;
		} else {
			return BDTile.EXIT;
		}
	}

	boolean isPuerta() {
		return puerta;
	}

	void setPuerta(boolean puerta) {
		this.puerta = puerta;
	}

}

