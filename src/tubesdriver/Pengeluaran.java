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
public class Pengeluaran extends Transaksi{
    int total_Saldo;
    public Pengeluaran (int nominal,String Detail,String Tgl){
        super.setNominal(nominal);
        super.setDetail(Detail);
        super.setTanggal(Tgl);
        
    }
  
  
   
   @Override
   public String toString(){
        return "Tanggal : "+getTanggal()+"\nPemasukan : "+super.getNominal()+"\nTotal Saldo : "+this.Operation(total_Saldo);
       
   }

    @Override
  public int Operation(int total_Saldo) {
        return total_Saldo-=super.getNominal();
        
    }

   
    
    
}
