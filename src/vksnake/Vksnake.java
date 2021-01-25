/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vksnake;
import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author hello
 */
public class Vksnake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame vkjf=new JFrame();
        gameplay gameplayvk=new gameplay();
        JButton but=new JButton("");
        but.setBounds(30,30,10,10);
        vkjf.setResizable(false);
        vkjf.setBackground(Color.darkGray);
        vkjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vkjf.setVisible(true);
        vkjf.setBounds(10,10,905,700);
        vkjf.add(gameplayvk);
    }
    
}
