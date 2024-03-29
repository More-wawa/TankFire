package TankFire;

public class Tank extends Movement {
    /*
     * @param x 坦克左上角x坐标
     * 
     * @param y 坦克左上角y坐标
     * 
     * @param direction 坦克朝向
     * 
     * @param speed 坦克移动速度
     * 
     * @param isLive 是否存活
     */
    protected Fire fire;
    protected int speed = 2;
    protected boolean isLive = true;

    public Tank(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Tank(int x, int y, int direction, int speed) {
        super(x, y, direction);
        this.speed = speed;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

}
