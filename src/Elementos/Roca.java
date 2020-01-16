package Elementos;

import Boulder.Explosion;
import Boulder.Partida;
import Boulder.PosXY;
import mapa.BDTile;

public class Roca extends ItemCaible {

	@Override
	public BDTile getTipo() {
		if (isCayendo()) {
			return BDTile.FALLINGROCK;
		} else {
			return BDTile.ROCK;
		}
	}

	@Override
	public void caeSobreRockford(Partida partida, PosXY posicion) {
		Explosion explosion = new Explosion();
		explosion.explotar(partida,
				new PosXY(posicion.getPosX(), posicion.getPosY() + 1));
		partida.reiniciarPartida();
	}

}
