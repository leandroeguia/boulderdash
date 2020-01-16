package Boulder;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import mapa.BDLevelReader;
import datos.EstadoJuego;
import datos.JugadorEnRanking;
import datos.ListaRanking;
import datos.ReproductorSonido;
import datos.SonidoEnum;
import Elementos.*;

public class Partida extends TimerTask {
	/** 
	 * @author Bonansea Nahuel, Eguia Leandro
	 * 

	/** 

	 * Contiene las direcciones a seguir en los tests. */
	private Timer timer;
	
	private JugadorEnRanking rankingJugador;
	
	Direccion direccion;

	private boolean exit = false;

	private EstadoJuego estadoJuego;

	private Item[][] matrizBase;

	private Integer numeroDiamantes;

	private Rockford jugador;

	private PosXY posJugador;

	private int vidas;

	private int nivelActual;

	private Mapa mapa;

	private boolean reiniciarPartida;

	private boolean finalizarPartida;

	/**
	 * Constructor de clase
	 * @param nivel: nivel que se cargara
	 * @param direccion 
	 */
	public Partida(int nivel, Direccion direccion) {

		this.estadoJuego = EstadoJuego.crearEstadoJuego();

		this.estadoJuego.reiniciar();

		this.estadoJuego.setTiempo(150);

		this.reiniciarPartida = false;

		this.finalizarPartida = false;

		this.nivelActual = nivel;

		this.mapa = Mapa.crearMapa();

		this.cargarMapa();

		this.mapa.setMapa(matrizBase.clone());

		this.direccion = direccion;

	}

	/**
	 * 
	 * @return : Retorna el numero de diamantes necesario para abrir la puerta.
	 */
	public Integer getNumeroDiamantes() {
		return numeroDiamantes;
	}
	
	/**
	 *  Cambia el numero de diamantes necesarios para abrir la puerta de final
	 * @param numeroDiamantes: nuevo numero de diamantes necesarios para abrir la puerta.
	 */

	public void setNumeroDiamantes(Integer numeroDiamantes) {
		this.numeroDiamantes = numeroDiamantes;
	}

	/**
	 * 
	 * @return : Retorna el jugador.
	 */
	public Rockford getJugador() {
		return jugador;
	}

	/**
	 * Modifica el jugador con los valores que vienen por parametro
	 * @param jugador: nuevos valores para el jugador.
	 */
	public void setJugador(Rockford jugador) {
		this.jugador = jugador;
	}
	
	/**
	 * 
	 * @return : Retorna el mapa de partida.
	 */

	public Mapa getMapa() {
		return mapa;
	}

