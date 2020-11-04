package com.cookandroid.self9_1;

public class SimpleShapeFactory {
    final static int LINE = 1, CIRCLE = 2, SQUARE = 3;

    public CustomShape createShape(int type, int startX, int startY, int stopX, int stopY) {
        CustomShape shape = null;

        if(type == LINE) shape = new Line(startX, startY, stopX, stopY);
        if(type == CIRCLE) shape = new Circle(startX, startY, stopX, stopY);
        if(type == SQUARE) shape = new Square(startX, startY, stopX, stopY);

        return shape;
    }

}
