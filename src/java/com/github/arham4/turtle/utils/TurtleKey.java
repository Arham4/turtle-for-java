package com.github.arham4.turtle.utils;

import java.util.HashMap;
import java.util.Map;

public enum TurtleKey {
    ENTER("enter", '\n'),
    BACK_SPACE("backspace", '\b'),
    TAB("tab", '\t'),
    CANCEL("cancel", 0x03),
    CLEAR("clear", 0x0C),
    SHIFT("shift", 0x10),
    CONTROL("control", 0x11),
    ALT("alt", 0x12),
    PAUSE("pause", 0x13),
    CAPS_LOCK("capslock", 0x14),
    ESCAPE("escape", 0x1B),
    SPACE("space", 0x20),
    PAGE_UP("pageup", 0x21),
    PAGE_DOWN("pagedown", 0x22),
    END("end", 0x23),
    HOME("home", 0x24),
    LEFT("left", 0x25),
    UP("up", 0x26),
    RIGHT("right", 0x27),
    DOWN("down", 0x28),
    COMMA("comma", 0x2C),
    MINUS("minus", 0x2D),
    PERIOD("period", 0x2E),
    SLASH("slash", 0x2F),
    ZERO("0", 0x30),
    ONE("1", 0x31),
    TWO("2", 0x32),
    THREE("3", 0x33),
    FOUR("4", 0x34),
    FIVE("5", 0x35),
    SIX("6", 0x36),
    SEVEN("7", 0x37),
    EIGHT("8", 0x38),
    NINE("9", 0x39),
    SEMICOLON("semicolon", 0x3B),
    EQUALS("equals", 0x3D),
    A("a", 0x41),
    B("b", 0x42),
    C("c", 0x43),
    D("d", 0x44),
    E("e", 0x45),
    F("f", 0x46),
    G("g", 0x47),
    H("h", 0x48),
    I("i", 0x49),
    J("j", 0x4A),
    K("k", 0x4B),
    L("l", 0x4C),
    M("m", 0x4D),
    N("n", 0x4E),
    O("o", 0x4F),
    P("p", 0x50),
    Q("q", 0x51),
    R("r", 0x52),
    S("s", 0x53),
    T("t", 0x54),
    U("u", 0x55),
    V("v", 0x56),
    W("w", 0x57),
    X("x", 0x58),
    Y("y", 0x59),
    Z("z", 0x5A),
    OPEN_BRACKET("openbracket", 0x5B),
    BACK_SLASH("backslash", 0x5C),
    CLOSE_BRACKET("closebracket", 0x5D),
    NUMPAD0("numpad0", 0x60),
    NUMPAD1("numpad1", 0x61),
    NUMPAD2("numpad2", 0x62),
    NUMPAD3("numpad3", 0x63),
    NUMPAD4("numpad4", 0x64),
    NUMPAD5("numpad5", 0x65),
    NUMPAD6("numpad6", 0x66),
    NUMPAD7("numpad7", 0x67),
    NUMPAD8("numpad8", 0x68),
    NUMPAD9("numpad9", 0x69),
    MULTIPLY("multiply", 0x6A),
    ADD("add", 0x6B),
    SEPARATER("separater", 0x6C),
    SEPARATOR("separator", SEPARATER.keyCode),
    SUBTRACT("subtract", 0x6D),
    DECIMAL("decimal", 0x6E),
    DIVIDE("divide", 0x6F),
    DELETE("delete", 0x7F),
    NUM_LOCK("numlock", 0x90),
    SCROLL_LOCK("scrolllock", 0x91),
    F1("f1", 0x70),
    F2("f2", 0x71),
    F3("f3", 0x72),
    F4("f4", 0x73),
    F5("f5", 0x74),
    F6("f6", 0x75),
    F7("f7", 0x76),
    F8("f8", 0x77),
    F9("f9", 0x78),
    F10("f10", 0x79),
    F11("f11", 0x7A),
    F12("f12", 0x7B),
    F13("f13", 0xF000),
    F14("f14", 0xF001),
    F15("f15", 0xF002),
    F16("f16", 0xF003),
    F17("f17", 0xF004),
    F18("f18", 0xF005),
    F19("f19", 0xF006),
    F20("f20", 0xF007),
    F21("f21", 0xF008),
    F22("f22", 0xF009),
    F23("f23", 0xF00A),
    F24("f24", 0xF00B),
    PRINTSCREEN("printscreen", 0x9A),
    INSERT("insert", 0x9B),
    HELP("help", 0x9C),
    META("meta", 0x9D),
    BACK_QUOTE("backquote", 0xC0),
    QUOTE("quote", 0xDE),
    KP_UP("kpup", 0xE0),
    KP_DOWN("kpdown", 0xE1),
    KP_LEFT("kpleft", 0xE2),
    KP_RIGHT("kpright", 0xE3),
    DEAD_GRAVE("deadgrave", 0x80),
    DEAD_ACUTE("deadacute", 0x81),
    DEAD_CIRCUMFLEX("deadcircumflex", 0x82),
    DEAD_TILDE("deadtilde", 0x83),
    DEAD_MACRON("deadmacron", 0x84),
    DEAD_BREVE("deadbreve", 0x85),
    DEAD_ABOVEDOT("deadabovedot", 0x86),
    DEAD_DIAERESIS("deaddiaeresis", 0x87),
    DEAD_ABOVERING("deadabovering", 0x88),
    DEAD_DOUBLEACUTE("deaddoubleacute", 0x89),
    DEAD_CARON("deadcaron", 0x8a),
    DEAD_CEDILLA("deadcedilla", 0x8b),
    DEAD_OGONEK("deadogonek", 0x8c),
    DEAD_IOTA("deadiota", 0x8d),
    DEAD_VOICED_SOUND("deadvoicedsound", 0x8e),
    DEAD_SEMIVOICED_SOUND("deadsemivoicedsound", 0x8f),
    AMPERSAND("ampersand", 0x96),
    ASTERISK("asterisk", 0x97),
    QUOTEDBL("quotedbl", 0x98),
    LESS("less", 0x99),
    GREATER("greater", 0xa0),
    BRACELEFT("braceleft", 0xa1),
    BRACERIGHT("braceright", 0xa2),
    AT("at", 0x0200),
    COLON("colon", 0x0201),
    CIRCUMFLEX("circumflex", 0x0202),
    DOLLAR("dollar", 0x0203),
    EURO_SIGN("eurosign", 0x0204),
    EXCLAMATION_MARK("exclamationmark", 0x0205),
    INVERTED_EXCLAMATION_MARK("invertedexclamationmark", 0x020),
    LEFT_PARENTHESIS("leftparenthesis", 0x0207),
    NUMBER_SIGN("numbersign", 0x0208),
    PLUS("plus", 0x0209),
    RIGHT_PARENTHESIS("rightparenthesis", 0x020A),
    UNDERSCORE("underscore", 0x020B),
    WINDOWS("windows", 0x020C),
    CONTEXT_MENU("contextmenu", 0x020D),
    FINAL("final", 0x0018),
    CONVERT("convert", 0x001C),
    NONCONVERT("nonconvert", 0x001D),
    ACCEPT("accept", 0x001E),
    MODECHANGE("modechange", 0x001F),
    KANA("kana", 0x0015),
    KANJI("kanji", 0x0019),
    ALPHANUMERIC("alphanumeric", 0x00F0),
    KATAKANA("katakana", 0x00F1),
    HIRAGANA("hiragana", 0x00F2),
    FULL_WIDTH("fullwidth", 0x00F3),
    HALF_WIDTH("halfwidth", 0x00F4),
    ROMAN_CHARACTERS("romancharacters", 0x00F5),
    ALL_CANDIDATES("allcandidates", 0x0100),
    PREVIOUS_CANDIDATE("previouscandidate", 0x0101),
    CODE_INPUT("codeinput", 0x0102),
    JAPANESE_KATAKANA("japanesekatakana", 0x0103),
    JAPANESE_HIRAGANA("japanesehiragana", 0x0104),
    JAPANESE_ROMAN("japaneseroman", 0x0105),
    KANA_LOCK("kanalock", 0x0106),
    INPUT_METHOD_ON_OFF("inputmethodonoff", 0x0107),
    CUT("cut", 0xFFD1),
    COPY("copy", 0xFFCD),
    PASTE("paste", 0xFFCF),
    UNDO("undo", 0xFFCB),
    AGAIN("again", 0xFFC9),
    FIND("find", 0xFFD0),
    PROPS("props", 0xFFCA),
    STOP("stop", 0xFFC8),
    COMPOSE("compose", 0xFF20),
    ALT_GRAPH("altgraph", 0xFF7E),
    BEGIN("begin", 0xFF58),
    ;

    /**
     * Each {@code name} of the {@code TurtleKey}s paired with their respective {@link java.awt.event.KeyEvent} keycode.
     */
    public static final Map<String, Integer> KEY_FOR_NAME;

    static {
        KEY_FOR_NAME = new HashMap<>();
        for (TurtleKey key : values()) {
            KEY_FOR_NAME.put(key.name, key.keyCode);
        }
    }

    private final String name;
    private final int keyCode;

    TurtleKey(String name, int keyCode) {
        this.name = name;
        this.keyCode = keyCode;
    }

    /**
     * Gets the {@link java.awt.event.KeyEvent} key code for the key.
     *
     * @return The key code for the key.
     */
    public int getKeyCode() {
        return keyCode;
    }
}