package Elementos;

import mapa.BDTile;
import Boulder.Direccion;
import Boulder.Partida;
import Boulder.PosXY;

public class Mariposa extends Insecto {

	public Mariposa(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Mariposa() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public BDTile getTipo() {
		return BDTile.BUTTERFLY;
	}

	@Override
	public void reemplazoExplosion(Partida partida, PosXY posicion) {
		partida.getMapa().setElemento(posicion, new Diamante());
	}

	@Override
	public Direccion girar() {
		return new Direccion(this.getDireccion().getDireccionEnum())
				.girarSentidoAntiReloj();
	}

	@Override
	public Direccion girarEnSentidoContrario() {
		return new Direccion(this.getDireccion().getDireccionEnum())
				.girarSentidoReloj();
		// Direccion dir = new
		// Direccion(this.getDireccion().getDireccionEnum());
		// dir.girarSentidoReloj();
		// if (partida.getMapa().posicionSiguienteVacio(posicion, dir)) {
		// this.setDireccion(dir);
		// }
	}

}
