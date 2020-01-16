package Boulder;

import java.util.concurrent.TimeUnit;

import datos.EstadoJuego;

import ventanas.VentanaPartida;

/**
 * Clase que maneja los hilos de juego, cotiene los metodos necesarios para modificar el estado del juego y su visualizacion.
 * @author Bonansea Nahuel, Eguia Leandro
 *
 */
public class ImpresionThread extends Thread {

	private VentanaPartida ventana;

	private EstadoJuego estadoJuego;
	
	public ImpresionThread(VentanaPartida ventana) {

		this.setVentana(ventana);
		
		this.estadoJuego = EstadoJuego.crearEstadoJuego();
		
		
		
		

	}
	
	/**
	 * Corre los hilos, haciendo que se mueva el juego.
	 */

	public void run() {

		while (!this.estadoJuego.isFinalizar()) {

			getVentana().actualizar();

			try {
				TimeUnit.MILLISECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		if(this.estadoJuego.isFinalizar()){
			
			ventana.dispose();
		}

		}
	}

	/**
	 * 
	 * @return Retorna el estado del juego en un momento dado.
	 */
	public EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}

	/**
	 *  Cambia el estado del juego, porel nuevo que entra como parametro
	 * @param estadoJuego: nuevo estado.
	 */
	public void setEstadoJuego(EstadoJuego estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	/**
	 * @return Retorna la ventana de juego.
	 * 
	 */
	public VentanaPartida getVentana() {
		return ventana;
	}

	/**
	 * Actualiza la ventana con una nueva que viene por parametro
	 * @param ventana : Nueva ventana.
	 */
	public void setVentana(VentanaPartida ventana) {
		this.ventana = ventana;
	}

}