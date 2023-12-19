import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

 public class Pacman {
//variables 
 private int x,y;
 private int xa=1;
 private int ya=1;
 //Pac-man Diameter
 private int D =60;	
 private int direction=0;
 private int mod=50;
 private int n = 10;
//Coin variables
 
 
 //key-binds 
 private boolean right = false, left = false;
 private boolean up = false, down = false;

 //Pac-man poses 
 private BufferedImage imgLRC = null;
 private BufferedImage imgUDC = null;
 private BufferedImage imgLRO = null;
 private BufferedImage imgUDO = null;

 	
	//constructor
 	public Pacman(int x,int y)
	{
		this.x=x;
		this.y=y;
		
		//left and right closed
		try {
			imgLRC = ImageIO.read(new File("1.png"));
		} catch (IOException e)
		{
			System.out.println("No Image");
		}
		//up and down closed
		try {
			imgUDC = ImageIO.read(new File("2.png"));
		} catch (IOException e) 
		{
			System.out.println("No Image");
		}  
		//left and right open
		try {
			imgLRO = ImageIO.read(new File("10.png"));
		} catch (IOException e)
		{
			System.out.println("No Image");
		} 
		try {
			imgUDO = ImageIO.read(new File("20.png"));
		} catch (IOException e)
		{
			System.out.println("No Image");
		}
	
	}
	
	public void keyPressed(KeyEvent e){ 
		 if (e.getKeyCode() == KeyEvent.VK_W){
			 up=true;
			 direction=1;
		 }
		 if (e.getKeyCode() == KeyEvent.VK_A){
			 left = true;
			 direction=2;
		 }
		 if (e.getKeyCode() == KeyEvent.VK_S){
			 down = true;
			 direction=3;
		 }
		 if (e.getKeyCode() == KeyEvent.VK_D){
			 right = true;
			 direction=4;
		 }
	}
 	public void keyReleased(KeyEvent e){
		 if (e.getKeyCode() == KeyEvent.VK_W){
			up = false;
			 
		 } 
		 if (e.getKeyCode() == KeyEvent.VK_A){
			left = false; 
			
		 }
		 if (e.getKeyCode() == KeyEvent.VK_S){
			down = false;
			 
		 }
		 if (e.getKeyCode() == KeyEvent.VK_D){
			right=false;
		 }
 	}
 	
 	//movement 
 	public void move() {
		 //Right   	
 		if (direction==4){
 			if(x<820) {
			 xa = 1;
			 x+=xa;
 			}
		 }
 		//Left
		 if (direction==2){
			 if(x>-20) {
			 xa = -1;
			 x+=xa;
			 }
		 }	
 		//Down  
		 if (direction==3){
			 if(y<710){
			 ya = 1;
			 y+=ya; 
			 }
		 }
		 //Up
		 if (direction==1){
			 if(y>-20) {
			 ya = -1;
			 y+=ya;
			 }
		 }	
 	}
 	
 	//getters 
 		public int getX () {
 			return this.x;
 		}	 
 		public int getY () {
 			return this.y;
 		}
 			 
	 public void paint(Graphics2D g2d) {

		g2d.setColor(Color.yellow);
		g2d.fillOval(500, 40, 20, 20); 
		g2d.setColor(Color.black);
		g2d.drawOval(500, 40, 20, 20); 
		 	 
		int num = this.direction;
		switch(num) {
		//up
		case 1:
			up=true;
			//closed
			if(getY()%mod==n) {
			g2d.drawImage(imgUDO, x, y,D,D,null);	
			}
			else {
			g2d.drawImage(imgUDC, x, y,D,D,null);	
			}
		break;
		//left 
		case 2:
			left=true;
			if(getX()%mod==n) {
				//open
				g2d.drawImage(imgLRO, x+D, y,-D,D,null);
			}
			else {
				//closed
				g2d.drawImage(imgLRC, x+D, y,-D,D,null);
			}
		break;
		//down 	
		case 3:
			down=true;
			//closed
			if(getY()%mod==n) {
			g2d.drawImage(imgUDO, x, y+D,D,-D,null);
			} 
			else {
				g2d.drawImage(imgUDC, x, y+D,D,-D,null);	
			}
		break;
		//right  
		case 4:
			right=true;
			if(getX()%mod==n) {
			//open
			g2d.drawImage(imgLRO, x, y,D,D,null);
			}
			else {
			//closed
			g2d.drawImage(imgLRC, x, y,D,D,null);
			}
		break;	
		default:
			g2d.drawImage(imgLRC, x, y,D,D,null);		
		}			
	}	
}

