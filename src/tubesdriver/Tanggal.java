/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

import jdk.management.resource.internal.TotalResourceContext;

/**
 *
 * @author John
 */
public class Tanggal {
    
   
    public int bulan;
    public int tahun;
    
    public Tanggal(){
       
        bulan = 1;
        tahun = 2018;
    }
    
    public Tanggal(int bln , int thn){
       
        if(bln > 0 && bln <= 12){
            bulan = bln;
        }else{
            bulan = 1;
        }
        if(thn > 0){
            tahun = thn;
        }else{
            tahun = 2018;
        }
    }
    
    /// Mendapatkan estimasi waktu yang diperlukan dari tgl selesai - tgl mulai
    public static Tanggal getEstimateTime(Tanggal mulai , Tanggal selesai){
        
        int tahun = selesai.tahun - mulai.tahun;
      
        int bulan;
        if(selesai.bulan < mulai.bulan){
            bulan = (selesai.bulan+12) - mulai.bulan;
        }else{
            bulan = selesai.bulan - mulai.bulan;
        }
        
        return new Tanggal(bulan , tahun);
    }
    
    
    /// Mendapatkan estimasi waktu yang diperlukan dari tgl selesai - tgl mulai
    public static int getEstimateTimeHari(Tanggal mulai , Tanggal selesai){
        
        int tahun = selesai.tahun - mulai.tahun;
      
        int bulan;
        if(selesai.bulan < mulai.bulan){
            bulan = (selesai.bulan+12) - mulai.bulan;
        }else{
            bulan = selesai.bulan - mulai.bulan;
        }
        
        int totalTanggal = 0;
        int currentBulan = mulai.bulan;
        int currentTahun = mulai.tahun;
        for(int i= 0 ; i < bulan ; i ++){
            totalTanggal += getTotalTanggal(currentBulan, currentTahun);
            currentBulan++;
            if(currentBulan > 12){
                currentBulan = 1;
                currentTahun++;
            }
        }
        
        
        
        return totalTanggal;
    }
    
    public static int getTotalTanggal(int bulan , int thn){
        switch(bulan){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            
            
            case 2:
               if(thn%4 == 0){
                   return 29;
               }else{
                   return 28;
               }
             
            default :
                return 30;
        
        
        }
        
        
    }
    
}
