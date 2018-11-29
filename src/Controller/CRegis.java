/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.RegisGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CRegis {
    private RegisGUI viewReg;
    
    public CRegis(Application model){
        viewReg = new RegisGUI();
        viewReg.setVisible(true);     
                    
        viewReg.getBtnOk().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addUser(viewReg.getName(), viewReg.getUsername(),viewReg.getPassword(), viewReg.getUsia(), viewReg.getGender(), viewReg.getAlamat(), viewReg.getGaji());
                System.out.println("Ok pressed");
                viewReg.dispose();
                CLogin l = new CLogin(model);
            }
        });
                        
        viewReg.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel pressed");
                viewReg.dispose();
                CLogin l = new CLogin(model);
            }
        });
    }

}
           