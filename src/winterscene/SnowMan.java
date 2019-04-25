package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape {

    public SnowMan(int x, int y, int w, int h) {
        super(x, y, w, h, Color.WHITE, 0, 0);
    }

    public void draw(Graphics window) {
        window.fillOval(getXPos()+getWidth()/4, getYPos(), getWidth()/2, getHeight()/3);
        window.fillOval(getXPos()+getWidth()/8, getYPos()+getHeight()/4, getWidth()*3/4, getHeight()/2);
        window.fillOval(getXPos(), getYPos()+getHeight()/2, getWidth(), getHeight()/2);
    }

    public void moveAndDraw(Graphics window) {
        draw(window);
    }
}