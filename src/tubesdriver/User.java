/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yulius Langobelen
 */
public class User implements Edit_Uang{
    private String name;
    private int usia;
    private String gender;
    private String address;
    private int Gaji;
    private int Saldo;
    private Planning plan;
    private String username;
    private String password;
    private Transaksi t;
    public List <Transaksi> history;
    
    public User (String nama,String username,String password,int usia,String gender,String address ,int gaji){
        setAddress(address);
        setGender(gender);
        setUsia(usia);
        setUsername(username);
        setPassword(password);
        setName(nama);
        history =  new ArrayList<Transaksi>();
        setGaji(gaji);
        setSaldo(gaji);
        this.plan=null;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Transaksi getTransaksi() {
        return t;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setTransaksi(Transaksi t) {
        this.t = t;
        setSaldo(t.Operation(Saldo));
    }
    public void setPlanning(Planning p){
         this.plan=p;
     }
    public Planning getPlanning(){
         return this.plan;
     }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name!=""){
        this.name = name;
        }
    }
    public int getGaji() {
        return Gaji;
    }
    public void setGaji(int Gaji) {
        this.Gaji = Gaji;
    }
    public int getSaldo() {
        return Saldo;
    }
    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }
    public int getUsia() {
        return usia;
    }
    public void setUsia(int usia) {
        if(usia>10){
        this.usia = usia;
        }
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        if(address!=""){
        this.address = address;
        }
    }
    public void add_History (Transaksi t){
        history.add(t);
    }
    
    public void showHistory(){
        for (Transaksi o : history){
            System.out.println(o.toString());
        }
    }

    @Override
    public void editable(int uang) {
      setSaldo(uang);   
    }
    
    
}
