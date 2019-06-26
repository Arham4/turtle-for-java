package com.github.arham4.turtle.utils;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A color from the Python turtle library. A full list of colors can be seen
 * <a href="https://trinket.io/docs/colors">here</a>.
 */
public enum TurtleColor {

    WHITE("white", new Color(255, 255, 255)),
    WHITE_SMOKE("white smoke", new Color(245, 245, 245)),
    GAINSBORO("gainsboro", new Color(220, 220, 220)),
    LIGHT_GRAY("light gray", new Color(211, 211, 211)),
    SILVER("silver", new Color(192, 192, 192)),
    DARK_GRAY("dark gray", new Color(169, 169, 169)),
    GRAY("gray", new Color(128, 128, 128)),
    DIM_GRAY("dim gray", new Color(105, 105, 105)),
    BLACK("black", new Color(0, 0, 0)),
    LIGHT_SLATE_GRAY("light slate gray", new Color(119, 136, 153)),
    SLATE_GRAY("slate gray", new Color(112, 128, 144)),
    ALICE_BLUE("alice blue", new Color(240, 248, 255)),
    LIGHT_STEEL_BLUE("light steel blue", new Color(176, 196, 222)),
    CORNFLOWER_BLUE("cornflower blue", new Color(100, 149, 237)),
    ROYAL_BLUE("royal blue", new Color(65, 105, 225)),
    BLUE("blue", new Color(0, 0, 255)),
    MEDIUM_BLUE("medium blue", new Color(0, 0, 205)),
    NAVY("navy", new Color(0, 0, 128)),
    DARK_BLUE("dark blue", new Color(0, 0, 139)),
    MIDNIGHT_BLUE("midnight blue", new Color(25, 25, 112)),
    LIGHT_BLUE("light blue", new Color(173, 216, 230)),
    DEEP_SKY_BLUE("deep sky blue", new Color(0, 191, 255)),
    DODGER_BLUE("dodger blue", new Color(30, 144, 255)),
    POWDER_BLUE("powder blue", new Color(176, 224, 230)),
    SKY_BLUE("sky blue", new Color(135, 206, 235)),
    LIGHT_SKY_BLUE("light sky blue", new Color(135, 206, 250)),
    STEEL_BLUE("steel blue", new Color(70, 130, 180)),
    AZURE("azure", new Color(240, 255, 255)),
    LIGHT_CYAN("light cyan", new Color(224, 255, 255)),
    CYAN("cyan", new Color(0, 255, 255)),
    PALE_TURQUOISE("pale turquoise", new Color(175, 238, 238)),
    DARK_TURQUOISE("dark turquoise", new Color(0, 206, 209)),
    TURQUOISE("turquoise", new Color(64, 224, 208)),
    MEDIUM_TURQUOISE("medium turquoise", new Color(72, 209, 204)),
    LIGHT_SEA_GREEN("light sea green", new Color(32, 178, 170)),
    CADET_BLUE("cadet blue", new Color(95, 158, 160)),
    DARK_CYAN("dark cyan", new Color(0, 139, 139)),
    TEAL("teal", new Color(0, 128, 128)),
    DARK_SLATE_GRAY("dark slate gray", new Color(47, 79, 79)),
    MINT_CREAM("mint cream", new Color(245, 255, 250)),
    AQUAMARINE("aquamarine", new Color(127, 255, 212)),
    MEDIUM_AQUAMARINE("medium aquamarine", new Color(102, 205, 170)),
    DARK_SEA_GREEN("dark sea green", new Color(143, 188, 143)),
    MEDIUM_SEA_GREEN("medium sea green", new Color(60, 179, 113)),
    SEA_GREEN("sea green", new Color(46, 139, 87)),
    HONEYDEW("honeydew", new Color(240, 255, 240)),
    PALE_GREEN("pale green", new Color(152, 251, 152)),
    LIGHT_GREEN("light green", new Color(144, 238, 144)),
    MEDIUM_SPRING_GREEN("medium spring green", new Color(0, 250, 154)),
    SPRING_GREEN("spring green", new Color(0, 255, 127)),
    LIME_GREEN("lime green", new Color(50, 205, 50)),
    GREEN("green", new Color(0, 128, 0)),
    FOREST_GREEN("forest green", new Color(34, 139, 34)),
    DARK_GREEN("dark green", new Color(0, 100, 0)),
    GREEN_YELLOW("green yellow", new Color(173, 255, 47)),
    CHARTREUSE("chartreuse", new Color(127, 255, 0)),
    LAWN_GREEN("lawn green", new Color(124, 252, 0)),
    LIME("lime", new Color(0, 255, 0)),
    YELLOW_GREEN("yellow green", new Color(154, 205, 50)),
    OLIVE_DRAB("olive drab", new Color(107, 142, 35)),
    BEIGE("beige", new Color(245, 245, 220)),
    DARK_KHAKI("dark khaki", new Color(189, 183, 107)),
    OLIVE("olive", new Color(128, 128, 0)),
    DARK_OLIVE_GREEN("dark olive green", new Color(85, 107, 47)),
    PALE_GOLDENROD("pale goldenrod", new Color(238, 232, 170)),
    KHAKI("khaki", new Color(240, 230, 140)),
    IVORY("ivory", new Color(255, 255, 240)),
    LIGHT_YELLOW("light yellow", new Color(255, 255, 224)),
    LIGHT_GOLDENROD_YELLOW("light goldenrod yellow", new Color(250, 250, 210)),
    CORNSILK("cornsilk", new Color(255, 248, 220)),
    LEMON_CHIFFON("lemon chiffon", new Color(255, 250, 205)),
    YELLOW("yellow", new Color(255, 255, 0)),
    GOLD("gold", new Color(255, 215, 0)),
    GOLDENROD("goldenrod", new Color(218, 165, 32)),
    DARK_GOLDENROD("dark goldenrod", new Color(184, 134, 11)),
    WHEAT("wheat", new Color(245, 222, 179)),
    TAN("tan", new Color(210, 180, 140)),
    BURLYWOOD("burlywood", new Color(222, 184, 135)),
    PERU("peru", new Color(205, 133, 63)),
    SIENNA("sienna", new Color(160, 82, 45)),
    SADDLE_BROWN("saddle brown", new Color(139, 69, 19)),
    FLORAL_WHITE("floral white", new Color(255, 250, 240)),
    OLD_LACE("old lace", new Color(253, 245, 230)),
    NAVAJO_WHITE("navajo white", new Color(255, 222, 173)),
    MOCCASIN("moccasin", new Color(255, 228, 181)),
    SANDY_BROWN("sandy brown", new Color(244, 164, 96)),
    ORANGE("orange", new Color(255, 165, 0)),
    DARK_ORANGE("dark orange", new Color(255, 140, 0)),
    CHOCOLATE("chocolate", new Color(210, 105, 30)),
    FIREBRICK("firebrick", new Color(178, 34, 34)),
    BROWN("brown", new Color(165, 42, 42)),
    DARK_RED("dark red", new Color(139, 0, 0)),
    MAROON("maroon", new Color(128, 0, 0)),
    ANTIQUE_WHITE("antique white", new Color(250, 235, 215)),
    PAPAYA_WHIP("papaya whip", new Color(255, 239, 213)),
    BLANCHED_ALMOND("blanched almond", new Color(255, 235, 205)),
    BISQUE("bisque", new Color(255, 228, 196)),
    PEACH_PUFF("peach puff", new Color(255, 218, 185)),
    LIGHT_SALMON("light salmon", new Color(255, 160, 122)),
    CORAL("coral", new Color(255, 127, 80)),
    TOMATO("tomato", new Color(255, 99, 71)),
    ORANGE_RED("orange red", new Color(255, 69, 0)),
    RED("red", new Color(255, 0, 0)),
    CRIMSON("crimson", new Color(220, 20, 60)),
    DARK_SALMON("dark salmon", new Color(233, 150, 122)),
    SALMON("salmon", new Color(250, 128, 114)),
    LIGHT_CORAL("light coral", new Color(240, 128, 128)),
    INDIAN_RED("indian red", new Color(205, 92, 92)),
    ROSY_BROWN("rosy brown", new Color(188, 143, 143)),
    LINEN("linen", new Color(250, 240, 230)),
    SEASHELL("seashell", new Color(255, 245, 238)),
    MISTY_ROSE("misty rose", new Color(255, 228, 225)),
    PINK("pink", new Color(255, 192, 203)),
    LIGHT_PINK("light pink", new Color(255, 182, 193)),
    HOT_PINK("hot pink", new Color(255, 105, 180)),
    DEEP_PINK("deep pink", new Color(255, 20, 147)),
    SNOW("snow", new Color(255, 250, 250)),
    LAVENDER_BLUSH("lavender blush", new Color(255, 240, 245)),
    PALE_VIOLET_RED("pale violet red", new Color(219, 112, 147)),
    VIOLET_RED("violet red", new Color(204, 50, 153)),
    MEDIUM_VIOLET_RED("medium violet red", new Color(199, 21, 133)),
    PURPLE("purple", new Color(128, 0, 128)),
    DARK_MAGENTA("dark magenta", new Color(139, 0, 139)),
    VIOLET("violet", new Color(238, 130, 238)),
    MAGENTA("magenta", new Color(255, 0, 255)),
    THISTLE("thistle", new Color(216, 191, 216)),
    PLUM("plum", new Color(221, 160, 221)),
    ORCHID("orchid", new Color(218, 112, 214)),
    MEDIUM_ORCHID("medium orchid", new Color(186, 85, 211)),
    DARK_ORCHID("dark orchid", new Color(153, 50, 204)),
    DARK_VIOLET("dark violet", new Color(148, 0, 211)),
    BLUE_VIOLET("blue violet", new Color(138, 43, 226)),
    MEDIUM_PURPLE("medium purple", new Color(147, 112, 219)),
    REBECCA_PURPLE("rebecca purple", new Color(102, 51, 153)),
    INDIGO("indigo", new Color(75, 0, 130)),
    GHOST_WHITE("ghost white", new Color(248, 248, 255)),
    LAVENDER("lavender", new Color(230, 230, 250)),
    LIGHT_SLATE_BLUE("light slate blue", new Color(132, 112, 255)),
    MEDIUM_SLATE_BLUE("medium slate blue", new Color(123, 104, 238)),
    SLATE_BLUE("slate blue", new Color(106, 90, 205)),
    DARK_SLATE_BLUE("dark slate blue", new Color(72, 61, 139));

    public static final Map<String, Color> COLOR_FOR_NAME;

    static {
        COLOR_FOR_NAME = new HashMap<>();
        for (TurtleColor color : values()) {
            COLOR_FOR_NAME.put(color.name, color.color);
        }
    }

    private final String name;
    private final Color color;

    TurtleColor(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
