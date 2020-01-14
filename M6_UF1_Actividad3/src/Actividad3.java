import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Actividad3 {
	 private Persona[] arrayPerson;
	 private File fichero;
	public Actividad3(File file,Persona[] personas) throws IOException{
		this.fichero= file;;
		this.arrayPerson = personas;
		guardar();
	}
	private void guardar() throws IOException{
		RandomAccessFile aleatoriFile = new RandomAccessFile(fichero, "rw");
		StringBuffer buffer = null;
		
		for (int i=0; i<arrayPerson.length; i++) {
			aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes
			//50 caràcters a 2bytes/caràcter 100 bytes
			buffer = new StringBuffer (arrayPerson[i].getNombre());
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//50 caràcters a 2bytes/caràcter 100 bytes
			buffer = new StringBuffer (arrayPerson[i].getApellido());
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//25 caràcters a 2bytes/caràcter 50 bytes
			
			buffer = new StringBuffer (arrayPerson[i].getDNI());
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			
			//1 float ocupa 4 bytes
			aleatoriFile.writeInt(arrayPerson[i].getEdad());
			//Total 222 bytes
		}
		aleatoriFile.close();
	}		
}
