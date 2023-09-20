package TankFire;

public class Tank extends Movement {
    /*
     * @param x 坦克左上角x坐标
     * 
     * @param y 坦克左上角y坐标
     * 
     * @param direction 坦克朝向
     * 
     * @param spead 坦克移动速度
     * 
     * @param isLive 是否存活
     */
    protected Fire fire;
    protected boolean isLive = true;

    public Tank(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }

    public Tank(int x, int y, int direction, int speed) {
        this(x, y, direction);
        this.speed = speed;
    }

    public void fire() {
        switch (direction) {
            // Up
            case 0:
                Hero.heroFires.add(fire = new Fire(x + 20, y, direction, 0));
                break;
            // Right
            case 1:
                Hero.heroFires.add(fire = new Fire(x + 60, y + 20, direction, 0));
                break;
            // Down
            case 2:
                Hero.heroFires.add(fire = new Fire(x + 20, y + 60, direction, 0));
                break;
            // Left
            case 3:
                Hero.heroFires.add(fire = new Fire(x, y + 20, direction, 0));
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
