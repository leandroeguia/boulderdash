package Boulder;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

/**
 * Clase encargada de leer el teclado
 * @author Bonansea Nahuel, Eguia Leandro
 *
 */

public class Teclado implements KeyListener {

	private Direccion dir = new Direccion();

	public Teclado(Direccion dir) {

		this.dir = dir;

	}
	/**
	 * Lee las teclas precionadas y las convierte en tipos de direccion enumerativos.
	 */
	@Override
	public void keyPressed(KeyEvent evento) {

		int tecla = evento.getKeyCode();

		switch (tecla) {

		case 38:

			dir.setDireccion(DireccionEnum.ARRIBA);

			break;

		case 40:

			dir.setDireccion(DireccionEnum.ABAJO);

			break;

		case 39:

			dir.setDireccion(DireccionEnum.DERECHA);

			break;

		case 37:

			dir.setDireccion(DireccionEnum.IZQUIERDA);

			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}