package bits.oops.project;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class container extends javax.swing.JPanel {

    /**
     * Creates new form container
     */
    public container(ArrayList<HotelTab> a1) {
        initComponents();
         JFrame f = new JFrame();
        //f.setSize(1000, 1000);
        
        
        if(a1.size()==0)
        {
            this.results.setText("Sorry, no results found");
        }
        for(int i=0; i<a1.size();i++)
        {
            this.add(a1.get(i));
            //MouseListener l1 = on
            final int id = i;
            a1.get(i).addMouseListener(new MouseListener()
            {
            

                @Override
                public void mouseClicked(MouseEvent e) {
                    
                    action(e,id,a1); 
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
       
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JScrollPane p1= new JScrollPane();
        p1.getViewport().add(this);
        f.add(p1);
        f.setVisible(true);
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        results = new javax.swing.JLabel();

        results.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        results.setText("RESULTS");
        add(results);
    }// </editor-fold>//GEN-END:initComponents
   public void action(MouseEvent e ,int i, ArrayList<HotelTab> a1)
   {
       //int id = Integer.parseInt(a1.get(i).hotel_id.getText());
       a1.get(i).name.setText("changed");
       a1.get(i).setBackground(Color.LIGHT_GRAY);
       //function to view hotel passing id
   
   }
    public static void main(String args[])
    {
        ArrayList<HotelTab> a1= new ArrayList<>();
    for(int i=0; i<15; i++)
    {
    HotelTab h1= new HotelTab();
    h1.name.setText("name" + i);
    a1.add(i,h1);
    }
    new container(a1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel results;
    // End of variables declaration//GEN-END:variables
}
