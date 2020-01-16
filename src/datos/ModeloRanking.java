package datos;

import javax.swing.table.DefaultTableModel;

/**
 * Crea la tabla de ranking de jugadores
 * 
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class ModeloRanking extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public ModeloRanking(Object[][] datos, String[] titulos) {
		super(datos, titulos);
	}

	public ModeloRanking() {
	}
}