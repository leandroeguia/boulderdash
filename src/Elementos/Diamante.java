package Elementos;

import datos.ReproductorSonido;
import datos.SonidoEnum;
import mapa.BDTile;
import Boulder.Partida;
import Boulder.PosXY;

public class Diamante extends ItemCaible {

	public Diamante(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Diamante() {
		
	}

	@Override
	public BDTile getTipo() {
		if (isCayendo()) {
			return BDTile.FALLINGDIAMOND;
		} else {
			return BDTile.DIAMOND;
		}
	}

	@Override
	public void caeSobreRockford(Partida partida, PosXY posicion) {
		partida.getMapa().setElemento(posicion, new Vacio());
		partida.getJugador().setDiamantes(
				partida.getJugador().getDiamantes() + 1);
		ReproductorSonido.reproducirSonido(SonidoEnum.DIAMANTE);
	}
}
