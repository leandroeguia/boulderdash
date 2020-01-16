package Boulder;

public class PosXY {

	public int posX;

	public int posY;

	public PosXY() {

	}

	/**
	 * Constructor de clase
	 * @param pos
	 */
	public PosXY(PosXY pos) {

		this.posX = pos.getPosX();

		this.posY = pos.getPosY();

	}

	/** Genera una instancia de PosXY con las coordenadas dadas por dos enteros. */
	public PosXY(Integer a, Integer b) {

		posX = a;

		posY = b;
	}

	/**
	 * Llama a getPosDir(DireccionEnum b) con la direccion contenida en el
	 * objeto Direccion pasado por parametro.
	 */
	public PosXY getPosDir(Direccion dir) {
		return getPosDir(dir.getDireccionEnum());
	}

	/**
	 * Recibe una direccion en forma de enumerativo y obtiene la posicion en esa
	 * direccion respecto de posX y posY.
	 */
	public PosXY getPosDir(DireccionEnum dir) {

		PosXY pos = new PosXY();

		switch (dir) {

		case ABAJO:

			pos.setPosX(this.posX);

			pos.setPosY(this.posY + 1);

			break;

		case ARRIBA:

			pos.setPosX(this.posX);

			pos.setPosY(this.posY - 1);

			break;

		case DERECHA:

			pos.setPosX(this.getPosX() + 1);

			pos.setPosY(this.getPosY());

			break;

		case IZQUIERDA:

			pos.setPosX(this.posX - 1);

			pos.setPosY(this.posY);
			break;

		default:

			break;

		}

		return pos;

	}

	public void setPosX(Integer posX) {

		this.posX = posX;

	}

	public void setPosY(Integer posY) {

		this.posY = posY;

	}

	public int getPosX() {

		return posX;

	}

	public int getPosY() {

		return posY;
	}

	public String toString() {
		return ("[" + posX + ", " + posY + "]");

	}
}