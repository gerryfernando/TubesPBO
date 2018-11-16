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
public class Pendapatan extends Transaksi {
    int total_Saldo;
    public Pendapatan(int Saldo){
        Operation(Saldo);
        setTanggal(super.getTanggal());
        setDetail(super.getDetail());
    }

    @Override
    public int Operation(int total_Saldo) {
        return total_Saldo+=super.getNominal();       
    }
    @Override
    public String toString() {
        return "Tanggal : "+getTanggal()+"\nPemasukan : "+super.getNominal()+"\nTotal Saldo : "+this.Operation(total_Saldo);
                }
    }
