/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Database.Database;
import java.util.ArrayList;
import tubesdriver.Planning;
import tubesdriver.User;

/**
 *
 * @author Yulius Langobelen
 */
public class Application {
    
    private ArrayList<User> userList;
    private ArrayList<Planning> planlist;
    private Database db;
    
    public Application(){
        userList=new ArrayList();
        planlist=new ArrayList();
        db=new Database();
        db.connect();
        loadUserProfile();
    }
    public void addUser(String nama,String username,String pass,int usia, String gender,String Alamat,int gaji){
        User u = new User(nama,username,pass,usia,gender,Alamat,gaji);
        db.saveUser(u);
    }
    public void loadUserProfile(){
        userList=db.loadUser();
    }
    
    public String loadUserPlanning(String username){
       return db.loadPlanning(username);
    }
    
    public String getUserprofile(String username){
        String s="";
        for (User u :userList){
            if(u.getUsername().equals(username)){
                s = s + "Nama : "+u.getName()+"\nUsia : "+u.getUsia()+"\nJenis Kelamin : "+u.getGender()+"\nAlamat : "+u.getAddress()+"\nGaji : "+u.getGaji()+"\nSaldo : "+u.getSaldo();
            }
        }
        return s;
    }
    
     
    public boolean isLogin(String username,String password){
        return db.cekLogin(username,password);
    }
   
}
