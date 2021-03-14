/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author takehirotsurumi
 */
public class MovingRectangle extends MovingShape {
    
    public MovingRectangle(){
        this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor,defaultFillColor, defaultPath);
    }

    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x ,y ,w ,h ,mw ,mh ,bc ,fc , pathType); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Point p) {
        if(super.getX()<p.getX()&&super.getX()+super.width>p.getX()){
            if(super.getY()>p.getY()&&super.getY()+super.height<p.getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(fillColor);
	g.fillRect(topLeft.x, topLeft.y, width, height);
	g.setColor(borderColor);
	g.drawRect(topLeft.x, topLeft.y, width, height);
	drawHandles(g);
    }
    
}
