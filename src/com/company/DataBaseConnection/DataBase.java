package com.company.DataBaseConnection;

import java.sql.*;

public class DataBase {


    String url = "jdbc:sqlserver://localhost;database=sexsler";
    String user = "sa";
    String pass = "1";
static Connection conn;

    public static void baglan(){
        String url = "jdbc:sqlserver://localhost;database=sexsler";
        String user = "sa";
        String pass = "1";
        try {
            conn=DriverManager.getConnection(url,user,pass);
            System.out.println("Baglanti alindi 1");
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Baglanti alinmadi 3");
        }
    }

public static ResultSet listele(String sorgu){

    Statement st;
    ResultSet rs;

    try {
        st=conn.createStatement();
        rs=st.executeQuery(sorgu);
        return rs;

    } catch (SQLException exception) {
        exception.printStackTrace();
        return null;
    }



}

    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, user, pass);


    }
    public void ShowError (SQLException exception){
        System.out.println("Error "+exception.getMessage());
        System.out.println("Error code "+exception.getErrorCode());
    }
}



