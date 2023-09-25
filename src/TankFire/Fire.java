package TankFire;

public class Fire extends Movement implements Runnable {
    /*
     * @param x 子弹x坐标
     * 
     * @param y 子弹y坐标
     * 
     * @param direction 子弹方向
     * 
     * @param speed 子弹速度
     * 
     * @param type 子弹的发射者类型
     */
    private int type;

    public Fire(int x, int y, int direction, int type) {
        super(x, y);
        this.direction = direction;
        this.type = type;
    }

    // 子弹是否击中坦克
    public static boolean isHitTank(Fire fire, Tank tank) {
        int xFire = fire.getX(), yFire = fire.getY(), xTank = tank.getX(), yTank = tank.getY();
        if (xFire >= xTank && xFire <= xTank + 40 && yFire >= yTank && yFire <= yTank + 60) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            switch (direction) {
                // Up
                case 0:
                    moveUp(speed);
                    break;
                // Right
                case 1:
                    moveRight(speed);
                    break;
                // Down
                case 2:
                    moveDown(speed);
                    break;
                // Left
                case 3:
                    moveLeft(speed);
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}