import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/** The Game Canvas!**/
public class GameCanvas extends JComponent {
    private int width;
    private int height;
    private int s=60;
    private Color bg=Color.WHITE;
    
    /** Instantiating Player 1**/
    private Color fieldcolor1=Color.getHSBColor(0.55f, 0.67f, 0.84f);
    private Player p1 = new Player(width/4-50/2,height/2-50/2,100,fieldcolor1);
    private Field f1 = new Field(s/2, s/2, width, 1, fieldcolor1);
    private Pew pew1= new Pew(1100,-50,20,20,1,fieldcolor1);
    private Pewpew pewpew1= new Pewpew(1100,-50,20,20,1,fieldcolor1);
    
    /** Instantiating Player 2**/
    private Color fieldcolor2=Color.getHSBColor(0.93f, 0.99f, 1f);
    private Player p2 = new Player(width/4-50/2+width/2,height/2-50/2,-100,fieldcolor2);
    private Field f2 = new Field(s/2+width/2, s/2, width, height-s,fieldcolor2);
    private Pew pew2= new Pew(-100,-50,20,20,2,fieldcolor2);
    private Pewpew pewpew2= new Pewpew(-100,-50,20,20,2,fieldcolor2);
    
    public void createPlayer(){
        p1= new Player(width/4-30,height/2-25,50,fieldcolor1);
        p2 = new Player(width/4-50/2+width/2,height/2-50/2,50,fieldcolor2);
    }
    public void createField(){
        f1 = new Field(s/2, s/2, width/2-s, height-s, fieldcolor1); 
        f2 = new Field(s/2+width/2, s/2, width/2-s, height-s,fieldcolor2);
    }
    public void createBullet(){
        pew1= new Pew(1100,-50,20,20,1,fieldcolor1);
        pewpew1= new Pewpew(1100,-50,20,20,1,fieldcolor1);
        
        pew2= new Pew(-100,-5,20,20,2,fieldcolor2);
        pewpew2= new Pewpew(-100,-5,20,20,2,fieldcolor2);
    }
    
    public GameCanvas(int w, int h, Color bgc){
       width=w;
       height=h;
       bg=bgc;
       
       createBullet();
       createPlayer();
       createField();
      
       setPreferredSize(new Dimension(width,height));  
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d= (Graphics2D) g;
        
        RenderingHints rh=new RenderingHints (RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        
        AffineTransform reset=g2d.getTransform();
        
        Rectangle2D.Double background =new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(bg);
        g2d.fill(background);
                
        /** Draws Everything!**/
        f1.draw(g2d);
        g2d.setTransform(reset);
        f2.draw(g2d);
        g2d.setTransform(reset);
        pew1.draw(g2d);
        g2d.setTransform(reset);
        pewpew1.draw(g2d);
        g2d.setTransform(reset);
        pewpew2.draw(g2d);
        g2d.setTransform(reset);
        pew2.draw(g2d);
        g2d.setTransform(reset);
        p1.drawp1win(g2d);
        p1.draw(g2d);
        g2d.setTransform(reset);
        p2.drawp2win(g2d);
        p2.draw(g2d);
        g2d.setTransform(reset);
    }
    public Player returnP1(){
        return p1;
    }
    public Field returnF1(){
        return f1;
    }
    public Pew returnPew1(){
        return pew1;
    }
    public Pewpew returnPewpew1(){
        return pewpew1;
    }
    public Pewpew returnPewpew2(){
        return pewpew2;
    }
    public Player returnP2(){
        return p2;
    }
    public Field returnF2(){
        return f2;
    }
    public Pew returnPew2(){
        return pew2;
    }
}
