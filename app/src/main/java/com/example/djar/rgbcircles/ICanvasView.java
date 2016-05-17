package com.example.djar.rgbcircles;

/**
 * Created by djar on 15/02/16.
 */
public interface ICanvasView {
    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}
