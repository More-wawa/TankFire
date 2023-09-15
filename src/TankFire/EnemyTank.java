package TankFire;

public class EnemyTank extends Tank {
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int spead) {
        super(x, y, spead);
    }

    public EnemyTank(int x, int y, int spead, int direction) {
        super(x, y, spead);
        this.direction = direction;
    }
}
