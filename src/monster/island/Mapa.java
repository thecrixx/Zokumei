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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Mapa extends JPanel{
    private Personaje personaje;
    final AudioClip oyasumi;
    private JLabel[][] tiles;
    private int[][] images;
    public Mapa(){
        super();
            int[][] images = new int[][]{
            {1, 2, 3, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22 },
            {4, 5, 6, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22},
            {7, 8, 9, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 51, 51, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 51, 51, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 10, 11, 51, 51, 51, 10, 11, 51, 51, 51, 51, 51, 51, 51, 25, 26, 51, 51, 51, 51, 51, 51, 51, 25, 26, 72, 53, 53, 53, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 10, 11, 51, 10, 11, 51, 51, 51, 51, 10, 11, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 73, 52, 52, 73, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 51, 51, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 24, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 73, 52, 71, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {10, 11, 51, 51, 24, 51, 51, 51, 51, 70, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 24, 51, 73, 52, 71, 59, 55, 55, 55, 60, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 25, 26, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 10, 11, 51, 51, 25, 26, 51, 51, 51, 24, 51, 51, 72, 25, 26, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 10, 11, 12, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 17, 17, 17, 13, 53, 53, 54, 53, 41, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {10, 11, 51, 61, 62, 63, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 25, 26, 53},
            {51, 51, 51, 64, 65, 66, 51, 40, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 67, 68, 69, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 42, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 24, 51, 51, 51, 51, 16, 20, 20, 20, 20, 21, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 53, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 25, 26, 54, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 10, 11, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 59, 58, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 18, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 20, 20, 20, 20, 20, 18, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 41, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 25, 26, 51, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 41, 54, 25, 26, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 16, 20, 20, 21, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 54, 53, 53, 53, 53, 54, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53},
            {51, 51, 51, 24, 51, 51, 51, 51, 16, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 18, 53, 54, 53, 43, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 14, 49, 49, 49, 49, 50, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 15, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 25, 26, 51, 51, 51, 73, 52, 71, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 59, 55, 55, 55, 53, 53, 53, 59, 55, 55, 58, 53, 53, 53, 53, 30, 30, 30, 30, 59, 55, 55, 55, 55, 60, 53, 53, 53, 53},
            {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 72, 71, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 54, 53, 41, 53, 53, 53, 53, 53, 30, 30, 32, 30, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53 },
            {25, 26, 51, 51, 51, 51, 51, 51, 73, 52, 71, 53, 53, 25, 26, 53, 53, 53, 53, 53, 25, 26, 25, 26, 53, 54, 53, 53, 53, 25, 26, 53, 54, 53, 53, 53, 53, 53, 53, 53, 30, 31, 30, 30, 54, 53, 53, 53, 53, 54, 53, 27, 28, 53},
            {51, 51, 51, 73, 51, 51, 51, 51, 72, 53, 53, 25, 26, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 54, 53, 47, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53},
            {51, 51, 51, 73, 52, 52, 52, 52, 71, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 54, 53, 53, 53, 53},
            {25, 26, 51, 72, 52, 51, 51, 53, 57, 55, 55, 55, 55, 55, 55, 44, 53, 53, 53, 54, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 54, 53, 27, 28, 53},
            {51, 51, 73, 71, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 29, 29, 29, 29, 54, 53, 53, 53, 53},
            {51, 51, 72, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 30, 30, 30, 30, 57, 55, 55, 60, 53},
            {52, 52, 71, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 30, 32, 30, 53, 53, 53, 54, 53},
            {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 46, 53, 53, 53, 53, 25, 26, 54, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 30, 31, 30, 30, 53, 53, 53, 54, 53},
            {53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53},
            {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53},
            {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53},
            {53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 29, 29, 29, 29, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 54, 53, 53, 30, 30, 30, 30, 54, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53},
            {53, 53, 25, 26, 54, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 54, 53, 53, 30, 30, 32, 30, 54, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 53, 53},
            {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 30, 31, 30, 30, 54, 53, 30, 30, 30, 30, 53, 53, 53, 53, 53, 53, 53},
            {53, 53, 53, 53, 54, 53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 54, 53, 30, 30, 32, 30, 53, 48, 53, 53, 53, 53, 53},
            {53, 53, 53, 53, 54, 53, 25, 26, 53, 53, 53, 45, 53, 53, 53, 53, 53, 59, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 59, 55, 58, 53, 30, 31, 30, 30, 53, 53, 53, 53, 53, 53, 53},
            {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {53, 53, 53, 41, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 30, 30, 30, 30, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53},
            {25, 26, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 30, 30, 32, 30, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 54, 53, 53, 53, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33},
            {53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 30, 31, 30, 30, 53, 53, 53, 53, 53, 29, 29, 29, 29, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34},
            {53, 53, 53, 53, 57, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 30, 30, 30, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34},
            {53, 53, 53, 53, 53, 53, 53, 53, 53, 41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 30, 32, 30, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34},
            {41, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 30, 31, 30, 30, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 36, 37, 34, 34, 34, 34},
            {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 34, 34, 34, 34, 34, 35, 38, 34, 34, 34, 34},
            {53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 53, 53, 53, 53},
            {53, 53, 53, 25, 26, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 27, 28, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 57, 55, 55, 55, 55, 55, 55, 55, 55, 55, 58, 53, 53, 53, 53}
        };

        personaje = new Personaje(1);
        oyasumi = java.applet.Applet.newAudioClip(getClass().getResource("audio/35.wav"));
        oyasumi.stop();
        JLabel[][] tiles = new JLabel[53][53];
        for(int i = 0;i <= 53;i++){
            for(int ii = 0;ii <= 53;i++){
                tiles[i][ii] = new JLabel(new ImageIcon(getClass().getResource("imagenes/mapa/"+images[i][ii]+".png")));
                tiles[i][ii].setSize(40, 40);
                tiles[i][ii].setLocation(i*40, ii*40);
                this.add(tiles[i][ii]);
            }
        }
        this.setBackground(Color.red);
        this.setLocation(0, 0);
        this.setSize(2160, 2160);
        this.setLayout(null);
        personaje.setLocation(80, 160);
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
