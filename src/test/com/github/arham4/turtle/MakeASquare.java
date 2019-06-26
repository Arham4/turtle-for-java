package com.github.arham4.turtle;

import java.awt.*;

/**
 * A sample application that makes a turtle make a square.
 */
public final class MakeASquare {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setup(400, 400);

        Turtle turtle = new Turtle();
        screen.addTurtle(turtle);
        turtle.color(new Color(37, 35, 79));
        for (int i = 0; i < 4; i++) {
            turtle.forward(100);
            turtle.left(90);
        }
    }
}
