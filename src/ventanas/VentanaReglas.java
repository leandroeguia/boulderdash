package ventanas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * 
 * Clase que contiene el panel con las reglas del juego.
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class VentanaReglas extends JFrame {
	private static final long serialVersionUID = 1L;

	private JEditorPane area;

	/**
	 * Constructor de clase
	 */
	
	protected VentanaReglas() {
		this.setSize(400, 400);
		this.setTitle("Reglas del juego");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		String filename = "resources/reglas.txt";
		URL url = this.getClass().getClassLoader().getResource(filename);
		area = new JEditorPane();
		try {
			area.setPage(url);
		} catch (IOException e) {
			System.out.println("No se pudo abrir " + filename);
			e.printStackTrace();
		}

		Box cuadro = Box.createHorizontalBox();
		cuadro.add(new JScrollPane(area));
		this.add(cuadro);
		area.setEditable(false);
		area.setVisible(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = this.getSize().width;
		int alto = this.getSize().height;
		int x = (dim.width - ancho) / 2;
		int y = (dim.height - alto) / 2;
		this.setLocation(x, y);
	}
}
