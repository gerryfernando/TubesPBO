/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

import Database.Application;
import Controller.Controller;

/**
 *
 * @author Yulius Langobelen
 */
public class TubesDriver {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        Application a = new Application();
        
        
        Controller c = new Controller(a);
        
        
        
        
//        System.out.println("Welcome to Manajemen Keuangan");
//        
//        User usr = new User("Firdi", 19, 'L', "Telkom univ",2000000);
//        Planning pb = new Planning_Barang("Laptop", 5000000, new Tanggal(1,2017), new Tanggal(12,2018), usr.getGaji());
//       // System.out.println(pb.Show());
//       // Planning_Harian ph = new Planning_Harian(usr.getSaldo(),usr,new Tanggal(2,2018),new Tanggal(3,2018));
//        usr.setPlanning(pb);
//       // System.out.println(usr.getPlanning().Show());
//      //  System.out.println(ph.Show());
//        Transaksi tm = new Pendapatan(usr.getSaldo(),100000,new Tanggal(2,2018),"ngamen");
//        usr.setTransaksi(tm);
//       // System.out.println(usr.getTransaksi().toString());
//        System.out.println(usr.getSaldo());
//        Transaksi tk = new Pengeluaran(usr.getSaldo(),100000,new Tanggal(5,2018),"top up diamond");
//        usr.setTransaksi(tk);
//       // System.out.println(usr.getTransaksi().toString());
//        
//        usr.add_History(tm);
//        usr.add_History(tk);
//       // usr.showHistory();
//        
//        usr.editable(5000000);
//        System.out.println(usr.getSaldo());
        
    }
    
}
