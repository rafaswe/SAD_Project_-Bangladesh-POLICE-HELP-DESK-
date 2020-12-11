
package com.project.Database;

import com.project.UI.ReistrationForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Crime {
    public static void crimeInfo(String Cname, String Location, String Ctime, String Cdetails,String vName,String name) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into crimeinformation(CrimeName,Location,CrimeTime,CrimeDetails,VictimName,UserName) Values (?,?,?,?,?,?)");
            ps.setString(1, Cname);
            ps.setString(2,Location);
            ps.setString(3, Ctime);
            ps.setString(4, Cdetails);
            ps.setString(5, vName);
            ps.setString(6, name);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
