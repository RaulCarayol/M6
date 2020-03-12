import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Actividad8GUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad8GUI frame = new Actividad8GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Actividad8GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("TALLER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 35, 10, 35));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 1, 25, 5));
		
		JButton btnNewButton = new JButton("Visualizar");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Insertar Coches");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new InsertarVehiculoGUI();
				frame.setVisible(true);
                frame.setEnabled(true);
                frame.setLocationRelativeTo(null);
                frame.pack();
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Insertar Personas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new InsertarVehiculoGUI();
				frame.setVisible(true);
                frame.setEnabled(true);
                frame.setLocationRelativeTo(null);
                frame.pack();
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_1.add(btnNewButton_3);
	}
}
