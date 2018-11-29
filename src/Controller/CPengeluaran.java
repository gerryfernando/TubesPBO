/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.PengeluaranGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CPengeluaran {
    private PengeluaranGUI viewKeluaran;
    
    public CPengeluaran(Application model){
        viewKeluaran = new PengeluaranGUI();
        viewKeluaran.setVisible(true);
        
        viewKeluaran.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel pressed");
                viewKeluaran.dispose();
                new CMenu(model);
            }

        });
        viewKeluaran.getBtnOk().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok pressed");
                viewKeluaran.dispose();
                new CMenu(model);
            }
        });
                               
    }
}
