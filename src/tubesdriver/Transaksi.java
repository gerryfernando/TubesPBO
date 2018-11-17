/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;
import java.util.*;



/**
 *
 * @author Yulius Langobelen
 */
public  abstract class Transaksi {
    private int Nominal;
    private String Detail;
    private Tanggal Tgl;
    
    
    public abstract int Operation(int Saldo);
    
    public abstract String toString();
       
   
    
    public int getNominal() {
        return Nominal;
    }

    /**
     * @param Nominal the Nominal to set
     */
    public void setNominal(int Nominal) {
        this.Nominal = Nominal;
    }

    /**
     * @return the Detail
     */
    public String getDetail() {
        return Detail;
    }

    /**
     * @param Detail the Detail to set
     */
    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    /**
     * @return the Tanggal
     */
    public Tanggal getTanggal() {
        return Tgl;
    }

 
    public void setTanggal(Tanggal tgl) {
        this.Tgl = tgl;
    }
}
