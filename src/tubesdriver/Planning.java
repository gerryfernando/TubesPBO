/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesdriver;

/**
 *
 * @author Yulius Langobelen
 */
public abstract class Planning {


   protected int id=1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id++;
    }

  
   
   
   public abstract String Show(); 
   
}
