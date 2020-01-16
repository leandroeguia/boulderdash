package Boulder;

import java.util.concurrent.TimeUnit;

import datos.EstadoJuego;
/**
 * Clase encargada de manejar el tiempo de juego.
 * @author Bonansea Nahuel, Leandro Eguia
 *
 */
public class Reloj extends Thread {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {

		EstadoJuego estado = EstadoJuego.crearEstadoJuego();

		while (!estado.isFinalizar()) {

			estado.setTiempo(estado.getTiempo() - 1);

			if (estado.getTiempo() == 0) {

				estado.setTiempoFin(true);

			}
			if (!estado.isFinalizar()) {
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			} else

				this.stop();

		}
	}
}