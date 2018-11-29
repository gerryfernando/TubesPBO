/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.PlanningGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CPlan {
    private PlanningGUI viewPlan;
    
    
    public CPlan(Application model){
        viewPlan = new PlanningGUI();
        viewPlan.setVisible(true);
                            
        viewPlan.getBtnBack().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back pressed");
                viewPlan.dispose();
                new CMenu(model);
            }
        });
        
        viewPlan.getBtnBarang().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("barang pressed");
                viewPlan.dispose();
                new CPlanB(model);
                
            }

        });
        viewPlan.getBtnHarian().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Harian pressed");
                viewPlan.dispose();
                new CPlanH(model);
                
            }

        });
    }
}
