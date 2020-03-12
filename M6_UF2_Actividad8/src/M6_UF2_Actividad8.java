
import javax.persistence.*;
import javax.swing.JFrame;

import java.util.*;

public class M6_UF2_Actividad8 {

	public static void main(String[] args) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					JFrame frame = new Actividad8GUI();
					frame.setVisible(true);
				}
			});
			t.start();

//            // Find the number of Point objects in the database:
//            Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
//            System.out.println("Total Points: " + q1.getSingleResult());
//
//            // Find the average X value:
//            Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
//            System.out.println("Average X: " + q2.getSingleResult());
//
//            // Retrieve all the Point objects from the database:
//            TypedQuery<Point> query =
//                em.createQuery("SELECT p FROM Point p", Point.class);
//            List<Point> results = query.getResultList();
//            for (Point p : results) {
//                System.out.println(p);
//            }

            // Close the database connection:


	}

}
