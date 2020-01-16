package Elementos;

import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

public class Magico extends Muro {

	public Magico(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Magico() {
		
		// TODO Auto-generated constructor stub
	}

	public void evaluar(Partida partida, PosXY posicion) {
	}

	@Override
	public BDTile getTipo() {
		return BDTile.WALL;
	}

}