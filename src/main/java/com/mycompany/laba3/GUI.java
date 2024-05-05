package com.mycompany.laba3;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI extends javax.swing.JFrame {
    private Manager manager;
    
    public GUI(Manager manager) {
        try {
            this.manager = manager;
            initComponents();
            treeConfiguration();

            File currentDirectory = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
            fileChooser.setCurrentDirectory(currentDirectory);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON, YAML, XML", "json", "yaml", "xml");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
        } catch (URISyntaxException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        panel = new javax.swing.JPanel();
        treeProcesses = new javax.swing.JScrollPane();
        reactorsTree = new javax.swing.JTree();
        download = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        treeProcesses.setViewportView(reactorsTree);

        download.setText("Загрузить файл");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(download)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(treeProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(treeProcesses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(download)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                manager.processingFile(file);
                treeConfiguration();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Ошибка чтения", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            
        }    
    }//GEN-LAST:event_downloadActionPerformed
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
        
        reactorsTree.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));    
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton download;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel panel;
    private javax.swing.JTree reactorsTree;
    private javax.swing.JScrollPane treeProcesses;
    // End of variables declaration//GEN-END:variables
}
