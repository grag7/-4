package com.mycompany.laba3;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI extends javax.swing.JFrame {
    private Manager manager;
    
    public GUI(Manager manager) {
        this.manager = manager;
        initComponents();
        treeConfiguration();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        loadBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        loadBtn.setText("Загрузить файл");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(loadBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(loadBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                manager.processingFile(file);
                treeConfiguration();
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }    
    }//GEN-LAST:event_loadBtnActionPerformed
    private void treeConfiguration() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Реакторы");
        
        List<Reactor> listReactors = manager.getStorage().getReactorStorage();
        for(Reactor reactor: listReactors) {
            DefaultMutableTreeNode reactorNode = new DefaultMutableTreeNode(
                    reactor.getName());
            reactorNode.add(new DefaultMutableTreeNode("Class: "+ reactor.getClasse()));
            reactorNode.add(new DefaultMutableTreeNode("Burnup: "+ reactor.getBurnup()));
            reactorNode.add(new DefaultMutableTreeNode("KPD: " + reactor.getKpd()));
            reactorNode.add(new DefaultMutableTreeNode("Enrichment: " +reactor.getEnrichment()));
            reactorNode.add(new DefaultMutableTreeNode("Termal Capacity: " + reactor.getTermalCapacity()));
            reactorNode.add(new DefaultMutableTreeNode("Electrical Capacity: " + reactor.getElectricalCapacity()));
            reactorNode.add(new DefaultMutableTreeNode("Life time: " + reactor.getLifeTime()));
            reactorNode.add(new DefaultMutableTreeNode("First load: " +reactor.getFirstLoad()));
            reactorNode.add(new DefaultMutableTreeNode("Source: " + reactor.getFileType()));
            
            rootNode.add(reactorNode);
        }
        
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));
        
        
        
        
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton loadBtn;
    // End of variables declaration//GEN-END:variables
}
