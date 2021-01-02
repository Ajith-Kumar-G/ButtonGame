import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;
import ButtonDrag.*;
import winAdapt.*;

class mainScreen extends Frame implements ActionListener
{
	private int n=2;
	JPanel gamePanel = new JPanel();
	JPanel userPanel = new JPanel();
	Button buttonGame1,buttonGame2;
	JTextField userName= new JTextField();
	String uName="";	
	public mainScreen()
	{
		addWindowListener(new winAdapt.MyWindowAdapter());
        setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(n,1));
        userPanel.setLayout(new BorderLayout());
        add(gamePanel,BorderLayout.CENTER); 
        add(gamePanel,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent ae) 
    {
    }
	public static void main(String[] args)
	{
		mainScreen m=new mainScreen();
		m.setTitle("Fast Button Game");
		m.setSize(new Dimension(500,500));	
		m.setVisible(true);
	}
}
