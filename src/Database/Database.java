/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Yulius Langobelen
 */
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import tubesdriver.Pendapatan;
import tubesdriver.Pengeluaran;
import tubesdriver.Planning;

import tubesdriver.Planning_Barang;
import tubesdriver.Planning_Harian;

import tubesdriver.Tanggal;
import tubesdriver.Transaksi;
import tubesdriver.User;

public class Database {
    

    private Connection con;
    private Statement state;
    private ResultSet rs;
    private ResultSet rs1;
    private Statement stmt;
    public void connect() {
        
        try {
      
            String url = "jdbc:mysql://localhost/aplikasimanajemenkeuangan";
            String username ="root";
            String pass = "";
            con = DriverManager.getConnection(url, username, pass);
            state=con.createStatement();
            System.out.println("Connected");
            stmt=con.createStatement();
        }catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
                }
            
    }
    
    public void disconnect(){
        if(con != null){
            try{
            con.close();
            con = null;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
   

    
    
    public ArrayList<Transaksi> loadHistory(String username){
        connect();
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
            disconnect();
            return listT;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin History");
            disconnect();
            return null;
        }
        
        
    }
    public void saveUser(User u){
     
        connect();
        
        try {
            String query = "insert into user values('"+u.getName()+"','"+u.getUsername()+"','"+u.getPassword()+"','"+u.getUsia()+"','"+u.getGender()+"','"+u.getAddress()+"',"+u.getGaji()+","+u.getSaldo()+")";
            state.execute(query);
            System.out.println("saving user succeed");
        } catch (SQLException ex) {
            System.out.println("saving user error : "+ex.getMessage());        
        }
        disconnect();
    }
    
       public void savePlanningB(Planning_Barang pb,String username){
     
        connect();
        
        try {
           
            String query = "insert into planning_barang values("+pb.getId()+",'"+username+"',"+pb.getEstimasiBulan()+",'"+pb.getNamaBarang()+"',"+pb.getHarga()+","+pb.getDuit()+")";
            state.execute(query);
            System.out.println("saving planning barang succeed");
        } catch (SQLException ex) {
            System.out.println("saving user error : "+ex.getMessage());        
        }
        disconnect();
    }
    public void savePlanningH(Planning_Harian ph, String username){
     
        connect();
        
        try {
            String query = "insert into planning_harian values("+ph.getId()+","+ph.getDuitHari()+","+ph.getEstimasi()+",'"+username+"')";
            state.execute(query);
            System.out.println("saving planning harian succeed");
        } catch (SQLException ex) {
            System.out.println("saving user error : "+ex.getMessage());        
        }
        disconnect();
    }
    
        
    public String loadPlanningB(String username){
        connect();
        try{
            String query = "select * from planning_barang where username='"+username+"'";
            rs = state.executeQuery(query);
            query = "select saldo from user where username = '"+username+"'";
            rs1=stmt.executeQuery(query);
            rs1.next();
            int saldo = rs1.getInt(1);
            String s = "";

            while(rs.next()){
                
                int id = rs.getInt("id_planning");
                    int estimasiBln = rs.getInt("estimasi_bulan");
                    String barang = rs.getString("nama_barang");
                    int harga = rs.getInt("harga");
                    int tabungan = rs.getInt("tabunganBarang");
                    
                    Planning_Barang p = new Planning_Barang(id, username, barang, harga, estimasiBln, tabungan, saldo);
                    s = s + "Planning Barang : "+"\nID Planning : "+p.getId()+"\nNama Barang : "+p.getNamaBarang()+
                            "\nHarga Barang : "+p.getHarga()+"\nEstimasi Bulan : "+p.getEstimasiBulan()+"\nTabungan per Bulan : "+p.getDuit();
                
            }
            disconnect();
            return s;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin Planning "+ex.getMessage());
            disconnect();
            return null;
        }
    }
        public String loadPlanningH(String username){

    connect();
        try{
            String query = "select * from planning_barang where username='"+username+"'";
            rs = state.executeQuery(query);
            query = "select saldo from user where username = '"+username+"'";
            rs1=stmt.executeQuery(query);
            rs1.next();
            int saldo = rs1.getInt(1);
            String s = "";

            while(rs.next()){
                
                int id = rs.getInt("id_planning");
                    int estimasiHari = rs.getInt("estimasi_hari");
                    Planning_Harian p = new Planning_Harian(id , saldo ,estimasiHari);
                    s = s + "Planning Harian : " + "\nID Planning : "+ p.getId() + "\n Pengeluaran yang disarankan : " +  
                            p.getDuitHari() +" per bulan"+"\nEstimasi Hari : "+p.getEstimasi();
            }
            disconnect();
            return s;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin Planning "+ex.getMessage());
            disconnect();
            return null;
        }
    }
      

        
    public ArrayList<User> loadUser(){
        connect();
        try{
            ArrayList<User> listU = new ArrayList();
            state = con.createStatement();
            String query = "select * from user";
            rs = state.executeQuery(query);
            while(rs.next()){
                User u = new User(
                    rs.getString("nama"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("usia"),
                    rs.getString("gender"),
                    rs.getString("alamat"),
                    rs.getInt("gaji"));
            
            listU.add(u);
            }
            disconnect();
            return listU;
        }
        catch (Exception ex) {
            System.out.println("Error di LIst User");
            disconnect();
            return null;
        }  
    }

  

    public boolean cekLogin(String username,String password){
        connect();

        boolean b=false;

            try {
            String query="select * from user where username='"+username+"'";
            rs=state.executeQuery(query);
            while(rs.next()){
            if(rs.getString("password").equals(password)){
                b= true;
            }
            }
        } catch (SQLException ex) {
            System.out.println("login error : "+ex.getMessage());   
        }

        disconnect();
        return b;
        }

    }

