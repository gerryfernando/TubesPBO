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
    public Planning_Harian(int duit , Tanggal mulai , Tanggal selesai){
        setTanggalMulai(mulai);
        setTanggalSelesai(selesai);
        setDuit(duit);
        setDuitHari(duit);
        
    }
    
    public void setTanggalMulai(Tanggal Tanggal_Mulai ){
        super.Tanggal_Mulai = Tanggal_Mulai;
        
    }
    public void setTanggalSelesai(Tanggal Tanggal_Selesai ){
        super.Tanggal_Selesai= Tanggal_Selesai;
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
        this.duithari=getDuit()/super.getEstimasiHari();
    }
    
    
   
    
    @Override
    public String Show() {
        return "Maksimal Penggunaan perharinya agar kebutuhan dapat tercukupi adalah "+getDuitHari();
    }
    
}
