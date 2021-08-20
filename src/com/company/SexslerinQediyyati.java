package com.company;

import com.company.DataBaseConnection.DataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class SexslerinQediyyati extends JFrame {
    private JTextField txtAd;
    private JTextField txtSoyad;
    private JTextField txtAtaAdi;
    private JTextField txtTelefonNo;
    private JTextField txtUnvan;
    private JPanel pnlSexslerinQeydiyyati;
    private JButton btnDaxilEt;
    private JLabel lblAd;
    private JLabel lblSoyad;
    private JLabel lblAtaAdi;
    private JLabel lblTelefonNo;
    private JLabel lblUnvan;


    public SexslerinQediyyati() {

        add(pnlSexslerinQeydiyyati);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnDaxilEt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtAd.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Xanalari doldurun");
                }else {
                    JOptionPane.showMessageDialog(null, "Qeydiyyat tamamlandi");
                    IlkSehife is = new IlkSehife();
                    is.setVisible(true);
                    setVisible(false);
                    try {
                        Insert();
                        System.out.println("Baglanti alindi");
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                }

            }
        });
    }
    public void Insert() throws SQLException {


        Connection connection = null;
        DataBase db = new DataBase();
        PreparedStatement ps = null;

        try {
            connection = db.getConnection();
            String sql = "INSERT INTO melumatlar (ad,soyad,ataadi,telefon_no,unvan) VALUES (?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtAd.getText());
            ps.setString(2, txtSoyad.getText());
            ps.setString(3, txtAtaAdi.getText());
            ps.setString(4, txtTelefonNo.getText());
            ps.setString(5, txtUnvan.getText());
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    }



