/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.PlanningHarianGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CPlanH {
    private PlanningHarianGUI viewHrn;
    
    public CPlanH(Application model){
        viewHrn = new PlanningHarianGUI();
        viewHrn.setVisible(true);

        viewHrn.getBtnOk().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok pressed");
                
            }

        });
        viewHrn.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel pressed");
                viewHrn.dispose();
                new CMenu(model);
            }

        });
    }
}
