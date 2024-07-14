import java.awt.*;
public class Pewpew extends Bullet {
    public Pewpew(double xa, double ya, double sizea, double vel, double direction, Color e) {
        super(xa-30/2, ya-30/2, sizea+60, vel*2, direction, e);
    }
}
