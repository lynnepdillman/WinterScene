package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WinterScenePanel extends JPanel implements Runnable {

    private List<AbstractShape> shapes;
    private AbstractShape sMan;
    
    public WinterScenePanel() {
        setVisible(true);
        //refer shapes to a new ArrayList of AbstractShape
        shapes = new ArrayList(100);
        //populate the list with 50 unique snowflakes
        for (int i = 0; i < 50; i++) {
            shapes.add(new SimpleSnowFlake((int) (Math.random()*800), (int) (Math.random()*600), 15, 15, Color.WHITE, (int) (Math.random()*3)-1, (int) (Math.random()*3)+1));
            shapes.add(new FancySnowFlake((int) (Math.random()*800), (int) (Math.random()*600), 15, 15));
        }
        //instantiate a snowman
        sMan = new SnowMan(200, 300, 100, 200);
        
        new Thread(this).start();
    }
    
    public void update(Graphics window) {
        paint(window);
    }
    
    public void paint(Graphics window) {
        window.setColor(Color.BLUE);
        window.fillRect(0, 0, getWidth(), getHeight());
        window.setColor(Color.WHITE);
        window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        window.setFont(new Font("TAHOMA", Font.BOLD, 18));
        window.drawString("MAKE A WINTER SCENE!", 40, 40);

		//make the snowman appear
        sMan.draw(window);
        //make the snowflakes appear and move down the screen
        for (AbstractShape s: shapes) {
            s.moveAndDraw(window);
        
        //check to see if any of the snowflakes need to be reset to the top of the screen
            if (s.getYPos() > 600) {
                s.setYPos(0);
            }
            if (s.getXPos() > 800) {
                s.setXPos(0);
            }
            if (s.getXPos() < 0) {
                s.setXPos(800);
            }
        }
    }
    
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(35);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}