package TankFire;

public class Hero extends Tank{
    public Hero(int x, int y, int direction) {
        super(x, y, direction, direction);
    }

    public Hero(int x, int y, int direction, int spead) {
        super(x, y, direction, spead);
    }
}
