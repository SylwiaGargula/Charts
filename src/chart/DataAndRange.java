/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

/**
 *
 * @author Sylwik
 */
public class DataAndRange extends javax.swing.JFrame {
int selectedAxisX=0;
int selectedAxisY=0;
int selectedAxisXSeries=0;
int selectedAxisYSeries=2;
 Object[][] data;
 String[] column;
 MainFrame mainFrame;
 int start=0;
 int end;
 String filterTemp="1";
 ButtonGroup group;
 
 
        DataAndRange(MainFrame mainFrame){
          super("Data and Range");
          this.mainFrame=mainFrame;
          initComponents();
          MyInitComponents();
          javax.swing.border.Border border=BorderFactory.createLineBorder(Color.GRAY);
          pPanelSeriesII.setBorder(border);
          pPanelSeriesI.setBorder(border);
          pPanelRange.setBorder(border);
          pPanelFilter.setBorder(border);
          setResizable(false);
          setAlwaysOnTop(true);
          pPanelRange.setEnabled(false);
          pPanelFilter.setEnabled(false);
          cbSecondSeries.setSelected(true);
        }

    
    public void MyInitComponents(){
        selectedAxisX=mainFrame.selectedAxisX;
        selectedAxisY=mainFrame.selectedAxisY;
        selectedAxisXSeries=mainFrame.selectedAxisXSeries;
        selectedAxisYSeries=mainFrame.selectedAxisYSeries;
        data=mainFrame.dataFromTable;
        column=mainFrame.column;
        filterTemp=mainFrame.filterTemp;
        jsStart.setValue(1);
        jsEnd.setValue(10);
        
        
        group = new ButtonGroup();
        group.add(rbLine);
        group.add(rbScatter);
        group.add(rbStepArea);
        rbLine.setSelected(true);
        rbScatter.setSelected(false);
        rbStepArea.setSelected(false);
      
         cbSeriesX.removeAllItems();
         cbSeriesY.removeAllItems();
         cbAxisX.removeAllItems();
         cbAxisY.removeAllItems();
        
    for (String column1 : column) {
        cbAxisY.addItem(column1);
        cbAxisX.addItem(column1);
        cbSeriesX.addItem(column1);
        cbSeriesY.addItem(column1);}

        cbAxisX.setSelectedIndex(0);
        cbAxisY.setSelectedIndex(0);
        cbSeriesX.setSelectedIndex(0);
        cbSeriesY.setSelectedIndex(1);}
    
    
     public String getAxisXTitle(MainFrame mainFrame){
     this.mainFrame=mainFrame;
     return (String)cbAxisX.getSelectedItem();}
    
    public String getAxisYTitle(MainFrame mainFrame){
    this.mainFrame=mainFrame;
     return (String)cbAxisY.getSelectedItem();}
    
    public String getAxisXSeriesName(MainFrame mainFrame) {
    this.mainFrame=mainFrame;
     return (String)cbSeriesX.getSelectedItem();}
    
    public String getAxisYSeriesName(MainFrame mainFrame){
    this.mainFrame=mainFrame;
    return (String)cbSeriesY.getSelectedItem();}
    
    public String getFilterTemp(MainFrame mainFrame){
        this.mainFrame=mainFrame;
        return tfFilter.getText();}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPanelButtons = new javax.swing.JPanel();
        bClose = new javax.swing.JButton();
        bOk = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        pPanelSeriesI = new javax.swing.JPanel();
        cbAxisX = new javax.swing.JComboBox<>();
        cbAxisY = new javax.swing.JComboBox<>();
        lAxisX = new javax.swing.JLabel();
        lAxisY = new javax.swing.JLabel();
        lseriesI = new javax.swing.JLabel();
        pPanelRange = new javax.swing.JPanel();
        lRange = new javax.swing.JLabel();
        lStart = new javax.swing.JLabel();
        lEnd = new javax.swing.JLabel();
        jsStart = new javax.swing.JSpinner();
        jsEnd = new javax.swing.JSpinner();
        bOkRange = new javax.swing.JButton();
        bAll = new javax.swing.JButton();
        pPanelFilter = new javax.swing.JPanel();
        lFilter = new javax.swing.JLabel();
        tfFilter = new javax.swing.JTextField();
        pPanelSeriesII = new javax.swing.JPanel();
        lSeriesII = new javax.swing.JLabel();
        lAxisYSeriesII = new javax.swing.JLabel();
        lAxisXSeriesII = new javax.swing.JLabel();
        cbSeriesX = new javax.swing.JComboBox<>();
        cbSeriesY = new javax.swing.JComboBox<>();
        cbSecondSeries = new javax.swing.JCheckBox();
        pPanelType = new javax.swing.JPanel();
        lType = new javax.swing.JLabel();
        rbLine = new javax.swing.JRadioButton();
        rbScatter = new javax.swing.JRadioButton();
        rbStepArea = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pPanelButtons.setLayout(new javax.swing.BoxLayout(pPanelButtons, javax.swing.BoxLayout.LINE_AXIS));

