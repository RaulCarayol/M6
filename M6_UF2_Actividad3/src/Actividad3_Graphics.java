import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;


public class Actividad3_Graphics extends JFrame {

	private JPanel contentPane;
	public JTextField tfUsuario;
	public JTextField tfConstrasenya;
	public JButton btnValidar;
	public ButtonGroup grupoModos;
	public JRadioButton rdbtnStament;
	public JRadioButton rdbtnPrepared;
	JLabel labelVer;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad3_Graphics frame = new Actividad3_Graphics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Actividad3_Graphics() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][grow][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel, "cell 3 1,alignx right");
		
		tfUsuario = new JTextField();
		contentPane.add(tfUsuario, "cell 4 1 2 1,growx");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		contentPane.add(lblNewLabel_1, "cell 3 2,alignx right");
		
		tfConstrasenya = new JTextField();
		contentPane.add(tfConstrasenya, "cell 4 2 2 1,growx");
		tfConstrasenya.setColumns(10);
		
		rdbtnStament = new JRadioButton("Statement");
		rdbtnPrepared = new JRadioButton("PreparedStatement");
		grupoModos = new ButtonGroup();
		grupoModos.add(rdbtnStament);
		grupoModos.add(rdbtnPrepared);
		contentPane.add(rdbtnStament, "cell 4 3");
		contentPane.add(rdbtnPrepared, "cell 4 4");
		rdbtnStament.setSelected(true);
		
		btnValidar = new JButton("Validar");
		contentPane.add(btnValidar, "cell 4 6,alignx center");
		
		labelVer = new JLabel("");
		contentPane.add(labelVer, "cell 4 7 1 2");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
}
