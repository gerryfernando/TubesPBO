/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Yulius Langobelen
 */
public class Controller implements ActionListener{
    private Application model;
    private LoginGUI viewLog;
    
    public Controller(Application model){
        this.model=model;
        viewLog=new LoginGUI();
        viewLog.addActionListener(this);
        viewLog.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(viewLog.getBtnLogin())){
            if(model.isLogin(viewLog.getUsername(),viewLog.getPassword())){
                
            }
//            if(source.equals(viewLog.getBtnReg())){
//               // viewReg.setVisible(true);
//                if(source.equals(viewReg.getBtnOk())){
//                    String nama = viewReg.getName();
//                    String username = viewReg.getUsername();
//                    String password = viewReg.getPassword();
//                    int usia = viewReg.getUsia();
//                    String gender = viewReg.getGender();
//                    String alamat = viewReg.getAlamat();
//                    int gaji = viewReg.getGaji();
//                    model.addUser(nama, username, nama, usia, gender, alamat, gaji);
//                    model.loadUserProfile();
//
//                    if(viewLog.getBtnLogin().isSelected()){
//                        if(model.isLogin(viewLog.getUsername(),viewLog.getPassword())){
//                            viewLog.setVisible(false);
//                            viewMenu.setVisible(true);
//                            viewMenu.setProfile(model.getUserprofile(viewLog.getUsername()));
//                        }
//                    }
                
                }
            }}
            
        
    
    
    

