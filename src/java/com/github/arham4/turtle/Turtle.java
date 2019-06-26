package com.github.arham4.turtle;

import javax.imageio.ImageIO;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A {@code Turtle} entity. A turtle is essentially a character that can be manipulated to perform actions on a screen,
 * such as movement and changes in its appearance.
 */
public final class Turtle {
    private Screen screen;
    private BufferedImage shape;
    private double x;
    private double y;
    private double angle;
    private double speed;

    /**
     * Creates a turtle.
     */
    public Turtle() {
        shape("classic.png");
        speed = 3;
    }

    public void shape(String name) {
        try {
            shape = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes a turtle go to a certain coordinate point.
     *
     * @param x The x-coordinate for the turtle to go to.
     * @param y THe y-coordinate for the turtle to go to.
     */
    public void goTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Makes a turtle move forward with respect to its current angle that it is facing.
     *
     * @param amount The distance for the turtle to move. This number is taken and then multiplied with the cosine
     *               of the angle at which the turtle is currently facing for the x distance and done the same
     *               for the y-position, using sine instead.
     */
    public void forward(double amount) {
        double endX = x + (Math.cos(Math.toRadians(angle)) * amount);
        double endY = y + (Math.sin(Math.toRadians(angle)) * amount);
        if (screen != null) {
            Line line = new Line(x, y, endX, endY);
            drawLine(line);
        }
        x = endX;
        y = endY;
    }

    /**
     * Incrementally draws a line path. A given line is split by its speed value with respect to a given angle
     * and then drawn piece by piece to have an end result of the complete line.
     *
     * @implNote This method performs synchronously.
     */
    private void drawLine(Line line) {
        double xStart = line.getX1();
        double yStart = line.getY1();
        double xSpeed = speed * Math.cos(Math.toRadians(angle));
        double ySpeed = speed * Math.sin(Math.toRadians(angle));
        while ((line.getX1() == line.getX2() || xStart != line.getX2()) && (line.getY1() == line.getY2() || yStart != line.getY2())) {
            double nextX = getNextCoordinate(xStart, xSpeed, line.getX2());
            double nextY = getNextCoordinate(yStart, ySpeed, line.getY2());
            Line2D.Double smallLine = new Line2D.Double(xStart, yStart, nextX, nextY);
            screen.addShape(smallLine);
            xStart = nextX;
            yStart = nextY;
            x = nextX;
            y = nextY;
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

    /**
     * Turns a turtle right.
     *
     * @param angle The angle at which to turn the turtle.
     */
    public void right(double angle) {
        changeAngle(-angle);
    }

    /**
     * Turns a turtle left.
     *
     * @param angle The angle at which to turn the turtle.
     */
    public void left(double angle) {
        changeAngle(angle);
    }

    /**
     * Sets the speed value to a new speed.
     *
     * @param speed The new speed at which to draw with the turtle.
     * @implSpec The default value of the turtle's speed is 3.
     */
    public void speed(double speed) {
        this.speed = speed;
    }

    /**
     * Changes the angle the turlte is facing. This method ensures the angle remains in the range [0, 360).
     *
     * @param angle The angle at which the current angle is being modified.
     */
    private void changeAngle(double angle) {
        double newAmount = this.angle + angle;
        if (newAmount < 0) {
            this.angle = 360 - (Math.abs(angle) - this.angle);
        } else if (newAmount >= 360) {
            this.angle = (this.angle + Math.abs(angle)) - 360;
        } else {
            this.angle += angle;
        }
    }

    public BufferedImage getShape() {
        return shape;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void setScreen(Screen screen) {
        this.screen = screen;
    }

    public double getAngle() {
        return angle;
    }
}
