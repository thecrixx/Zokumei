/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Mapa extends JPanel{
    private Personaje personaje;
    final AudioClip oyasumi;
    public Mapa(){
        super();
        personaje = new Personaje(1);
        oyasumi = java.applet.Applet.newAudioClip(getClass().getResource("audio/35.wav"));
        oyasumi.stop();
        this.setBackground(Color.red);
        this.setSize(720, 720);
        this.setLayout(null);
        personaje.setLocation(0, 0);
        this.add(personaje);
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    personaje.muevete(3);
                }
                else if (ke.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    personaje.muevete(4);
                }
                else  if (ke.getKeyCode()==KeyEvent.VK_UP)
                {
                    personaje.muevete(1);
                }
                else if (ke.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    personaje.muevete(2);
                }
            }
        });
    }
    public AudioClip getOyasumi(){
        return oyasumi;
    }
}
