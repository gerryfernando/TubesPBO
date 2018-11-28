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
public class Controller{
    private Application model;
    private LoginGUI viewLog;
    
    public Controller(Application model){
        this.model=model;
        viewLog=new LoginGUI();
        //viewLog.addActionListener();
        //viewLog.setVisible(true);
        
    }
    
}
            
        
    
    
    

