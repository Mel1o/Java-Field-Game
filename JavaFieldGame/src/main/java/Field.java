import java.awt.*;
import java.awt.geom.*;
public class Field {
    private double x,y;
    private Color color;
    private int space=60;
    private double width;
    private double height;
    public Field(double a, double b, double c,double d, Color e){
        x=a;
        y=b;
        width=c;
        height=d;
        color=e;
    }
    public void draw(Graphics2D g2d){
       RoundRectangle2D b= new RoundRectangle2D.Double(x, y, width, height, space/2, space/2);
       g2d.setColor(color);
       g2d.fill(b);
    }
    
    public void Resize(double n){
        width=width+n;
    }
    public void movex(double n){
        x=x+n;
    }
    public double gettop(){
        return y;
    }
    public double getbottom(){
        return y+height;
    }
    public double getleft(){
        return x;
    }
    public double getright(){
        return x+width;
    }
    public double getsize(){
        return width;
    }
    public void setleft(double n){
        x=n;
    }
    public void setright(double n){
        width=n;
    }
}
