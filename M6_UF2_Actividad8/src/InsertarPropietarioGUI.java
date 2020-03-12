import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;


public class InsertarPropietarioGUI extends JFrame {


		private JPanel contentPane;
		private JTextField tfDni;
		private JTextField tfNombre;
		private JTextField tfEdad;
		private JTextField tfApellidos;
		private JCheckBox chckbxCasado;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InsertarPropietarioGUI frame = new InsertarPropietarioGUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public InsertarPropietarioGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			
			JPanel panel = new JPanel();
			panel.setAlignmentX(0.32f);
			contentPane.add(panel);
			JPanel panel_3 = new JPanel();
			//panel.setLayout( = new JPanel();
			contentPane.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			JButton btnNewButton_1 = new JButton("Volver");
			btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
			panel.add(btnNewButton_1);
			btnNewButton_1.setIcon(new ImageIcon(InsertarPropietarioGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
			
			JLabel lblNewLabel_4 = new JLabel("        Insertar Propietario");
			panel.add(lblNewLabel_4);
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
			
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new EmptyBorder(0, 25, 0, 25));
			panel_1.add(panel_2);
			panel_2.setLayout(new GridLayout(12, 2, 0, 0));
			
			JLabel lblNewLabel = new JLabel("Nombre");
			panel_2.add(lblNewLabel);
			
			tfNombre = new JTextField();
			panel_2.add(tfNombre);
			tfNombre.setColumns(10);
			
			JLabel lblApellidos = new JLabel("Apellidos");
			panel_2.add(lblApellidos);
			
			tfApellidos = new JTextField();
			panel_2.add(tfApellidos);
			tfApellidos.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("DNI");
			panel_2.add(lblNewLabel_1);
			
			tfDni = new JTextField();
			panel_2.add(tfDni);
			tfDni.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Edad");
			panel_2.add(lblNewLabel_2);
			
			tfEdad = new JTextField();
			panel_2.add(tfEdad);
			tfEdad.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Coche");
			panel_2.add(lblNewLabel_3);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Coche 1", "Coche 2", "Coche 3"}));
			panel_2.add(comboBox);
			
			chckbxCasado = new JCheckBox("Casado");
			panel_2.add(chckbxCasado);
			
			
			JButton btnInsertar = new JButton("Insertar");
			btnInsertar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Persona propietario = new Persona();
					propietario.setNombre(tfNombre.getText());
					propietario.setApellidos(tfApellidos.getText());
					propietario.setDni(Integer.parseInt(tfDni.getText()));
					propietario.setEdad(Integer.parseInt(tfEdad.getText()));
					if(chckbxCasado.isSelected()){
						propietario.setCasado(true);
					}
					
			        EntityManagerFactory emf =
			                Persistence.createEntityManagerFactory("bdTaller.odb");
			            EntityManager em = emf.createEntityManager();
			        
			            em.getTransaction().begin();
			            em.persist(propietario);
			            em.getTransaction().commit();
				}
			});
			panel_2.add(btnInsertar);
		}

	}
