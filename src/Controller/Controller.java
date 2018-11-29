/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.RegisGUI;
import GUI.TransaksiGUI;
import GUI.LoginGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Application;
import GUI.LoginGUI;
import GUI.MenuGUI;
import GUI.PendapatanGUI;
import GUI.PengeluaranGUI;
import GUI.PlanningBarangGUI;
import GUI.PlanningGUI;
import GUI.PlanningHarianGUI;
import GUI.RegisGUI;
import GUI.TransaksiGUI;
import tubesdriver.User;

/**
 *
 * @author Yulius Langobelen
 */

public class Controller{
    
    public static User CurentUser;
    public static Application model;
  
            
    public Controller(Application model){
        model = new Application();
        CLogin c = new CLogin(model);
        
}
}
