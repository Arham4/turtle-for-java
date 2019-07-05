package com.github.arham4.turtle;

import com.github.arham4.turtle.utils.TurtleColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A {@code Turtle} entity. A turtle is essentially a character that can be manipulated to perform actions on a screen,
 * such as movement and changes in its appearance.
 */
public final class Turtle {
    private Screen screen;
    private Color color;
    private BufferedImage shape;
    private double x;
    private double y;
    private double angle;
    private double speed;
    private List<TurtleShape> lines;

    /**
     * Creates a turtle.
     */
    public Turtle() {
        shape("classic.png");
        speed = 3;
        lines = new ArrayList<>();
    }

    /**
     * Changes the shape of the turtle. Shapes are not required to use an <em>addShape</em> function.
     *
     * @param name The complete name of the "shape," including its file extension.
     */
    public void shape(String name) {
        try {
            shape = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the color of the turtle and the line it draws using the name of the color. A full list of colors can
     * be found at {@link TurtleColor}.
     *
     * @param name The name of the color.
     * @see TurtleColor
     */
    public void color(String name) {
        color(TurtleColor.COLOR_FOR_NAME.get(name.toLowerCase()));
    }

    /**
     * Sets the color of the turtle and the line it draws using the name of the color. A full list of colors can
     * be found at {@link TurtleColor}.
     *
     * @param color The {@link TurtleColor} to set it to.
     * @see TurtleColor
     */
    public void color(TurtleColor color) {
        color(color.getColor());
    }

    /**
     * Sets the color of the turtle and the line it draws.
     *
     * @param color The new {@link Color} to set the turtle and line colors to.
     */
    public void color(Color color) {
        this.color = color;
        int width = shape.getWidth();
        int height = shape.getHeight();
        for (int column = 0; column < height; column++) {
            for (int row = 0; row < width; row++) {
                int rgb = shape.getRGB(row, column);
                if (rgb == 0) {
                    continue;
                }
                shape.setRGB(row, column, color.getRGB());
            }
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
        while ((line.getX1() == line.getX2() || xStart != line.getX2())
                && (line.getY1() == line.getY2() || yStart != line.getY2())) {
            double nextX = getNextNumberWithoutOverflow(xStart, xSpeed, line.getX2());
            double nextY = getNextNumberWithoutOverflow(yStart, ySpeed, line.getY2());
            Line2D.Double smallLine = new Line2D.Double(xStart, yStart, nextX, nextY);
            lines.add(new TurtleShape(smallLine, color));
            screen.refreshFrame();
            xStart = nextX;
            yStart = nextY;
            x = nextX;
            y = nextY;
        }
    }

    private void drawTurn(double finalAngle, boolean left) {
        while (angle != finalAngle) {
            angle = getNextAngleWithoutOverflow(angle, (left ? 1.5 : -1.5) * 1.5, finalAngle);
            screen.refreshFrame();
        }
    }

    private double getNextAngleWithoutOverflow(double current, double incrementation, double capacity) {
        double angle = current + incrementation;
        if (incrementation > 0) {
            if (angle > capacity) {
                return capacity;
            }
        } else {
            if (angle < capacity) {
                return capacity;
            }
        }
        return angle;
    }

    private double getNextNumberWithoutOverflow(double current, double incrementation, double capacity) {
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
        drawTurn(this.angle - angle, false);
    }

    /**
     * Turns a turtle left.
     *
     * @param angle The angle at which to turn the turtle.
     */
    public void left(double angle) {
        drawTurn(this.angle + angle, true);
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
     * Changes the angle the turtle is facing. This method ensures the angle remains in the range [0, 360).
     *
     * @param angle    The current angle.
     * @param addition The angle at which the current angle is being modified.
     * @apiNote Currently, this method is not being employed due to mathematical errors in incremental turning.
     */
    private double getProperAngle(double angle, double addition) {
        double newAmount = angle + addition;
        if (newAmount < 0) {
            return 360 - Math.abs(addition) - angle;
        } else if (newAmount >= 360) {
            return angle + Math.abs(addition) - 360;
        } else {
            return newAmount;
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

    public Color getColor() {
        return color;
    }

    public List<TurtleShape> getLines() {
        return lines;
    }
}
