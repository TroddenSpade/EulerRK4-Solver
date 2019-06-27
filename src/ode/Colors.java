package ode;

import java.awt.*;

public enum Colors{
    RED(Color.RED),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    BLACK(Color.BLACK),
    CYAN(Color.CYAN),
    PINK(Color.PINK),
    ORANGE(Color.ORANGE),
    MAGENTA(Color.MAGENTA);

    private Color color;

    public Color getColor(){
        return color;
    }

    Colors(Color color){
        this.color = color;
    }
}
