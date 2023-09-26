package TankFire;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    /*
     * @param fires 敌方的子弹数组
     */
    private Vector<Fire> fires = new Vector<>();

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    public EnemyTank(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    public void enemyFire() {
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

    @Override
    public void run() {
        while (isLive) {
            // 每过30步随机换一个方向并发射子弹
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (direction) {
                    // Up
                    case 0:
                        if (Movement.isMoveable(x, y, 0, speed))
                            moveUp(speed);
                        break;
                    // Right
                    case 1:
                        if (Movement.isMoveable(x, y, 1, speed))
                            moveRight(speed);
                        break;
                    // Down
                    case 2:
                        if (Movement.isMoveable(x, y, 2, speed))
                            moveDown(speed);
                        break;
                    // Left
                    case 3:
                        if (Movement.isMoveable(x, y, 3, speed))
                            moveLeft(speed);
                        break;
                }
            }
            enemyFire();
            direction = (int) (Math.random() * 4);
        }
    }

    public Vector<Fire> getFires() {
        return fires;
    }

    public void setFires(Vector<Fire> enemyFires) {
        this.fires = enemyFires;
    }
}
