package Elementos;

import Boulder.Partida;

import Boulder.PosXY;
import mapa.BDTile;

public class Titanio extends Muro {

	public Titanio(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Titanio() {
		
		// TODO Auto-generated constructor stub
	}


	public void evaluar(Partida partida, PosXY posicion) {
	}

	@Override
	public BDTile getTipo() {
		return BDTile.TITANIUM;
	}

}