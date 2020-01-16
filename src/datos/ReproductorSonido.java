package datos;

/**
 * Reproductor de sonido
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class ReproductorSonido {

/**
 * Constructor de clase
 * @param sonido: sonido a reproducirse
 */
	
	public static void reproducirSonido(SonidoEnum sonido) {
		switch (sonido) {
		case PASO:
			play("resources/paso.wav");
			break;
		case MUEVEROCA:
			play("resources/mueveRoca.wav");
			break;
		case DIAMANTE:
			play("resources/diamante.wav");
			break;
		case EXPLOSION:
			play("resources/explosion.wav");
			break;
		case BOTON:
			play("resources/boton.wav");
			break;
		case VICTORIA:
			play("resources/victoria.wav");
			break;
		case DERROTA:
			play("resources/derrota.wav");
			break;
		case MENU:
			play("resources/untitled.wav");
			break;
		}
	}
	
	/**
	 * Reproduce el sonido
	 * @param filename: sonido a reproducir.
	 */

	private static void play(String filename) {
		AePlayWave aw = new AePlayWave(filename);
		aw.start();
		
		
	}
	
	

     }
