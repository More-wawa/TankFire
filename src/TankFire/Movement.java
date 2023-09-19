package TankFire;

public class Movement {
    protected int x, y;

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(int spead) {
        y -= spead;
    }

    public void moveRight(int spead) {
        x += spead;
    }

    public void moveDown(int spead) {
        y += spead;
    }

    public void moveLeft(int spead) {
        x -= spead;
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

}
