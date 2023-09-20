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
     * @param isLive 子弹是否存在
     * 
     * @param type 子弹的发射者类型
     */
    private boolean isLive = true;
    private int type;

    public Fire(int x, int y, int direction, int type) {
        super(x, y);
        this.direction = direction;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(x + " " + y);
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

            // 子弹超出边界或击中
            if (!isLive || x < 0 || x > 1000 || y < 0 || y > 750) {
                isLive = false;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

}
