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
    private int enemyTankCount = 3;
    private EnemyTank enemyTank;
    private Fire fire;

    public MyPanel() {
        // 初始化主角
        hero = Hero.getHero();
        // 初始化敌人坦克
        for (int i = 1; i <= enemyTankCount; i++) {
            enemyTanks.add(enemyTank = new EnemyTank(100 * i, 0, (int) (Math.random() * 4)));
            new Thread(enemyTank).start();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 主角移动
        switch (e.getKeyCode()) {
            // Up
            case KeyEvent.VK_W:
                if (Movement.isMoveable(hero.getX(), hero.getY(), 0, hero.getSpeed())) {
                    hero.setDirection(0);
                    hero.moveUp(hero.getSpeed());
                }
                break;
            // Right
            case KeyEvent.VK_D:
                if (Movement.isMoveable(hero.getX(), hero.getY(), 1, hero.getSpeed())) {
                    hero.setDirection(1);
                    hero.moveRight(hero.getSpeed());
                }
                break;
            // Down
            case KeyEvent.VK_S:
                if (Movement.isMoveable(hero.getX(), hero.getY(), 2, hero.getSpeed())) {
                    hero.setDirection(2);
                    hero.moveDown(hero.getSpeed());
                }
                break;
            // Left
            case KeyEvent.VK_A:
                if (Movement.isMoveable(hero.getX(), hero.getY(), 3, hero.getSpeed())) {
                    hero.setDirection(3);
                    hero.moveLeft(hero.getSpeed());
                }
                break;
            // Hero fire
            case KeyEvent.VK_J:
                if (Hero.fires.size() < 5)
                    hero.heroFire();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // 绘制坦克
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

    // 绘制子弹
    public void drawFire(int x, int y, Graphics g, int type) {
        if (type == 0) {
            g.setColor(Color.cyan);
        } else {
            g.setColor(Color.yellow);
        }
        g.fillOval(x, y, 5, 5);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 绘制背景色
        g.fillRect(0, 0, 1000, 750);

        // 绘制主角
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        // 绘制敌人坦克
        for (int iEnemy = 0; iEnemy < enemyTanks.size(); iEnemy++) {
            enemyTank = enemyTanks.get(iEnemy);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
        }

        // 绘制主角子弹
        for (int iHeroFire = 0; iHeroFire < Hero.fires.size(); iHeroFire++) {
            fire = Hero.fires.get(iHeroFire);
            drawFire(fire.getX(), fire.getY(), g, 0);
        }

        // 绘制敌人坦克子弹
        for (int iEnemy = 0; iEnemy < enemyTanks.size(); iEnemy++) {
            enemyTank = enemyTanks.get(iEnemy);
            for (int iEnemyFire = 0; iEnemyFire < enemyTank.getFires().size(); iEnemyFire++) {
                fire = enemyTank.getFires().get(iEnemyFire);
                drawFire(fire.getX(), fire.getY(), g, 1);
            }
        }
    }

    @Override
    public void run() {
        while (hero.isLive() && enemyTanks.size() > 0) {
            // 主角子弹
            for (int iHeroFire = Hero.fires.size() - 1; iHeroFire >= 0; iHeroFire--) {
                fire = Hero.fires.get(iHeroFire);
                // 主角子弹是否超出边界
                if (fire.getX() < 0 || fire.getX() > 1000 || fire.getY() < 0 || fire.getY() > 750) {
                    Hero.fires.remove(iHeroFire);
                } else {
                    // 主角子弹是否击中敌人
                    for (int iEnemy = enemyTanks.size() - 1; iEnemy >= 0; iEnemy--) {
                        if (Fire.isHitTank(fire, enemyTanks.get(iEnemy))) {
                            Hero.fires.remove(iHeroFire);
                            enemyTanks.remove(iEnemy);
                        }
                    }
                }
            }

            // 敌人子弹
            for (int iEnemy = 0; iEnemy < enemyTanks.size(); iEnemy++) {
                enemyTank = enemyTanks.get(iEnemy);
                for (int i = enemyTank.getFires().size() - 1; i >= 0; i--) {
                    fire = enemyTank.getFires().get(i);
                    // 敌人子弹是否超出边界
                    if (fire.getX() < 0 || fire.getX() > 1000 || fire.getY() < 0 || fire.getY() > 750) {
                        enemyTank.getFires().remove(i);
                    } else {
                        // 敌人子弹是否击中主角
                        if (Fire.isHitTank(fire, hero)) {
                            System.out.println("GG");
                            hero.isLive = false;
                        }
                    }
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

}
