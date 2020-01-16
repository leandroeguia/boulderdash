package Boulder;

import datos.ReproductorSonido;
import datos.SonidoEnum;
import mapa.BDTile;
import Elementos.ExplosionElemento;
import Elementos.Insecto;

public class Explosion {

	/**
	 * @author Bonansea Nahuel, Eguia Leandro
	 * Reemplaza el conjunto de casilleros alrededor del parametro posicion en
	 * la explosion de un insecto.
	 */
	public void explotarInsecto(Partida partida, PosXY posicion, Insecto insecto) {

		PosXY posReemplazo = new PosXY();

		for (int i = (posicion.posX - 1); i <= (posicion.posX + 1); i++) {
			for (int j = (posicion.posY - 1); j <= (posicion.posY + 1); j++) {
				posReemplazo.setPosX(i);
				posReemplazo.setPosY(j);
				if (!(partida.getMapa().fueraDeRango(posReemplazo)
						|| partida.getMapa().esDelTipo(posReemplazo,
								BDTile.EXIT) || partida.getMapa().esDelTipo(
						posReemplazo, BDTile.TITANIUM))) {
					insecto.reemplazoExplosion(partida, posReemplazo);
				}
			}
		}

		ReproductorSonido.reproducirSonido(SonidoEnum.EXPLOSION);
	}

	/**
	 * Reemplaza el conjunto de casilleros alrededor del parametro posicion en
	 * una explosion.
	 */
	public void explotar(Partida partida, PosXY posicion) {

		PosXY posReemplazo = new PosXY();
		posicion.setPosY(posicion.getPosY() + 1);

		for (int i = (posicion.posX - 1); i <= (posicion.posX + 1); i++) {
			for (int j = (posicion.posY - 1); j <= (posicion.posY + 1); j++) {
				posReemplazo.setPosX(i);
				posReemplazo.setPosY(j);
				if (!(partida.getMapa().fueraDeRango(posReemplazo)
						|| partida.getMapa().esDelTipo(posReemplazo,
								BDTile.EXIT) || partida.getMapa().esDelTipo(
						posReemplazo, BDTile.TITANIUM))) {
					partida.getMapa().setElemento(posReemplazo,
							new ExplosionElemento(j, j));
				}
			}
		}

		ReproductorSonido.reproducirSonido(SonidoEnum.EXPLOSION);
	}
}
