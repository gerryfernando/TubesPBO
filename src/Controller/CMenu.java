/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.MenuGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CMenu {
    private MenuGUI viewMenu;
    public String username;
    
    public CMenu(Application model){
        
        viewMenu = new MenuGUI();

        viewMenu.setVisible(true);

        viewMenu.setProfile(model.getUserprofile(Controller.CurentUser.getUsername()));
        viewMenu.setPlaningH(model.loadPlanningHarian(Controller.CurentUser.getUsername()));
        viewMenu.setPlaningB(model.loadPlanningBarang(Controller.CurentUser.getUsername()));

        viewMenu.getBtnLogout().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   System.out.println("LogOut Pressed");
                   viewMenu.dispose();
                   new CLogin(model);
            }
        });
        viewMenu.getBtnPlanning().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("planning pressed");
                viewMenu.dispose();
                new CPlan(model);
            }          
         });

        viewMenu.getBtnTransaksi().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("transaksi pressed");
                viewMenu.dispose();
                new CTransaksi(model);

                 }

        });

                       
                    
    }
}
