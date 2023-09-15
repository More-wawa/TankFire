package TankFire;

import javax.swing.JFrame;

public class TankGame02 extends JFrame{
    public TankGame02() {
        MyPanel mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

    public static void main(String[] args) {
        new TankGame02();
    }
}
