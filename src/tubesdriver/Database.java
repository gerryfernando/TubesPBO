/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

/**
 *
 * @author Yulius Langobelen
 */
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    

    private Connection con;
    private Statement state;
    private ResultSet rs;
    
    public void connect() {
        
        try {
      
            String url = "jdbc:mysql://localhost/aplikasimanajemenkeuangan";
            String username ="root";
            String pass = "";
            con = DriverManager.getConnection(url, username, pass);
            state=con.createStatement();
            System.out.println("Connected");
            
        }catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
                }
            
        }

    
    
    public ArrayList<Transaksi> loadHistory(String username){
        
        try{
            
            ArrayList<Transaksi> listT = new ArrayList();
            String query = "select * from transaksi where username = '"+username+"'";
            rs = state.executeQuery(query);
            while (rs.next()){
               String Tanggal=rs.getString("Tanggal");
               int i=0;
               String bulan="";
               String tahun ="";
               while(Tanggal.charAt(i)!='-'){
                   bulan+=Tanggal.charAt(i);
                   i++;
               }
               i=i+1;
               while(i!=Tanggal.length()){
                   tahun+=Tanggal.charAt(i);
               }
               Transaksi t=null;
               if(rs.getString("jenisTransaksi")==("pengeluaran")){
                    t = new Pengeluaran(rs.getInt("id_Transaksi"),rs.getInt("saldo"),rs.getInt("nominal"),rs.getString("username"),new Tanggal(Integer.parseInt(bulan),Integer.parseInt(tahun)),rs.getString("detail"));
               }else if(rs.getString("jenisTransaksi")=="pendapatan"){
                    t = new Pendapatan(rs.getInt("id_Transaksi"),rs.getInt("saldo"),rs.getInt("nominal"),rs.getString("username"),new Tanggal(Integer.parseInt(bulan),Integer.parseInt(tahun)),rs.getString("detail"));
               }
               listT.add(t);
            }
            return listT;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin History");
            return null;
        }
    }
        public void saveUser(User u){
          
        try {
            String query = "insert into user values('"+u.getName()+"','"+u.getUsername()+"','"+u.getPassword()+"','"+u.getUsia()+"','"+u.getGender()+"','"+u.getAddress()+"',"+u.getGaji()+","+u.getSaldo();
            rs=state.executeQuery(query);
            System.out.println("saving user succeed");
        } catch (SQLException ex) {
            System.out.println("saving user error : "+ex.getMessage());        }
        }
        
        public ArrayList<Planning> loadPlanning(){
        try{
            ArrayList<Planning> listP = new ArrayList();
            String query = "select * from planning";
            rs = state.executeQuery(query);
            Planning p = new Planning() {
                @Override
                public String Show() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            listP.add(p);
            return listP;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin Planning");
            return null;
        }
        }
        
         public ArrayList<User> loadUser(){
        try{
            ArrayList<User> listU = new ArrayList();
            state = con.createStatement();
            String query = "select * from user";
            rs = state.executeQuery(query);
            User u = new User(
                    rs.getString("nama"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("usia"),
                    rs.getString("gender"),
                    rs.getString("alamat"),
                    rs.getInt("gaji"));
            
            listU.add(u);
            return listU;
        }
        catch (Exception ex) {
            System.out.println("Error di LIst User");
            return null;
        }  
    }
         
        public boolean cekLogin(String username,String password){
        try {
            boolean b=false;
            String query="select password from user where username='"+username+"'";
            rs=state.executeQuery(query);
            System.out.println(rs.getString("password"));
            if(rs.getString("password").equals(password)){
                b= true;
            }
        } catch (SQLException ex) {
            System.out.println("login error : "+ex.getMessage());   
        }
        return false;
         }
    }

