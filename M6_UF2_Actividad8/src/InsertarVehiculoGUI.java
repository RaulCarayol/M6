import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InsertarVehiculoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfMarca;
	private JTextField tfCV;
	private JCheckBox chckbxReparado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarVehiculoGUI frame = new InsertarVehiculoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsertarVehiculoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS = new JPanel()));
		
		
		JPanel panel1 = new JPanel();
		panel_3.add(panel1);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(InsertarPropietarioGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		
		JLabel lblInsertarCoches = new JLabel("    Insertar Coches");
		panel.add(lblInsertarCoches);
		lblInsertarCoches.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarCoches.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		//JLabel lblInsertarCoches = new JLabel("Insertar Coches");
		lblInsertarCoches.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsertarCoches.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblInsertarCoches);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 25, 0, 25));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(10, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Nombre");
		panel_2.add(lblNewLabel);
		
		tfNombre = new JTextField();
		panel_2.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		panel_2.add(lblNewLabel_1);
		
		tfMarca = new JTextField();
		panel_2.add(tfMarca);
		tfMarca.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Caballos Cubicos (CV)");
		panel_2.add(lblNewLabel_2);
		
		tfCV = new JTextField();
		panel_2.add(tfCV);
		tfCV.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Propietario");
		panel_2.add(lblNewLabel_3);
		
		JList list = new JList();
		panel_2.add(list);
		
		chckbxReparado = new JCheckBox("Reparado");
		panel_2.add(chckbxReparado);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Coche Coche = new Coche();
				Coche.setNombre(tfNombre.getText());
				Coche.setMarca(tfMarca.getText());
				Coche.setcV(Integer.parseInt(tfCV.getText()));

				if(chckbxReparado.isSelected()){
					Coche.setReparado(true);
				}
				
		        EntityManagerFactory emf =
		                Persistence.createEntityManagerFactory("bdTaller.odb");
		            EntityManager em = emf.createEntityManager();
		        
		            em.getTransaction().begin();
		            em.persist(Coche);
		            em.getTransaction().commit();
			}
		});
		panel_2.add(btnInsertar);
	}

}