	/**
	 * Modifica el mapa con valores de parametros
	 * @param Nuevos valores
	 */
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	/**
	 * Crea el mapa del nivel especificado por nivelActual a partir de la tabla
	 * generada en BDLevelReader.
	 */
	public void cargarMapa() {

		BDLevelReader levelReader = new BDLevelReader();

		try {
			levelReader.readLevels("levels.xml");

			levelReader.setCurrentLevel(this.nivelActual);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Item[][] matriz = new Item[levelReader.getWIDTH()][levelReader
				.getHEIGHT()];

		this.mapa.setTamañoX(levelReader.getWIDTH());
		this.mapa.setTamañoY(levelReader.getHEIGHT());

		this.numeroDiamantes = levelReader.getDiamondsNeeded();

		for (int x = 0; x < levelReader.getWIDTH(); x++) {
			for (int y = 0; y < levelReader.getHEIGHT(); y++) {
				switch (levelReader.getTile(x, y)) {
				case EMPTY:
					matriz[x][y] = new Vacio();
					break;

				case DIRT:
					matriz[x][y] = new Suciedad();
					break;

				case TITANIUM:
					matriz[x][y] = new Titanio();
					break;

				case WALL:
					matriz[x][y] = new Magico();
					break;

				case ROCK:
					matriz[x][y] = new Roca();
					break;

				case DIAMOND:
					matriz[x][y] = new Diamante();
					break;

				case AMOEBA:
					matriz[x][y] = new Ameba();
					break;

				case FIREFLY:
					matriz[x][y] = new Luciernaga();
					break;

				case BUTTERFLY:
					matriz[x][y] = new Mariposa();
					break;

				case EXIT:
					matriz[x][y] = new Puerta();
					break;

				case PLAYER:
					this.posJugador = new PosXY(x, y);
					this.jugador = new Rockford();
					matriz[x][y] = jugador;
					break;

				case FALLINGROCK:
					matriz[x][y] = new Roca();
					break;

				case FALLINGDIAMOND:
					matriz[x][y] = new Diamante();
					break;

				default:

					break;
				}
			}
		}

		this.matrizBase = matriz;
	}

	/**
	 * 
	 * @return Retorna la cantidad de vidas que quedan al jugador
	 */
	public Integer getCantidadVidas() {
		return this.vidas;
	}

	/**
	 * Cambia la cantidad de vids, por las vidas que vienen por parametro.
	 * @param nueva cantidad de vidas
	 */
	public void setCantidadVidas(Integer a) {
		this.vidas = a;
	}

	/**
	 * Inicializa la cantidad de vidas en 3 e inicia el gestor de ciclos. Tras
	 * cargar el mapa de un nivel se debe llamar a este metodo desde el main en
	 * BoulderDash.
	 */
	public void iniciarPartida() {

		this.vidas = 4;

		this.estadoJuego.setVidas(this.vidas);

		this.estadoJuego.setCantDiamantesMinimos(this.numeroDiamantes);

		this.timer = new Timer("Ciclo");

		this.timer.schedule(this, 0, 100);

		Reloj reloj = new Reloj();

		reloj.start();

		System.out.println(this.jugador);

		this.getRankingJugador();

	}

	/**
	 * Decrementa la cantidad de vidas y activa el boolean reiniciarPartida, que
	 * indica que se debe reiniciar la partida antes del siguiente ciclo.
	 */
	public void reiniciarPartida() {

		this.reiniciarPartida = true;

		this.vidas = this.vidas - 1;

		this.estadoJuego.setVidas(this.vidas);

		this.estadoJuego.setTiempo(150);

		if (vidas == 0)

			finalizarPartida = true;

	}

	/**
	 * Activa el boolean finalizarPartida, el cual indica al gestor que debe
	 * parar la ejecucion de los ciclos.
	 */
	public void finalizarPartida() {

		this.finalizarPartida = true;

	}
	
	/**
	 * 
	 * @return Retorna true si la puerta está liberada, o false si no lo está.
	 */

	public boolean getExit() {

		return this.exit;

	}

	/**
	 * Evalua cada elemento de la matriz, con lo cual representa un ciclo de
	 * ejecucion.
	 */
	private void ciclo() {

		if (this.direccion.getDireccionEnum() != DireccionEnum.NULL) {

			this.posJugador = this.jugador.mover(direccion, posJugador, this);

			this.direccion.setDireccion(DireccionEnum.NULL);

		}

		PosXY pos = new PosXY();

		for (int i = 0; i < this.mapa.getTamañoX(); i++) {

			for (int j = 0; j < this.mapa.getTamañoY(); j++) {

				pos.setPosX(i);

				pos.setPosY(j);

				if (!this.mapa.getElemento(pos).getSeActualizo()) {

					this.mapa.getElemento(pos).SetSeActualizo(true);

					this.mapa.getElemento(pos).evaluar(this, pos);

				}

			}

		}

		PosXY posi = new PosXY();

		for (int i = 0; i < this.mapa.getTamañoX(); i++) {

			for (int j = 0; j < this.mapa.getTamañoY(); j++) {

				posi.setPosX(i);

				posi.setPosY(j);

				this.mapa.getElemento(posi).SetSeActualizo(false);

			}
		}

	}
/**
 * Comienza a correr el juego.
 */
	public void run() {

		EstadoJuego estado = EstadoJuego.crearEstadoJuego();

		estado.setCantDiamantesRockford(this.jugador.getDiamantes());

		if (estado.isTiempoFin()) {

			this.reiniciarPartida();

			EstadoJuego.crearEstadoJuego().setTiempoFin(false);

		}

		if (!this.finalizarPartida) {

			if (this.reiniciarPartida) {

				this.cargarMapa();

				this.mapa.setMapa(this.matrizBase);

				this.reiniciarPartida = false;

			} else {

				if (this.numeroDiamantes == this.jugador.getDiamantes())

					exit = true;

				this.ciclo();

			}

		} else {

			this.estadoJuego.setFinalizar(true);

			if (this.estadoJuego.isGano()) {

				ReproductorSonido.reproducirSonido(SonidoEnum.VICTORIA);

				JOptionPane.showMessageDialog(null, "USTED GANO");

			} else {

				ReproductorSonido.reproducirSonido(SonidoEnum.DERROTA);

				JOptionPane.showMessageDialog(null, "GAME OVER");

			}
			this.timer.cancel();

		}
	}


	public EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(EstadoJuego estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	public JugadorEnRanking getRankingJugador() {
		return rankingJugador;
	}

	public void setRankingJugador(JugadorEnRanking rankingJugador) {
		this.rankingJugador = rankingJugador;
	}

	public void guardarRanking() {

		EstadoJuego.crearEstadoJuego().setGano(true);

		this.rankingJugador = new JugadorEnRanking();

		this.rankingJugador.setJugador(this.estadoJuego.getNombreJugador());

		this.rankingJugador.setNivel(this.nivelActual);

		this.rankingJugador.setDiamantes(this.jugador.getDiamantes());
		
		this.rankingJugador.setTiempo(estadoJuego.getTiempo());
		

		EstadoJuego.crearEstadoJuego().setRankingJugador(rankingJugador);

		ListaRanking.getInstance().add(
				EstadoJuego.crearEstadoJuego().getRankingJugador());

		ListaRanking.getInstance().save();

	}

}