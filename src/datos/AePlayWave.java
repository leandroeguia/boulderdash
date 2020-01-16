package datos;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Hilo encargado de reproducir sonido.
 * @author Bonansea Nahuel Eguia Leandro
 *
 */

public class AePlayWave extends Thread {

	private String filename;

	private Position curPosition;

	private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

	enum Position {
		LEFT, RIGHT, NORMAL
	};

	/**
	 * constructor base de clase, sin posicion.
	 * @param wavfile nombre de archivo
	 */
	public AePlayWave(String wavfile) {
		filename = wavfile;
		curPosition = Position.NORMAL;
	}

	/**
	 * constructor de clase complejo
	 * @param wavfile: nombre de archivo
	 * @param p: posicion inicial
	 */
	public AePlayWave(String wavfile, Position p) {
		filename = wavfile;
		curPosition = p;
	}
	
	/**
	 * comienza la reproduccion del sonido
	 */

	public void run() {
		
		URL archivoSonido = this.getClass().getClassLoader().getResource(filename);
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}

		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}

	}
}