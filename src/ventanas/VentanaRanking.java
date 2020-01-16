package ventanas;

import datos.ListaRanking;
import datos.ModeloRanking;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Clase con el panel del ranking de jugadores
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class VentanaRanking
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private ListaRanking lista;
  private JTable tabla;
  private ModeloRanking ranking;
  
  /**
   * Constructor de clase.
   */
  protected VentanaRanking()
  {
    this.lista = ListaRanking.getInstance();
    this.lista.load();
    this.ranking = new ModeloRanking();
    inicializarModeloRanking();
    init();
    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int ancho = getSize().width;
    int alto = getSize().height;
    int x = (dim.width - ancho) / 2;
    int y = (dim.height - alto) / 2;
    setLocation(x, y);
  }
  /**
   * Inicia y crea la tabla de ranking
   */
  private void inicializarModeloRanking()
  {
    Object[][] datos = new Object[this.lista.size()][4];
    for (int i = 0; i < this.lista.size(); i++) {
      datos[i] = this.lista.get(i).getJugadorEnRanking();
    }
    this.tabla = new JTable();
    String[] titulos = { "Jugador", "Puntaje", "Nivel", "Tiempo" };
    this.ranking.setDataVector(datos, titulos);
  }
  
  /**
   * arma el ranking
   */
  
  public void init()
  {
    Container contentPane = getContentPane();
    this.tabla.setModel(this.ranking);
    contentPane.add(new JScrollPane(this.tabla));
    this.tabla.setEnabled(false);
    pack();
  }
  
  /**
   * hace visible el ranking
   */
  public void hacerVisible()
  {
    ListaRanking.getInstance().load();
    inicializarModeloRanking();
    setVisible(true);
  }
}
