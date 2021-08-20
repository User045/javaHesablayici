package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IlkSehife extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JButton btnCihazlar;
    private JButton btnSobeler;
    private JButton btnSexsler;
    private JButton şəxslərButton;
    private JButton cihazlarButton;
    private JButton əməliyyatlarButton;

    public IlkSehife(){
        add(panel1);
        setSize(500,600);
        setTitle("Ilk sehife");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);

        btnSexsler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
SexslerinQediyyati sq=new SexslerinQediyyati();
sq.setVisible(true);
setVisible(false);
            }
        });

        btnCihazlar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cihazlarin c=new Cihazlarin();
                c.setVisible(true);
                setVisible(false);
            }
        });
        btnSexsler.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               ButtonRengleri.setBgFg(btnSexsler, Color.black,Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ButtonRengleri.setOrginalBgColor(btnSexsler);
            }
        });
        btnCihazlar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ButtonRengleri.setBgFg(btnCihazlar,Color.black,Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               ButtonRengleri.setOrginalBgColor(btnCihazlar);
            }
        });
        btnSobeler.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               ButtonRengleri.setBgFg(btnSobeler,Color.black,Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               ButtonRengleri.setOrginalBgColor(btnSobeler);
            }
        });
        şəxslərButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reyestr reyestr=new Reyestr();
                reyestr.setVisible(true);
                setVisible(false);

            }
        });

        cihazlarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReyestrCihazlar reyestrCihazlar=new ReyestrCihazlar();
                reyestrCihazlar.setVisible(true);
                setVisible(false);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
