/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster.island;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Omar xv
 */
public class Personaje extends JLabel{
    private int fotograma;
    private int sentido;
    private int noPersonaje;
    private Timer tmrMovimiento;
    public Personaje(int noPersonaje)
    {
        super();
        sentido=3; //dar un numero a cadda direccion 
        setSize(40,40);
        setLocation(0,0);
        this.noPersonaje=noPersonaje;
        fotograma=1;
        setIcon(new ImageIcon(getClass().getResource("imagenes/personajes/"+noPersonaje+"/caminando/abajo/"+fotograma+".png")));
        tmrMovimiento=new Timer(120, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switch(sentido)
                {
                    case 1:
                        if (getLocation().y>0)
                            setLocation(getLocation().x,getLocation().y-5);
                        setIcon(new ImageIcon(getClass().getResource("imagenes/personajes/"+getNoPersonaje()+"/caminando/arriba/"+fotograma+".png")));
                        break;
                    case 2:
                        if (getLocation().x<660)
                            setLocation(getLocation().x+5,getLocation().y);
                        setIcon(new ImageIcon(getClass().getResource("imagenes/personajes/"+getNoPersonaje()+"/caminando/derecha/"+fotograma+".png")));
                        break;
                    case 3:
                        if (getLocation().y<620)
                            setLocation(getLocation().x,getLocation().y+5);
                        setIcon(new ImageIcon(getClass().getResource("imagenes/personajes/"+getNoPersonaje()+"/caminando/abajo/"+fotograma+".png")));
                        break;
                    case 4:
                        if (getLocation().x>0)
                            setLocation(getLocation().x-5,getLocation().y);
                        setIcon(new ImageIcon(getClass().getResource("imagenes/personajes/"+getNoPersonaje()+"/caminando/izquierda/"+fotograma+".png")));
                        break;
                }
                fotograma++;
                if(fotograma==9)
                {
                    tmrMovimiento.stop();
                }
            }
        }); 
        
    }
    public int getNoPersonaje()
    {
        return noPersonaje;
    }
    public void muevete(int sentido)
    {
        this.sentido=sentido;
        fotograma=1;
        tmrMovimiento.start();
    }
    
}
