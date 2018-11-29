/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.RegisGUI;
import GUI.TransaksiGUI;
import GUI.LoginGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private PendapatanGUI viewDapatan;
    private PengeluaranGUI viewKeluaran;
    private PlanningGUI viewPlan;
    private TransaksiGUI viewT;
    private PlanningBarangGUI viewBrg;
    private PlanningHarianGUI viewHrn;


    
    public Controller(Application model){
        this.model=model;
        viewLog=new LoginGUI();
        viewLog.setVisible(true);
        viewReg=new RegisGUI();
        viewT = new TransaksiGUI();
        viewPlan = new PlanningGUI();
        viewDapatan = new PendapatanGUI();
        viewKeluaran = new PengeluaranGUI();
        viewBrg = new PlanningBarangGUI();
        viewHrn = new PlanningHarianGUI();

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
                            
                            viewT.getBtnBack().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("back pressed");
                                    viewT.setVisible(false);
                                    viewMenu.setVisible(true);
                                }
                            });
                            viewT.getBtnPendapatan().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("pendapatan pressed");
                                    viewT.setVisible(false);
                                    viewDapatan.setVisible(true);
                                    
                                    viewDapatan.getBtnCancel().addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("cancel pressed");
                                            viewDapatan.setVisible(false);
                                            viewMenu.setVisible(true);
                                        }
                                    });
                                    viewDapatan.getBtnOk().addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("ok pressed");
                                            viewDapatan.setVisible(false);
                                            viewMenu.setVisible(true);
                                            
                                        }
                                        
                                    });
                                }
                            });
                            viewT.getBtnPengeluaran().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    viewT.setVisible(false);
                                    viewKeluaran.setVisible(true);
                                    
                                    viewKeluaran.getBtnCancel().addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("cancel pressed");
                                            viewKeluaran.setVisible(false);
                                            viewMenu.setVisible(true);
                                        }
                                        
                                    });
                                }
                                
                            });
                            
                        }
                    });
                    
                    viewMenu.getBtnPlanning().addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("planning pressed");
                            viewMenu.setVisible(false);
                            viewPlan.setVisible(true);
                            
                            viewPlan.getBtnBack().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("back pressed");
                                    viewPlan.setVisible(false);
                                    viewMenu.setVisible(true);
                                }
                            });
                            viewPlan.getBtnBarang().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("barang pressed");
                                    viewPlan.setVisible(false);
                                    viewBrg.setVisible(true);
                                    
                                    viewBrg.getBtnOk().addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("ok pressed");
                                        }
                                        
                                    });
                                    viewBrg.getBtnCancel().addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("cancel pressed");
                                            viewBrg.setVisible(false);
                                            viewMenu.setVisible(true);
                                        }
                                        
                                    });
                                }
                                
                            });
                            viewPlan.getBtnHarian().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("Harian pressed");
                                    viewPlan.setVisible(false);
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
                                            viewHrn.setVisible(false);
                                            viewMenu.setVisible(true);
                                        }
                                        
                                    });
                                }
                                
                            });
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
