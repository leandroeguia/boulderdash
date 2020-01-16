package Elementos;

import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

public class Vacio extends Item {

	public Vacio(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Vacio() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void evaluar(Partida partida, PosXY posicion) {
	}

	@Override
	public BDTile getTipo() {
		return BDTile.EMPTY;
	}

}

