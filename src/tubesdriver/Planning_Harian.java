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
public class Planning_Harian extends Planning {
    private int duit ;
    private int duithari;
    public Planning_Harian(int duit){
        setTanggalMulai(Tanggal_Mulai);
        setTanggalSelesai(Tanggal_Selesai);
        setEstimasi(Tanggal_Selesai-Tanggal_Mulai);
        setDuit(duit);
        setDuitHari(duit);
        
    }
    
    public void setTanggalMulai(int Tanggal_Mulai ){
        super.Tanggal_Mulai = Tanggal_Mulai;
        
    }
    public void setTanggalSelesai(int Tanggal_Selesai ){
        super.Tanggal_Selesai= Tanggal_Selesai;
        
    }
    public void setEstimasi(int Estimasi){
        this.Estimasi = Estimasi;
    }
    public int getEstimasi(){
        return Estimasi;
    }
    public void setDuit(int duit){
        this.duit=duit;
    }
    public int getDuit(){
        return duit;
    }
    
    
    public int getDuitHari(){
        return duithari;
    }
    public void setDuitHari(int duit){
        this.duithari=getDuit()/getEstimasi();
    }
    
    
   
    
    @Override
    public String Show() {
        return "Maksimal Penggunaan perharinya agar kebutuhan dapat tercukupi adalah "+getDuitHari();
    }
    
}
