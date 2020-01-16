package Elementos;

import mapa.BDTile;
import Boulder.Partida;
import Boulder.PosXY;

public class ExplosionElemento extends Item {

	public ExplosionElemento(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public ExplosionElemento() {
	
		// TODO Auto-generated constructor stub
	}

	int i = 5;

	@Override
	public void evaluar(Partida partida, PosXY posicion) {
		if (i == 0) {
			partida.getMapa().setElemento(posicion, new Vacio());
		} else {
			i = i - 1;
		}
	}

	@Override
	public BDTile getTipo() {
		// TODO Auto-generated method stub
		return null;
	}


	//public BDTile getTipo() {
		//return BDTile.EXPLOSION;
	

}
