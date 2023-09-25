package TankFire;

import java.util.Vector;

public class Hero extends Tank {
    /*
     * param fires 主角的子弹数组
     */
    public static Vector<Fire> fires = new Vector<>();

    public Hero(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Hero(int x, int y, int direction, int spead) {
        super(x, y, direction, spead);
    }

    public void heroFire() {
        switch (direction) {
            // Up
            case 0:
                fires.add(fire = new Fire(x + 20, y, direction, 0));
                break;
            // Right
            case 1:
                fires.add(fire = new Fire(x + 60, y + 20, direction, 0));
                break;
            // Down
            case 2:
                fires.add(fire = new Fire(x + 20, y + 60, direction, 0));
                break;
            // Left
            case 3:
                fires.add(fire = new Fire(x, y + 20, direction, 0));
                break;
        }
        new Thread(fire).start();
    }
}
