package monster.island;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar xv
 */
public class Tablero extends JFrame
{
    private boolean openedOnce;
    private Mapa map;
    private Menu men;
    private int onNow;
    public Tablero()
    {
        super();
        openedOnce = false;
        map = new Mapa();
        onNow = 1;
        men = new Menu();
        reevaluate(onNow);
        map.setFocusable(true);
        setSize(1150,720); 
        map.addComponentListener(new ComponentAdapter() {
           public void componentHidden(ComponentEvent e){
               map.getOyasumi().stop();
           }
           public void componentShown(ComponentEvent e) {
               map.getOyasumi().play();
           }
        });
        men.addComponentListener(new ComponentAdapter() {
           public void componentHidden(ComponentEvent e){
               men.getSong().stop();
               onNow = men.getOnNow();
               getMe().remove(men);
               men = null;
               reevaluate(onNow);
           }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        if(openedOnce == false){
            new Splash(this);
            openedOnce = true;
        }
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private Tablero getMe(){
        return this;
    }
    private void reevaluate(int i){
        if(i == 1){
            this.add(men);
        }
        else if(i == 2){
            
        }
        else{
            this.add(map);
            map.requestFocus();
            map.getOyasumi().play();
        }
    }
}
