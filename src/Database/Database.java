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
            String query = "insert into user values('"+u.getName()+"','"+u.getUsername()+"','"+u.getPassword()+"','"+u.getUsia()+"','"+u.getGender()+"','"+u.getAddress()+"',"+u.getGaji()+","+u.getSaldo()+")";
            state.execute(query);
            System.out.println("saving user succeed");
        } catch (SQLException ex) {
            System.out.println("saving user error : "+ex.getMessage());        }
        }
        
        public String loadPlanning(String username){
        try{
            String query = "select * from planning where username='"+username+"'";
            rs = state.executeQuery(query);
            query = "select saldo from user where username = '"+username+"'";
            rs1=stmt.executeQuery(query);
            rs1.next();
            int saldo = rs1.getInt(1);
            String s = "";

            while(rs.next()){

                int id = rs.getInt("id_planning");
                String jenis = rs.getString("jenis_planning");
                String mulai = rs.getString("Tanggal_Mulai");
                String selesai = rs.getString("Tanggal_Selesai");
                int pengeluaranHari = rs.getInt("pengeluaranHari");
                int i=0;
                String bulanmulai="";
                String tahunmulai ="";
                while(mulai.charAt(i)!='-'){
                    bulanmulai+=mulai.charAt(i);
                    i++;
                }
                i=i+1;
                while(i!=mulai.length()){
                    tahunmulai+=mulai.charAt(i);
                }                
                i=0;
                String bulanselesai="";
                String tahunselesai ="";
                while(selesai.charAt(i)!='-'){
                    bulanselesai+=selesai.charAt(i);
                    i++;
                }
                i=i+1;
                while(i!=selesai.length()){
                    tahunselesai+=selesai.charAt(i);
                }                
                if(jenis == "Planning Harian"){
                    int estimasiHari = rs.getInt("estimasi_hari");
                    Planning_Harian p = new Planning_Harian(id , saldo , new Tanggal(Integer.parseInt(bulanmulai),Integer.parseInt(tahunmulai)) , new Tanggal(Integer.parseInt(bulanselesai),Integer.parseInt(tahunselesai)));
                    s = s + "Planning Harian : " + "\nID Planning : "+ p.getId() + "\n Pengeluaran yang disarankan : " +  
                            p.getDuitHari() +" per bulan" + "\nBulan Mulai : "+mulai+"\nBulan Selesai : "+selesai
                            +"\nEstimasi Hari : "+p.getEstimasiHari();

                }
                else if(jenis=="Planning Barang"){
                    int estimasiBln = rs.getInt("estimasi_bulan");
                    String barang = rs.getString("nama_barang");
                    int harga = rs.getInt("harga");
                    int tabungan = rs.getInt("tabunganBarang");
                    
                    Planning_Barang p = new Planning_Barang(id, username, barang, harga, new Tanggal(Integer.parseInt(bulanmulai),Integer.parseInt(tahunmulai)) , new Tanggal(Integer.parseInt(bulanselesai),Integer.parseInt(tahunselesai)), estimasiBln, tabungan, saldo);
                    s = s + "Planning Barang : "+"\nID Planning : "+p.getId()+"\nNama Barang : "+p.getNamaBarang()+
                            "\nHarga Barang : "+p.getHarga()+"\nBulan Mulai : "+mulai+"\nBulan Selesai : "+selesai
                            +"\nEstimasi Bulan : "+p.getEstimasiBulan()+"\nTabungan per Bulan : "+p.getDuit();
                    System.out.println(s);
                } 
            }
            return s;
        }
        catch (Exception ex) {
            System.out.println("Error di Tampilin Planning "+ex.getMessage());
            return null;
        }
        }
        
         public ArrayList<User> loadUser(){
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
            return listU;
        }
        catch (Exception ex) {
            System.out.println("Error di LIst User");
            return null;
        }  
    }
         
        public boolean cekLogin(String username,String password){
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
        return b;
         }
    }

