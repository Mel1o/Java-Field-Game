import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

public class GameFrame extends JFrame {
    
    private int width,height;
    private Container contentPane;
    private JFrame frame;
    private GameCanvas gc= new GameCanvas(1100,650,Color.WHITE);
    private Timer timer;
    private int speed=5;
    
    /** Counters for player 1**/
        /** for the vertical movement**/
        private int c=0;
        /** for the horizontal movement**/
        private int c1=0;
        /** for the movement of the bullet**/
        private int c2=0;
        /** for the resizing of the field**/
        private double c3=0;
        /** for knowing what size bullet to fire**/
        private double c4=0;
    
    /** Counters for player 2**/
        private int z=0;
        /** for the horizontal movement**/
        private int z1=0;
        /** for the movement of the bullet**/
        private int z2=0;
        /** for the resizing of the field**/
        private double z3=0;
        /** for knowing what size bullet to fire**/
        private double z4=0;
    
    /** Calculating the amount of space decreased for the fields every time a player is hit**/
    private double p1healthpoints=3;
    private double p2healthpoints=3;
    private double fieldcounter=p1healthpoints;
    private double fieldsize=gc.returnF1().getsize()/fieldcounter;

    public GameFrame(int w, int h){
        frame=new JFrame();
        width=w;
        height=h;
    }
    public void setUpGUI(){
        contentPane=frame.getContentPane();
        frame.setTitle("Knock off");
        contentPane.setPreferredSize(new Dimension(width,height));
        
        gc.createPlayer();
        gc.createBullet();
        gc.createField();
        contentPane.add(gc,BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
     
        setUpTimer();
        setUpKL();
    }
    
    private void setUpTimer(){
        int interval=10;
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                
                /**                                     LOGIC FOR PLAYER 1 MOVEMENT                             **/
                
                /** This is for decreasing the velocity of the player1 **/
                if(c==1){
                    gc.returnP1().decvely();
                    if (gc.returnP1().returnvely()==0)
                        c=0;
                }
                
                else if(c1==1){
                    gc.returnP1().decvelx();
                    if (gc.returnP1().returnvelx()==0)
                        c1=0;
                }
                
                /** This is for stopping the player 1 from going out of their field**/
                if(gc.returnP1().gettop()<=gc.returnF1().gettop()){
                    gc.returnP1().setvely(speed+1);
                    c=1;
                }
                
                if(gc.returnP1().getbottom()>=gc.returnF1().getbottom()){
                    gc.returnP1().setvely(-speed-1);
                    c=1;
                }
                
               if(gc.returnP1().getright()>=gc.returnF1().getright()){
                    gc.returnP1().setvelx(-speed-1);
                    c1=1;
                }
               
               if(gc.returnP1().getleft()<=gc.returnF1().getleft()){
                    gc.returnP1().setvelx(speed+1);
                    c1=1;
                }
                
                
                /** This is for controlling the movement of the bullet of player 1**/
                if(c2==0){
                    gc.returnPew1().setX(-30);
                    gc.returnPew1().setY(-30);
                }
                if(gc.returnPew1().getleft()>=1300){
                    c2=0;
                }
                /** This is for controlling the movement of the bullet 2 of player 1**/
                if(c2==0){
                    gc.returnPewpew1().setX(-100);
                    gc.returnPewpew1().setY(-100);
                }
                if(gc.returnPewpew1().getleft()>=1300){
                    c2=0;
                }
                /** When Player1 collides with PLayer 2 bullet**/
                if(c3<=0){
                    if(gc.returnP1().getright()>gc.returnPew2().getleft()&&
                        gc.returnP1().gettop()<gc.returnPew2().getbottom()&&
                        gc.returnP1().getbottom()>gc.returnPew2().getup()&&
                        gc.returnP1().getleft()<gc.returnPew2().getright()){
                    c3=fieldsize/50;
                    p1healthpoints= p1healthpoints-1;
                    p2healthpoints= p2healthpoints+1;
                    }
                }
                /** When Player1 collides with PLayer 2 big bullet**/
                if(c3<=0){
                if(gc.returnP1().getright()>gc.returnPewpew2().getleft()&&
                        gc.returnP1().gettop()<gc.returnPewpew2().getbottom()&&
                        gc.returnP1().getbottom()>gc.returnPewpew2().getup()&&
                        gc.returnP1().getleft()<gc.returnPewpew2().getright()){
                    c3=fieldsize/50;
                    p1healthpoints= p1healthpoints-1;
                    p2healthpoints= p2healthpoints+1;
                    }
                }
                /**Resizing and moving the fields after a player 1 is hit**/
                if(c3>0.1){
                        gc.returnF1().Resize(-c3);
                        gc.returnF2().Resize(c3);
                        gc.returnF2().movex(-c3);
                        c3=c3-c3/50;      
                        gc.returnP1().changeColor(0.55f, 0.67f, 0.84f,0f, 0f, 1f);
                }
                else {
                    gc.returnP1().changeColor(0.55f, 0.67f, 0.84f,0.55f, 0.67f, 0.84f);
                    c3=0;
                }
                
                /**                                 LOGIC FOR PLAYER 2 MOVEMENT                                 **/
                
                /** This is for decreasing the velocity of the player2 **/
                if(z==1){
                    gc.returnP2().decvely();
                    if (gc.returnP2().returnvely()==0)
                        z=0;
                }
                
                else if(z1==1){
                    gc.returnP2().decvelx();
                    if (gc.returnP2().returnvelx()==0)
                        z1=0;
                }
                
                /** This is for stopping the player 2 from going out of their field**/
                if(gc.returnP2().gettop()<=gc.returnF2().gettop()){
                    gc.returnP2().setvely(speed+1);
                    z=1;
                }
                
                if(gc.returnP2().getbottom()>=gc.returnF2().getbottom()){
                    gc.returnP2().setvely(-speed-1);
                    z=1;
                }
                
               if(gc.returnP2().getright()>=gc.returnF2().getright()){
                    gc.returnP2().setvelx(-speed-1);
                    z1=1;
                }
               
               if(gc.returnP2().getleft()<=gc.returnF2().getleft()){
                    gc.returnP2().setvelx(speed+1);
                    z1=1;
                }
                
                if(z2==0){
                    gc.returnPew2().setX(1100);
                    gc.returnPew2().setY(-30);
                }
                if(gc.returnPew2().getleft()<=-10){
                    z2=0;
                }
                if(z2==0){
                    gc.returnPewpew2().setX(1100);
                    gc.returnPewpew2().setY(-100);
                }
                if(gc.returnPewpew2().getleft()<=-10){
                    z2=0;
                }
                
                /**When Player2 collides with PLayer 1 bullet**/
                if(z3<=0){
                    if(gc.returnP2().getright()>gc.returnPew1().getleft()&&
                        gc.returnP2().gettop()<gc.returnPew1().getbottom()&&
                        gc.returnP2().getbottom()>gc.returnPew1().getup()&&
                        gc.returnP2().getleft()<gc.returnPew1().getright()){
                    z3=fieldsize/50;
                    p2healthpoints= p2healthpoints-1;
                    p1healthpoints= p1healthpoints+1;
                    }
                }
                /**When Player2 collides with PLayer 1 BIG bullet**/
                if(z3<=0){
                if(gc.returnP2().getright()>gc.returnPewpew1().getleft()&&
                        gc.returnP2().gettop()<gc.returnPewpew1().getbottom()&&
                        gc.returnP2().getbottom()>gc.returnPewpew1().getup()&&
                        gc.returnP2().getleft()<gc.returnPewpew1().getright()){
                    z3=fieldsize/50;
                    p2healthpoints= p2healthpoints-1;
                    p1healthpoints= p1healthpoints+1;
                    }
                }
                /**Resizing and moving the fields after a player 2 is hit**/
                if(z3>0.1){
                        gc.returnF1().Resize(z3);
                        gc.returnF2().Resize(-z3);
                        gc.returnF2().movex(z3);
                        z3=z3-z3/50;    
                        gc.returnP2().changeColor(0.93f, 0.99f, 1f,0f, 0f, 1f);
                        
                }
                else {
                    gc.returnP2().changeColor(0.93f, 0.99f, 1f,0.93f, 0.99f, 1f);
                    z3=0;
                }
                /** This adds the velocity to the coordinates of player 1 to simulate movement **/
                gc.returnP1().moveY();
                gc.returnP1().moveX();
                gc.returnP1().spin();
                /** This adds the velocity to the coordinates of player 2 to simulate movement**/
                gc.returnP2().moveY();
                gc.returnP2().moveX();
                gc.returnP2().spin();
                /** moves the bullets**/
                gc.returnPew1().move();
                gc.returnPew2().move();
                gc.returnPewpew1().move();
                gc.returnPewpew2().move(); 
                
                /** Checks if a player has won and if they have, what to do**/
                
                /** If P2 wins**/
                if(p1healthpoints==0){
                    gc.returnP1().sety(-100);
                    gc.returnP1().sety(-100);
                    if(gc.returnF2().getleft()>40){
                        gc.returnF1().Resize(-1 );
                        gc.returnF2().Resize(1 );
                        gc.returnF2().movex(-1 );
                    }
                    gc.returnP2().movewinscreen2();
                }
                /** If P1 wins**/
                if(p2healthpoints==0){
                    gc.returnP2().sety(-100);
                    gc.returnP2().sety(-100);
                    if(gc.returnF1().getright()<1040){
                        gc.returnF1().Resize(1 );
                        gc.returnF2().Resize(-1 );
                    }
                    gc.returnP1().movewinscreen1();
                }
                String k="021";
                System.out.println(k.charAt(1)+1);
                
                gc.repaint();
            }
            
        };
        timer=new Timer(interval,al);
        timer.start();
    }
    
    /** CONTROLS**/
    public void setUpKL(){
        KeyListener kl = new KeyListener(){
            public void keyTyped(KeyEvent ke){
            }
            public void keyPressed(KeyEvent ke){
                int keyCode = ke.getKeyCode();
                switch(keyCode){
                    /** Controls for Player 1**/
                    case KeyEvent.VK_W:
                        gc.returnP1().setvely(-speed);
                        break;
                    case KeyEvent.VK_S:
                       gc.returnP1().setvely(speed);
                        break;
                    case KeyEvent.VK_A:
                        gc.returnP1().setvelx(-speed);
                        break;
                    case KeyEvent.VK_D:
                        gc.returnP1().setvelx(speed);
                        break;
                    case KeyEvent.VK_J:
                        gc.returnP1().dashup();
                        break;
                    case KeyEvent.VK_K:
                        gc.returnP1().dashdown();
                        break;
                    case KeyEvent.VK_H:
                        gc.returnP1().setspinspeed(5);
                        c4=c4+1;
                        break;
                    /** Controls for Player 2**/
                    case KeyEvent.VK_UP:
                        gc.returnP2().setvely(-speed);
                        break;
                    case KeyEvent.VK_DOWN:
                       gc.returnP2().setvely(speed);
                        break;
                    case KeyEvent.VK_LEFT:
                        gc.returnP2().setvelx(-speed);
                        break;
                    case KeyEvent.VK_RIGHT:
                        gc.returnP2().setvelx(speed);
                        break;
                    case KeyEvent.VK_N:
                        gc.returnP2().dashup();
                        break;
                    case KeyEvent.VK_M:
                        gc.returnP2().dashdown();
                        break;
                    case KeyEvent.VK_SPACE:
                        gc.returnP2().setspinspeed(5);
                        z4=z4+1;
                        break;
                }
            }
            public void keyReleased(KeyEvent ke){
                int keyCode = ke.getKeyCode();
                switch(keyCode){
                    /** Controls for Player 1**/
                    case KeyEvent.VK_W:
                        c=1;
                        break;
                    case KeyEvent.VK_S:
                        c=1;
                        break;
                    case KeyEvent.VK_A:
                        c1=1;
                        break;
                    case KeyEvent.VK_D:
                        c1=1;
                        break;
                    case KeyEvent.VK_H:
                        if(c4>3){
                        gc.returnPewpew1().setX(gc.returnP1().getleft()+10);
                        gc.returnPewpew1().setY(gc.returnP1().gettop()-20);
                        gc.returnPewpew1().bang();
                        c4=0;
                        }
                        else if(c4>1){
                        gc.returnPew1().setX(gc.returnP1().getleft()+10);
                        gc.returnPew1().setY(gc.returnP1().gettop()+10);
                        gc.returnPew1().bang();
                        c4=0;
                        }
                        gc.returnP1().setspinspeed(0);
                        c2=1;
                        break;
                    /** Controls for Player 2**/
                    case KeyEvent.VK_UP:
                        z=1;
                        break;
                    case KeyEvent.VK_DOWN:
                        z=1;
                        break;
                    case KeyEvent.VK_LEFT:
                        z1=1;
                        break;
                    case KeyEvent.VK_RIGHT:
                        z1=1;
                        break;
                    case KeyEvent.VK_SPACE:
                        if(z4>3){
                        gc.returnPewpew2().setX(gc.returnP2().getleft()+10);
                        gc.returnPewpew2().setY(gc.returnP2().gettop()-20);
                        gc.returnPewpew2().bang();
                        z4=0;
                        }
                        else if(z4>1){
                        gc.returnPew2().setX(gc.returnP2().getleft()+10);
                        gc.returnPew2().setY(gc.returnP2().gettop()+10);
                        gc.returnPew2().bang();
                        z4=0;
                        }
                        gc.returnP2().setspinspeed(0);
                        z2=1;
                        break;
                        
                }
            }
        };
        contentPane.addKeyListener(kl);
        contentPane.setFocusable(true);
        contentPane.requestFocusInWindow();
    }
    
}
