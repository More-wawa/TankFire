package TankFire;

public class Movement {
    protected int x, y, direction, speed;

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Movement(int x, int y, int direction) {
        this(x, y);
        this.direction = direction;
    }

    public static boolean isMoveable(int x, int y, int direction, int speed) {
        switch (direction) {
            // Up
            case 0:
                if (y - speed >= 0)
                    return true;
                break;
            // Right
            case 1:
                if (x + 60 + speed <= 1000)
                    return true;
                break;
            // Down
            case 2:
                if (y + 60 + speed <= 750)
                    return true;
                break;
            // Left
            case 3:
                if (x - speed >= 0)
                    return true;
                break;
        }
        return false;
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
