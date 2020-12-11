/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Rafa
 */
public class User {
    public static String name;

    public static boolean login(String username, String password) {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement st = con.prepareStatement("Select UserName,Password from userinfo where UserName=? and Password=?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet a = st.executeQuery();
            if (a.next()) {
                name = username;
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static void edit(String fname,String phone,String email,String pass){
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement st=con.createStatement();
            String sql="'"+name+"'";
            ResultSet r=st.executeQuery("Select * from userinfo where UserName = "+sql);
            if(r.next()){
                PreparedStatement ps=con.prepareStatement("Update userinfo set FullName= ? ,Phone=?, Email=?, Password = ? where UserName = ?");
                
                if(!fname.isEmpty())
                {
                    ps.setString(1,fname);
                }
                else
                {
                    ps.setString(1,r.getString(2));
                }
                
                
                if(!phone.isEmpty())
                {
                    ps.setString(2,phone);
                }
                else
                {
                    ps.setString(2,r.getString(4));
                }
                
                
                if(!email.isEmpty())
                {
                    ps.setString(3,email);
                }
                else
                {
                    ps.setString(3,r.getString(5));
                }
                
                
                if(!pass.isEmpty())
                {
                    ps.setString(4,pass);
                }
                else
                {
                    ps.setString(4,r.getString(6));
                }
                ps.setString(5,name);
                ps.executeUpdate();
                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
public static void setPreviousValue()
{
    Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement st=con.createStatement();
            String sql="'"+name+"'";
            ResultSet r=st.executeQuery("Select * from userinfo where UserName = "+sql);
            if(r.next()){
              Menu.view(r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6));                     
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
}


  public static void reg(String fname, String uname, String phone, String email, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into userinfo(FullName,UserName,Phone,Email,Password) Values (?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, uname);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static boolean checkUniqueUID(String a) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("Select UserName from userinfo where UserName= '"+a+"'");
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
