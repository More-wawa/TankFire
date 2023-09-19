package TankFire;

import javax.swing.JFrame;

public class TankGame extends JFrame{
    public TankGame() {
        MyPanel mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

    public static void main(String[] args) {
        new TankGame();
    }
}
