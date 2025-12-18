
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, hi, wi, rem; 

	private String screen, speaker, screen2;

    private tButton logInButton, signUpButton;
	private iButton homeButton, gHButton, weatherButton, aPButton;
	private textInput uNInput, pWInput, pNInput;
	private sButton saveButton, savePlant;
	private cButton checkButton;
	private uLButton imgUpload;
	private File tempFile;

	private ArrayList<Button> buttons;
	private ArrayList<Pic> images;


	

	
	public Game() {

		// setup
		
		
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		screen = "landing";
		screen2 = "landing";
		wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        hi = Toolkit.getDefaultToolkit().getScreenSize().height;

		// ints
		key =-1; 
		x=0;
		y=0;

		// files
		tempFile = new File("");

		// lists
		buttons = new ArrayList<Button>();
		images = new ArrayList<Pic>();

        // BUTTONS

		// text buttons
        logInButton = new tButton("log in", "login", 135, 225, new Color(80, 105, 62), Color.white);
		signUpButton = new tButton("sign up", "signup", 125, 345, new Color(80, 105, 62), Color.white);
		
		// text inputs
		uNInput = new textInput(20, 100, 300, 30);
		pWInput = new textInput(20, 150, 300, 30);
		pNInput = new textInput(20, 210, 300, 30);

		// save and check buttons
		saveButton = new sButton("save", "landing", 135, 225, new Color(80, 105, 62), Color.white);
		checkButton = new cButton ("enter", "home", 135, 225, new Color(80, 105, 62), Color.white);

		savePlant = new sButton("confirm", "greenhouse", 128, 510, new Color(80, 105, 62), Color.white);

		// upload button
		imgUpload = new uLButton("upload", "who cares", 20, 285, new Color(80, 105, 62), Color.white);

		// icon buttons
		homeButton = new iButton("assets/icons/hIcon.png", "home", 148, 592,75, 75);
		gHButton = new iButton("assets/icons/pIcon.png", "greenhouse", 260, 592,75, 75);
		weatherButton = new iButton("assets/icons/wIcon.png", "weather", 10, 575,100, 100);

		aPButton = new iButton("assets/icons/addIcon.png", "plantAdd", 150, 125, 75, 75);
		
	}

	// setting arraylists



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

		if (!images.isEmpty()){
			for (int i = 0; i < images.size(); i++) {
				g2d.drawImage(new ImageIcon(images.get(i).getP()).getImage(), images.get(i).getX(), images.get(i).getY(), images.get(i).getW(), images.get(i).getH(), this);
				// System.out.println(images.get(i).getP());
			}
		}

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
			landing(g2d);
			break;
			case "login":
			login();
			break;
			case "signup":
			signup();
			break;
			case "home":
				home(g2d);
			break;
			case "weather":
				weather(g2d);
			break;
			case "greenhouse":
				greenhouse(g2d);
			break;
			case "plantAdd":
				plantAdd(g2d);
			break;
		}
		

	}

	// different screens

	public void removal(){
		while(!buttons.isEmpty()){
			buttons.remove(buttons.get(0));
		}

		while(!images.isEmpty()&&!screen.equals(screen2)){			
			images.remove(images.get(0));
		}
		
		if (screen.equals("greenhouse")&&!screen.equals(screen2)){
			checkThumbnail(new File("assets/logins/" + uNInput.getS()));

		}

		screen2 = screen;

	}

	public void landing(Graphics g2d){
		removal();
		g2d.setColor(Color.BLACK);
		g2d.drawString("DIGIGARDEN", 115, 150);
		buttons.add(logInButton);
		buttons.add(signUpButton);

	}

	public void login(){
		removal();
		buttons.add(uNInput);
		buttons.add(pWInput);
		buttons.add(checkButton);
	}

	public void signup(){
		removal();
		buttons.add(uNInput);
		buttons.add(pWInput);
		buttons.add(saveButton);

	}

	public void home(Graphics g2d){
		removal();

		g2d.setColor(Color.BLACK);
		g2d.drawString("DIGIGARDEN", 115, 150);

		buttons.add(homeButton);
		buttons.add(gHButton);
		buttons.add(weatherButton);

	}

	public void weather(Graphics g2d){
		removal();

		g2d.setColor(Color.BLACK);
		g2d.drawString("WEATHER", 115, 150);

		buttons.add(homeButton);
		buttons.add(gHButton);
		buttons.add(weatherButton);

	}

	public void greenhouse(Graphics g2d){
		removal();

		g2d.setColor(Color.BLACK);
		g2d.drawString("GREENHOUSE", 112, 100);

		buttons.add(homeButton);
		buttons.add(gHButton);
		buttons.add(weatherButton);
		buttons.add(aPButton);

		Scanner scanner;

		

		
		// try {
		// 	scanner = new Scanner(new File ("assets/logins/" + uNInput.getS() + "/" + "plantlist.txt"));

		// 	while (scanner.hasNext()){
		// 		String temp = scanner.nextLine();

	
	
		// 		if (temp.startsWith("plant: ")){
	
	
		// 			
					
		// 			// for (int i = 0; i < images.size(); i++) {
		// 			// }
	
		// 			tx += 110;
		// 		} else {
		// 			// System.out.println("no line found");
		// 		}

		// 		// scanner.close();
		// 	}
		// } catch (FileNotFoundException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
		
		
		

	}

	public void plantAdd(Graphics g2d){
		removal();

		g2d.setColor(Color.BLACK);
		g2d.drawString("ADD A PLANT", 110, 100);
		
		g2d.drawString("PLANT NAME", 25, 200);
		buttons.add(pNInput);

		g2d.drawString("PLANT IMAGE", 25, 275);
		buttons.add(imgUpload);

		buttons.add(savePlant);

	}

	public void checkThumbnail(File folder){
		int tx = 20;
		int ty = 200;
		// System.out.println(folder.toString());



		File[] temp = folder.listFiles(); 

		if (temp != null) { 
			ArrayList<File> files = new ArrayList<File>();
			ArrayList<File> subfiles = new ArrayList<File>();

			for (File t : temp) {
				files.add(t);
			 }

			 for (int j = 0; j < files.size(); j++) {
				File f = files.get(j);

				if (f.isFile()&&f.getName().startsWith("thumbnail.")) { 

					System.out.println(f.getPath());
					tx += images.size()*110;
					images.add(new Pic(f.getPath(), 100, 120, tx, ty));
				} 
					
				if (f.isDirectory()) {
					
					subfiles.add(f);
					
					}
					
					
				} 
				if (!subfiles.isEmpty()){
					for (int i = 0; i < subfiles.size(); i++) {
						
						checkThumbnail(subfiles.get(i));
					}
				}
				 
			 }
			
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

						if(buttons.get(i) instanceof uLButton){
							// ((uLButton)buttons.get(i)).uploadIMG();
							tempFile = ((uLButton)buttons.get(i)).uploadIMG(images);


						}

						if (buttons.get(i).switchScreen(uNInput.getS(), pWInput.getS())){
							screen = buttons.get(i).getD();
							if (screen.equals("greenhouse")){

							}
						}
					// System.out.println(screen);
					}

					if (buttons.get(i) instanceof textInput){
						((textInput)buttons.get(i)).setBeingTyped(true);
					}

					if (buttons.get(i) instanceof sButton){

						String tempName = "";

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

							if (buttons.get(j).equals(pNInput)){
								tempName = pNInput.getS();
								// System.out.println(tempName);

							}
							((textInput)buttons.get(j)).setS("");
							}

							// if (buttons.get(j) instanceof uLButton){

							// 	
							// 	System.out.println(tempFile.toString());	
							// }
							
						}

						// System.out.println("file: " + tempFile.toString());
						((sButton)buttons.get(i)).makePlant(tempFile, uNInput.getS(), tempName, images);
						
					}
					
				} else {
					if (buttons.get(i) instanceof textInput){
						((textInput)buttons.get(i)).setBeingTyped(false);
					}
				}

				

			}}
		
	}
	
	
	

	
}
