/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.LoginGUI;
import GUI.MenuGUI;
import GUI.RegisGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CLogin {
        private LoginGUI viewLog;
        
        
        public CLogin(Application model){
            viewLog=new LoginGUI();
            viewLog.setVisible(true);
            
            viewLog.getBtnLogin().addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    String username=viewLog.getUsername();
                    
                    if(model.isLogin(viewLog.getUsername(), viewLog.getPassword())){
                        viewLog.dispose();
                        Controller.CurentUser = model.getUser(username);
                        new CMenu(model);
                    }
                }
            });
            viewLog.getBtnReg().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Regis Pressed");
                    viewLog.dispose();
                    new CRegis(model);
            }
            });   
        }
}
