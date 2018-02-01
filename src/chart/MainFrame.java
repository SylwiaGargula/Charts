/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Sylwik
 */
public class MainFrame extends javax.swing.JFrame {
    Object[][] dataFromFile;
     String[] column;
     int selectedAxisX=0;
     int selectedAxisY=0;
     boolean addSeries=false;
     int  selectedForColouring;
     String axisXTitle="X";
     String axisYTitle="Y";
     String chartName="MyChart";
     int start=0;
     int end;
     Color groundColour=Color.CYAN;
     Color series1colour=Color.RED;
     String filterTemp="1";
     String series1Name="1";
     String series2Name="2";
     XYSeriesCollection dataset = new XYSeriesCollection();
     JFreeChart chart;
     XYPlot plot;
     boolean changeAxisXTitle=false;
     boolean changeAxisYTitle=false;
     boolean changeSeries1Name=false;
     boolean changeSeries2Name=false;
     int selectedAxisXSeries=0;
     int selectedAxisYSeries=2;
     JTable table;
     Object[][] dataFromTable;
     int secondLine;
     List<XYSeries> listSeries= new ArrayList<>();
     int font;
     int size;
     int boldItalic;
     java.util.List<Object> listStart= new ArrayList<>();
     java.util.List<Object> listEnd= new ArrayList<>();
     Color series2colour=Color.BLUE;
     Headings headings;
     DataAndRange dataAndRange;
     ColoursAndFont coloursAndFont;
      String fontName;
     boolean firstRead=true;
     int typeChart=1;
     Read read;
     
    
    public MainFrame() {
        super("Application program for data processing");
        initComponents();
        
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        mDataRange.setEnabled(false);
        mHeadings.setEnabled(false);
        mColoursFont.setEnabled(false);
        mSave.setEnabled(false); 
    }

    private void initKit(){
     headings=new Headings(this);
     dataAndRange=new DataAndRange(this);
     coloursAndFont=new ColoursAndFont(this);}
    
    
    private void initChooseFile(){
    JFileChooser jfilechooser=new JFileChooser();
    jfilechooser.setBounds(500, 300, 700, 600);
    jfilechooser.setVisible(true);
    
        try {
            
            if(jfilechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
        File file=jfilechooser.getSelectedFile();
        read=new Read(file);
        dataFromFile= read.getData();
        dataFromTable=dataFromFile.clone();
        column=read.getColumnName();
        secondLine=read.getSecondLine();
        initData(); }
             else
       System.exit(0);
        } catch (Exception e) {
            initChooseFile();
        }
    
     }
    
  
    public void EditFont(XYPlot plot,int font, int size, int boldItalic){
        Font fontTemp;
        this.plot=plot;
        this.boldItalic=boldItalic;
        fontName=coloursAndFont.getFontName(this);
        
        switch (this.boldItalic) {
            case 0:
                {
                    ValueAxis axis = plot.getRangeAxis();
                    fontTemp =new Font(fontName,Font.PLAIN,this.size);
                    axis.setTickLabelFont(fontTemp);
                    ValueAxis axis1 = plot.getDomainAxis();
                    axis1.setTickLabelFont(fontTemp);
                    TextTitle title=chart.getTitle();
                    title.setFont(fontTemp);
                    plot.getDomainAxis().setLabelFont(fontTemp);
                    plot.getRangeAxis().setLabelFont(fontTemp);
                    break;
                }
            case 1:
                {
                    ValueAxis axis = plot.getRangeAxis();
                    fontTemp =new Font(fontName,Font.BOLD,this.size);
                    axis.setTickLabelFont(fontTemp);
                    ValueAxis axis1 = plot.getDomainAxis();
                    axis1.setTickLabelFont(fontTemp);
                    TextTitle title=chart.getTitle();
                    title.setFont(fontTemp);
                     plot.getDomainAxis().setLabelFont(fontTemp);
                    plot.getRangeAxis().setLabelFont(fontTemp);
                    break;
                }
            case 2:
                {
                    ValueAxis axis = plot.getRangeAxis();
                    fontTemp =new Font(fontName,Font.ITALIC,this.size);
                    axis.setTickLabelFont(fontTemp);
                    ValueAxis axis1 = plot.getDomainAxis();
                    axis1.setTickLabelFont(fontTemp);
                    TextTitle title=chart.getTitle();
                    title.setFont(fontTemp);
                    plot.getDomainAxis().setLabelFont(fontTemp);
                    plot.getRangeAxis().setLabelFont(fontTemp);
                    break;
                }
            default:
                break; }}
  
