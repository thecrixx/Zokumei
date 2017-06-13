/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Omar xv
 */
public class Interfaz extends JPanel{
    private JButton pausa;
    public Interfaz(){
        pausa = new JButton("Pausa");
        this.setSize(430,720);
        this.setLocation(720,0);
        pausa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
    }
}
