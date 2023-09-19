package TankFire;

public class Tank extends Movement {
    protected int direction, spead = 1;
    protected Fire fire;

    public Tank(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }

    public Tank(int x, int y, int direction, int spead) {
        this(x, y, direction);
        this.spead = spead;
    }

    public void fireEnemyTank() {
        switch (direction) {
            // Up
            case 0:
                // new Thread(new Fire(x + 20, y, direction)).start();
                fire = new Fire(x + 20, y, direction);
                break;
            // Right
            case 1:
                // new Thread(new Fire(x + 60, y + 20, direction)).start();
                fire = new Fire(x + 60, y + 20, direction);
                break;
            // Down
            case 2:
                // new Thread(new Fire(x + 20, y + 60, direction)).start();
                fire = new Fire(x + 20, y + 60, direction);
                break;
            // Left
            case 3:
                // new Thread(new Fire(x, y + 20, direction)).start();
                fire = new Fire(x, y + 20, direction);
                break;
        }
        new Thread(fire).start();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return spead;
    }

    public void setSpeed(int speed) {
        this.spead = speed;
    }
}
