import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.geom.RoundRectangle2D;

public class LvlSel extends JPanel {
	Image moon = null;
	private int x, y;
	public LvlSel() {
		try {
			moon = ImageIO.read(new File("moon.png"));
		} catch (IOException e) {
		}
		
		moon = moon.getScaledInstance(1016, 839, Image.SCALE_DEFAULT);
		}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//create round rectangle object to store clip and initialize it
		RoundRectangle2D rr = new RoundRectangle2D.Double();
		rr.setRoundRect(100.0, 150.0, 816.0, 500.0, 20.0, 20.0);
		
		// draw background image + black tinted rectangle to darken it
		g2d.drawImage(moon, 0, 0, null);
        g.setColor(new Color(0,0,0,200));
        g.fillRect(0, 0, 1016, 839);
        
        //level button outline
        g.setColor(Color.blue.darker().darker());
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
        g2d.drawImage(moon, 100, 100, 816, 600, null);
        g.setClip(null);
        g.drawRoundRect(99, 149, 817, 501, 20, 20);
      //  g.setColor(Color.WHITE);
    //    rr.setRoundRect(100.0, 150.0, 816.0, 500.0, 20.0, 20.0);
    //    g.setClip(rr);
    //    g.setColor(Color.blue);
  //      g.fillRoundRect(79, 129, 857, 541, 20, 20);
   //     g2d.drawImage(moon, 100, 100, 816, 600, null);
   //     g.setClip(null);
   //     g.setColor(Color.white);
   //     int thickness = 5;
  //      Stroke oldStroke = g2d.getStroke();
    //    g2d.setStroke(new BasicStroke(thickness));
    //    g.drawRoundRect(79, 129, 857, 541, 20, 20);
    //    g.drawRoundRect(99, 149, 817, 501, 20, 20);
    //    g.setColor(Color.blue);
	      //  g.drawPolygon(new int[] {79, 79+857, 79+857, 79, 99, 99, 99+817, 99+817, 99, 79},
	       // 		new int[] {129, 129, 129+541, 129+541, 129, 149, 149, 149+501, 149+501, 149, 129}, 10);
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
