package org.example.snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author wgm
 * @since 2021/9/25
 */
public class SnakeApplication {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("SNAKE");
        jFrame.setBounds(new Rectangle(SnakeConfiguration.getWidth(), SnakeConfiguration.getHeight()));
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new SnakePanel());
        jFrame.setVisible(true);
    }
}
