//@author James Conn

package com.example.facemaker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{

    private Face face;

    //constructer
    public FaceController(Face f){
        face = f;
    }

    //button listener
    @Override
    public void onClick(View v) {
        face.randomize();
        if(face.selecter == 0){
            face.redBar.setProgress(Color.red(face.skinColor));
            face.greenBar.setProgress(Color.green(face.skinColor));
            face.blueBar.setProgress(Color.blue(face.skinColor));
        }else if(face.selecter == 1){
            face.redBar.setProgress(Color.red(face.eyeColor));
            face.greenBar.setProgress(Color.green(face.eyeColor));
            face.blueBar.setProgress(Color.blue(face.eyeColor));
        }else{
            face.redBar.setProgress(Color.red(face.hairColor));
            face.greenBar.setProgress(Color.green(face.hairColor));
            face.blueBar.setProgress(Color.blue(face.hairColor));
        }
        face.invalidate();
    }

    //seekbar listener
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.redBar){
            if(face.selecter == 0){
                float hsv[] = new float[3];
                Color.RGBToHSV(progress, Color.green(face.skinColor),
                        Color.blue(face.skinColor), hsv);
                face.skinColor = Color.HSVToColor(hsv);
            }else if(face.selecter == 1){
                float hsv[] = new float[3];
                Color.RGBToHSV(progress, Color.green(face.eyeColor),
                        Color.blue(face.eyeColor), hsv);
                face.eyeColor = Color.HSVToColor(hsv);
            }else{
                float hsv[] = new float[3];
                Color.RGBToHSV(progress, Color.green(face.hairColor),
                        Color.blue(face.hairColor), hsv);
                face.hairColor = Color.HSVToColor(hsv);
            }
        }else if (seekBar.getId() == R.id.greenBar){
            if(face.selecter == 0){
                float hsv[] = new float[3];
                Color.RGBToHSV(Color.red(face.skinColor), progress,
                        Color.blue(face.skinColor), hsv);
                face.skinColor = Color.HSVToColor(hsv);
            }else if(face.selecter == 1){
                float hsv[] = new float[3];
                Color.RGBToHSV(Color.red(face.eyeColor), progress,
                        Color.blue(face.eyeColor), hsv);
                face.eyeColor = Color.HSVToColor(hsv);
            }else{
                float hsv[] = new float[3];
                Color.RGBToHSV(Color.red(face.hairColor), progress,
                        Color.blue(face.hairColor), hsv);
                face.hairColor = Color.HSVToColor(hsv);
            }
        }else{
            if(face.selecter == 0){
                float hsv[] = new float[3];
                Color.RGBToHSV(Color.red(face.skinColor), Color.green(face.skinColor),
                        progress, hsv);
                face.skinColor = Color.HSVToColor(hsv);
            }else if(face.selecter == 1){
                float hsv[] = new float[3];
                Color.RGBToHSV(Color.red(face.eyeColor), Color.green(face.eyeColor),
                        progress, hsv);
                face.eyeColor = Color.HSVToColor(hsv);
            }else{
                float hsv[] = new float[3];
                Color.RGBToHSV(Color.red(face.hairColor), Color.green(face.hairColor),
                        progress, hsv);
                face.hairColor = Color.HSVToColor(hsv);
            }
        }
        face.invalidate();
    }

    //radio button listener
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.skinRadioButton){
            face.selecter = 0;
            face.redBar.setProgress(Color.red(face.skinColor));
            face.greenBar.setProgress(Color.green(face.skinColor));
            face.blueBar.setProgress(Color.blue(face.skinColor));
        }else if(checkedId == R.id.eyeRadioButton){
            face.selecter = 1;
            face.redBar.setProgress(Color.red(face.eyeColor));
            face.greenBar.setProgress(Color.green(face.eyeColor));
            face.blueBar.setProgress(Color.blue(face.eyeColor));
        }else{
            face.selecter = 2;
            face.redBar.setProgress(Color.red(face.hairColor));
            face.greenBar.setProgress(Color.green(face.hairColor));
            face.blueBar.setProgress(Color.blue(face.hairColor));
        }
        face.invalidate();
    }

    //spinner listener
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        face.hairStyle = (int) id;
        face.invalidate();
    }

    //extra inherited methods that are not implements
    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
