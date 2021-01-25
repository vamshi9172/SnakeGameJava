/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vksnake;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author hello
 */
public class gameplay extends JPanel implements ActionListener,KeyListener {
    private ImageIcon titleimage;
    private int snakexlength[]=new int[750],delay=100,lengthofsnake=3,moves=0,score=0;
    private int snakeylength[]=new int[750];
    private boolean left,right,up,down;
    private ImageIcon leftmouth,rightmouth,downmouth,upmouth,snakeimage,enemyimage;
    private Timer timer;
    private Random random=new Random();
    private int rax[]=new int[34],ray[]=new int[23];
    private int xpos=random.nextInt(34),ypos=random.nextInt(23);
    public gameplay(){
        addKeyListener(this);
        setFocusable(true);
        left=up=down=false;
        right=true;
        for(int t1=0;t1<34;t1++)
            rax[t1]=t1*25+25;
        for(int t1=0;t1<23;t1++)
            ray[t1]=t1*25+75;
        timer=new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
        if(moves==0)
        {
            snakexlength[2]=50;
            snakexlength[1]=75;
            snakexlength[0]=100;
            snakeylength[2]=100;
            snakeylength[1]=100;
            snakeylength[0]=100;
        }
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55);
        g.setColor(Color.CYAN);
        g.setFont(new Font("arial",Font.BOLD,40));
        g.drawString("Snake Game",100,50);
       // titleimage=new ImageIcon("");
        //titleimage.paintIcon(this,g,25,11);
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("scores: "+score,780,30);
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("length "+lengthofsnake,780,50);
        //g.drawOval(snakexlength[0],snakeylength[0],);
        //rightmouth=new ImageIcon("");
        //rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        for(int i=0;i<lengthofsnake;i++)
        {
            if(i==0 && right)
            {
                g.drawOval(snakexlength[0],snakeylength[0],25,25);
                g.setColor(Color.CYAN);
                //rightmouth=new ImageIcon("");
                //rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(i==0 && left)
            {
                g.drawOval(snakexlength[0],snakeylength[0],25,25);
                g.setColor(Color.CYAN);
                //leftmouth=new ImageIcon("");
                //leftmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(i==0 && up)
            {
                g.drawOval(snakexlength[0],snakeylength[0],25,25);
                g.setColor(Color.CYAN);
               // upmouth=new ImageIcon("");
                //upmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(i==0 && down)
            {
                 g.drawOval(snakexlength[0],snakeylength[0],25,25);
                g.setColor(Color.CYAN);
                //downmouth=new ImageIcon("");
                //downmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(i!=0)
            {
                 g.drawOval(snakexlength[i],snakeylength[i],25,25);
                g.setColor(Color.yellow);
                //snakeimage=new ImageIcon("");
                //snakeimage.paintIcon(this,g,snakexlength[i],snakeylength[i]);
            }
        }
         g.fillOval(rax[xpos],ray[ypos],25,20);
         g.setColor(Color.red);
       // enemyimage=new ImageIcon("");
        //enemyimage.paintIcon(this,g,rax[xpos],ray[ypos]);
        if(rax[xpos]==snakexlength[0] && ray[ypos]==snakeylength[0])
        {
            score++;
            lengthofsnake++;
            xpos=random.nextInt(34);
            ypos=random.nextInt(23);
        }
        for(int t2=1;t2<lengthofsnake;t2++)
        {
            if(snakexlength[t2]==snakexlength[0] && snakeylength[t2]==snakeylength[0])
            {
                up=down=right=left=false;
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.PLAIN,50));
                g.drawString("game over",300,300);
                g.setFont(new Font("arial",Font.PLAIN,30));
                g.drawString("press space to restart",350,350);
                
            }
                
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        timer.start();
        if(right)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakeylength[r+1]=snakeylength[r];
            }
            for(int r=lengthofsnake;r>=0;r--)
            {
                if(r==0)
                    snakexlength[0]=snakexlength[0]+25;
                else
                    snakexlength[r]=snakexlength[r-1];
                if(snakexlength[r]>850)
                    snakexlength[r]=25;
            }
            repaint();
        }
        if(left)
        {
             for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakeylength[r+1]=snakeylength[r];
            }
            for(int r=lengthofsnake;r>=0;r--)
            {
                if(r==0)
                    snakexlength[0]=snakexlength[0]-25;
                else
                    snakexlength[r]=snakexlength[r-1];
                if(snakexlength[r]<25)
                    snakexlength[r]=850;
            }
            repaint();
        }
        if(up)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakexlength[r+1]=snakexlength[r];
            }
            for(int r=lengthofsnake;r>=0;r--)
            {
                if(r==0)
                    snakeylength[0]=snakeylength[0]-25;
                else
                    snakeylength[r]=snakeylength[r-1];
                if(snakeylength[r]<75)
                    snakeylength[r]=625;
            }
            repaint();
        }
        if(down)
        {
             for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakexlength[r+1]=snakexlength[r];
            }
            for(int r=lengthofsnake;r>=0;r--)
            {
                if(r==0)
                    snakeylength[0]=snakeylength[0]+25;
                else
                    snakeylength[r]=snakeylength[r-1];
                if(snakeylength[r]>625)
                    snakeylength[r]=75;
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        if(ke.getKeyCode()==KeyEvent.VK_SPACE)
        {
            moves=0;
            score=0;
            lengthofsnake=3;
            right=true;
            //g.dispose();
            repaint();
        }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            moves++;
            if(left!=true){
               right=true;   
            }
            else
            {
                left=true;
                right=false;
            }
            up=down=false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT)
        {
            moves++;
            if(right!=true){
               left=true;   
            }
            else
            {
                left=false;
                right=true;
            }
            up=down=false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_UP)
        {
            moves++;
            if(down!=true){
               up=true;   
            }
            else
            {
                down=true;
                up=false;
            }
            left=right=false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_DOWN)
        {
            moves++;
            if(up!=true){
               down=true;   
            }
            else
            {
                up=true;
                down=false;
            }
            left=right=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
