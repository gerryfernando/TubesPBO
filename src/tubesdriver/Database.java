/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Yulius Langobelen
 */
import java.util.logging.Level;
import java.util.logging.Logger;
public class Database {
    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    public void connect() {
        try {
            String url = "jbdc:mysql://localhost:3306/library";
            String username ="root";
            String pass = "";
            con = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected");
        }catch (SQLException ex) {
            System.out.println("Error");
                }
            
        }
    
    public void disconnect(){
        try{
          con.close();
          state.close();
            
        }catch (SQLException ex) {
            System.out.println("Error");
                }
        
        
    }
    
    
    public ArrayList<Transaksi> loadHistory(){
        try{
            ArrayList<Transaksi> listT = new ArrayList();
            state = con.createStatement();
            String query = "select * from ";
            rs = state.executeQuery(query);
            while (rs.next()){
                
               Transaksi t = new Transaksi();
                listT.add(t);
            }
            return listT;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin History");
            return null;
        }
        
         public ArrayList<Planning> loadPlanning(){
        try{
            ArrayList<Planning> listP = new ArrayList();
            state = con.createStatement();
            String query = "select * from ";
            rs = state.executeQuery(query);
            Planning p = new Planning();
            listP.add(p);
            return listT;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin Planning");
            return null;
        }
        
         public ArrayList<User> loadUser(){
        try{
            ArrayList<User> listU = new ArrayList();
            state = con.createStatement();
            String query = "select * from ";
            rs = state.executeQuery(query);
            User u = new User();
            listU.add(p);
            return listU;
        }
        catch (Exception ex) {
            System.out.println("Error di LIst User");
            return null;
        }
            
        
        
    }
    }

