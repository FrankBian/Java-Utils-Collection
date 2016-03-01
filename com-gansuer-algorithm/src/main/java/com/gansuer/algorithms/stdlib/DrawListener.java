package com.gansuer.algorithms.stdlib;

public interface DrawListener {
    void mousePressed(double x, double y);
    void mouseDragged(double x, double y);
    void mouseReleased(double x, double y);
    void keyTyped(char c);
}
