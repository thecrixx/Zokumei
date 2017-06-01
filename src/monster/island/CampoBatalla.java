/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class CampoBatalla extends JFrame{
    private int noEnemigos;
    private JPanel HUD,opciones,estatus;
    private Enemigo ene1, ene2, ene3;
    public CampoBatalla(){
        HUD = new JPanel();
        opciones = new JPanel();
        estatus =new JPanel();
        ene1 = new Enemigo();
        ene2 = new Enemigo();
        ene3 = new Enemigo();
        
        setSize(1280, 720);
        setLayout(null);
        HUD.setLocation(0, 504);
        HUD.setSize(174, 216);
        opciones.setLocation(176, 504);
        opciones.setSize(null);
    }
}
