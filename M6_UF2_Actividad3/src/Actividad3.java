import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class Actividad3 {
	private static Actividad3_Graphics graficos;
	private static Connection connection = null;
	public static void main(String[] args) {
		
		graficos = new Actividad3_Graphics();
		
		graficos.btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(graficos.grupoModos.getSelection().equals(graficos.rdbtnStament)){
					verificarStament(graficos.tfUsuario.getText(),graficos.tfConstrasenya.getText());
				}else{
					verificarPrepared(graficos.tfUsuario.getText(),graficos.tfConstrasenya.getText());
				}
			}});
	}
	private static void verificarStament(String text, String text2) {
		// TODO Auto-generated method stub
		
	}
	
	private static void verificarPrepared(String text, String text2) {
		// TODO Auto-generated method stub
		
	}

}
