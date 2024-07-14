import java.awt.*;
public class Bullet {
    private double size,x,y;
    private Color color;
    
    private double speed;
    private double move;
    private double c=0;
    
    public Bullet(double xa, double ya, double sizea, double vel, double direction,Color e){
        x=xa;
        y=ya;
        size=sizea;
        c=direction;
        color=e;
        move=vel;
    }

    public void draw(Graphics2D g2d){
       Circle c1 = new Circle(x,y,size, Color.WHITE);
       Circle c2 = new Circle(x+size/4,y+size/4,size-size/2, color);
       c1.draw(g2d);
       c2.draw(g2d);
    }
    public void bang(){
        if (c==1){
            speed=move;
        }
        if (c==2){
            speed=-move;
        }

    }
    public void move(){
        if (x>=1300){
            speed=0;
        }
        if (x<=-200){
            speed=0;
        }
        x=x+speed;
    }
    
    public double getleft(){
        return x;
    }
    public double getup(){
        return y;
    }
    public double getbottom(){
        return y+size;
    }
    public double getright(){
        return x+size;
    }
    public void setX(double n){
        x=n;
    }
    public void setY(double n){
        y=n;
    }
}
