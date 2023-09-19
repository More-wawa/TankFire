package TankFire;

public class Fire extends Movement implements Runnable {
    /*
     * @param: x 子弹x坐标
     * 
     * @param: y 子弹y坐标
     * 
     * @param: direction 子弹方向
     * 
     * @param: speed 子弹速度
     * 
     * @param: isLive 子弹还是否存在
     */
    private int direction, speed = 2;
    private boolean isLive = true;

    public Fire(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }

    public Fire(int x, int y, int direction, int spead) {
        this(x, y, direction);
        this.speed = spead;
    }

    @Override
    public void run() {
        while (true) {
            switch (direction) {
                // Up
                case 0:
                    this.moveUp(speed);
                    break;
                // Right
                case 1:
                    this.moveRight(speed);
                    break;
                // Down
                case 2:
                    this.moveDown(speed);
                    break;
                // Left
                case 3:
                    this.moveLeft(speed);
                    break;
            }

            // 子弹超出边界
            if (x < 0 || x > 1000 || y < 0 || y > 750) {
                isLive = false;
                break;
            }
            // 子弹击中

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

    public boolean getIsLive() {
        return isLive;
    }

}
