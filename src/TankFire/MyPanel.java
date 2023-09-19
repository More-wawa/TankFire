package TankFire;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements Runnable, KeyListener {
    /*
     * @param x 坦克左上角x坐标
     * 
     * @param y 坦克左上角y坐标
     * 
     * @param g 画笔
     * 
     * @param direction 当前坦克的朝向
     * 
     * @param type 坦克的类型
     */
    private Hero hero;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private int EnemyTankCount = 3;

    public MyPanel() {
        hero = new Hero(100, 100, 0);
        for (int i = 1; i <= EnemyTankCount; i++) {
            enemyTanks.add(new EnemyTank(100 * i, 0, 2));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 输入选择
        switch (e.getKeyCode()) {
            // Up
            case KeyEvent.VK_W:
                hero.setDirection(0);
                hero.moveUp(hero.getSpeed());
                break;
            // Right
            case KeyEvent.VK_D:
                hero.setDirection(1);
                hero.moveRight(hero.getSpeed());
                break;
            // Down
            case KeyEvent.VK_S:
                hero.setDirection(2);
                hero.moveDown(hero.getSpeed());
                break;
            // Left
            case KeyEvent.VK_A:
                hero.setDirection(3);
                hero.moveLeft(hero.getSpeed());
                break;
            // Fire
            case KeyEvent.VK_J:
                hero.fireEnemyTank();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 绘制背景色
        g.fillRect(0, 0, 1000, 750);

        // 绘制主角
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        // 绘制敌人坦克
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
        }

        // 绘制主角子弹
        if (hero.fire != null && hero.fire.getIsLive()) {
            drawFire(hero.fire.getX(), hero.fire.getY(), g, 0);
            System.out.println(hero.fire.getX());
        }
    }

    // 绘制坦克
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        if (type == 0) {
            g.setColor(Color.cyan);
        } else {
            g.setColor(Color.yellow);
        }

        switch (direction) {
            // up
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            // right
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            // down
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            // left
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    public void drawFire(int x, int y, Graphics g, int type) {
        if (type == 0) {
            g.setColor(Color.cyan);
        } else {
            g.setColor(Color.yellow);
        }
        g.fillOval(x, y, 5, 5);
    }

    // 刷新界面
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

}
