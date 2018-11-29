/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.TransaksiGUI;
import GUI.LoginGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Database.Application;

/**
 *
 * @author Yulius Langobelen
 */
public class Controller{
    private Application model;
    private LoginGUI viewLog;
    private RegisGUI viewReg;
    private MenuGUI viewMenu;

    private PlanningGUI viewPlan;
    private TransaksiGUI viewT;


    
    public Controller(Application model){
        this.model=model;
        viewLog=new LoginGUI();
        viewLog.setVisible(true);
        viewReg=new RegisGUI();
        viewT = new TransaksiGUI();

        viewLog.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(model.isLogin(viewLog.getUsername(), viewLog.getPassword()));
                String username=viewLog.getUsername();
                if(model.isLogin(viewLog.getUsername(), viewLog.getPassword())){
                    viewMenu = new MenuGUI();
                    viewLog.setVisible(false);
                    viewMenu.setVisible(true);

                


                    viewMenu.setProfile(model.getUserprofile(username));
                    viewMenu.setPlaning(model.loadUserPlanning(username));    
                    
                    viewMenu.getBtnLogout().addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                               System.out.println("LogOut Pressed");
                               viewMenu.setVisible(false);
                               viewLog.setVisible(true);
                        }
                    });
                    
                    viewMenu.getBtnTransaksi().addActionListener(new ActionListener(){
                        
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("transaksi pressed");
                            viewMenu.setVisible(false);
                            viewT.setVisible(true);
                        }
                        
                        
                        
                    });
                    
         }          
         }
        });
        
         viewLog.getBtnReg().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Regis Pressed");
                    viewReg = new RegisGUI();
                    viewLog.setVisible(false);
                    viewReg.setVisible(true);     
                    
                        viewReg.getBtnOk().addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            model.addUser(viewReg.getName(), viewReg.getUsername(),viewReg.getPassword(), viewReg.getUsia(), viewReg.getGender(), viewReg.getAlamat(), viewReg.getGaji());
                            System.out.println("Ok pressed");
                            viewReg.setVisible(false);
                            viewLog.setVisible(true);
                        }});
                        
                        viewReg.getBtnCancel().addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("cancel pressed");
                            viewReg.setVisible(false);
                            viewLog.setVisible(true);
                        }
                            });
            }
            }
         );   
}
}
