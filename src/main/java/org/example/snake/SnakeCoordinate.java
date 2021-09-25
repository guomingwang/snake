package org.example.snake;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wgm
 * @since 2021/9/26
 */
@Data
@Accessors(chain = true)
public class SnakeCoordinate {

    private Integer x;
    private Integer y;

    public SnakeCoordinate() {
    }

    public SnakeCoordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
