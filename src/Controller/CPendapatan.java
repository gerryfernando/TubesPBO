/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.PendapatanGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CPendapatan {
    private PendapatanGUI viewDapatan;
    
    public CPendapatan(Application model){
        viewDapatan=new PendapatanGUI();
        viewDapatan.setVisible(true);

        viewDapatan.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel pressed");
                viewDapatan.dispose();
                new CMenu(model);
            }
        });
        viewDapatan.getBtnOk().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok pressed");
                viewDapatan.dispose();
                new CMenu(model);

            }

        });
    }
}
