package ButtonGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.event.*;  
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;
import ButtonDrag.*;
import winAdapt.*;
import Spinner.*;

public class mainScreen implements ActionListener
{
	private int n=2;
	int spinValue=4;
	JFrame login,mF;
	JPanel welcome = new JPanel();
	JPanel gamePanel = new JPanel();
	JPanel userPanel = new JPanel();
	JPanel innerGamePanel1 = new JPanel();
	JPanel innerGamePanel2 = new JPanel();
	JButton buttonGame1,buttonGame2;
	Spinner.spinner s1=new Spinner.spinner(3);
    Spinner.spinner s2=new Spinner.spinner(4); 
	JTextField userName;
	String uName="";
	JButton submit;	
	Boolean loginDone=false;
	
	public void loginGame()
	{
		login=new JFrame("Login");
		JLabel name;
		loginDone=false;
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		login.add(name=new JLabel(" Name: "));
		login.add(userName=new JTextField(8));
		login.add(submit=new JButton("Ok") );
		submit.setPreferredSize(new Dimension(50, 20));
		submit.addActionListener(this); 
		login.setSize(new Dimension(400,100));
		login.setVisible(true);
		login.setLayout(new FlowLayout());
	}
	public void startGame(String name)
	{
		mF=new JFrame("Brain Teaser");
		JLabel user;
		uName=name;
		mF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mF.setLayout(new BorderLayout());
		mF.add(welcome,BorderLayout.NORTH);
		mF.add(userPanel,BorderLayout.SOUTH);
		mF.add(gamePanel,BorderLayout.CENTER);
		welcome.setLayout(new FlowLayout());
		welcome.add(new JLabel(" Brain Teaser Puzzle!!"));
        gamePanel.setLayout(new GridLayout(n,1));
        buttonGame1=new JButton("Number Ordering");
        buttonGame2=new JButton("Sequence Memorize");
        buttonGame1.setPreferredSize(new Dimension(300, 100));
        buttonGame2.setPreferredSize(new Dimension(300, 100));
        mF.setResizable(false);
       	innerGamePanel1.setLayout(new FlowLayout());
        innerGamePanel1.add(buttonGame1);
        innerGamePanel1.add(s1.spinner);
        innerGamePanel2.setLayout(new FlowLayout());
        innerGamePanel2.add(buttonGame2);
        innerGamePanel2.add(s2.spinner);
        gamePanel.add(innerGamePanel1);
        gamePanel.add(innerGamePanel2);
        userPanel.setLayout(new FlowLayout());
        user = new JLabel(" Name: "+uName);
        userPanel.add(user);
        user.setBounds(400,400,100,20);
        mF.setSize(new Dimension(500,500));
        mF.setVisible(true);
        buttonGame1.addActionListener(this);
        buttonGame2.addActionListener(this);
	}

	public void startGame1(int v)
	{
			ButtonDrag.buttondrag cd=new ButtonDrag.buttondrag(uName,v);
       		cd.setSize(new Dimension(500,500));
        	cd.setVisible(true);
	}
	public void startGame2(int v)
	{
			MemorySeq.memorySeq cd=new MemorySeq.memorySeq(uName,v);
       		cd.setSize(new Dimension(500,500));
        	cd.setVisible(true);
	}  
	public void actionPerformed(ActionEvent ae) 
    {
    	if(ae.getSource() == submit)
    	{
    		uName=userName.getText();
    		loginDone=true;
    		login.setVisible(false);
    		this.startGame(uName);
    	}

    	if(ae.getSource() == buttonGame1)
    	{
    		mF.setVisible(false);
    		this.startGame1(s1.getSValue());
    	}
    	if(ae.getSource() == buttonGame2)
    	{
    		mF.setVisible(false);
    		this.startGame2(s2.getSValue());
    	}
    }
	public static void main(String[] args)
	{
		mainScreen m=new mainScreen();
		m.loginGame();
	}
}
