package org.example.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author wgm
 * @since 2021/9/26
 */
public class SnakePanel extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(SnakeConfiguration.delay, this);

    public SnakePanel() {
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SnakeConfiguration.getWidth(), SnakeConfiguration.getHeight());

        for (int i = 0; i < Snake.getInstance().getBody().size(); i++) {
            SnakeCoordinate snakeCoordinate = Snake.getInstance().getBody().get(i);
            SnakeConfiguration.body.paintIcon(this, g,
                    SnakeConfiguration.pixelLength * snakeCoordinate.getX(),
                    SnakeConfiguration.pixelLength * snakeCoordinate.getY()
            );
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (Snake.PLAYING == Snake.getInstance().getStatus()) {
            if (Snake.UP == Snake.getInstance().getDirection()) {
                Snake.getInstance().moveUp();
            } else if (Snake.DOWN == Snake.getInstance().getDirection()) {
                Snake.getInstance().moveDown();
            } else if (Snake.LEFT == Snake.getInstance().getDirection()) {
                Snake.getInstance().moveLeft();
            } else if (Snake.RIGHT == Snake.getInstance().getDirection()) {
                Snake.getInstance().moveRight();
            }
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (Snake.getInstance().getStatus().equals(Snake.PLAYING)) {
                Snake.getInstance().setStatus(Snake.PAUSED);
            } else {
                Snake.getInstance().setStatus(Snake.PLAYING);
            }
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
