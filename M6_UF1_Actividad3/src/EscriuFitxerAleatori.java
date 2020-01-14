import java.io.*;

public class EscriuFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("/home/user/Escriptori/llibres");
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		//Les dades per inserir
		String titol[] = {"El capital al segle xxi", "Sàpiens. una breu història de la humanitat", "És l'hora dels 					adéus?", "Els jueus catalans", "Raó i emoció"};
		int isbn[] = {190249335, 190444337, 543219331, 455249337, 780249335};
		String autor[] = {"Piketty, thomas", "Yuval noah harari", "Sala i martin, xavier", "Forcano, manuel", 						"Salmurri trinxet, ferran"};
		String editorial[] = {"MAGRANA EDICIONS DE LA", "EDICIONS 62 PENINSULA", "ROSA DELS VENTS", "angle 								editorial", "MAGRANA EDICIONS DE LA"};
		double preu[] = {25, 23.9, 16.9, 18.9, 12};
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;
		
		for (int i=0; i<titol.length; i++) {
			aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes
			//50 caràcters a 2bytes/caràcter 100 bytes
			buffer = new StringBuffer (titol[i]);
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//1 enter ocupa 4 bytes
			aleatoriFile.writeInt(isbn[i]);
			//25 caràcters a 2bytes/caràcter 50 bytes
			buffer = new StringBuffer (autor[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
			//30 caràcters a 2bytes/caràcter 60 bytes
			buffer = new StringBuffer (editorial[i]);
			buffer.setLength(30);
			aleatoriFile.writeChars(buffer.toString());
			//1 float ocupa 4 bytes
			aleatoriFile.writeFloat((float)preu[i]);
			//Total 222 bytes
		}
		aleatoriFile.close();
	}
}
