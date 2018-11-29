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
public class Planning_Barang extends Planning{
    private String Nama_Barang;
    private int Harga;
    private int id;
    private int EstimasiBulan;
   
    
    private int Duit;
    private int uangTerkumpul;
    
    public Planning_Barang(int id,String username,String Nama_Barang,int Harga ,int estimasibln,int tabungbln,int Gaji){
        
        uangTerkumpul = 0;
        setNamaBarang(Nama_Barang);
        setHarga(Harga);
        setDuit(Gaji);
        setId(id);
    }



    public String getNamaBarang() {
        return Nama_Barang;
    }

    public void setNamaBarang(String nama) {
        this.Nama_Barang = nama;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        this.Harga = harga;
    }

    public int getDuit() {
        return Duit;
    }

    public void setDuit(int Gaji) {
        int cek = getHarga()/getEstimasiBulan();
            if (Gaji-cek <= 600000){
                System.out.println("Maaf Uang anda tidak cukup untuk melakukan rencana ini...");
            }else {
                this.Duit = cek;
            }         
  }
    

    public int getEstimasiBulan() {
       return EstimasiBulan;
    }
    public void setEstimasiBulan(int estimasi){
        this.EstimasiBulan = estimasi;
    }
    

    @Override
    public String Show() {
        return "Selamat Planning Berhasil Dibuat"+ "\nPenyimpanan Uang Perbulan : "+getDuit() +"\nDengan Estimasi Waktu "+getEstimasiBulan()+" bulan"+"\nUang Akan Cukup Untuk Membeli "+getNamaBarang();
    }
}
