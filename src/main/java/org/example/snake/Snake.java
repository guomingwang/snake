package org.example.snake;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;

/**
 * @author wgm
 * @since 2021/9/26
 */
@Data
@Accessors(chain = true)
public class Snake {

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public static final int NOT_STARTED = 1;
    public static final int PLAYING = 2;
    public static final int PAUSED = 3;
    public static final int FAILED = 4;
    public static final int VICTORY = 5;

    public static Snake snake;

    private LinkedList<SnakeCoordinate> body;
    private Integer direction;
    private Integer status;

    private Snake() {
        SnakeCoordinate snakeCoordinate = SnakeConfiguration.matrix[0][0];
        body = new LinkedList<SnakeCoordinate>();
        body.add(snakeCoordinate);
        direction = RIGHT;
        status = NOT_STARTED;
    }

    public static Snake getInstance() {
        if (snake == null) {
            snake = new Snake();
        }
        return snake;
    }

    public void moveUp() {
        int y = body.getFirst().getY() - 1;
        if (y < 0) {
            y = SnakeConfiguration.heightMultiple - 1;
        }
        SnakeCoordinate newHead = SnakeConfiguration.matrix[body.getFirst().getX()][y];
        body.addFirst(newHead);
        body.removeLast();
    }

    public void moveDown() {
        int y = body.getFirst().getY() + 1;
        if (y >= SnakeConfiguration.heightMultiple) {
            y = 0;
        }
        SnakeCoordinate newHead = SnakeConfiguration.matrix[body.getFirst().getX()][y];
        body.addFirst(newHead);
        body.removeLast();
    }

    public void moveLeft() {
        int x = body.getFirst().getX() - 1;
        if (x < 0) {
            x = SnakeConfiguration.widthMultiple - 1;
        }
        SnakeCoordinate newHead = SnakeConfiguration.matrix[x][body.getFirst().getY()];
        body.addFirst(newHead);
        body.removeLast();
    }

    public void moveRight() {
        int x = body.getFirst().getX() + 1;
        if (x >= SnakeConfiguration.widthMultiple) {
            x = 0;
        }
        SnakeCoordinate newHead = SnakeConfiguration.matrix[x][body.getFirst().getY()];
        body.addFirst(newHead);
        body.removeLast();
    }
}
