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
 * @author Usuario
 */
public class Ataque extends JLabel{
    private int damage, fotograma;
    private String nom_att;
    private Timer tiempo;
    public Ataque(){
        damage = 0;
        nom_att = "";
        tiempo = new Timer(120,new ActionListener(){ //Este timer es responsable de la animacion de golpe del ataque
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(new ImageIcon(getClass().getResource("imagenes/ataques/"+nom_att+"/"+fotograma+".jpg")));//recibe  el nombre del ataque y el fotograma, busca carpeta con nombre de ataque e imagen con nombre de fotograma
                fotograma++; //pasa el fotograma
                if(fotograma == 4){ //si el fotograma es 4 (debatible) para el timer 
                    tiempo.stop();
                }
            } 
        });
    }
    public void Atacar(){ //metodo que da inicio a la animacion
        tiempo.start();
        fotograma = 1;
    }
    public void setDamage(int dmg){ //metodo para darle un valor de daño al ataque
        this.damage = dmg;
    }
    public void setNomAtt(String nom){ //metodo para darle un nombre al ataque
        this.nom_att = nom;
    }
    public String getNomAtt(){ //metodo para obtener el nombre del ataque
        return this.nom_att;
    }
    public int getDamage(){//metodo para obtener el nombre del ataque
        return this.damage;
    }
}
