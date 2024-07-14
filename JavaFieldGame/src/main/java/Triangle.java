import java.awt.*;
import java.awt.geom.*;
public class Triangle {
    private double x;
    private double y;
    private double height;
    private double length;
    private Color color;
    public Triangle(double x, double y, double height, double length, Color color){
        this.x =x;
        this.y =y;
        this.height=height;
        this.length=length;
        this.color =color;
    }
    
    public void draw(Graphics2D g2d) {
       Path2D.Double t =new Path2D.Double();
       t.moveTo(x, y+height);
       t.lineTo(x+length/2,y);
       t.lineTo(x+length,y+height);
       t.closePath();
       g2d.setColor(color);
       g2d.fill(t);
    }
}
