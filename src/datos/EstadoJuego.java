package datos;

/**
 * Clase que guarda el estado del juego.
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class EstadoJuego {

	private static EstadoJuego estadoJuego = null;

	private String nombreJugador;

	private boolean tiempoFin;

	private JugadorEnRanking rankingJugador;

	private boolean gano;

	private boolean finalizar;

	private int cantDiamantesRockford;

	private int cantDiamantesMinimos;

	private int puntaje;

	private int tiempo;

	private int vidas;

	public static EstadoJuego crearEstadoJuego() {

		if (EstadoJuego.estadoJuego == null) {

			EstadoJuego.estadoJuego = new EstadoJuego();

		}

		return EstadoJuego.estadoJuego;

	}

	private EstadoJuego() {

		this.reiniciar();

		this.nombreJugador = " ";

	}

	public boolean isFinalizar() {

		return finalizar;
	}

	public void setFinalizar(boolean finalizar) {
		this.finalizar = finalizar;
	}

	public int getCantDiamantesRockford() {
		return cantDiamantesRockford;
	}

	public void setCantDiamantesRockford(int cantDiamantesRockford) {
		this.cantDiamantesRockford = cantDiamantesRockford;
	}

	public int getCantDiamantesMinimos() {
		return cantDiamantesMinimos;
	}

	public void setCantDiamantesMinimos(int cantDiamantesMinimos) {
		this.cantDiamantesMinimos = cantDiamantesMinimos;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}

	public JugadorEnRanking getRankingJugador() {
		return rankingJugador;
	}

	public void setRankingJugador(JugadorEnRanking rankingJugador) {
		this.rankingJugador = rankingJugador;
	}

	public boolean isGano() {
		return gano;
	}

	public void setGano(boolean gano) {
		this.gano = gano;
	}

	public boolean isTiempoFin() {
		return tiempoFin;
	}

	public void setTiempoFin(boolean tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}


	public void reiniciar() {

		this.tiempo = 0;

		this.tiempoFin = false;

		this.rankingJugador = null;

		this.gano = false;

		this.finalizar = false;

		this.cantDiamantesRockford = 0;

		this.cantDiamantesMinimos = 0;

		this.puntaje = 0;

		this.vidas = 0;

	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

}
