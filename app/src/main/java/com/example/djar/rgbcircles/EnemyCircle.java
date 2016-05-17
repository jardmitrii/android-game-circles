package com.example.djar.rgbcircles;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by djar on 18/02/16.
 */
public class EnemyCircle extends SimpleCircle {

    public static final int INT_MIN_RADIUS = 10;
    public static final int INT_MAX_RADIUS = 100;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = INT_MIN_RADIUS + random.nextInt(INT_MAX_RADIUS - INT_MIN_RADIUS);
        EnemyCircle circle = new EnemyCircle(x, y, radius, dx, dy);
        return circle;
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThen(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    public boolean isSmallerThen(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if ( x >= GameManager.getWidth() || x < 0 ){
            dx *= -1;
        }

        if ( y >= GameManager.getWidth() || y < 0 ){
            dy *= -1;
        }
    }
}
