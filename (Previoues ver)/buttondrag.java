package ButtonDrag;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.*;
import javax.swing.JPanel;
import java.util.Random;
import time.*;
import winAdapt.*;
import ButtonGame.*;

 public class buttondrag extends Frame implements ActionListener
 {
    int n = 3;
    int m=n*n;
    Boolean clicked=false,doneFlag=false;
    String cLabel,uName;
    int cI;
    JPanel buttonPanel = new JPanel();
    JPanel optionPanel =new JPanel();
    Button b[]=new Button[n*n];

    Button start,reset,restart,menu;
    String msg="";
    time.timecalc total;
    int totalTime;

    public buttondrag(String uName)
    {
        this.uName=uName;
        this.setTitle(" <Button Arrange> <Name: "+uName+">");
        addWindowListener(new MyWindowAdapter());
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(n, n));
        setFont(new Font("Arial", Font.BOLD, 24));
        buttonPanel.setSize(300, 300);
        buttonPanel.setEnabled(false);
        optionPanel.setLayout(new FlowLayout());
        add(buttonPanel,BorderLayout.CENTER);
        add(optionPanel,BorderLayout.SOUTH);
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
               int k = i * n + j;
                 if(k > 0)
                    {
                      buttonPanel.add(b[k]=new Button("" + k));
                    }   
                             
            }
        }
        buttonPanel.add(b[0]=new Button("9"));
         for(int i=0;i<m;i++)
         {
            b[i].addActionListener(this);
         }
         optionPanel.add(reset=new Button("Reset"));
         optionPanel.add(start=new Button("Start"));
         optionPanel.add(restart=new Button("Restart"));
         optionPanel.add(menu=new Button("Back to Menu"));
         start.addActionListener(this);
         reset.addActionListener(this);
         restart.addActionListener(this);
         menu.addActionListener(this);
         restart.setEnabled(false);
         reset.setEnabled(false);
         //restart.setVisible(false);
         Component[] com = buttonPanel.getComponents();
        for (int a = 0; a < com.length; a++) 
        com[a].setEnabled(false);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==menu)
        {
          this.setVisible(false);
          ButtonGame.mainScreen m=new ButtonGame.mainScreen();
          m.startGame(uName);
        }
        
        if(ae.getSource()==start && (!doneFlag))
        {
            Component[] com = buttonPanel.getComponents();
            for (int a = 0; a < com.length; a++) 
            com[a].setEnabled(true);
            shuffleStart();
            reset.setEnabled(true);
            start.setEnabled(false);
            total=new time.timecalc();
        }
        else
        if(ae.getSource()==reset  && (!doneFlag) )
        { 
             if(clicked)
            {
                b[cI].setVisible(true);
                clicked=!clicked;
            }
            reSet();
            totalTime=0;
            reset.setEnabled(false);
            start.setEnabled(true);
        }
        else
        if(ae.getSource()==restart  && (doneFlag) )
        {
            reStart();
            totalTime=0;
            reset.setEnabled(false);
            start.setEnabled(true);
        }
     {
        for(int i=0;i<m;i++)
        {
            if(ae.getSource()==b[i] && (!clicked))
            {
                b[i].setVisible(false); 
                cLabel=b[i].getLabel();
                cI=i;
                clicked=!clicked;
            }
            else
            if(ae.getSource()==b[i] && (clicked))
            {
                b[cI].setLabel(b[i].getLabel());
                b[cI].setVisible(true);
                b[i].setLabel(""+cLabel);
                clicked=!clicked;
                checkCorrect();
            }  
        }
      }
    }
    public void checkCorrect()
    {
       int checkComI=0;
       for(int i=1;i<m;i++)
       {
            if(b[i].getLabel().equals(String.valueOf(i)))
                checkComI+=1;
       }
       if(checkComI==8)
        {
          totalTime=total.getTimeInSeconds();
          for(int i=0;i<m;i++)
             b[i].setVisible(false);
          doneFlag=true;
          restart.setEnabled(true);
          restart.setVisible(true);
          reset.setEnabled(false);
          msg="Congradulations!, you Finished it in "+ totalTime+ " seconds !!";
          repaint();
         }    
     
    }
    public void paint(Graphics g)
    {
        if(doneFlag)
        {
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        }
        else
            setBackground(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 24));
        g.drawString(msg,30,250);
    }
    public void shuffleStart()
    {
        for(int i=0; i<m;i++)
        {
            Random number=new Random();
            int num=number.nextInt(9);
            swap(num,i);
        }
    }
     public void reStart()
     {
        for(int i=1; i<m;i++)
        {
             b[i].setVisible(true);
             b[i].setLabel(String.valueOf(i));
        }
        b[0].setVisible(true);
        b[0].setLabel("9");
        doneFlag=false;
        Component[] com = buttonPanel.getComponents();
        for (int a = 0; a < com.length; a++) 
        com[a].setEnabled(false);
        restart.setEnabled(false);
        repaint();
     }
      public void reSet()
     {
        for(int i=1; i<m;i++)
        {
            b[i].setLabel(String.valueOf(i));
        }
        b[0].setLabel("9");
        Component[] com = buttonPanel.getComponents();
        for (int a = 0; a < com.length; a++) 
        com[a].setEnabled(false);
     }
    public void swap(int x,int y)
    {
        String temp=b[x].getLabel();
        b[x].setLabel(b[y].getLabel());
        b[y].setLabel(temp);
    }
    public static void main(String ar[])
    { 
        buttondrag cd=new buttondrag("");
        cd.setSize(new Dimension(500,500));
        cd.setVisible(true);
    } 
}





