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
public class Pendapatan extends Transaksi {
    int total_Saldo=0;
    public Pendapatan(int Saldo,int nominal,Tanggal tgl,String Detail){
        
        super.setTanggal(tgl);
        super.setDetail(Detail);
        super.setNominal(nominal);
        Operation(Saldo);
        setTotalSaldo(Saldo);

    }

    public int getTotalSaldo() {
        return total_Saldo;
    }

    public void setTotalSaldo(int total_Saldo) {
        this.total_Saldo = total_Saldo;
    }
    
    @Override
    public int Operation(int total_Saldo) {
        return getTotalSaldo()+super.getNominal();       
    }
    
    public int getSaldoBaru(){
        return Operation(getTotalSaldo());
    }
    
    @Override
    public String toString() {
        return "Waktu Transaksi(Bln-Thn) : "+getTanggal().bulan+"-"+getTanggal().tahun+"\nPemasukan : "+super.getNominal()+"\nTotal Saldo : "+getSaldoBaru()+"\nDetail : "+super.getDetail();
                }
    }