    public List computeRange(int selectedAxisX, int selectedAxisY){
    Object[][] dataTemp;
    List<List> helper;
    listStart=new ArrayList<>();
    listEnd=new ArrayList<>();
    
       dataTemp=dataFromTable.clone();
    double a=0.0;
       
              for(int w=0;w<dataTemp.length;w++){
                if(!isNumeric(dataTemp, w, selectedAxisX))
              a=0.0;
                else 
              a=Double.parseDouble(dataTemp[w][selectedAxisX].toString());
          
                if(a>=start && a<end){
                listStart.add(a);
          
                   listEnd.add(dataTemp[w][selectedAxisY]);};
                                                 }
         
       helper=new ArrayList<>();
       helper.add(listStart);
       helper.add(listEnd);

    return helper;}
  
    
     void initData(){
          
         table = new JTable(dataFromTable, column);
        
         Font fontTemp=new Font("Calibri",Font.PLAIN,13);
         table.setFont(fontTemp);
         
              table.getModel().addTableModelListener((TableModelEvent e) -> {
                  int selectedRow=  table.getSelectedRow();
                  int selectedColumn=table.getSelectedColumn();
                 
                       dataFromTable[selectedRow][selectedColumn]=table.getValueAt(selectedRow, selectedColumn);
                 if(!isNumeric(dataFromTable, selectedRow, selectedColumn)==true)
                 {
                         dataFromTable[selectedRow][selectedColumn]=0.0;  
                         table.setValueAt(0.0, selectedRow, selectedColumn);
                 }
                      if(!firstRead)
                          initChart();
             
                      });
         
        spData.setViewportView(table);
        pTabData.add(spData);
        pTabData.repaint(); 
        end=dataFromFile.length;
        size=10;
        
        if(firstRead)
            initKit();}
    
    
    void initChart(){
        
         mDataRange.setEnabled(true);
         mHeadings.setEnabled(true);
         mColoursFont.setEnabled(true);
         mSave.setEnabled(true);
         Menu.repaint();
        
        
         int filter;
         try {
            filter=Integer.parseInt(dataAndRange.getFilterTemp(this));
        } catch (Exception e) {
            filter=1;}
         
         List<List> pom=computeRange(selectedAxisX, selectedAxisY);
         List<List> pom1=computeRange(selectedAxisXSeries,selectedAxisYSeries);
       
        dataset = new XYSeriesCollection();
       if(addSeries==true){
               if(changeAxisXTitle==false)
               axisXTitle=dataAndRange.getAxisXTitle(this)+"/"+dataAndRange.getAxisXSeriesName(this);
               
               if(changeAxisYTitle==false)
               axisYTitle=dataAndRange.getAxisYTitle(this)+"/"+dataAndRange.getAxisYSeriesName(this);}
       
       else{
               if(changeAxisXTitle==false)
               axisXTitle=dataAndRange.getAxisXTitle(this);
               
               if(changeAxisYTitle==false)
              axisYTitle=dataAndRange.getAxisYTitle(this);}
      
       if(changeSeries1Name==false)
       series1Name=dataAndRange.getAxisXTitle(this)+" - "+dataAndRange.getAxisYTitle(this);
       
        if(changeSeries2Name==false)
       series2Name="Series 2 "+dataAndRange.getAxisXSeriesName(this)+" - "+dataAndRange.getAxisYSeriesName(this);
       
    XYSeries series1 = new XYSeries(series1Name);
    XYSeries series2 = new XYSeries(series2Name);

        try {
             for(int a=0;a<pom.get(0).size();){
        series1.add(Double.valueOf(pom.get(0).get(a).toString()), Double.valueOf(pom.get(1).get(a).toString()));
        series2.add(Double.valueOf(pom1.get(0).get(a).toString()), Double.valueOf(pom1.get(1).get(a).toString()));
        a+=filter;}
        } catch (Exception e) {
        }
     
   dataset.addSeries(series1);
   if(addSeries)
   dataset.addSeries(series2);

   if(typeChart==3)
    chart= ChartFactory.createXYStepAreaChart(chartName, axisXTitle, axisYTitle, dataset, PlotOrientation.VERTICAL, true, false, false);
   if(typeChart==2)
    chart= ChartFactory.createScatterPlot(chartName, axisXTitle, axisYTitle, dataset, PlotOrientation.VERTICAL, true, false, false);
   if(typeChart==1)
     chart= ChartFactory.createXYLineChart(chartName, axisXTitle, axisYTitle, dataset, PlotOrientation.VERTICAL, true, false, false);
    plot= (XYPlot) chart.getPlot();
    EditFont(plot,font,size,boldItalic);
    chart.setBackgroundPaint(groundColour);
    plot.getRenderer().setSeriesPaint(0, series1colour);
    plot.getRenderer().setSeriesPaint(1, series2colour);
    ChartPanel chartpanel=new ChartPanel(chart);
    pTabChart.removeAll();
    pTabChart.add(chartpanel);
    pTabChart.validate();
    firstRead=false;}
    
     
    
