package ventanas;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main del juego
 * @author Bonansea Nahuel, Eguia Leandro
 *
 */

public class Main {

	public static void main(String[] args) {
		// Hace que los botones sean como los de Windows
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		new VentanaMenu();
	}

}
