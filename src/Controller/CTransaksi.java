/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.TransaksiGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CTransaksi {
    private TransaksiGUI viewT;
    
    public CTransaksi(Application model){
    
        viewT= new TransaksiGUI();
        viewT.setVisible(true);

        viewT.getBtnBack().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back pressed");
                viewT.dispose();
                new CMenu(model);
            }
        });
        viewT.getBtnPendapatan().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pendapatan pressed");
                viewT.dispose();
                new CPendapatan(model);

            }
        });
        viewT.getBtnPengeluaran().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewT.dispose();
                new CPengeluaran(model);
            }
        });
    }
}
