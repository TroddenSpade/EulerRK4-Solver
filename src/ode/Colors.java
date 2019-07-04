package ode;

import java.awt.*;

public enum Colors{
    RED(Color.RED),
    BLUE(Color.BLUE),
    MAGENTA(Color.MAGENTA),
    ORANGE(Color.ORANGE),
    PINK(Color.PINK),
    CYAN(Color.CYAN),
    GREEN(Color.GREEN),
    BLACK(Color.BLACK);

    private Color color;

    public Color getColor(){
        return color;
    }

    Colors(Color color){
        this.color = color;
    }
}
