import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class M6_Actividad2_Graphics extends JFrame {
	public JButton btnInsertar;
	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M6_Actividad2_Graphics frame = new M6_Actividad2_Graphics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public M6_Actividad2_Graphics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 0, -2));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(25);
		flowLayout.setVgap(15);
		contentPane.add(panel);
		
		JLabel lblCP = new JLabel("Codigo Postal");
		panel.add(lblCP);
		
		JLabel lblNombrePobalacion = new JLabel("Nombre Poblaci\u00F3n");
		panel.add(lblNombrePobalacion);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(25);
		flowLayout_1.setVgap(0);
		contentPane.add(panel_1);
		
		JLabel lblCodi = new JLabel("43203");
		panel_1.add(lblCodi);
		
		JLabel lblNom = new JLabel("Tarragona");
		panel_1.add(lblNom);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		 btnInsertar = new JButton("Insertar");
		panel_2.add(btnInsertar);
	}

}
