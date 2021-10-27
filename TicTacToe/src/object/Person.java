package object;

import javafx.scene.paint.Color;

public class Person {
    String name;
    Color color;
    String icon;
    public Person(String name, Color color, String icon){
        this.name = name;
        this.color = color;
        this.icon = icon;
    }
    public Color getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
    public String getIcon() {
        return icon;
    }
}
