package TankFire;

public class Movement {
    protected int x, y, direction, speed = 2;

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(int speed) {
        y -= speed;
    }

    public void moveRight(int speed) {
        x += speed;
    }

    public void moveDown(int speed) {
        y += speed;
    }

    public void moveLeft(int speed) {
        x -= speed;
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