      public boolean isNumeric(Object[][] dataFromTable, int selectedRow, int selectedColumn)
      {
          Object[][] data;
          data=dataFromTable;
String dataDoubleses="1";
try{
  dataDoubleses=data[selectedRow][selectedColumn].toString(); 
  Double.parseDouble(dataDoubleses);
                return true;
}
catch(Exception exception){
   return false;
}

      }
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpTab = new javax.swing.JTabbedPane();
        pTabChart = new javax.swing.JPanel();
        pTabData = new javax.swing.JPanel();
        spData = new javax.swing.JScrollPane();
        pPanelData = new javax.swing.JPanel();
        Menu = new javax.swing.JMenuBar();
        mDataRange = new javax.swing.JMenu();
        mHeadings = new javax.swing.JMenu();
        mColoursFont = new javax.swing.JMenu();
        mSave = new javax.swing.JMenu();
        mOpen = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpTab.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        pTabChart.setLayout(new java.awt.BorderLayout());
        tpTab.addTab("Chart", pTabChart);

        pTabData.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pPanelDataLayout = new javax.swing.GroupLayout(pPanelData);
        pPanelData.setLayout(pPanelDataLayout);
        pPanelDataLayout.setHorizontalGroup(
            pPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1639, Short.MAX_VALUE)
        );
        pPanelDataLayout.setVerticalGroup(
            pPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );

        spData.setViewportView(pPanelData);

        pTabData.add(spData, java.awt.BorderLayout.CENTER);

        tpTab.addTab("Data", pTabData);

        mDataRange.setText("Data and Range");
        mDataRange.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mDataRange.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mDataRangeMenuSelected(evt);
            }
        });
        Menu.add(mDataRange);

        mHeadings.setText("Headings");
        mHeadings.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mHeadings.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mHeadingsMenuSelected(evt);
            }
        });
        Menu.add(mHeadings);

        mColoursFont.setText("Colours and Font");
        mColoursFont.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mColoursFont.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mColoursFontMenuSelected(evt);
            }
        });
        Menu.add(mColoursFont);

        mSave.setText("Save");
        mSave.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mSave.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mSaveMenuSelected(evt);
            }
        });
        Menu.add(mSave);

        mOpen.setText("Open");
        mOpen.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mOpen.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mOpenMenuSelected(evt);
            }
        });
        Menu.add(mOpen);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tpTab)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
        );

        tpTab.getAccessibleContext().setAccessibleName("Dane");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mHeadingsMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mHeadingsMenuSelected
     headings.setVisible(true);
    }//GEN-LAST:event_mHeadingsMenuSelected

    private void mOpenMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mOpenMenuSelected
  initChooseFile();
        dataFromTable= new Object[dataFromFile.length][column.length];
        
        for(int n=0; n<dataFromFile.length;n++){
              for(int m=0; m<column.length;m++) {
                            dataFromTable[n][m]=dataFromFile[n][m];} }
      firstRead=true;
      coloursAndFont.setVisible(true);
      headings.setVisible(true);
      dataAndRange.setVisible(true);
      dataAndRange.MyInitComponents();
       
     
    }//GEN-LAST:event_mOpenMenuSelected

    private void mDataRangeMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mDataRangeMenuSelected
     dataAndRange.setVisible(true);
    }//GEN-LAST:event_mDataRangeMenuSelected

    private void mColoursFontMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mColoursFontMenuSelected
coloursAndFont.setVisible(true);
    }//GEN-LAST:event_mColoursFontMenuSelected

    private void mSaveMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mSaveMenuSelected
       try{
          ChartUtilities.saveChartAsJPEG(new File("Chart.jpeg"), chart, 800, 600); }
     catch (IOException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_mSaveMenuSelected

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MainFrame okienko=new MainFrame();
                       okienko.setVisible(true);
            } });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu mColoursFont;
    private javax.swing.JMenu mDataRange;
    private javax.swing.JMenu mHeadings;
    private javax.swing.JMenu mOpen;
    private javax.swing.JMenu mSave;
    private javax.swing.JPanel pPanelData;
    private javax.swing.JPanel pTabChart;
    private javax.swing.JPanel pTabData;
    private javax.swing.JScrollPane spData;
    private javax.swing.JTabbedPane tpTab;
    // End of variables declaration//GEN-END:variables

   
}
