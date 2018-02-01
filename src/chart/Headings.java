/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Sylwik
 */
public class Headings extends javax.swing.JFrame {
     boolean changeAxisXTitle=false;
     boolean changeAxisYTitle=false;
     String axisXTitle="X";
     String axisYTitle="Y";
     String chartName="Chart";
     String series1Name="1";
     String series2Name="2"; 
      MainFrame mainFrame;
    
    public Headings(MainFrame mainFrame) {
        super("Headings");
        this.mainFrame=mainFrame;
        initComponents();
        MyInitComponents();
        javax.swing.border.Border border=BorderFactory.createLineBorder(Color.GRAY);
        pPanelHeadings.setBorder(border);
        setResizable(false);
        setAlwaysOnTop(true); }

    public void MyInitComponents() {
        changeAxisXTitle=mainFrame.changeAxisXTitle;
        changeAxisYTitle=mainFrame.changeAxisYTitle;
        axisXTitle=mainFrame.axisXTitle;
        axisYTitle=mainFrame.axisYTitle;
        chartName=mainFrame.chartName;
        series1Name=mainFrame.series1Name;
        series2Name=mainFrame.series2Name; }
    
    
    public String getAxisXTitle(MainFrame mainFrame){
      this.mainFrame=mainFrame;
      mainFrame.axisXTitle=axisXTitle;
      return mainFrame.axisXTitle; }
    
     public String getAxisYTitle(MainFrame mainFrame){
      this.mainFrame=mainFrame;
      mainFrame.axisYTitle=axisYTitle;
      return mainFrame.axisYTitle; }
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bclose = new javax.swing.JButton();
        pPanelHeadings = new javax.swing.JPanel();
        tfseries1Title = new javax.swing.JTextField();
        lseries1 = new javax.swing.JLabel();
        tfchartName = new javax.swing.JTextField();
        tfAxisXTitle = new javax.swing.JTextField();
        tfAxisYTitle = new javax.swing.JTextField();
        tfseries2Title = new javax.swing.JTextField();
        lchartHeading = new javax.swing.JLabel();
        laxisXTitle = new javax.swing.JLabel();
        laxixYTitle = new javax.swing.JLabel();
        lseries2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bclose.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        bclose.setText("Close");
        bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcloseActionPerformed(evt);
            }
        });

        tfseries1Title.setText("Series I");
        tfseries1Title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfseries1TitleActionPerformed(evt);
            }
        });

        lseries1.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lseries1.setText("Series I");

        tfchartName.setText("Chart");
        tfchartName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfchartNameActionPerformed(evt);
            }
        });

        tfAxisXTitle.setText("X axis");
        tfAxisXTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAxisXTitleActionPerformed(evt);
            }
        });

        tfAxisYTitle.setText("Y axis");
        tfAxisYTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAxisYTitleActionPerformed(evt);
            }
        });

        tfseries2Title.setText("Series II");
        tfseries2Title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfseries2TitleActionPerformed(evt);
            }
        });

        lchartHeading.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lchartHeading.setText("Chart's heading");

        laxisXTitle.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        laxisXTitle.setText("X axis's heading");

        laxixYTitle.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        laxixYTitle.setText("Y axis's heading");

        lseries2.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lseries2.setText("Series II");

        javax.swing.GroupLayout pPanelHeadingsLayout = new javax.swing.GroupLayout(pPanelHeadings);
        pPanelHeadings.setLayout(pPanelHeadingsLayout);
        pPanelHeadingsLayout.setHorizontalGroup(
            pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelHeadingsLayout.createSequentialGroup()
                .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelHeadingsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lseries2)
                            .addComponent(laxisXTitle)
                            .addComponent(laxixYTitle))
                        .addGap(15, 15, 15)
                        .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAxisYTitle)
                            .addComponent(tfseries2Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(tfAxisXTitle, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pPanelHeadingsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lchartHeading)
                            .addComponent(lseries1))
                        .addGap(18, 18, 18)
                        .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfchartName)
                            .addComponent(tfseries1Title))))
                .addContainerGap())
        );
        pPanelHeadingsLayout.setVerticalGroup(
            pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelHeadingsLayout.createSequentialGroup()
                .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lchartHeading)
                    .addComponent(tfchartName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lseries1)
                    .addComponent(tfseries1Title, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lseries2)
                    .addComponent(tfseries2Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAxisXTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laxisXTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPanelHeadingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAxisYTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laxixYTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(pPanelHeadings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(bclose, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pPanelHeadings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bclose)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfAxisXTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAxisXTitleActionPerformed
        mainFrame.changeAxisXTitle=true;
        axisXTitle=tfAxisXTitle.getText();
        mainFrame.axisXTitle=axisXTitle;
        mainFrame.initChart();
    }//GEN-LAST:event_tfAxisXTitleActionPerformed

    private void tfAxisYTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAxisYTitleActionPerformed
        mainFrame.changeAxisYTitle=true;
        axisYTitle=tfAxisYTitle.getText();
        mainFrame.axisYTitle=axisYTitle;
        mainFrame.initChart();
    }//GEN-LAST:event_tfAxisYTitleActionPerformed

    private void tfchartNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfchartNameActionPerformed
        chartName=tfchartName.getText();
        mainFrame.chartName=chartName;
        mainFrame.initChart();
    }//GEN-LAST:event_tfchartNameActionPerformed

    private void tfseries1TitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfseries1TitleActionPerformed
        series1Name=tfseries1Title.getText();
        mainFrame.series1Name=series1Name;
        mainFrame.changeSeries1Name=true;
        mainFrame.initChart();
    }//GEN-LAST:event_tfseries1TitleActionPerformed

    private void tfseries2TitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfseries2TitleActionPerformed
         series2Name=tfseries2Title.getText();
        mainFrame.series2Name=series2Name;
        mainFrame.changeSeries2Name=true;
        mainFrame.initChart();
    }//GEN-LAST:event_tfseries2TitleActionPerformed

    private void bcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcloseActionPerformed
        mainFrame.initChart();
        this.setVisible(false);
    }//GEN-LAST:event_bcloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bclose;
    private javax.swing.JLabel laxisXTitle;
    private javax.swing.JLabel laxixYTitle;
    private javax.swing.JLabel lchartHeading;
    private javax.swing.JLabel lseries1;
    private javax.swing.JLabel lseries2;
    private javax.swing.JPanel pPanelHeadings;
    private javax.swing.JTextField tfAxisXTitle;
    private javax.swing.JTextField tfAxisYTitle;
    private javax.swing.JTextField tfchartName;
    private javax.swing.JTextField tfseries1Title;
    private javax.swing.JTextField tfseries2Title;
    // End of variables declaration//GEN-END:variables
}
