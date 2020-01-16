package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;

import mapa.BDTile;
import datos.EstadoJuego;

/**
 * Clase que crea la ventana que contiene la partida.
 * @author Bonansea Nahuel Eguia Leandro
 *
 */


public class VentanaPartida extends JFrame {
	private static final long serialVersionUID = 1L;

	private PanelDatosPartida panelDatos;
	private PanelVentanaPartida panelJuego;
	private HashMap<BDTile, Image> imagenes = new HashMap<BDTile, Image>();

	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	// private Image image;
	
	/**
	 * Actualiza la ventana
	 */

	public void actualizar() {

		this.panelDatos.actualizar();
		this.panelJuego.paintComponents(getGraphics());

	}

	/**
	 * Constructor de clase
	 */
	public VentanaPartida() {

		EstadoJuego.crearEstadoJuego();

		this.setBounds(new Rectangle(new Dimension(6 + 16 * 40, 56 + 16 * 22)));

		this.setResizable(false);

		try {
			this.cargarHashMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		this.panelDatos = new PanelDatosPartida();
		this.panelJuego = new PanelVentanaPartida(this.imagenes);
		this.add(this.panelDatos, BorderLayout.NORTH);
		this.add(this.panelJuego, BorderLayout.CENTER);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = this.getSize().width;
		int alto = this.getSize().height;
		int x = (dim.width - ancho) / 2;
		int y = (dim.height - alto) / 2;
		this.setLocation(x, y);
	}

	/*
	 * Carga el mapa.
	 */
	public void cargarHashMap() throws IOException {

		imagenes.put(
				BDTile.BUTTERFLY,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/butterfly.gif")));
		imagenes.put(
				BDTile.AMOEBA,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/amoeba.gif")));
		imagenes.put(
				BDTile.DIAMOND,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/diamond.gif")));
		imagenes.put(
				BDTile.FALLINGDIAMOND,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/diamond.gif")));
		imagenes.put(
				BDTile.WALL,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/wall.gif")));
		imagenes.put(
				BDTile.DIRT,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/dirt.gif")));
		imagenes.put(
				BDTile.EMPTY,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/empty.jpg")));
		imagenes.put(
				BDTile.PLAYER,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/rockford.gif")));
		imagenes.put(
				BDTile.ROCK,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/boulder.gif")));
		imagenes.put(
				BDTile.FALLINGROCK,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/boulder.gif")));
		imagenes.put(
				BDTile.FIREFLY,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/firefly.gif")));
		imagenes.put(
				BDTile.TITANIUM,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/steel.gif")));
		imagenes.put(
				BDTile.EXIT,
				toolkit.getImage(this.getClass().getClassLoader()
						.getResource("resources/exit.gif")));
		//imagenes.put(
			//	BDTile.EXPLOSION,
				//toolkit.getImage(this.getClass().getClassLoader()
					//	.getResource("resources/explosion.gif")));

	}

}
