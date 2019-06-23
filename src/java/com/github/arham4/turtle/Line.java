package com.github.arham4.turtle;

import java.awt.geom.Line2D;

/**
 * A complete line path, which is then incrementally drawn using {@link Line#draw(Screen, double, double)}.
 */
public final class Line {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    /**
     * A complete line path.
     *
     * @param x1 The starting x-coordinate.
     * @param y1 The starting y-coordinate.
     * @param x2 The ending x-coordinate of the complete line path.
     * @param y2 The ending y-coordinate of the complete line path.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Incrementally draws a line path. A given line is split by its speed value with respect to a given angle
     * and then drawn piece by piece to have an end result of the complete line.
     *
     * @param screen The screen to draw the given line to.
     * @param speed  The speed at which to draw the line.
     * @param angle  The angle at which respect the line is being drawn at.
     * @implNote This method performs synchronously.
     */
    public void draw(Screen screen, double speed, double angle) {
        double xStart = x1;
        double yStart = y1;
        double xSpeed = speed * Math.cos(Math.toRadians(angle));
        double ySpeed = speed * Math.sin(Math.toRadians(angle));
        while ((x1 == x2 || xStart != x2) && (y1 == y2 || yStart != y2)) {
            double nextX = getNextCoordinate(xStart, xSpeed, x2);
            double nextY = getNextCoordinate(yStart, ySpeed, y2);
            Line2D.Double line = new Line2D.Double(xStart, yStart, nextX, nextY);
            screen.addShape(line);
            xStart = nextX;
            yStart = nextY;
        }
    }

    private double getNextCoordinate(double current, double incrementation, double capacity) {
        if (incrementation < 0) {
            if (incrementation + current < capacity) {
                return capacity;
            }
        } else {
            if (incrementation + current > capacity) {
                return capacity;
            }
        }
        return current + incrementation;
    }
}
