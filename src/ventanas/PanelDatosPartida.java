package ventanas;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import datos.EstadoJuego;

/**
 * Clase con el panel con los datos del partido
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class PanelDatosPartida extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel diamantesAJuntar = new JLabel();
	private JLabel diamantesObtenidos = new JLabel();
	private JLabel vidasRestantes = new JLabel();
	private JLabel tiempoRestante = new JLabel();
	private JLabel puntaje = new JLabel();
	private EstadoJuego estadoJuego;

	/**
	 * Constructor de calse
	 */
	
	protected PanelDatosPartida() {
		this.setLayout(new GridLayout(2, 3));

		this.add(diamantesAJuntar);
		this.add(diamantesObtenidos);
		this.add(vidasRestantes);
		this.add(tiempoRestante);
		this.add(puntaje);

		estadoJuego = EstadoJuego.crearEstadoJuego();
	}

	/**
	 * Actualiza el panel con datos cuando es necesario
	 */
	public void actualizar() {
		diamantesAJuntar.setText("Diamantes a juntar: "
				+ estadoJuego.getCantDiamantesMinimos());
		diamantesObtenidos.setText("Diamantes : "
				+ estadoJuego.getCantDiamantesRockford());
		vidasRestantes.setText("Vidas: " + estadoJuego.getVidas());
		tiempoRestante.setText("Tiempo: " + estadoJuego.getTiempo());
		puntaje.setText("Puntos: " + estadoJuego.getPuntaje());
	}
}
