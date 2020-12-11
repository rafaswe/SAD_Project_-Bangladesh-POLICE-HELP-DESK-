package com.project.Database;

import com.project.UI.Menu;
import com.project.UI.ReistrationForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Suspect {
     public static void susInfo(String Sname, int SAge, String Relation, String motive, String Saddress,String Uname,String Vname) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into suspect(SuspectName,SuspectAge,RelationShip,Motive,SuspectAddress,UserName,VictimName) Values (?,?,?,?,?,?,?)");
            ps.setString(1, Sname);
            ps.setInt(2,SAge);
            ps.setString(3, Relation);
            ps.setString(4, motive);
            ps.setString(5, Saddress);
            ps.setString(6, Uname);
            ps.setString(7,Vname );
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
