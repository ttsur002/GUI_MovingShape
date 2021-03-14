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
public class MovingSquarePattern extends MovingShape {
    
    public MovingSquarePattern(){
        this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor,defaultFillColor, defaultPath);
    }
    public MovingSquarePattern(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super(x ,y ,w ,h ,mw ,mh ,bc ,fc , pathType);
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
	/*g.setColor(fillColor);
        if(this.width>this.height){
	g.fill(topLeft.x, topLeft.y, height, height);
        }
        else{
        g.fillRect(topLeft.x, topLeft.y, width, width);
        }*/
	g.setColor(fillColor);
        if(this.width>this.height){
	g.drawRect(topLeft.x, topLeft.y, height, height);
        int step=height/10;
        int end=topLeft.x+step;
        for(int i=topLeft.y+step;i<topLeft.y+height;i+=step){
            g.drawLine(topLeft.x, i, end, topLeft.y+height);
            g.drawLine(topLeft.x+height, i, end, topLeft.y);
            end+=step;
        }
        }
        else{
        g.drawRect(topLeft.x, topLeft.y, width, width);
        int step=width/10;
        int end=topLeft.x+step;
        for(int i=topLeft.y+step;i<topLeft.y+width;i+=step){
            g.drawLine(topLeft.x, i, end, topLeft.y+width);
            g.drawLine(topLeft.x+width, i, end, topLeft.y);
            end+=step;
        }
        }
	drawHandles(g);
    }
    
}
