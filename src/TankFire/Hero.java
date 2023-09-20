package TankFire;

import java.util.Vector;

public class Hero extends Tank{
    public static Vector<Fire> heroFires = new Vector<>();

    public Hero(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Hero(int x, int y, int direction, int spead) {
        super(x, y, direction, spead);
    }

}
