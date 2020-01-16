package Elementos;

import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

public class Suciedad extends Item {

	public Suciedad(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Suciedad() {
		
		// TODO Auto-generated constructor stub
	}

	public void evaluar(Partida partida, PosXY pos) {
	}

	@Override
	public BDTile getTipo() {
		return BDTile.DIRT;
	}

}
