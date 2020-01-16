package Elementos;

import mapa.BDTile;
import Boulder.Direccion;
import Boulder.Partida;
import Boulder.PosXY;

public class Luciernaga extends Insecto {

	public Luciernaga(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Luciernaga() {
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public BDTile getTipo() {
		return BDTile.FIREFLY;
	}

	@Override
	public void reemplazoExplosion(Partida partida, PosXY posicion) {
		partida.getMapa().setElemento(posicion, new ExplosionElemento());
	}

	@Override
	public Direccion girar() {
		return new Direccion(this.getDireccion().getDireccionEnum())
				.girarSentidoReloj();
	}

	@Override
	public Direccion girarEnSentidoContrario() {
		return new Direccion(this.getDireccion().getDireccionEnum())
				.girarSentidoAntiReloj();
		// Direccion dir = new
		// Direccion(this.getDireccion().getDireccionEnum());
		// dir.girarSentidoAntiReloj();
		// if (partida.getMapa().posicionSiguienteVacio(posicion, dir)) {
		// this.setDireccion(dir);
		// }
	}

}
