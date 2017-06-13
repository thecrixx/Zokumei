/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Omar xv
 */
public class Menu extends JPanel{ 
    private JLabel dragon, segundon, ayuda;
    private Image fondillo;
    private int i;
    public boolean openedOnce;
    public final AudioClip menu;
    public Menu()
    {
        super();
        i = 0;
        ayuda = new JLabel(new ImageIcon(getClass().getResource("imagenes/menu/Ayuda.jpg")));
        dragon= new JLabel(new ImageIcon(getClass().getResource("imagenes/menu/1.gif")));
        fondillo = new ImageIcon(getClass().getResource("imagenes/menu/fondo.jpg")).getImage();
        segundon= new JLabel(new ImageIcon());    
        ayuda.setLocation(1040,460);
        ayuda.setSize(150,50);
        segundon.setSize(200,200);
        segundon.setLocation(320,50);
        dragon.setSize(200,200);
        dragon.setLocation(240,260);
        menu = java.applet.Applet.newAudioClip(getClass().getResource("audio/16.wav"));
        menu.play();
        setLayout(null);
        ayuda.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                getMe().setOnNow(2);
            }
        });
        dragon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                getMe().setOnNow(3);
                getMe().setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                dragon.setIcon(new ImageIcon(getClass().getResource("imagenes/menu/2.jpg")));
            }
            public void mouseExited(MouseEvent e) {
                dragon.setIcon(new ImageIcon(getClass().getResource("imagenes/menu/1.gif")));
            }
        });
        segundon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                Tablero tablero= new Tablero();
                tablero.setVisible(true);
                getMe().setVisible(false);
            }
        });
        this.add(ayuda);
        this.add(segundon);
        this.add(dragon);
        this.setSize(1280,720);
    }
    public Menu getMe()
    {
        return this;
    }
    public AudioClip getSong(){
        return menu;
    } 
    private void setOnNow(int ii){
        i = ii;
    }
    public int getOnNow(){
        return i;
    }
    public Mapa newMap(){
        return new Mapa();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondillo, 0, 0, this);
    }
}
