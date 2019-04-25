package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
class SimpleSnowFlake extends AbstractShape {

    public SimpleSnowFlake(int x, int y, int wid, int ht) {
        super(x, y, wid, ht);
    }

    public SimpleSnowFlake(int x, int y, int wid, int ht, Color col) {
        super(x, y, wid, ht, col);
    }

    public SimpleSnowFlake(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
        super(x, y, wid, ht, col, xSpd, ySpd);
    }

    //helper method
    private static final double SQRT3 = Math.sqrt(3);

    private int sqrt3(int n) {
        return (int) (SQRT3 * n);
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.drawLine(getXPos() + getWidth() / 2, getYPos(), getXPos() - getWidth() / 2, getYPos());
        window.drawLine(getXPos() + getWidth() / 4, getYPos() + sqrt3(getHeight()) / 2, getXPos() - getWidth() / 4, getYPos() - sqrt3(getHeight()) / 2);
        window.drawLine(getXPos() - getWidth() / 4, getYPos() + sqrt3(getHeight()) / 2, getXPos() + getWidth() / 4, getYPos() - sqrt3(getHeight()) / 2);
    }

    @Override
    public void draw(Graphics window) {
        draw(window, getColor());
    }

    @Override
    public void moveAndDraw(Graphics window) {
        draw(window, Color.BLUE);
        
        //experimental vx adjuster
        //setXSpeed((int)((getXSpeed() +(int)(Math.random()*3 )-1)));
        //setXSpeed((int)(getXSpeed()*Math.random()*4 + Math.random()-0.5));
        //end experimental vx adjuster
        
        setXPos(getXPos() + getXSpeed());
        setYPos(getYPos() + getYSpeed());
        draw(window);
    }

}