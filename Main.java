import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class Main extends JPanel{
	
	 Pacman M = new Pacman();

	 public Main() {
		 

		 addKeyListener(new KeyListener() {
			 @Override
			 public void keyTyped(KeyEvent e) {
			 }
			 @Override
			 public void keyReleased(KeyEvent e) {
			 M.keyReleased(e);
			 }
			 @Override
			 public void keyPressed(KeyEvent e) {
			 M.keyPressed(e);
			 }
		 } 
		 );
		 setFocusable(true);

	}
	
		 
	 private void move() {
		 M.move();
		 }
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);	
		Graphics2D g2d = (Graphics2D) g;
		M.paint(g2d);	
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_ON);	
	}
	
	public static void main(String[] args) throws InterruptedException {	
		JFrame frame = new JFrame("Window");
		frame.setBackground(Color.black);
		Main cf = new Main();	
		frame.setSize(1016,830);
		frame.setVisible(true);
		frame.add(cf);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true)
		 {
		 cf.move(); //Updates the coordinates 
		 cf.repaint(); //Calls the paint method
		 Thread.sleep(10); //Pauses for a moment
		 }
		}

}





