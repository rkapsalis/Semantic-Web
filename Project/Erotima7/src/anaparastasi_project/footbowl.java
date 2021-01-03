/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anaparastasi_project;
import java.awt.CardLayout;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ρωμανός
 */
public class footbowl extends Owl_ontology{   
    
    private final static String PANEL1 = "panel 1";
    private final static String PANEL2 = "panel 2";
    private final static String PANEL3 = "panel 3";
    private final static String PANEL4 = "panel 4";
    protected JPanel initFields() { 
         JPanel panel1_1 = new JPanel();
          return panel1_1;
    }
//user
     protected JPanel initFields1() {  //antikeim
      JPanel panel2_1 = new JPanel();
      
      panel2_1.setBackground(new java.awt.Color(103,177,234));
     
    
       return panel2_1;
   }
   public footbowl() {
        initComponents();
         
    }
    
   private void initComponents(){
       JFrame frame = new JFrame("Admin");
      setMaximumSize( new Dimension( 70, 60 ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground(new java.awt.Color(78, 108, 157));
      panel3.setPreferredSize(new Dimension(500,300));
      panel3.setLayout(new BorderLayout(5,5));  
       JPanel panel5 = new JPanel();
      panel5.setBackground(new java.awt.Color(78, 108, 157));
      panel5.setPreferredSize(new Dimension(500,300));
      JPanel panel1 = new JPanel();
      panel1.setBackground(new java.awt.Color(78, 108, 157));
     // panel1.setPreferredSize(new Dimension(500,300));
    
     
      Font f=new Font("Calibri",Font.BOLD,20);
    
      JPanel panel2 = new JPanel();
      panel2.setBackground(new java.awt.Color(78, 108, 157));
      panel2.setPreferredSize(new Dimension(500,300));
      panel2.setLayout(new BorderLayout(5,5));  
      
      JPanel panel4 = new JPanel();
      panel4.setBackground(new java.awt.Color(78, 108, 157));
      panel4.setPreferredSize(new Dimension(500,300));
      panel4.setLayout(new BorderLayout(5,5));
           
        JPanel panel6 = new JPanel();
      panel6.setBackground(new java.awt.Color(78, 108, 157));
      panel6.setPreferredSize(new Dimension(500,300));
      panel6.setLayout(new BorderLayout(5,5));
        JPanel panel4_1=new JPanel();
      panel4_1.setLayout(new BorderLayout());
      panel4_1.setBackground(new java.awt.Color(103,177,234));
      panel4.add(panel4_1,BorderLayout.CENTER);
      
      JPanel panel4_2=new JPanel();
      panel4_2.setLayout(new BorderLayout());
      panel4_2.setBackground(new java.awt.Color(103,177,234));
      panel6.add(panel4_2,BorderLayout.CENTER);
      
      JPanel panel2_1=new JPanel();
      panel2_1.setLayout(new BorderLayout());
      panel2_1.setBackground(new java.awt.Color(103,177,234));
      panel2.add(panel2_1,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        final JPanel cards = new JPanel(new CardLayout());
       
       
        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox menu = new JComboBox(petStrings);
    
        cards.add(panel1, PANEL1);
        cards.add(panel2, PANEL2);
        cards.add(panel3, PANEL3);
        cards.add(panel4, PANEL4);
        CardLayout cl = (CardLayout) (cards.getLayout());
        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 113, 7));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Please select one of the following options:");

        jButton1.setBackground(new java.awt.Color(17, 91, 238));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Retrieve instances");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.err.println("");
                panel2.add(initFields1(),BorderLayout.NORTH); 
                CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL2);
            }
        });

        jButton2.setBackground(new java.awt.Color(17, 91, 238));
        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Insert instances");

        jButton3.setBackground(new java.awt.Color(17, 91, 238));
        jButton3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Run SPARQL query");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(17, 91, 238));
        jButton4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search for instances");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel2.setText("Welcome to FootbOWL!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(menu);
        Owl_ontology sth = new Owl_ontology();
        sth.add(cards);
         sth.add(buttonPanel, BorderLayout.NORTH);

        sth.pack();
        sth.setVisible(true);
        //pack();
    }// </editor-fold>                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
    }                 
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Owl_ontology.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Owl_ontology.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Owl_ontology.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Owl_ontology.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new footbowl().setVisible(true);
            }
        });
    }
   
  // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration   
}