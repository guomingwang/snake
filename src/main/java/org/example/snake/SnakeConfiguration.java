package org.example.snake;

import javax.swing.*;

/**
 * @author wgm
 * @since 2021/9/25
 */
public class SnakeConfiguration {

    public static int pixelLength = 25;
    public static int widthMultiple = 40;
    public static int heightMultiple = 30;
    public static SnakeCoordinate[][] matrix = new SnakeCoordinate[widthMultiple][heightMultiple];
    public static int delay = 100;
    public static ImageIcon body = new ImageIcon(SnakeConfiguration.class.getResource("/body.png"));
    public static ImageIcon food = new ImageIcon(SnakeConfiguration.class.getResource("/food.png"));

    static {
        for (int x = 0; x < widthMultiple; x++) {
            for (int y = 0; y < heightMultiple; y++) {
                matrix[x][y] = new SnakeCoordinate(x, y);
            }
        }
    }

    public static int getWidth() {
        return pixelLength * widthMultiple;
    }

    public static int getHeight() {
        return pixelLength * heightMultiple;
    }
}
