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
import javax.swing.SwingConstants;


public class M6_Actividad2_Graphics extends JFrame {
	public JButton btnInsertar;
	public JLabel lblMensaje;
	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();

	public M6_Actividad2_Graphics() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 0, -2));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblCP = new JLabel("Codigo Postal");
		panel.add(lblCP);

		JLabel lblNombrePobalacion = new JLabel("Nombre Poblaci\u00F3n");
		panel.add(lblNombrePobalacion);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblCodi = new JLabel("43203");
		panel_1.add(lblCodi);

		JLabel lblNom = new JLabel("Tarragona");
		panel_1.add(lblNom);
		
		JLabel label = new JLabel("43217");
		panel_1.add(label);
		
		JLabel lblBarcelona = new JLabel("Barcelona");
		panel_1.add(lblBarcelona);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);

		btnInsertar = new JButton("Insertar");
		panel_2.add(btnInsertar);

		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
	}

}
