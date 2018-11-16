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
public abstract class Planning {


   protected Tanggal Tanggal_Mulai;
   

   protected Tanggal Tanggal_Selesai;
   
   public Tanggal getEstimasi(){
      return Tanggal.getEstimateTime(Tanggal_Mulai, Tanggal_Selesai);
   }
   
   public int getEstimasiHari(){
      return Tanggal.getEstimateTimeHari(Tanggal_Mulai, Tanggal_Selesai);
   }
   
   public abstract String Show(); 
   
}
