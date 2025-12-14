
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, hi, wi, rem; 

	private String screen, speaker;

    private Button logInButton, signUpButton;

	private ArrayList<Button> buttons;

	// lists

	

	
	public Game() {

		// setup
		
		
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		screen = "landing";
		wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        hi = Toolkit.getDefaultToolkit().getScreenSize().height;

		// ints
		key =-1; 
		x=0;
		y=0;

		// lists
		buttons = setButton();

        // buttons
        logInButton = new Button("log in", 135, 225, new Color(80, 105, 62), Color.white);
		signUpButton = new Button("sign up", 125, 345, new Color(80, 105, 62), Color.white);
	
		
		
	}

	// setting arraylists
	public ArrayList<Button> setButton(){
		ArrayList<Button> temp = new ArrayList<Button>();

		return temp;
	}


	// you can probably set the characters and stuff in backgrounds
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);

		// Set the font to be used for the dialogue text (example font)
		g2d.setFont(new Font("Jersey 10", Font.PLAIN, 35)); 

	
		// Get the FontMetrics for the current font
		FontMetrics fm = g2d.getFontMetrics();
		

		drawScreens(g2d);
	
	
		
		twoDgraph.drawImage(back, null, 0, 0);

	}

	// setup

	private void drawScreens(Graphics g2d){

		if (!buttons.isEmpty()){
			for (int i = 0; i < buttons.size(); i++) {
				Button b = buttons.get(i);

				b.setMetrics(g2d);
				b.drawButton(g2d);
			}
		}

		
		switch (screen){
			case "landing":
			landing(g2d);
			break;
		}
		

	}

	// different screens

	public void landing(Graphics g2d){
		buttons.add(logInButton);
		buttons.add(signUpButton);

	}

	public void sculpting(){

	}

	// other 

	


	


	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		key= e.getKeyCode();
		System.out.println(key);

	
			
		// player movement
		

		
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		

	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
				System.out.println(logInButton.clicked(x, y));

		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at x: "+ arg0.getX() + ", y: " + arg0.getY());
		

		x=arg0.getX();
		y=arg0.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		

		if (!buttons.isEmpty()){
			for (int i = 0; i < buttons.size(); i++) {
				System.out.println(buttons.get(i).clicked(x, y));
			}}
		
	}
	
	
	

	
}
