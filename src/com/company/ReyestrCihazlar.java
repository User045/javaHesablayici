package com.company;

import com.company.DataBaseConnection.DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReyestrCihazlar extends JFrame {
    private JTable table1;
    private JScrollBar scrollBar1;
    private JButton button1;
public static DefaultTableModel model1=new DefaultTableModel();
    public ReyestrCihazlar(){
        setSize(500,600);
        setLocationRelativeTo(null);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Data of device");
table1.setModel(model1);

        DataBase.baglan();



    }

    public static void elaqeListele(){
        DataBase.baglan();
        String baglanti="SELECT*FROM cihazlarin";
        ResultSet rs=DataBase.listele(baglanti);
Object [] kolonlar={"ad","soyad","Ata adi"};
Object[] satirlar= new Object[4];
model1.setColumnIdentifiers(kolonlar);

            try {
                if (rs.next())
                satirlar[0]=rs.getString("markasi");
                satirlar[1]=rs.getString("qeydiyyat_no");
                satirlar[2]=rs.getString("imei_kodu");
                satirlar[3]=rs.getString("istifade_olunacaq_sobe");
model1.addRow(satirlar);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }




