/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Database.Database;
import java.util.ArrayList;

import tubesdriver.Planning;
import tubesdriver.Planning_Barang;
import tubesdriver.Planning_Harian;
import tubesdriver.Tanggal;
import tubesdriver.User;

/**
 *
 * @author Yulius Langobelen
 */
public class Application {
    
    private ArrayList<User> userList;
    private String plan;
    private Database db;
    
    public Application(){
        userList=new ArrayList();
        db=new Database();
        db.connect();
        loadUserProfile();
    }
    public void addUser(String nama,String username,String pass,int usia, String gender,String Alamat,int gaji){
        //menambahkan data userbaru ke database
        User u = new User(nama,username,pass,usia,gender,Alamat,gaji);
        db.saveUser(u);
    }
    
    
    public void addPlanningB(int id,String username,String Nama_Barang,int Harga ,int estimasibln,int Gaji){
        //menambahkan data planning barang user tertentu ke database
        Planning_Barang pb = new Planning_Barang(id, username, Nama_Barang, Harga, estimasibln, Gaji);
        db.savePlanningB(pb, username);
    }
    
     public void addPlanningH(int id,int duit, int estimasi,String username){
         //menambahkan data planning harian user tertentu ke database
        Planning_Harian ph = new Planning_Harian(id, duit, estimasi);
        db.savePlanningH(ph, username);
    }
    
    public String loadPlanningBarang(String username){
        //mengambil data planning barang user tertentu dari database
        return db.loadPlanningB(username);
    }
    public String loadPlanningHarian(String username){
        //mengambil data planning harian user tertentu dari database
        return db.loadPlanningH(username);
    }
    
    public void loadUserProfile(){
        //mengambil data user tertentu dari database dan menyimpannya ke list
        userList=db.loadUser();
    }
    

    
    
    public String getUserprofile(String username){
        //mengambil data user dari list dan menyimpannya dalam sebuah string
        String s="";
        for (User u :userList){
            if(u.getUsername().equals(username)){
              s =s+ "Nama : "+u.getName()+"\nUsia : "+u.getUsia()+" Tahun"+"\nJenis Kelamin : "+u.getGender()+"\nAlamat : "+u.getAddress()+"\nGaji : Rp "+u.getGaji()+"\nSaldo : Rp "+u.getSaldo();
                
            }
        }
        return s;
    }
    
    public User getUser(String username){
        //mengambil data user dari list dan menyimpannya dalam sebuah string
        
        return db.loadUser(username);
    }
    
    public int generateIdPB(){
        // mengambil id planning barang terakhir dari database
        return db.generateIdPB()+1;
    }
     
    public boolean isLogin(String username,String password){
        //mngecek data login user tertentu(username dan password)
        return db.cekLogin(username,password);
    }
   
}
