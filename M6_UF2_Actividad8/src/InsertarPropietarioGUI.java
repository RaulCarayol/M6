import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

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
import javax.swing.ImageIcon;


public class InsertarPropietarioGUI extends JFrame {


		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;

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
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new EmptyBorder(10, 0, 10, 10));
			panel.add(panel_3);
			panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			
			JButton btnNewButton_1 = new JButton("Volver");
			btnNewButton_1.setIcon(new ImageIcon(InsertarPropietarioGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
			panel_3.add(btnNewButton_1);
			
			JPanel panel_4 = new JPanel();
			panel.add(panel_4);
			panel_4.setLayout(new GridLayout(0, 1, 0, 10));
			
			JLabel lblNewLabel_4 = new JLabel("Insertar Propietario");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
			panel_4.add(lblNewLabel_4);
			
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new EmptyBorder(0, 25, 0, 25));
			panel_1.add(panel_2);
			panel_2.setLayout(new GridLayout(10, 2, 0, 0));
			
			JLabel lblNewLabel = new JLabel("Nombre");
			panel_2.add(lblNewLabel);
			
			textField = new JTextField();
			panel_2.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("DNI");
			panel_2.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			panel_2.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Edad");
			panel_2.add(lblNewLabel_2);
			
			textField_2 = new JTextField();
			panel_2.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Coche");
			panel_2.add(lblNewLabel_3);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Coche 1", "Coche 2", "Coche 3"}));
			panel_2.add(comboBox);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("Casado");
			panel_2.add(chckbxNewCheckBox);
			
			JButton btnNewButton = new JButton("Insertar");
			panel_2.add(btnNewButton);
		}

	}
