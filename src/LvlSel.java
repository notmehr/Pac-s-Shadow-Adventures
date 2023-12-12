import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.RoundRectangle2D;

public class LvlSel extends JPanel {
	Image moon = null;
	Image basement = null;
	Image colisseum = null;
	Image mars = null;
	Image currImg = null;
	Image[] bg;
	private int x, y, g;
	public LvlSel() {
		try {
			moon = ImageIO.read(new File("moon.png"));
			basement = ImageIO.read(new File("basement.png"));
			colisseum = ImageIO.read(new File("colisseum.jfif"));
			mars = ImageIO.read(new File("mars.jfif"));
		} catch (IOException e) {
		}
		
		moon = moon.getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
		basement = basement.getScaledInstance(1000,  800, Image.SCALE_DEFAULT);
		colisseum = colisseum.getScaledInstance(1000,  800, Image.SCALE_DEFAULT);
		mars = mars.getScaledInstance(1000,  800, Image.SCALE_DEFAULT);
		bg = new Image[] {moon, basement, colisseum, mars};
		
		addKeyListener(new KeyListener() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{

			}
			@Override
			public void keyReleased(KeyEvent e) 
			{
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(g+1>bg.length-1) g=0;
					else g++;
					
					currImg = bg[g];
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(g-1<0) g=bg.length-1;
					else g--;
					
					currImg = bg[g];
				}
			}
			
		});
		setFocusable(true);
		currImg = bg[0];

	}
	
	
	
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//create round rectangle object to store clip and initialize it
		RoundRectangle2D rr = new RoundRectangle2D.Double();
		rr.setRoundRect(100.0, 150.0, 816.0, 500.0, 20.0, 20.0);

		// draw background image + black tinted rectangle to darken it
		g2d.drawImage(currImg, 0, 0, null);
        g.setColor(new Color(0,0,0,200));
        g.fillRect(0, 0, 1016, 839);
        
        //level button outline
        g.setColor(new Color(204, 23, 9));
        g.fillRoundRect(79, 129, 857, 541, 20, 20);
        
        //sets rectangle outline thickness and creates an oldstroke var
        int thickness = 5;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(thickness));
        
        //draws outer level button line
        g.setColor(Color.WHITE);
        g.drawRoundRect(79, 129, 857, 541, 20, 20);
        
        //sets the clip to the round rectangle + draws level button image
	    g.setClip(rr);
        g2d.drawImage(currImg, 100, 100, 816, 600, null);
        g.setClip(null);
        g.drawRoundRect(99, 149, 817, 501, 20, 20);
        
        //instructions
        g.setFont(new Font("DialogInput", Font.BOLD, 20));
      	g2d.drawString("Press [SPACEBAR] to select, use arrow keys to choose", 210, 785);
      	
      	int a = 956;
      	int b = 375;
      	int c = 54;
        g.setColor(new Color(204, 23, 9));
      	g.fillPolygon(new int[] {a, a, a+30}, new int[] {b, b+50, b+25}, 3);
      	g.fillPolygon(new int[] {c, c, c-30}, new int[] {b, b+50, b+25}, 3);
      	g2d.setColor(Color.WHITE);
      	g.drawPolygon(new int[] {a, a, a+30}, new int[] {b, b+50, b+25}, 3);
      	g.drawPolygon(new int[] {c, c, c-30}, new int[] {b, b+50, b+25}, 3);

	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("C");
		LvlSel c = new LvlSel();
		frame.add(c);
	//	  frame.setResizable(false);
		  frame.setSize(1016, 839);
		  frame.setVisible(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		  while(true) {
			  c.repaint();
			  Thread.sleep(10);
			  }
		  }
	}
