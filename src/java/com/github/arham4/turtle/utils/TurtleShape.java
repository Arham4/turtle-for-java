package com.github.arham4.turtle.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public enum TurtleShape {
    CLASSIC("classic", new File("classic.png")),
    TURTLE("turtle", new File("classic.png")), // todo add image to project
    ARROW("arrow", new File("classic.png")), // todo add image to project
    CIRCLE("circle", new File("classic.png")), // todo add image to project
    ;

    public static final Map<String, BufferedImage> SHAPE_FOR_NAME;

    static {
        SHAPE_FOR_NAME = new HashMap<>();
        for (TurtleShape turtleShape : values()) {
            SHAPE_FOR_NAME.put(turtleShape.name, turtleShape.shape);
        }
    }

    private final String name;
    private final BufferedImage shape;

    TurtleShape(String name, File shapeLocation) {
        BufferedImage shapeBufferedImageAttempt;
        this.name = name;
        try {
            shapeBufferedImageAttempt = ImageIO.read(shapeLocation);
        } catch (IOException e) {
            e.printStackTrace();
            shapeBufferedImageAttempt = null;
        }
        shape = shapeBufferedImageAttempt;
    }

    public BufferedImage getShape() {
        return shape;
    }

    public String getName() {
        return name;
    }
}