        bClose.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });
        pPanelButtons.add(bClose);

        bOk.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        bOk.setText("Draw");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });
        pPanelButtons.add(bOk);

        bReset.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        bReset.setText("Reset");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });
        pPanelButtons.add(bReset);

        cbAxisX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAxisX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAxisXActionPerformed(evt);
            }
        });

        cbAxisY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAxisY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAxisYActionPerformed(evt);
            }
        });

        lAxisX.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lAxisX.setText("X axis's data");

        lAxisY.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lAxisY.setText("Y axis's data");

        lseriesI.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lseriesI.setText("Series I- data");

        javax.swing.GroupLayout pPanelSeriesILayout = new javax.swing.GroupLayout(pPanelSeriesI);
        pPanelSeriesI.setLayout(pPanelSeriesILayout);
        pPanelSeriesILayout.setHorizontalGroup(
            pPanelSeriesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelSeriesILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pPanelSeriesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelSeriesILayout.createSequentialGroup()
                        .addComponent(lAxisY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbAxisY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelSeriesILayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lAxisX)
                        .addGap(18, 18, 18)
                        .addComponent(cbAxisX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pPanelSeriesILayout.createSequentialGroup()
                .addComponent(lseriesI)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pPanelSeriesILayout.setVerticalGroup(
            pPanelSeriesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelSeriesILayout.createSequentialGroup()
                .addComponent(lseriesI)
                .addGap(13, 13, 13)
                .addGroup(pPanelSeriesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAxisX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAxisX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pPanelSeriesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAxisY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAxisY))
                .addGap(34, 34, 34))
        );

        lRange.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lRange.setText("Range");

        lStart.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lStart.setText("From");

        lEnd.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lEnd.setText("To");

        jsStart.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        jsEnd.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));

        bOkRange.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        bOkRange.setText("OK");
        bOkRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkRangeActionPerformed(evt);
            }
        });

        bAll.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        bAll.setText("All");
        bAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelRangeLayout = new javax.swing.GroupLayout(pPanelRange);
        pPanelRange.setLayout(pPanelRangeLayout);
        pPanelRangeLayout.setHorizontalGroup(
            pPanelRangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelRangeLayout.createSequentialGroup()
                .addComponent(lEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jsEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pPanelRangeLayout.createSequentialGroup()
                .addComponent(lRange)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pPanelRangeLayout.createSequentialGroup()
                .addComponent(lStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jsStart, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pPanelRangeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bOkRange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPanelRangeLayout.setVerticalGroup(
            pPanelRangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelRangeLayout.createSequentialGroup()
                .addComponent(lRange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPanelRangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lStart)
                    .addComponent(jsStart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPanelRangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lEnd)
                    .addComponent(jsEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(pPanelRangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOkRange)
                    .addComponent(bAll)))
        );

        lFilter.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lFilter.setText("Filter data every ");

        tfFilter.setText("1");
        tfFilter.setMinimumSize(new java.awt.Dimension(1, 1));
        tfFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelFilterLayout = new javax.swing.GroupLayout(pPanelFilter);
        pPanelFilter.setLayout(pPanelFilterLayout);
        pPanelFilterLayout.setHorizontalGroup(
            pPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelFilterLayout.createSequentialGroup()
                .addComponent(lFilter)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pPanelFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPanelFilterLayout.setVerticalGroup(
            pPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelFilterLayout.createSequentialGroup()
                .addComponent(lFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lSeriesII.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lSeriesII.setText("Series II- data");

        lAxisYSeriesII.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lAxisYSeriesII.setText("Y axis's data");

        lAxisXSeriesII.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lAxisXSeriesII.setText("X axis's data");

        cbSeriesX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeriesXActionPerformed(evt);
            }
        });

        cbSeriesY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeriesYActionPerformed(evt);
            }
        });

        cbSecondSeries.setText("Second series");
        cbSecondSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecondSeriesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelSeriesIILayout = new javax.swing.GroupLayout(pPanelSeriesII);
        pPanelSeriesII.setLayout(pPanelSeriesIILayout);
        pPanelSeriesIILayout.setHorizontalGroup(
            pPanelSeriesIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelSeriesIILayout.createSequentialGroup()
                .addComponent(lSeriesII)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(pPanelSeriesIILayout.createSequentialGroup()
                .addGroup(pPanelSeriesIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lAxisXSeriesII)
                    .addComponent(lAxisYSeriesII))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPanelSeriesIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSeriesY, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSeriesX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(pPanelSeriesIILayout.createSequentialGroup()
                .addComponent(cbSecondSeries)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pPanelSeriesIILayout.setVerticalGroup(
            pPanelSeriesIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelSeriesIILayout.createSequentialGroup()
                .addComponent(lSeriesII)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPanelSeriesIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSeriesX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pPanelSeriesIILayout.createSequentialGroup()
                        .addComponent(lAxisXSeriesII)
                        .addGap(36, 36, 36)
                        .addGroup(pPanelSeriesIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lAxisYSeriesII)
                            .addComponent(cbSeriesY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbSecondSeries))
        );

        pPanelType.setLayout(new javax.swing.BoxLayout(pPanelType, javax.swing.BoxLayout.LINE_AXIS));

        lType.setText("Type of chart");
        pPanelType.add(lType);

        rbLine.setText("XYLine");
        rbLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLineActionPerformed(evt);
            }
        });
        pPanelType.add(rbLine);

        rbScatter.setText("Scatter");
        rbScatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbScatterActionPerformed(evt);
            }
        });
        pPanelType.add(rbScatter);

        rbStepArea.setText("Step Arena");
        rbStepArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStepAreaActionPerformed(evt);
            }
        });
        pPanelType.add(rbStepArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pPanelSeriesI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pPanelSeriesII, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPanelRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pPanelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(pPanelType, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pPanelFilter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pPanelRange, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pPanelSeriesI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pPanelSeriesII, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pPanelType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAxisXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAxisXActionPerformed
         selectedAxisX=cbAxisX.getSelectedIndex();
        if(selectedAxisX==-1)
           selectedAxisX=0; 
        
        mainFrame.selectedAxisX=selectedAxisX;
        mainFrame.changeAxisXTitle=false;
        mainFrame.changeSeries2Name=false;

        if(!mainFrame.firstRead)
        mainFrame.initChart();
        
        pPanelFilter.setEnabled(true);
        pPanelRange.setEnabled(true);
        
    }//GEN-LAST:event_cbAxisXActionPerformed

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
      mainFrame.initChart();
    }//GEN-LAST:event_bOkActionPerformed

    private void cbAxisYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAxisYActionPerformed
        selectedAxisY=cbAxisY.getSelectedIndex();
         if(selectedAxisY==-1)
            selectedAxisY=0;
         
        mainFrame.selectedAxisY=selectedAxisY;
        mainFrame.changeAxisYTitle=false;
        mainFrame.changeSeries1Name=false;
        
        if(!mainFrame.firstRead)
        mainFrame.initChart();
        
        pPanelFilter.setEnabled(true);
        pPanelRange.setEnabled(true);
        
    }//GEN-LAST:event_cbAxisYActionPerformed

    private void tfFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFilterActionPerformed
        filterTemp=tfFilter.getText();
        mainFrame.filterTemp=filterTemp;
        
        if(!mainFrame.firstRead)
        mainFrame.initChart();
    }//GEN-LAST:event_tfFilterActionPerformed

    private void bOkRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkRangeActionPerformed
       start= (Integer)  jsStart.getValue();
        end= (Integer)  jsEnd.getValue();
        if(start<end){
       mainFrame.start=start;
       mainFrame.end=end; }
        else{
        start=end-1;
        mainFrame.start=start;
        mainFrame.end=end;
        }
            if(!mainFrame.firstRead)
        mainFrame.initChart();
    }//GEN-LAST:event_bOkRangeActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
      if(!mainFrame.firstRead)
        mainFrame.initChart();
        
        this.setVisible(false);
    }//GEN-LAST:event_bCloseActionPerformed

    private void cbSeriesXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeriesXActionPerformed
        selectedAxisXSeries=cbSeriesX.getSelectedIndex();
        cbSecondSeries.setSelected(true);
        if(selectedAxisXSeries==-1)
         selectedAxisXSeries=0;
        
        mainFrame.selectedAxisXSeries=selectedAxisXSeries;
        mainFrame.changeSeries1Name=false;
        mainFrame.addSeries=true;
        
        if(!mainFrame.firstRead)
        mainFrame.initChart();
        
        pPanelFilter.setEnabled(true);
        pPanelRange.setEnabled(true);
    }//GEN-LAST:event_cbSeriesXActionPerformed

    private void cbSeriesYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeriesYActionPerformed
       selectedAxisYSeries=cbSeriesY.getSelectedIndex();
       cbSecondSeries.setSelected(true);
        if(selectedAxisYSeries==-1)
        selectedAxisYSeries=0;
        
       mainFrame.selectedAxisYSeries=selectedAxisYSeries;
       mainFrame.changeSeries2Name=false;
       mainFrame.addSeries=true;
       
       if(!mainFrame.firstRead)
       mainFrame.initChart();
       
       pPanelFilter.setEnabled(true);
        pPanelRange.setEnabled(true);
    }//GEN-LAST:event_cbSeriesYActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        mainFrame.typeChart=1;
        rbLine.setSelected(true);
        rbScatter.setSelected(false);
        rbStepArea.setSelected(false);
        tfFilter.setText("1");
        mainFrame.filterTemp="1";
        jsStart.setValue(1);
        jsEnd.setValue(10);
       mainFrame.initData();
       mainFrame.initChart();
       MyInitComponents();
       pPanelFilter.setEnabled(false);
       pPanelRange.setEnabled(false);
    }//GEN-LAST:event_bResetActionPerformed

    private void bAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAllActionPerformed
       mainFrame.initData();
       mainFrame.initChart();
    }//GEN-LAST:event_bAllActionPerformed

    private void rbLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLineActionPerformed
     mainFrame.typeChart=1;
     mainFrame.initChart();
    }//GEN-LAST:event_rbLineActionPerformed

    private void rbScatterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbScatterActionPerformed
      mainFrame.typeChart=2;
      mainFrame.initChart();
    }//GEN-LAST:event_rbScatterActionPerformed

    private void rbStepAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStepAreaActionPerformed
      mainFrame.typeChart=3;
      mainFrame.initChart();
    }//GEN-LAST:event_rbStepAreaActionPerformed

    private void cbSecondSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecondSeriesActionPerformed
      if(!cbSecondSeries.isSelected())
       
         mainFrame.addSeries=false;
        else
            mainFrame.addSeries=true;
        
          if(!mainFrame.firstRead)
        mainFrame.initChart();
        
        pPanelFilter.setEnabled(false);
        pPanelRange.setEnabled(false);
    }//GEN-LAST:event_cbSecondSeriesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAll;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bOk;
    private javax.swing.JButton bOkRange;
    private javax.swing.JButton bReset;
    private javax.swing.JComboBox<String> cbAxisX;
    private javax.swing.JComboBox<String> cbAxisY;
    private javax.swing.JCheckBox cbSecondSeries;
    private javax.swing.JComboBox<String> cbSeriesX;
    private javax.swing.JComboBox<String> cbSeriesY;
    private javax.swing.JSpinner jsEnd;
    private javax.swing.JSpinner jsStart;
    private javax.swing.JLabel lAxisX;
    private javax.swing.JLabel lAxisXSeriesII;
    private javax.swing.JLabel lAxisY;
    private javax.swing.JLabel lAxisYSeriesII;
    private javax.swing.JLabel lEnd;
    private javax.swing.JLabel lFilter;
    private javax.swing.JLabel lRange;
    private javax.swing.JLabel lSeriesII;
    private javax.swing.JLabel lStart;
    private javax.swing.JLabel lType;
    private javax.swing.JLabel lseriesI;
    private javax.swing.JPanel pPanelButtons;
    private javax.swing.JPanel pPanelFilter;
    private javax.swing.JPanel pPanelRange;
    private javax.swing.JPanel pPanelSeriesI;
    private javax.swing.JPanel pPanelSeriesII;
    private javax.swing.JPanel pPanelType;
    private javax.swing.JRadioButton rbLine;
    private javax.swing.JRadioButton rbScatter;
    private javax.swing.JRadioButton rbStepArea;
    private javax.swing.JTextField tfFilter;
    // End of variables declaration//GEN-END:variables
}
