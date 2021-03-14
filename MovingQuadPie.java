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
public class MovingQuadPie extends MovingShape{
    public MovingQuadPie(){
        this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor,defaultFillColor, defaultPath);
    }

    public MovingQuadPie(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x ,y ,w ,h ,mw ,mh ,bc ,fc , pathType); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean contains(Point p) {
        if(this.width>this.height){
            double dx, dy;
		Point EndPt = new Point(topLeft.x + height, topLeft.y + height);
		dx = (2 * p.x - topLeft.x - EndPt.x) / (double) height;
		dy = (2 * p.y - topLeft.y - EndPt.y) / (double) height;
		return dx * dx + dy * dy < 1.0;
        }
        else{
            double dx, dy;
		Point EndPt = new Point(topLeft.x + width, topLeft.y + width);
		dx = (2 * p.x - topLeft.x - EndPt.x) / (double) width;
		dy = (2 * p.y - topLeft.y - EndPt.y) / (double) width;
		return dx * dx + dy * dy < 1.0;
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(fillColor);
        if(this.width>this.height){
	g.fillArc(topLeft.x, topLeft.y, height, height,0,90);
        g.fillArc(topLeft.x, topLeft.y, height, height,180,90);
        }
        else{
        g.fillArc(topLeft.x, topLeft.y, width, width,0,90);
        g.fillArc(topLeft.x, topLeft.y, width, width,180,90);
        }
	g.setColor(borderColor);
        if(this.width>this.height){
	g.drawOval(topLeft.x, topLeft.y, height, height);
        }
        else{
        g.drawOval(topLeft.x, topLeft.y, width, width);
        }
	drawHandles(g);
    }
    
}
