package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import datos.ReproductorSonido;
import datos.SonidoEnum;

/**
 * Clase que contiene la ventana de inicio del juego
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

@SuppressWarnings("unused")
public class VentanaMenu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private BufferedImage imagenMenu;
	private JButton reglas;
	private JButton jugar;
	private JButton ranking;
	//private JButton config;
	
	private VentanaReglas ventanaReglas = new VentanaReglas();
	private VentanaDatosJugador ventanaDatos = null;
	private VentanaRanking ventanaRanking = new VentanaRanking();
	//private VentanaConfig ventanaConfig = new VentanaConfig();

	/**
	 * Constructor de clase
	 */
	
	protected VentanaMenu() {
		this.setSize(400, 200);
		this.setTitle("Boulder Dash");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		//ReproductorSonido.reproducirSonido(SonidoEnum.MENU);
	
		String filename = "resources/logo.png";
		try {
			imagenMenu = ImageIO.read(getClass().getClassLoader().getResource(
					filename));
		} catch (IOException e) {
			System.out.println("No se pudo abrir " + filename);
			e.printStackTrace();
		}
		JLabel imagenMenuLabel = new JLabel(new ImageIcon(imagenMenu));
		this.add(imagenMenuLabel, BorderLayout.NORTH);
		

		inicializarBotones();
		this.add(reglas, BorderLayout.WEST);
		this.add(jugar, BorderLayout.CENTER);
		this.add(ranking, BorderLayout.EAST);
		//this.add(config, BorderLayout.SOUTH);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = this.getSize().width;
		int alto = this.getSize().height;
		int x = (dim.width - ancho) / 2;
		int y = (dim.height - alto) / 2;
		this.setLocation(x, y);

		this.setVisible(true);
	}
	
	/**
	 * Crea los botones del menu del inicio
	 */

	private void inicializarBotones() {
		reglas = new JButton("Reglas del juego");
		jugar = new JButton("Quiero Jugar!");
		ranking = new JButton("Top 5");
		//config = new JButton("Config");

		reglas.addActionListener(this);
		jugar.addActionListener(this);
		ranking.addActionListener(this);
		//config.addActionListener(this);
	}

	/**
	 * Manejo de eventos de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		ReproductorSonido.reproducirSonido(SonidoEnum.BOTON);

		if (e.getSource() == reglas) {
			ventanaReglas.setVisible(true);

		} else {
			if (e.getSource() == jugar) {
				if (ventanaDatos == null) {
					ventanaDatos = new VentanaDatosJugador();
				}
				ventanaDatos.setEnabled(true);
				ventanaDatos.setVisible(true);
			} else {
				if (e.getSource() == ranking) {
					ventanaRanking.hacerVisible();
				}
				//else {
					//if(e.getSource()== config)
						//ventanaConfig.setVisible(true);
				}
			}
		}
	}

	
