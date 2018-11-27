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
        viewReg.addActionListener(this);
        viewReg.setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
