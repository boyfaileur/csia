
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

    private tButton logInButton, signUpButton;
	private iButton homeButton;
	private textInput uNInput, pWInput;
	private sButton saveButton;
	private cButton checkButton;

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
        logInButton = new tButton("log in", "login", 135, 225, new Color(80, 105, 62), Color.white);
		signUpButton = new tButton("sign up", "signup", 125, 345, new Color(80, 105, 62), Color.white);
		homeButton = new iButton("assets/icons/hIcon.png", "landing", 200, 200,100, 100);
		uNInput = new textInput(20, 100, 300, 30);
		pWInput = new textInput(20, 150, 300, 30);
		saveButton = new sButton("save", "landing", 135, 225, new Color(80, 105, 62), Color.white);
		checkButton = new cButton ("enter", "landing", 135, 225, new Color(80, 105, 62), Color.white);
	
		
		
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

				if (b instanceof tButton){
					((tButton)b).setMetrics(g2d);
					((tButton)b).drawButton(g2d);
				}

				if (b instanceof iButton){
					((iButton)b).drawButton(g2d);
				}

				if (b instanceof textInput){
					((textInput)b).drawTextInput(g2d);
				}
				
			}
		}

		
		switch (screen){
			case "landing":
			landing();
			break;
			case "login":
			login();
			break;
			case "signup":
			signup();
			break;
		}
		

	}

	// different screens

	public void landing(){
		while(!buttons.isEmpty()){
			buttons.remove(buttons.get(0));
		}
		buttons.add(logInButton);
		buttons.add(signUpButton);

	}

	public void login(){
		while(!buttons.isEmpty()){
			buttons.remove(buttons.get(0));
		}
		buttons.add(uNInput);
		buttons.add(pWInput);
		buttons.add(checkButton);
	}

	public void signup(){
		while(!buttons.isEmpty()){
			buttons.remove(buttons.get(0));
		}
		buttons.add(uNInput);
		buttons.add(pWInput);
		buttons.add(saveButton);

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
		
		if (!buttons.isEmpty()){
			for (int i = 0; i < buttons.size(); i++) {

				if (buttons.get(i) instanceof textInput){

					textInput t = (textInput)buttons.get(i);
					if (t.getBeingTyped()){

						if(key==8&&!t.getS().equals("")){
							t.setS(t.getS().substring(0, t.getS().length() - 1));
						}else if (key!=16){
							t.setS(t.getS()+e.getKeyChar());
						}	
					}
				}

			}}

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
				if (buttons.get(i).clicked(x, y)){

					if ((buttons.get(i) instanceof iButton|| buttons.get(i) instanceof tButton)){

						if (buttons.get(i).switchScreen(uNInput.getS(), pWInput.getS())){
							screen = buttons.get(i).getD();
						}
					System.out.println(screen);
					}

					if (buttons.get(i) instanceof textInput){
						((textInput)buttons.get(i)).setBeingTyped(true);
					}

					if (buttons.get(i) instanceof sButton){

						for (int j = 0; j < buttons.size(); j++) {
							if (buttons.get(j) instanceof textInput){

								if (buttons.get(j)==uNInput){
									textInput password = new textInput(j, j, i, j);
								textInput username = uNInput;

								for (int m = 0; m < buttons.size(); m++) {
									if(buttons.get(m)==pWInput){
										password=pWInput;
									}

								}

								((sButton)buttons.get(i)).save(username,password);
								
							}
							((textInput)buttons.get(j)).setS("");
							}
							
						}
						
					}
					
				} else {
					if (buttons.get(i) instanceof textInput){
						((textInput)buttons.get(i)).setBeingTyped(false);
					}
				}

				

			}}
		
	}
	
	
	

	
}
