package com.project.Database;

import com.project.UI.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Police {

    public static void PoliceInfo(String Pname, String batch, String workstation, String Rank, String number) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into police(PoliceName,Batch,WorkStation,Rank,Number) Values (?,?,?,?,?)");
            ps.setString(1, Pname);
            ps.setString(2, batch);
            ps.setString(3, workstation);
            ps.setString(4, Rank);
            ps.setString(5, number);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readInfo() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement st = con.prepareStatement("select * from police");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String PID = String.valueOf(rs.getInt("PoliceId"));
                String Pname = rs.getString("PoliceName");
                String number= rs.getString("Number");
                String Wstation = rs.getString("WorkStation");
                Menu.Value(PID,Pname,number,Wstation);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void select(String ws) {
   try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from police where WorkStation= '"+ws+"'");
             while (rs.next()) {
                String PID = String.valueOf(rs.getInt("PoliceId"));
                String Pname = rs.getString("PoliceName");
                String number= rs.getString("Number");
                String Wstation = rs.getString("WorkStation");
                 Menu.Value(PID,Pname,number,Wstation);
      }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    

}
