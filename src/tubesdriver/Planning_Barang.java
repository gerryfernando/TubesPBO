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
    private int Duit;
    
    public Planning_Barang(String Nama_Barang,int Harga, Tanggal mulai , Tanggal selesai ,int Gaji){
        Tanggal_Mulai = mulai;
        Tanggal_Selesai = selesai;
        
        setNamaBarang(Nama_Barang);
        setHarga(Harga);
        setDuit(Gaji);
        
        
        
        
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
        Tanggal dateEst = super.getEstimasi();
        int estTime = dateEst.bulan + (12*dateEst.tahun);
        return estTime;
    }
    

    @Override
    public String Show() {
        return "Selamat Planning Berhasil Dibuat"+ "\nPenyimpanan Uang Perbulan : "+getDuit() +"\nDengan Estimasi Waktu "+getEstimasi()+"\nUang Akan Cukup Untuk Membeli "+getNamaBarang();
    }
}
