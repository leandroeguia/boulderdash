package ventanas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.EstadoJuego;
import datos.ReproductorSonido;
import datos.SonidoEnum;
import Boulder.PartidaComenzar;

/**
 * Clase que tiene la ventana con los datos que llenara el jugador
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class VentanaDatosJugador extends JFrame {

	private JComboBox<String> seleccionador;
	private JPanel panel, contenedor1, contenedor2, contenedor3;
	private JLabel nombre;
	private JLabel nivel;
	private JTextField texto;
	private JButton boton;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de clase
	 */
	
	protected VentanaDatosJugador() {

		super("Datos del Jugador");

		seleccionador = new JComboBox<String>();
		texto = new JTextField(20);

		texto.setText(EstadoJuego.crearEstadoJuego().getNombreJugador());

		seleccionador.addItem("Uno");
		seleccionador.addItem("Dos");
		seleccionador.addItem("Tres");
		seleccionador.addItem("Cuatro");
		seleccionador.addItem("Cinco");
		seleccionador.addItem("Seis");
		seleccionador.addItem("Siete");
		seleccionador.addItem("Ocho");
		seleccionador.addItem("Nueve");
		seleccionador.addItem("Diez");
		boton = new JButton("Jugar");

		boton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				ReproductorSonido.reproducirSonido(SonidoEnum.BOTON);

				if (texto.getText().length() >= 3) {
					
					
					VentanaDatosJugador.this.setVisible(false);

					VentanaDatosJugador.this.setEnabled(false);

					PartidaComenzar partida = new PartidaComenzar();
					
					
					if (texto.getText().length() > 20) {
					EstadoJuego.crearEstadoJuego().setNombreJugador(
							texto.getText().substring(0, 20));
					}
					else {
						EstadoJuego.crearEstadoJuego().setNombreJugador(
								texto.getText());
					}
					
					partida.comenzar(seleccionador.getSelectedIndex() + 1);

					VentanaDatosJugador.this.dispose();


					
				} else {

					JOptionPane.showMessageDialog(null,
							"Ingrese un nombre con 2 o mas letras");
				}

			}

		});
		nombre = new JLabel("Nombre:");
		nivel = new JLabel("Nivel Seleccionado:");
		panel = new JPanel();
		contenedor1 = new JPanel();
		contenedor1.add(nombre);
		contenedor1.add(texto);
		contenedor2 = new JPanel();
		contenedor2.add(nivel);
		contenedor2.add(seleccionador);
		contenedor3 = new JPanel();
		contenedor3.add(boton);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		panel.add(contenedor1);
		panel.add(contenedor2);
		panel.add(contenedor3);
		this.add(panel);
		this.pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = this.getSize().width;
		int alto = this.getSize().height;
		int x = (dim.width - ancho) / 2;
		int y = (dim.height - alto) / 2;
		this.setLocation(x, y);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaDatosJugador ventana = new VentanaDatosJugador();

	}

}
