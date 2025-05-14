
package main;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class GuiMenu extends javax.swing.JFrame {

   
    public GuiMenu() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tartalom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        betoltesmenu = new javax.swing.JMenuItem();
        menuMentes = new javax.swing.JMenuItem();
        menuPlgKilepes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Elnevezés:");

        jCheckBox1.setText("Hírlevél");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Programtervező informatikus", "Mérnökinformatikus", "Gazdaságinformatikus", "Adattudomány " }));

        jLabel2.setText("Szakok:");

        jMenu1.setText("Program");

        betoltesmenu.setText("Betöltés");
        betoltesmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betoltesmenuActionPerformed(evt);
            }
        });
        jMenu1.add(betoltesmenu);

        menuMentes.setText("Mentés");
        menuMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMentesActionPerformed(evt);
            }
        });
        jMenu1.add(menuMentes);

        menuPlgKilepes.setText("Kilépés");
        menuPlgKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPlgKilepesActionPerformed(evt);
            }
        });
        jMenu1.add(menuPlgKilepes);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(16, 16, 16)
                        .addComponent(Tartalom))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tartalom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void menuPlgKilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPlgKilepesActionPerformed
        kilepes();
    }//GEN-LAST:event_menuPlgKilepesActionPerformed

    private void kilepes() throws HeadlessException {
        int OptTip = JOptionPane.YES_NO_OPTION;
        int megTip = JOptionPane.QUESTION_MESSAGE;
        String kerdes= "Biztosan kilépsz?";
        String cim = "KILÉPÉS";
        int gomb = JOptionPane.showConfirmDialog(rootPane, kerdes, cim,OptTip );
        //JOptionPane.showMessageDialog(null, kerdes,cim , megTip);
        //System.out.println("gomb, " + gomb);
        
        if (gomb == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //System.out.println("Kilépés.....");
        kilepes();
    }//GEN-LAST:event_formWindowClosing

    private void menuMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMentesActionPerformed
        JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
        int gomb = jfc.showSaveDialog(null);//lehet null,this,rootpane
        
        if (gomb == JFileChooser.APPROVE_OPTION) {
            File kivalasztottFajl = jfc.getSelectedFile();
            String fajlnev= kivalasztottFajl.getAbsolutePath();
            Path path = Path.of(fajlnev);//hova irjuk
            String tart = tartalom();
            
            try {
                Files.writeString(path, Tartalom.getText());
            } catch (IOException ex) {
                String  mag = "Io hiba" + ex.getMessage();
                JOptionPane.showMessageDialog(rootPane, mag);
                JOptionPane.showMessageDialog(rootPane, tart);
            }
           
        }

        /*Path path = Path.of("kimenet.txt");//Hova írjuk
        byte[] bytes = jTextField1.getText().getBytes();//Mit írunk
        try {
            //Files.write(path, bytes);
            Files.write(path, jTextField1.getText().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(GuiMenu.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_menuMentesActionPerformed
    
    private String tartalom(){
       String nev = Tartalom.getText();
       String szak =(String) jComboBox1.getSelectedItem();
       boolean hir = jCheckBox1.isSelected();
       if (hir==true){
           System.out.println("Köszönjük hogy feliratkoztal a hírlevélre.");
       }else{
           System.out.println("Nem iratkozol fel a hírlevélre.");
       }
       String msg = "Név: " + nev +
             "\nSzak: ".formatted(szak) +
             "\nFeliratkozás a hírlevélre: " + (hir);
        return msg;
    }
    
    
    
    
    private void betoltesmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betoltesmenuActionPerformed
        JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
        int gomb = jfc.showSaveDialog(rootPane);
        if (gomb == JFileChooser.APPROVE_OPTION) {
            File kivalasztottFajl = jfc.getSelectedFile();
            
            try {
                String sorok = Files.readString(kivalasztottFajl.toPath());
                System.out.println("A beolvasott fajl tartalma: ");
                System.out.println(sorok);
            } catch (IOException ex) {
                Logger.getLogger(GuiMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_betoltesmenuActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tartalom;
    private javax.swing.JMenuItem betoltesmenu;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuMentes;
    private javax.swing.JMenuItem menuPlgKilepes;
    // End of variables declaration//GEN-END:variables
}
