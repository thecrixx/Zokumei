package monster.island;


import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

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
    private Personaje personaje;
    public Tablero()
    {
        super();
        personaje=new Personaje(1);
        setSize(1280,720);
        final AudioClip oyasumi;
        oyasumi = java.applet.Applet.newAudioClip(getClass().getResource("audio/35.wav"));
        oyasumi.play();
        setLayout(null);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we) {
                oyasumi.stop();
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(personaje);
        addKeyListener(new KeyAdapter(){
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
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
