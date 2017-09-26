/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arogya;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author Karan-PC
 */
public class Verify extends javax.swing.JFrame {

    /**
     * Creates new form Verify
     */
    private int mem_count=0;
    private int verify_count=0;
    public Verify() {
        
        initComponents();
        this.addWindowListener(exitListener);
         
    }
    
    WindowListener exitListener = new WindowAdapter() {

    @Override
    public void windowClosing(WindowEvent e) {
        
           new ClientWindow().setVisible(true);
        
    }
};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verify");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, false},
                {null, null, null, null, false}
            },
            new String [] {
                "Sr. no.", "Enrollment ID", "Name", "No of Members to verify", ""
            }
        )

        {
            boolean[] canEdit = new boolean[]{
                false, false,false,false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

        }

        //{public boolean isCellEditable(int row, int column){return false;}}
    );
    jTable1.setEditingColumn(0);
    jTable1.setEditingRow(0);
    jTable1.setRowHeight(20);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jButton1.setText("Verify");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1)
            .addGap(46, 46, 46))
        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
            .addComponent(jButton1)
            .addGap(25, 25, 25))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();
            String id = jTable1.getValueAt(row, 1).toString();
            SurveyForm.verifyCheck=true;
            try {
                UnMarshal(id);
            } catch (JAXBException | FileNotFoundException ex) {
                Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
      
   }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        try {
            
           UnMarshalling();
           for (int i = 0; i < verify_count; i++) {
            System.out.println(jTable1.getModel().getValueAt(i, 4));
            
            }
       } catch (JAXBException | FileNotFoundException ex) {
           Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int c=0;
        int arr[] = new int[verify_count];
        for (int i = 0; i < verify_count; i++) {
            if((boolean)jTable1.getModel().getValueAt(i, 4))
            {
                arr[c]=Integer.parseInt(jTable1.getModel().getValueAt(i, 0).toString());
                c++;
                System.out.println(arr[i]);
            }
        }
        
        String[] ids = new String[c];
        boolean status;
        for (int i = 0; i < c; i++) {
                ids[i]=jTable1.getModel().getValueAt((arr[i]-1), 1).toString();
        }
        
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(MembersList.class);
            for (int i = 0; i < ids.length; i++) {
                MembersList config = (MembersList)jc.createUnmarshaller().unmarshal(new File(System.getProperty("user.dir")+"/Data/Packet/"+ids[i]+".xml"));
                List<SurveyFormData> list = config.getSurvey();
                list.get(0).setStatus(true);
            
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                Calendar cal = Calendar.getInstance();
                String s;
                s=dateFormat.format(cal.getTime()).toString();
                
                Marshaller m = jc.createMarshaller();
                FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"/Archive/"+ids[i]+"_"+s+".xml");
                FileOutputStream fo1 = new FileOutputStream(System.getProperty("user.dir")+"/Data/Packet/"+ids[i]+".xml");
                m.marshal(config,  fo);
                m.marshal(config,  fo1);
            }   
            
          
        } catch (JAXBException ex) {
            Logger.getLogger(Verify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Verify.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
        new ClientWindow().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UnMarshal(String id) throws JAXBException,FileNotFoundException
    {
         JAXBContext jaxbContext = JAXBContext.newInstance(MembersList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        File folder = new File(System.getProperty("user.dir")+"/Data/Packet");
        File[] listOfFiles = folder.listFiles(new FilenameFilter() 
        { @Override public boolean accept(File dir, String name) { return name.endsWith(".xml"); } });
        
        for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
          if(listOfFiles[i].getName().equalsIgnoreCase(id+".xml")){
          MembersList ml = (MembersList) jaxbUnmarshaller.unmarshal( new File(System.getProperty("user.dir")+"/Data/Packet/"+listOfFiles[i].getName()) );
              SurveyForm sd1 = new SurveyForm();
          for(SurveyFormData sd : ml.getSurvey())
        {
            
        sd1.jComboBox1.setSelectedItem(sd.getDistrict());
        sd1.jComboBox2.setSelectedItem(sd.getPhc());
        sd1.jComboBox3.setSelectedItem(sd.getHealth_centre());
        sd1.jComboBox4.setSelectedItem(sd.getAsha_member());
        
        sd1.jComboBox5.setSelectedItem(sd.getVillage());
        sd1.jTextField1.setText(Long.toString(sd.getForm_num()));
        sd1.jTextField2.setText(sd.getHof_name());
        sd1.jTextField3.setText(Integer.toString(sd.getF_members()));
        sd1.jTextField4.setText(Long.toString(sd.getMobile()));
        
        sd1.jTextField5.setText(Long.toString(sd.getRashan_id()));
        sd1.jTextField6.setText(sd.getBhamasha());
        
        sd1.jTextField1.setEditable(false);
        sd1.jTextField2.setEditable(false);
        sd1.jTextField3.setEditable(false);
        sd1.jTextField4.setEditable(false);
        sd1.jTextField5.setEditable(false);
        sd1.jTextField6.setEditable(false);
        sd1.jComboBox1.setEnabled(false);
        sd1.jComboBox2.setEnabled(false);
        sd1.jComboBox3.setEnabled(false);
        sd1.jComboBox4.setEnabled(false);
        sd1.jComboBox5.setEnabled(false);
        
        if(Long.toString(sd.getHealth_insurance())==null)
        {
            sd1.buttonGroup1.setSelected(sd1.jRadioButton7.getModel(), true);
            sd1.jRadioButton6.setEnabled(false);
            
        }
        else
        {
        sd1.buttonGroup1.setSelected(sd1.jRadioButton6.getModel(), true);
        sd1.jRadioButton7.setEnabled(false);
        sd1.jTextField7.setText(Long.toString(sd.getHealth_insurance()));
        }   
        
        sd1.jButton1.setEnabled(false);
        sd1.jButton2.setEnabled(false);
        sd1.jButton3.setEnabled(false);
        
        sd1.jTextField7.setEditable(false);
        }
          int k=0;
        for(MemberData md : ml.getMembers())
        {
        sd1.jTable1.setValueAt(md.getSr_no(), k, 0);
        sd1.jTable1.setValueAt(md.getMember_name(), k, 1);
        sd1.jTable1.setValueAt(md.getRelation(), k, 2);
        sd1.jTable1.setValueAt(md.getGender(), k, 3);
        sd1.jTable1.setValueAt(md.getDob(), k, 4);
        sd1.jTable1.setValueAt(md.getAge(), k, 5);
        sd1.jTable1.setValueAt(md.getDisease(), k, 6);
        sd1.jTable1.setValueAt(md.getDisease_symp(), k, 7);
        sd1.jTable1.setValueAt(md.getAadhar(), k, 8);
        k++;
        }
        sd1.jTable1.setEnabled(false);
          sd1.setVisible(true);
          
          }
    }
        }
    }
    
    private void UnMarshalling() throws JAXBException,FileNotFoundException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(MembersList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        File folder = new File(System.getProperty("user.dir")+"/Data/Packet");
        File[] listOfFiles = folder.listFiles(new FilenameFilter() 
        { @Override public boolean accept(File dir, String name) { return name.endsWith(".xml"); } });

        SurveyForm.total_enrol= listOfFiles.length;
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        
        int k =0;
        verify_count=0;
    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
          MembersList ml = (MembersList) jaxbUnmarshaller.unmarshal( new File(System.getProperty("user.dir")+"/Data/Packet/"+listOfFiles[i].getName()) );
        
        for(SurveyFormData sd : ml.getSurvey())
        {
            if(sd.isStatus()==false)
            {
                dtm.setRowCount(k+1);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
                mem_count=0;
            for(MemberData md : ml.getMembers())
            {
            mem_count++;
            }
            jTable1.getModel().setValueAt(k+1, k,0);
            jTable1.getModel().setValueAt(sd.getForm_num(), k,1);
            jTable1.getModel().setValueAt(sd.getHof_name(),k,2);
            jTable1.getModel().setValueAt(mem_count, k,3);
            jTable1.getModel().setValueAt(false, k, 4);
            k++;
            verify_count++;
            }
            
        }
        
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
      
    }
      System.out.println(verify_count);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Verify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Verify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}