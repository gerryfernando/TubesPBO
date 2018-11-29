/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Application;
import GUI.PlanningBarangGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulius Langobelen
 */
public class CPlanB {
    private PlanningBarangGUI viewBrg;
    
    public CPlanB(Application model){
        viewBrg = new PlanningBarangGUI();
        viewBrg.setVisible(true);
        
        System.out.println(model.generateIdPB());
        viewBrg.setIdPlan(model.generateIdPB());
        
        viewBrg.getBtnSubmit().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("submit pressed");
                model.addPlanningB(viewBrg.getIdPlan(),Controller.CurentUser.getUsername(), viewBrg.getNamaB(), viewBrg.getHarga(), viewBrg.getEstimasi(),Controller.CurentUser.getGaji());
                viewBrg.toStringBarang(model.loadPlanningBarang(Controller.CurentUser.getUsername()));
            }
            
        });
        viewBrg.getBtnDone().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("done pressed");
                viewBrg.dispose();
                new CMenu(model);
            }
            
        });
        viewBrg.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel pressed");
                viewBrg.dispose();
                new CMenu(model);
            }

        });
    }
}
