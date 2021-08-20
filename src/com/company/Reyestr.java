package com.company;

import com.company.DataBaseConnection.DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reyestr extends JFrame {
    public JTable tables;
    private JPanel panel1;
    private JScrollBar scrollBar1;
    private JButton button1;
    public static DefaultTableModel modelim=new DefaultTableModel();
//    public static Object[] kolonlar ={"Ad","Soyad","Ata Adi","Telefon","Unvan"};
    public Reyestr(){
        add(panel1);
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
baglanListele();
        tables.setModel(modelim);
//        scrollBar1.add(tables);
      //  scrollBar1.addAdjustmentListener((AdjustmentListener) tables);

    }


    public static void baglanListele(){
        DataBase.baglan();
        modelim=new DefaultTableModel();
        Object[] colDoctorName=new Object[5];
        colDoctorName[0]="Ad";
        colDoctorName[1]="Soyad";
        colDoctorName[2]="Ata adi";
        colDoctorName[3]="Telefon";
        colDoctorName[4]="Unvan";
        modelim.setColumnIdentifiers(colDoctorName);


        String liseteleSql="SELECT *FROM melumatlar";
       ResultSet rs=DataBase.listele(liseteleSql);
       Object[] kolonlar ={"Ad","Soyad","Ata Adi","Telefon","Unvan"};
       Object[] satirlar=new Object[5];
modelim.setColumnIdentifiers(kolonlar);

           try {
               while (rs.next()){
                   satirlar[0]=rs.getString("ad");
                   satirlar[1]=rs.getString("soyad");
                   satirlar[2]=rs.getString("ataadi");
                   satirlar[3]=rs.getString("unvan");
                   satirlar[4]=rs.getString("telefon_no");
modelim.addRow(satirlar);

               }



           } catch (SQLException exception) {
               exception.printStackTrace();
           }



   }

}
