package TankFire;

import java.util.Vector;

public class EnemyTank extends Tank {
    /*
     * @param enemyFires 敌方发射的子弹数组
     */
    private Vector<Fire> enemyFires = new Vector<>();

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    public EnemyTank(int x, int y, int direction, int spead) {
        super(x, y, direction, spead);
    }

    public Vector<Fire> getEnemyFires() {
        return enemyFires;
    }

    public void setEnemyFires(Vector<Fire> enemyFires) {
        this.enemyFires = enemyFires;
    }


}
