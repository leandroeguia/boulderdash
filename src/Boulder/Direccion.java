package Boulder;

/** Sirve como "wrapper" del enumerativo DireccionEnum. */
public class Direccion {

	private DireccionEnum dir;

	/**
	 * constructor de clase vacio.
	 */
	public Direccion() {
	}

	/** Genera una instancia de Direccion con el enumerativo dado por a. */
	public Direccion(DireccionEnum dir) {
		this.dir = dir;
	}
	/**Cambia la direccion, por una recibida.
	 * @param dir: Direccion nueva.
	 * */
	public void setDireccion(DireccionEnum dir) {
		this.dir = dir;
	}

	/**
	 * Retorna una direccion
	 * 
	 */
	public DireccionEnum getDireccionEnum() {
		return this.dir;
	}

	/** Gira la direccion dir en sentido de las agujas del reloj. */
	public Direccion girarSentidoReloj() {
		switch (dir) {
		case ARRIBA:
			this.dir = DireccionEnum.DERECHA;
			break;
		case DERECHA:
			this.dir = DireccionEnum.ABAJO;
			break;
		case ABAJO:
			this.dir = DireccionEnum.IZQUIERDA;
			break;
		case IZQUIERDA:
			this.dir = DireccionEnum.ARRIBA;
			break;
		default:
			break;
		}
		return new Direccion(this.dir);
	}

	/** Gira la direccion dir en sentido contrario a las agujas del reloj. */
	public Direccion girarSentidoAntiReloj() {
		switch (dir) {
		case ARRIBA:
			this.dir = DireccionEnum.IZQUIERDA;
			break;
		case DERECHA:
			this.dir = DireccionEnum.ARRIBA;
			break;
		case ABAJO:
			this.dir = DireccionEnum.DERECHA;
			break;
		case IZQUIERDA:
			this.dir = DireccionEnum.ABAJO;
			break;
		default:
			break;
		}
		return new Direccion(this.dir);
	}

}
