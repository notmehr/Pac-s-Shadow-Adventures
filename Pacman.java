import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 public class Pacman {
 private int x = 500;
 private int y =250;
 private int xa = 1;
 private int ya = 1;
 private int D =200;	 

 private boolean right = false, left = false;
 private boolean up = false, down = false;

 private BufferedImage imgLRO = null;
 private BufferedImage imgLRC = null;
 private BufferedImage imgUDO = null;
 private BufferedImage imgUDC = null;
 
	public Pacman()
	{
		try {
			imgLRO = ImageIO.read(new File("Pac man - Left (open).png"));
		} catch (IOException e) 
		{
			System.out.println("No Image");
		}
		try {
			imgUDO = ImageIO.read(new File("Pac man - Up (open).png"));
		} catch (IOException e) 
		{
			System.out.println("No Image");
		}
		try {
			imgLRC = ImageIO.read(new File("Pac man - Right (closed).png"));
		} catch (IOException e) 
		{
			System.out.println("No Image");
		}		
	}
 
 public void keyPressed(KeyEvent e){
 
	 if (e.getKeyCode() == KeyEvent.VK_W){
		 up = true;
	 }
	 if (e.getKeyCode() == KeyEvent.VK_A){
		 left = true;
	 }
	 if (e.getKeyCode() == KeyEvent.VK_S){
		 down = true;
	 }
	 if (e.getKeyCode() == KeyEvent.VK_D){
		 right = true;
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
		 right = false; 
	 }

 }
 	public void move() {
		 // movement 
		 if (right==true){
			 xa = 1;
			 x+=xa;
		 }
		 if (left==true){
			 xa = -1;
			 x+=xa;
		 }
		 if (down==true){
			 ya = 1;
			 y+=ya; 
		 }
		 if (up==true){
			 ya = -1;
			 y+=ya; 
		 }		
    }
	 
	 public void paint(Graphics2D g2d) {	 
		if(right==true) {
		 
		 g2d.drawImage(imgLRO, x+D, y,-D,D,null);
		}
		else {
			
			g2d.drawImage(imgLRC, x, y,D,D,null);	
		}
		
		if(left==true) {
			g2d.drawImage(imgLRO, x, y,D,D,null);	
		} 
		
		
		if(up==true) {
			g2d.drawImage(imgUDO, x, y,D,D,null);	
		}
		if(down==true) {
			g2d.drawImage(imgUDO, x, y+D,D,-D,null);	
		}
	} 
 }



