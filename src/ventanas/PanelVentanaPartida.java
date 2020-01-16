package ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.JPanel;

import mapa.BDTile;
import Boulder.*;
import Elementos.Item;

/**
 * Clase con el panel que contiene el mapa y el jeugo en si
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class PanelVentanaPartida extends JPanel {
	private static final long serialVersionUID = 1L;

	private HashMap<BDTile, Image> imagenes;

	/**
	 * COnstructor de clase
	 */
	
	public PanelVentanaPartida(HashMap<BDTile, Image> imagenes) {

		this.imagenes = imagenes;

	}
/**
 * Dibuja el mapa
 */
	public void paint(Graphics g) {

		Item[][] matriz = Mapa.crearMapa().getMapa();

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz[i].length; j++) {

				BDTile aux = matriz[i][j].getTipo();

				Image auxIma = imagenes.get(aux);

				g.drawImage(auxIma, 0 + i * 16, 0 + j * 16, 16, 16, this);

			}

		}

	}

}
