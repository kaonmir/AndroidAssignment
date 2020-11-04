package com.cookandroid.self9_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

abstract class CustomShape extends Shape {
    int startX, startY, stopX, stopY;
    CustomShape(int startX, int startY, int stopX, int stopY) {
        this.setCoordinates(startX, startY, stopX, stopY);
    }

    void setCoordinates(int startX, int startY, int stopX, int stopY) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
    }

}

class Circle extends CustomShape {

    Circle(int startX, int startY, int stopX, int stopY) {
        super(startX, startY, stopX, stopY);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                + Math.pow(stopY - startY, 2));
        canvas.drawCircle(startX, startY, radius, paint);
    }
}

class Line extends CustomShape {
    Line(int startX, int startY, int stopX, int stopY) {
        super(startX, startY, stopX, stopY);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);

        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }
}

class Square extends CustomShape {

    Square(int startX, int startY, int stopX, int stopY) {
        super(startX, startY, stopX, stopY);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.MAGENTA);

        canvas.drawRect(startX, startY, stopX, stopY, paint);
    }
}
