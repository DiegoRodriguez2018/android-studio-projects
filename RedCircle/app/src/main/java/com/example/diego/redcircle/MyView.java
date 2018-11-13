package com.example.diego.redcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class MyView extends View implements Runnable {
    int speed = 5;
    int xdirection=speed;
    int ydirection=2*speed;
    int x = 100;
    int y = 100;

    public MyView (Context context){
        super (context);
    }

    Thread t=new Thread();
    Paint paint=new Paint();

    public void start()
    {
        t.start();
    }
    public void run()
    {
        try
        {
            Thread.sleep(1000, 1);
        }catch(InterruptedException e){}
    }

    @Override
    protected void onDraw (Canvas canvas){
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = 50;


        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.RED);
        if (x>=width-(radius)  || x<=radius){
            xdirection = xdirection*(-1);
        }
        if (y>=height-(radius)  || y<=radius){
            ydirection = ydirection*(-1);
        }


        canvas.drawCircle  (x,y,radius,paint);
        x=x+xdirection;
        y=y+ydirection;
        invalidate();
    }
}


