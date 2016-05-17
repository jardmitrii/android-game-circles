package com.example.djar.rgbcircles;

import android.graphics.Color;

/**
 * Created by djar on 15/02/16.
 */
public class MainCircle extends SimpleCircle {
    public static final int INT_RADIUS = 50;
    public static final int INT_MAIN_SPEED = 50;
    public static final int OUR_COLOR = Color.BLUE;

    public MainCircle(int x, int y) {
        super(x, y, INT_RADIUS);
        setColor(OUR_COLOR);
    }

    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 -x) * INT_MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 -y) * INT_MAIN_SPEED / GameManager.getHeight();
        this.x += dx;
        this.y += dy;
    }

    public void resetRadius() {
        radius = INT_RADIUS;
    }

    public void growRadius(EnemyCircle circle) {
        // pi * newr^2 == pi * r^2 + pi *eatr^2
        // newr = sqrt(r^2 + eatr^2)
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));
    }
}