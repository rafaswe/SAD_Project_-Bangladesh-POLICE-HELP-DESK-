package com.project.Database;


import com.project.UI.PoliceForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Diary {
   
      public static void readInfo() {
        try {
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
           PreparedStatement st1 = con.prepareStatement("select * from victim ");
            ResultSet rs1 = st1.executeQuery();
            while (rs1.next()) {
                String vname = rs1.getString("VictimName");
                String Vage = String.valueOf(rs1.getInt("VictimAge"));
                String Mobile= rs1.getString("Mobile");
                String NID = rs1.getString("NID");
                String Vaddress = rs1.getString("VictimAddress");
                String Nationality = rs1.getString("Nationality");
              PoliceForm.Value(vname,Vage,Mobile,NID,Vaddress,Nationality);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
      public static void moreInfo(String a){
            try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement st2 = con.prepareStatement("select * from crimeinformation where VictimName = ?");
            PreparedStatement st3 = con.prepareStatement("select * from suspect  where VictimName = ?");
            st2.setString(1, a);
            st3.setString(1, a);
            ResultSet rs2 = st2.executeQuery();
            ResultSet rs3 = st3.executeQuery();
            
            while (rs2.next()) {
               String Cname = rs2.getString("CrimeName");
                String Location = rs2.getString("Location");
               String CrimeTime = rs2.getString("CrimeTime");
              String CrimeDetails = rs2.getString("CrimeDetails");
              PoliceForm.setValueOfCrime(Cname,Location,CrimeTime,CrimeDetails);
            }
            while (rs3.next()) {
               String Susname = rs3.getString("SuspectName");
               String SuspectAge = String.valueOf(rs3.getInt("SuspectAge"));
               String relation = rs3.getString("Relationship");
               String Motive = rs3.getString("Motive");
               String Saddress = rs3.getString("SuspectAddress");
               PoliceForm.setValueOfSuspect(Susname,SuspectAge,relation,Motive,Saddress);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
      }

}
