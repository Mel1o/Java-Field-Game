import java.awt.*;
import java.awt.geom.*;
public class Player {
    
    private double centerx,centery,size,x,y;
    private Color color=Color.white;  
    private Color wc=Color.white; 
    private double velx=0;
    private double vely=0;
    private double spinspeed=0;
    private double r=0;
    
    private int upcolor=0;
    
    //**These values are for making the win screen work**//    
    private double s=0;
    private double z=0;
    private double ex=-220;
    private double o=-190;
    
    public Player(double a, double b, double c,Color d){
        x=a;
        y=b;
        size=c;
        centerx=a+c/2;
        centery=b+c/2;
        color=d;
    }

    public void draw(Graphics2D g2d){
       g2d.rotate(Math.toRadians(r),centerx,centery);
       Triangle t1= new Triangle(x-5,y-7,size,size+8,Color.WHITE);
       t1.draw(g2d);
       Triangle t2= new Triangle(x+size+3,y+size+9,-size,-size-8,Color.WHITE);
       t2.draw(g2d);
       g2d.rotate(Math.toRadians(-r),centerx,centery);
       Rectangle2D.Double in= new Rectangle2D.Double(x+size/3-2,y+size/3,size-30,size-30);
       g2d.setColor(color);
       g2d.fill(in);
    }
    //**FOR DRAWING THE WIN SCREEN OF PLAYER 1**//   
    public void drawp1win(Graphics2D g2d){
       Rectangle2D.Double pa= new Rectangle2D.Double(x-ex,y-s*2+o,s,s*5);
       g2d.setColor(wc);
       g2d.fill(pa);
       Rectangle2D.Double pb= new Rectangle2D.Double(x-ex,y-s*2+o,s*3,s);
       g2d.setColor(wc);
       g2d.fill(pb);
       Rectangle2D.Double pc= new Rectangle2D.Double(x-ex+s*3,y-s+o,s,s);
       g2d.setColor(wc);
       g2d.fill(pc);
       Rectangle2D.Double pd= new Rectangle2D.Double(x-ex,y+o,s*3,s);
       g2d.setColor(wc);
       g2d.fill(pd);
       
       Rectangle2D.Double a1= new Rectangle2D.Double(x-ex+s*6,y-s*2+o,s,s*5);
       g2d.setColor(wc);
       g2d.fill(a1);
       Rectangle2D.Double b1= new Rectangle2D.Double(x-ex+s*5,y-s+o,s,s);
       g2d.setColor(wc);
       g2d.fill(b1);
       
       Rectangle2D.Double w1= new Rectangle2D.Double(x-ex+s*14,y-s*2+o,s,s*4);
       g2d.setColor(wc);
       g2d.fill(w1);
       Rectangle2D.Double w2= new Rectangle2D.Double(x-ex+s*15,y+s*2+o,s,s);
       g2d.setColor(wc);
       g2d.fill(w2);
       Rectangle2D.Double w3= new Rectangle2D.Double(x-ex+s*16,y-s*2+o,s,s*4);
       g2d.setColor(wc);
       g2d.fill(w3);
       Rectangle2D.Double w4 =new Rectangle2D.Double(x-ex+s*17,y+s*2+o,s,s);
       g2d.setColor(wc);
       g2d.fill(w4);
       Rectangle2D.Double w5= new Rectangle2D.Double(x-ex+s*18,y-s*2+o,s,s*4);
       g2d.setColor(wc);
       g2d.fill(w5);
       
       Rectangle2D.Double i= new Rectangle2D.Double(x-ex+s*20,y-s*2+o,s,s*5);
       g2d.setColor(wc);
       g2d.fill(i);
       
       Rectangle2D.Double n1= new Rectangle2D.Double(x-ex+s*22,y-s*2+o,s,s*5);
       g2d.setColor(wc);
       g2d.fill(n1);
       Rectangle2D.Double n2= new Rectangle2D.Double(x-ex+s*23,y-s+o,s,s);
       g2d.setColor(wc);
       g2d.fill(n2);
       Rectangle2D.Double n3= new Rectangle2D.Double(x-ex+s*24,y+o,s,s);
       g2d.setColor(wc);
       g2d.fill(n3);
       Rectangle2D.Double n4= new Rectangle2D.Double(x-ex+s*25,y-s*2+o,s,s*5);
       g2d.setColor(wc);
       g2d.fill(n4);
       
       Rectangle2D.Double s1= new Rectangle2D.Double(x-ex+s*28,y-s*2+o,s*3,s);
       g2d.setColor(wc);
       g2d.fill(s1);
       Rectangle2D.Double s2= new Rectangle2D.Double(x-ex+s*27,y+s*2+o,s*3,s);
       g2d.setColor(wc);
       g2d.fill(s2);
       Rectangle2D.Double s3= new Rectangle2D.Double(x-ex+s*28,y+o,s*2,s);
       g2d.setColor(wc);
       g2d.fill(s3);
       Rectangle2D.Double s4= new Rectangle2D.Double(x-ex+s*27,y-s+o,s,s);
       g2d.setColor(wc);
       g2d.fill(s4);
       Rectangle2D.Double s5= new Rectangle2D.Double(x-ex+s*30,y+s+o,s,s);
       g2d.setColor(wc);
       g2d.fill(s5);
       
       Rectangle2D.Double exclam1= new Rectangle2D.Double(x-ex+s*32,y-s*2+o,s,s*3);
       g2d.setColor(wc);
       g2d.fill(exclam1);
       Rectangle2D.Double exclam2= new Rectangle2D.Double(x-ex+s*32,y+s*2+o,s,s);
       g2d.setColor(wc);
       g2d.fill(exclam2);
    }
    //**FOR MAKING THE WIN SCREEN APPEAR OF PLAYER 1**//   
    public void movewinscreen1(){
        if(s<=20){
            ex=ex+2;
            s=s+0.1;
            o=o+1;
        }
    }
    //**FOR DRAWING THE WIN SCREEN OF PLAYER 2**//  
    public void drawp2win(Graphics2D g2d){
       Rectangle2D.Double pa= new Rectangle2D.Double(x-ex-z*4,y-z*2+o,z,z*5);
       g2d.setColor(wc);
       g2d.fill(pa);
       Rectangle2D.Double pb= new Rectangle2D.Double(x-ex-z*4,y-z*2+o,z*3,z);
       g2d.setColor(wc);
       g2d.fill(pb);
       Rectangle2D.Double pc= new Rectangle2D.Double(x-ex-z,y-z+o,z,z);
       g2d.setColor(wc);
       g2d.fill(pc);
       Rectangle2D.Double pd= new Rectangle2D.Double(x-ex-z*4,y+o,z*3,z);
       g2d.setColor(wc);
       g2d.fill(pd);
       
       Rectangle2D.Double a2= new Rectangle2D.Double(x-ex+z,y-z*2+o,z*3,z);
       g2d.setColor(wc);
       g2d.fill(a2);
       Rectangle2D.Double b2= new Rectangle2D.Double(x-ex+z*4,y-z+o,z,z);
       g2d.setColor(wc);
       g2d.fill(b2);
       Rectangle2D.Double c2= new Rectangle2D.Double(x-ex+z,y+z*2+o,z*4,z);
       g2d.setColor(wc);
       g2d.fill(c2);
       Rectangle2D.Double d2= new Rectangle2D.Double(x-ex+z*2,y+o,z*2,z);
       g2d.setColor(wc);
       g2d.fill(d2);
       Rectangle2D.Double e2= new Rectangle2D.Double(x-ex+z,y+z+o,z,z);
       g2d.setColor(wc);
       g2d.fill(e2);
       
       
       Rectangle2D.Double w1= new Rectangle2D.Double(x-ex+z*14,y-z*2+o,z,z*4);
       g2d.setColor(wc);
       g2d.fill(w1);
       Rectangle2D.Double w2= new Rectangle2D.Double(x-ex+z*15,y+z*2+o,z,z);
       g2d.setColor(wc);
       g2d.fill(w2);
       Rectangle2D.Double w3= new Rectangle2D.Double(x-ex+z*16,y-z*2+o,z,z*4);
       g2d.setColor(wc);
       g2d.fill(w3);
       Rectangle2D.Double w4 =new Rectangle2D.Double(x-ex+z*17,y+z*2+o,z,z);
       g2d.setColor(wc);
       g2d.fill(w4);
       Rectangle2D.Double w5= new Rectangle2D.Double(x-ex+z*18,y-z*2+o,z,z*4);
       g2d.setColor(wc);
       g2d.fill(w5);
       
       Rectangle2D.Double i= new Rectangle2D.Double(x-ex+z*20,y-z*2+o,z,z*5);
       g2d.setColor(wc);
       g2d.fill(i);
       
       Rectangle2D.Double n1= new Rectangle2D.Double(x-ex+z*22,y-z*2+o,z,z*5);
       g2d.setColor(wc);
       g2d.fill(n1);
       Rectangle2D.Double n2= new Rectangle2D.Double(x-ex+z*23,y-z+o,z,z);
       g2d.setColor(wc);
       g2d.fill(n2);
       Rectangle2D.Double n3= new Rectangle2D.Double(x-ex+z*24,y+o,z,z);
       g2d.setColor(wc);
       g2d.fill(n3);
       Rectangle2D.Double n4= new Rectangle2D.Double(x-ex+z*25,y-z*2+o,z,z*5);
       g2d.setColor(wc);
       g2d.fill(n4);
       
       Rectangle2D.Double s1= new Rectangle2D.Double(x-ex+z*28,y-z*2+o,z*3,z);
       g2d.setColor(wc);
       g2d.fill(s1);
       Rectangle2D.Double s2= new Rectangle2D.Double(x-ex+z*27,y+z*2+o,z*3,z);
       g2d.setColor(wc);
       g2d.fill(s2);
       Rectangle2D.Double s3= new Rectangle2D.Double(x-ex+z*28,y+o,z*2,z);
       g2d.setColor(wc);
       g2d.fill(s3);
       Rectangle2D.Double s4= new Rectangle2D.Double(x-ex+z*27,y-z+o,z,z);
       g2d.setColor(wc);
       g2d.fill(s4);
       Rectangle2D.Double s5= new Rectangle2D.Double(x-ex+z*30,y+z+o,z,z);
       g2d.setColor(wc);
       g2d.fill(s5);
       
       Rectangle2D.Double exclam1= new Rectangle2D.Double(x-ex+z*32,y-z*2+o,z,z*3);
       g2d.setColor(wc);
       g2d.fill(exclam1);
       Rectangle2D.Double exclam2= new Rectangle2D.Double(x-ex+z*32,y+z*2+o,z,z);
       g2d.setColor(wc);
       g2d.fill(exclam2);
    }
    //**FOR MAKING THE WIN SCREEN APPEAR OF PLAYER 1**//   
    public void movewinscreen2(){
        if(z<=20){
            ex=ex+2;
            z=z+0.1;
            o=o+1;
        }
    }
    /** adds the x and y coordinates with their respective **/
    public void sety(double n){
        y=n;
    }
    public void moveX(){
        x=x+velx;
        /** Handling the rotation**/
        r=r+2;
        centerx=x+size/2;
        centery=y+size/2;
    }
    public void moveY(){
        y=y+vely;
        /** Handling the rotation**/
        r=r+2;
        centerx=x+size/2;
        centery=y+size/2;  
    }
    /** Handling the velocity**/
    public void setvely(double s){
        if (vely<=10 && vely>=-10)
            vely=vely+s;
    }
    public void setvelx(double s){
        if (velx<=10 && velx>=-10)
            velx=velx+s;
    }
    public void decvelx(){
        if (velx>0){
            velx=velx-1;
        }
        else if (velx<0){
            velx=velx+1;
        }
    }
    public void decvely(){
        if (vely>0){
            vely=vely-1;
        }
        else if (vely<0){
            vely=vely+1;
        }
    }
    public double returnvelx(){
        return velx;
    }
    public double returnvely(){
        return vely;
    }
    /** knowing the coordinates of each side of the player**/
    public double getleft(){
        return x;
    }
    public double gettop(){
        return y;
    }
    public double getbottom(){
        return y+size;
    }
    public double getright(){
        return size+x;
    }
    /** dashing!**/
    public void dashdown(){
        y=y+70;
    }
    public void dashup(){
        y=y-70;
    }
    public void spin(){
        r=r+spinspeed;
    }
    public void setspinspeed(double n){
        spinspeed=n;
    }
    public void changeColor(float h1, float s1, float v1,float h2, float s2, float v2) {
        if (upcolor==0){
            color = Color.getHSBColor(h1,s1,v1);
                    upcolor=1;  
        }
        else if(upcolor==1){
            color = Color.getHSBColor(h2,s2,v2);
                    upcolor=0;
                
        }    
    }
    
}