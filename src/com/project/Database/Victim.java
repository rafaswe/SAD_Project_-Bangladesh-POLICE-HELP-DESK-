
package com.project.Database;

import com.project.UI.ReistrationForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Victim {
     public static void vicInfo(String Vname, int Age, String phone, String NID, String Nationality,String Address,String username) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into victim(VictimName,VictimAge,Mobile,NID,Nationality,VictimAddress,UserName) Values (?,?,?,?,?,?,?)");
            ps.setString(1, Vname);
            ps.setInt(2, Age);
            ps.setString(3, phone);
            ps.setString(4, NID);
            ps.setString(5, Nationality);
            ps.setString(6, Address);
            ps.setString(7, username);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static boolean checkUniqueUID(String a) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("Select VictimName from victim where VictimName= '"+a+"'");
            if (r.next()) {
                return false;
            } else {
                return true;
            }
             
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

}
