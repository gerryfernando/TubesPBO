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
    private int duit,id ;
    private int duithari;
    private int Estimasi;
    public Planning_Harian(int id,int duit, int estimasi){
        setEstimasi(estimasi);
        setDuit(duit);
        setDuitHari(duit);
        setId(id);
    }

    public int getEstimasi() {
        return Estimasi;
    }

    public void setEstimasi(int Estimasi) {
        this.Estimasi = Estimasi;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        
        this.duithari=Math.round(getDuit()/(getEstimasi()*1.0f));
        
    }
    
    
   
    
    @Override
    public String Show() {
        return "Maksimal Penggunaan perharinya agar kebutuhan dapat tercukupi adalah "+getDuitHari();
    }
    
}
