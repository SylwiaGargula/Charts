/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sylwia
 */
public class Read  {
 private LineNumberReader  lnr;
 private   int rowNumber=0;
 private  int columnNumber=0;
 private  Object[][] data;
 private String[] columnName;
 private String[] secondHeading;
 private int second=0;
 private int secondLine=0;
 
    public int getRowNumber() {
        return rowNumber;}
 
    public Object[][] getData() {
        return data;}

    public String[] getColumnName() {
        return columnName;}
    
    public int getSecondLine(){ 
        return secondLine;}
    
       public Read(File file){
        try {
            try {
                this.lnr = new LineNumberReader(new FileReader(file));
                lnr.skip(Long.MAX_VALUE);
                rowNumber=lnr.getLineNumber();
                this.lnr = new LineNumberReader(new FileReader(file));
                String columns=lnr.readLine();
                
                int space= columns.indexOf(32);
                int tab= columns.indexOf(9);
                int tab1= columns.indexOf(11);
                
                if(space!=-1)
                {columnName=columns.split(" ");}
                if(tab!=-1)
                {columnName=columns.split("	"); }
                if(tab1!=-1)
                { columnName=columns.split("	"); }
                
                columnNumber=columnName.length;
                data=new Object[rowNumber][columnNumber];
                
                for(int i=0; i<rowNumber-1;i++){
                    String pomoc=lnr.readLine();
                    String[] readLine=pomoc.split("	");
                    
                    if(pomoc.indexOf(40)>-1){
                        second++;
                        secondLine++;}
                    
                    if(second>0){
                        secondHeading=readLine;
                        for(int s=0; s<secondHeading.length;s++)
                            columnName[s]+=secondHeading[s];}
                    
                    else{
                        if(secondLine>0){
                            for(int j=0; j<columnNumber;j++)
                            {data[i-1][j]=Double.parseDouble(readLine[j]); }}
                        else{
                            for(int j=0; j<columnNumber;j++){
                                data[i][j]=Double.parseDouble(readLine[j]);}}}
                    second=0;
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            }
            lnr.close();
          
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

}