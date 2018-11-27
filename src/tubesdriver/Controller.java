/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class Controller implements ActionListener{
    private Application model;
    private LoginGUI viewLog;
    private RegistrasiGUI viewReg;
    private MenuGUI viewMenu;
    
    public Controller(Application model){
        this.model=model;
        viewLog=new LoginGUI();
        viewReg=new RegistrasiGUI();
        viewMenu=new MenuGUI();
        viewLog.addActionListener(this);
        viewLog.setVisible(true);
        viewReg.addActionListener(this);
        viewMenu.addActionListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(!source.equals(viewMenu.getBtnLogout())){
            if(source.equals(viewLog.getBtnReg())){
                viewLog.setVisible(false);
                viewReg.setVisible(true);
                if(source.equals(viewReg.getBtnOk())){
                    String nama = viewReg.getName();
                    String username = viewReg.getUsername();
                    String password = viewReg.getPassword();
                    int usia = viewReg.getUsia();
                    String gender = viewReg.getGender();
                    String alamat = viewReg.getAlamat();
                    int gaji = viewReg.getGaji();
                    model.addUser(nama, username, nama, usia, gender, alamat, gaji);
                    model.loadUserProfile();
                    viewReg.setVisible(false);
                    viewLog.setVisible(true);

                    if(viewLog.getBtnLogin().isSelected()){
                        int i = 0;
//                        while(i==0){
//                            if(viewLog.getUsername()== )
//                        }
                    }
                
                }
            }
        
        }
    }
    
}
