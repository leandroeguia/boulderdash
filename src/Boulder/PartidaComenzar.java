package Boulder;

import javax.swing.JFrame;

import ventanas.VentanaPartida;

/**
 * Clase que comienza una partida
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class PartidaComenzar {

	public void comenzar(int nivel) {

		Direccion dir = new Direccion(DireccionEnum.NULL);

		VentanaPartida ventana = new VentanaPartida();

		Partida partida = new Partida(nivel, dir);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.setVisible(true);

		ventana.setEnabled(true);

		Teclado tecla = new Teclado(dir);

		ventana.setFocusable(true);

		ventana.addKeyListener(tecla);

	
		ImpresionThread thread = new ImpresionThread(ventana);
		
		thread.start();
		
		partida.iniciarPartida();

		

	}
	
	

}