package TankFire;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
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
     */
    private Hero hero;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private int EnemyTankCount = 3;

    public MyPanel() {
        // 初始化主角
        hero = new Hero(100, 100, 0);
        // 初始化敌人坦克
        for (int i = 1; i <= EnemyTankCount; i++) {
            enemyTanks.add(new EnemyTank(100 * i, 0, 2));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 主角移动
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
            // Hero fire
            case KeyEvent.VK_J:
                hero.fire();
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

        // 绘制主角子弹
        Fire fire;
        for (int iHeroFire = Hero.heroFires.size() - 1; iHeroFire >= 0; iHeroFire--) {
            fire = Hero.heroFires.get(iHeroFire);
            // 判断子弹是否击中敌人坦克
            for (int iEnemyTank = enemyTanks.size() - 1; iEnemyTank >= 0; iEnemyTank--) {
                if (isHitTank(fire, enemyTanks.get(iEnemyTank))) {
                    Hero.heroFires.remove(iHeroFire);
                    enemyTanks.remove(iEnemyTank);
                }
            }
            if (fire.isLive()) {
                drawFire(fire.getX(), fire.getY(), g, 0);
            }
        }

        // 绘制敌人坦克子弹
        for (EnemyTank enemyTank : enemyTanks) {
            for (int i = enemyTank.getEnemyFires().size() - 1; i >= 0; i--) {
                fire = enemyTank.getEnemyFires().get(i);
                if (isHitTank(fire, hero)) {
                    System.out.println("GG");
                    return;
                }
                drawFire(fire.getX(), fire.getY(), g, 1);
            }
        }

        // 绘制主角
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        // 绘制敌人坦克
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
        }
    }

    // 绘制坦克
    /*
     * @param type 坦克的类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        if (type == 0) {
            g.setColor(Color.cyan);
        } else {
            g.setColor(Color.yellow);
        }

        switch (direction) {
            // Up
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            // Right
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            // Down
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            // Left
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

    // 子弹是否击中坦克
    public static boolean isHitTank(Fire fire, Tank tank) {
        int xFire = fire.getX(), yFire = fire.getY(), xTank = tank.getX(), yTank = tank.getY();
        if (xFire >= xTank && xFire <= xTank + 40 && yFire >= yTank && yFire <= yTank + 60) {
            fire.setLive(false);
            return true;
        }
        return false;
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
