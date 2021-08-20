package com.company;

import com.company.DataBaseConnection.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cihazlarin extends JFrame {
    private JPanel pnlCihazlar;
    private JTextField txtMarkasi;
    private JTextField txtQeydiyyar_no;
    private JTextField txtImei_kodu;
    private JTextField txtIstifadeOlunacaqSobe;
    private JButton btnDaxilEt;

    public Cihazlarin() {
        add(pnlCihazlar);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setTitle("Cihazlarin qeydiyyati");
        setLocationRelativeTo(null);
        setFocusable(true);


        btnDaxilEt.addActionListener(e -> {
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
        });
        btnDaxilEt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ButtonRengleri.setBgFg(btnDaxilEt, Color.BLACK,Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ButtonRengleri.setOrginalBgColor(btnDaxilEt);
            }
        });
    }

    public void Insert() throws SQLException {


        Connection connection;
        DataBase db = new DataBase();
        PreparedStatement ps ;
        try {
            connection = db.getConnection();
            String sql = "INSERT INTO cihazlarin (markasi,qeydiyyat_no,imei_kodu,istifade_olunacaq_sobe) VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtMarkasi.getText());
            ps.setString(2, txtQeydiyyar_no.getText());
            ps.setString(3, txtImei_kodu.getText());
            ps.setString(4, txtIstifadeOlunacaqSobe.getText());
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
