package TankFire;

public class Tank {
    protected int x, y, direction, spead = 1;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, int spead) {
        this(x, y);
        this.spead = spead;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpead() {
        return spead;
    }

    public void setSpead(int spead) {
        this.spead = spead;
    }

    public void moveUp() {
        y -= spead;
    }

    public void moveLeft() {
        x -= spead;
    }

    public void moveDown() {
        y += spead;
    }

    public void moveRight() {
        x += spead;
    }

}
