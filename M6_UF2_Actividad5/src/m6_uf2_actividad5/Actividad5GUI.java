package m6_uf2_actividad5;
import bd6.entity.Movimientos;
import bd6.entity.Partidas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

public class Actividad5GUI extends javax.swing.JFrame {

    private static String PARTIDA_MAS_NUEVA = "select ID, num_movimientos from partidas where ID =( select MAX(ID) from partidas)";
    private static String MOVIMIENTOS = "select moviments from movimientos where partida_id =:n";
    boolean jugaX = true;
    boolean jugaO = false;
    int filaOrigen = -1;
    int columnaOrigen = -1;
    static Partidas partida;
    static int numMovimientos;
    static boolean cargarPartida;
    static boolean ganado;

    public Actividad5GUI(boolean cargarPartida, Partidas partida) throws InterruptedException {              
       initComponents(); 
        this.cargarPartida = true;
        this.partida = partida;
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        cargaInicio();
    }

    public static void main(String args[]) throws InterruptedException {
        JFrame frame = new Actividad5GUI(cargarPartida, partida);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();

    }
    public static void cargaInicio() throws InterruptedException{
         if (cargarPartida) {
                cargarUltimaPartida();
            } else {
             ganado=false;
                numMovimientos = 0;
                jLabelX.setVisible(true);
                jLabelO.setVisible(false);
            }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelO = new javax.swing.JLabel();
        jLabelX = new javax.swing.JLabel();
        jButtonSortir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(875, 600));
        setMinimumSize(new java.awt.Dimension(875, 600));
        setPreferredSize(new java.awt.Dimension(875, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(875, 600));

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"X", " ", "X", " ", "X", " ", "X", " "},
                {" ", "X", " ", "X", " ", "X", " ", "X"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"O", " ", "O", " ", "O", " ", "O", " "},
                {" ", "O", " ", "O", " ", "O", " ", "O"}
            },
            new String [] {
                "Col 1", "Col 2", "Col 3", "Col 4", "Col 5", "Col 6", "Col 7", "Col 8"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setAutoscrolls(false);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
        jTable1.setFocusable(false);
        jTable1.setRowHeight(46);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 76, 845, 406));

        jLabelO.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelO.setText("Jugador O");
        jLabelO.setIconTextGap(10);
        jLabelO.setPreferredSize(new java.awt.Dimension(60, 14));
        jLabelO.setRequestFocusEnabled(false);
        jPanel1.add(jLabelO, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 20, 313, 43));

        jLabelX.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelX.setText("Jugador X");
        jLabelX.setIconTextGap(10);
        jLabelX.setPreferredSize(new java.awt.Dimension(60, 14));
        jLabelX.setRequestFocusEnabled(false);
        jPanel1.add(jLabelX, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 20, 299, 43));

        jButtonSortir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSortir.setText("Sortir");
        jButtonSortir.setToolTipText("");
        jButtonSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSortir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 210, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public static void cargarUltimaPartida() throws InterruptedException {
        int id = 0;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(PARTIDA_MAS_NUEVA);
        List<Object[]> list = query.list();
        session.getTransaction().commit();
        for (Object[] objects : list) {
            id = (int) objects[0];
            numMovimientos = (int) objects[1];
            System.out.println(id);
            System.out.println(numMovimientos);
        }
        Query q = session.createSQLQuery(MOVIMIENTOS);
        q.setParameter("n", id);
        List<String> listaMovimientos = q.list();
        jTable1.setVisible(true);
        DefaultTableModel model = (DefaultTableModel)(jTable1.getModel());
        for (String listaMovimiento : listaMovimientos) {
            int indice = 0;
             String valor;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                System.out.print("|");
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    valor = String.valueOf(listaMovimiento.charAt(indice));
                    System.out.print(valor+"|");
                    model.setValueAt(valor, i, j);
                    model.fireTableDataChanged();
                    indice++;
                }
                System.out.println("");
            }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Actividad5GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        System.out.println("Fin Cargar Partida");
    }

    private static void guardarMovimientos() {
        //inicio sesion
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //crear movimientos
        Movimientos movimientos = new Movimientos();
        //asociar con la partida
        movimientos.setPartidas(partida);
        String tablero = new String();
        String fila;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero += jTable1.getValueAt(i, j);
            }
        }
        System.out.println(tablero + " tamaño:" + tablero.length());
        movimientos.setMoviments(tablero);
        //guardar movimientos
        session.save(movimientos);
        partida.setNumMovimientos(Actividad5GUI.numMovimientos);
        session.update(partida);
        session.getTransaction().commit();
        session.close();
        
    }

    private boolean esX(int fil, int col) {
        if (jTable1.getValueAt(fil, col).toString().trim().equals("X")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean esO(int fil, int col) {
        if (jTable1.getValueAt(fil, col).toString().trim().equals("O")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean noHiHaOrigen() {
        return (filaOrigen == -1) && (columnaOrigen == -1);
    }

    private void actualitzaNouOrigen(int fil, int col) {
        filaOrigen = fil;
        columnaOrigen = col;
    }

    private boolean movimentValid(int col, int fil) {
        boolean movimiento = false;
        if (jugaO && ((fil == filaOrigen - 1) && (columnaOrigen + 1 == col || columnaOrigen - 1 == col))) {
            movimiento = true;
        } else if (jugaX && ((fil == (filaOrigen + 1)) && (columnaOrigen + 1 == col || columnaOrigen - 1 == col))) {
            movimiento = true;
        }
        return movimiento;
    }

    private boolean esBuit(int col, int fil) {
        if (jTable1.getValueAt(fil, col).toString().equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean ocupatContrari(int col, int fil) {
        boolean ocuopat = false;
        if (jugaO && jTable1.getValueAt(fil, col).equals("X")) {
            ocuopat = true;
        } else if (jugaX && jTable1.getValueAt(fil, col).equals("O")) {
            ocuopat = true;
        }
        return ocuopat;
    }

    private void mou(int col, int fil) {
        if (jugaO) {
            jTable1.setValueAt("O", fil, col);
            jugaO = false;
            jugaX = true;
            jLabelX.setVisible(true);
            jLabelO.setVisible(false);

        } else {
            jTable1.setValueAt("X", fil, col);
            jugaO = true;
            jugaX = false;
            jLabelX.setVisible(false);
            jLabelO.setVisible(true);

        }
        System.out.println("fila: "+fil);
        jTable1.setValueAt(" ", filaOrigen, columnaOrigen);
        actualitzaNouOrigen(-1, -1);
        numMovimientos++;
        guardarMovimientos();
        if (jugaX && (fil == 0)) {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            partida.setGanador("O");
            session.update(partida);
            ganado = true;
            JOptionPane.showMessageDialog(this, "Ha gando O");
            this.dispose();
        } else if (jugaO && fil == 7) {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            partida.setGanador("X");
            session.update(partida);
            session.getTransaction().commit();
            session.close();
            JOptionPane.showMessageDialog(this, "Ha gando X");
            ganado=true;
            this.dispose();
        }

    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            if(!ganado){
                int fil = jTable1.getSelectedRow();
                int col = jTable1.getSelectedColumn();
                if (noHiHaOrigen()) {
                    if (jugaX && esX(fil, col)) {
                        actualitzaNouOrigen(fil, col);
                    } else if (jugaO && esO(fil, col)) {
                        actualitzaNouOrigen(fil, col);
                    } else {
                    }
                } else if (movimentValid(col, fil) && ((esBuit(col, fil) || ocupatContrari(col, fil)))) {
                        mou(col, fil);
                }else{
                    actualitzaNouOrigen(-1, -1);
                }
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        dispose();
    }//GEN-LAST:event_jButtonSortirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButtonSortir;
    private static javax.swing.JLabel jLabelO;
    private static javax.swing.JLabel jLabelX;
    private static javax.swing.JPanel jPanel1;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
