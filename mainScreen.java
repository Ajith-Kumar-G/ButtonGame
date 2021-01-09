package ButtonGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;
import ButtonDrag.*;
import winAdapt.*;

public class mainScreen implements ActionListener
{
	private int n=2;
	JFrame login,mF;
	JPanel welcome = new JPanel();
	JPanel gamePanel = new JPanel();
	JPanel userPanel = new JPanel();
	JButton buttonGame1,buttonGame2;
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
        gamePanel.add(buttonGame1);
        gamePanel.add(buttonGame2);
        userPanel.setLayout(new FlowLayout());
        user = new JLabel(" Name: "+uName);
        userPanel.add(user);
        user.setBounds(400,400,100,20);
        mF.setSize(new Dimension(500,500));
        mF.setVisible(true);
        buttonGame1.addActionListener(this);
        buttonGame2.addActionListener(this);
	}

	public void startGame1()
	{
			ButtonDrag.buttondrag cd=new ButtonDrag.buttondrag(uName);
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
    		this.startGame1();
    	}
    }
	public static void main(String[] args)
	{
		mainScreen m=new mainScreen();
		m.loginGame();
	}
}
