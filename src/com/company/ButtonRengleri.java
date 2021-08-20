package com.company;

import javax.swing.*;
import java.awt.*;

public class ButtonRengleri {
    private static Color orginalBgColor,orginalFgColor;

    public static void setBgFg(JButton button,Color color, Color fgColor){
        orginalBgColor=button.getBackground();
        orginalFgColor=button.getForeground();
        button.setBackground(color);
        button.setForeground(fgColor);
    }

    public static void setOrginalBgColor(JButton button){
     button.setBackground(orginalBgColor);
     button.setForeground(orginalFgColor);
    }
}
