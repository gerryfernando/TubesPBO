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
    private char gender;
    private String address;
    private int Gaji;
    private int Saldo;
    private Planning plan;
    private Transaksi t;
    public List <Transaksi> history;
    public User (String nama,int usia,char gender,String address ,int gaji){
        this.address=address;
        this.name=name;
        this.gender=gender;
        this.usia=usia;
        history =  new ArrayList<Transaksi>();
        setGaji(gaji);
        setSaldo(gaji);
    }

    public Transaksi getTransaksi() {
        return t;
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
    

    /**
     * @param name the name to set
     */
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
    
   
    /**
     * @return the usia
     */
    public int getUsia() {
        return usia;
    }

    /**
     * @param usia the usia to set
     */
    public void setUsia(int usia) {
        if(usia>10){
        this.usia = usia;
        }
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
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
