package com.cookandroid.self9_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static int curShape = SimpleShapeFactory.LINE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("손성훈의 그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, SimpleShapeFactory.LINE, 0, "선 그리기");
        menu.add(0, SimpleShapeFactory.CIRCLE, 0, "원 그리기");
        menu.add(0, SimpleShapeFactory.SQUARE, 0, "네모 그리기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        curShape = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        SimpleShapeFactory simpleShapeFactory = new SimpleShapeFactory();
        ArrayList<CustomShape> models = new ArrayList<CustomShape>();
        CustomShape current = null;
        Paint paint = new Paint();

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    if (current == null) {
                        current = simpleShapeFactory.createShape(curShape, startX, startY, stopX, stopY);
                        models.add(current);
                    } else {
                        current.setCoordinates(startX, startY, stopX, stopY);
                    }
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    current.setCoordinates(startX, startY, stopX, stopY);
                    current = null;
                    this.invalidate();
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            for(Shape x: models) x.draw(canvas, paint);

        }
    }

}


