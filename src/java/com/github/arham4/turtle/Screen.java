package com.github.arham4.turtle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Screen} to display all entities on. Without a screen, a Turtle program cannot exist. Thus, it is essential
 * to make a screen at the beginning of every Turtle program.
 */
public final class Screen extends JPanel {

    private int width = 200;
    private int height = 200;
    private final List<Shape> shapeList = new ArrayList<>();
    private final List<Turtle> turtleList = new ArrayList<>();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(width / 2, height / 2);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.scale(1, -1);
        for (Turtle turtle : turtleList) {
            BufferedImage shape = turtle.getShape();
            double angle = Math.toRadians(turtle.getAngle());
            AffineTransform trans = (AffineTransform) graphics2D.getTransform().clone();
            // - - = right
            // + - = up
            // + + = left
            // - + = down
//            trans.setToTranslation(turtle.getX() - (shape.getWidth() / 2.0),
//                    turtle.getY() + (shape.getHeight() / 2.0));
            trans.setToTranslation(turtle.getX() - (Math.cos(angle) * (shape.getWidth() / 2.0) - ((shape.getHeight() / 2.0) * Math.sin(angle))),
                    turtle.getY() - (Math.sin(angle) * (shape.getHeight() / 2.0)) - ((shape.getWidth() / 2.0) * Math.cos(angle)));
            trans.rotate(angle);
            graphics2D.drawImage(shape, trans, this);
        }
        for (Shape shape : shapeList) {
            graphics2D.draw(shape);
        }
    }

    /**
     * Sets up the Graphical User Interface to make a canvas in which entities are displayed.
     *
     * @param width  The width of the display screen.
     * @param height The height of the display screen.
     * @apiNote This method is overloaded.
     * @see Screen#setup(String, int, int)
     */
    public void setup(int width, int height) {
        setup("Turtle", width, height);
    }

    /**
     * Sets up the Graphical User Interface to make a canvas in which entities are displayed.
     *
     * @param title  The title of the Graphic User Interface window.
     * @param width  The width of the display screen.
     * @param height The height of the display screen.
     * @apiNote This method is overloaded.
     * @see Screen#setup(int, int)
     */
    public void setup(String title, int width, int height) {
        this.width = width;
        this.height = height;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setTitle(title);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Adds a shape synchronously to the screen. Once a shape is added, the drawing thread sleeps for 10 milliseconds
     * and proceeds to redraw the screen.
     *
     * @param shape The shape to add to the screen.
     */
    public void addShape(Shape shape) {
        shapeList.add(shape);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void addTurtle(Turtle turtle) {
        turtleList.add(turtle);
        turtle.setScreen(this);
    }
}
