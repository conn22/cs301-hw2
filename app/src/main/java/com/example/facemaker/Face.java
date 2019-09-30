//@author James Conn

package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;

public class Face extends SurfaceView {

    public int skinColor, eyeColor, hairColor, hairStyle, selecter;
    private Paint fPaint, ePaint, hPaint;
    public SeekBar redBar, greenBar, blueBar;

    //constructor
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        fPaint = new Paint();
        ePaint = new Paint();
        hPaint = new Paint();
        selecter = 0;
        randomize();
    }

    public void setRedBar(SeekBar r){
        redBar = r;
    }

    public void setGreenBar(SeekBar g){
        greenBar = g;
    }

    public void setBlueBar(SeekBar b){
        blueBar = b;
    }

    //randomizes all values
    public void randomize() {
        skinColor = randomColor();
        eyeColor = randomColor();
        hairColor = randomColor();
        hairStyle = (int) (Math.random() * 3);
    }

    //helper method for randomization
    private int randomColor(){
        float[] hsv = new float[3];
        Color.RGBToHSV((int) (Math.random()*255), (int) (Math.random()*255),
                (int) (Math.random()*255), hsv);
        int col = Color.HSVToColor(255, hsv);
        return col;
    }

    //onDraw method, draws head and calls helper drawing methods
    public void onDraw(Canvas canvas){
        drawHair(canvas);
        fPaint.setColor(skinColor);
        canvas.drawCircle(700,500, 350, fPaint);
        drawEyes(canvas);
        drawMouth(canvas);
    }


    //helper method that draws the eyes of the face
    private void drawEyes(Canvas canvas){
        ePaint.setColor(Color.WHITE);
        canvas.drawCircle(550, 350,50, ePaint);
        canvas.drawCircle(825, 350, 50, ePaint);
        ePaint.setColor(eyeColor);
        canvas.drawCircle(550, 350,35, ePaint);
        canvas.drawCircle(825, 350, 35, ePaint);
        ePaint.setColor(Color.BLACK);
        canvas.drawCircle(550, 350, 15, ePaint);
        canvas.drawCircle(825, 350, 15, ePaint);

    }

    //helper method that draws the hair, depending on the style selected
    private void drawHair(Canvas canvas) {
        hPaint.setColor(hairColor);
        if (hairStyle == 1) {
            canvas.drawCircle(700, 300, 250, hPaint);
        }else if (hairStyle == 2) {
            canvas.drawRect(450, 100, 950, 500, hPaint);
        }
    }

    //helper method that draws the mouth
    private void drawMouth (Canvas canvas){
        Paint mPaint = new Paint();
//        float hsv[] = new float[3];
//        Color.RGBToHSV(233, 150, 122, hsv);
//        int col = Color.HSVToColor(255, hsv);
        int col = Color.BLACK;
        mPaint.setColor(col);
        canvas.drawRect(525, 625, 875, 655, mPaint);
    }

}
