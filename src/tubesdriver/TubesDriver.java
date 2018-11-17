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
public class TubesDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Manajemen Keuangan");
        
        User usr = new User("Firdi", 19, 'L', "Telkom univ");
        Planning_Barang pb = new Planning_Barang("Laptop", 5000000, new Tanggal(1,2018), new Tanggal(12,2018), usr.getGaji());
    }
    
}
