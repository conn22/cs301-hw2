//@author James Conn
/* Reference(?): Thank you to Glen Johnson (johnsonglent) for helping 
 * me manually upload this to github since my computer sucks
 */

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets face controller
        Face face = findViewById(R.id.faceView);
        FaceController fCont = new FaceController(face);

        //establishes spinner text and sets listener
        //Reference: https://developer.android.com/guide/topics/ui/controls/spinner#java
        Spinner spinner = (Spinner) findViewById(R.id.hairSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hair_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(fCont);

        //sets radio button group listener
        RadioGroup group = (RadioGroup) findViewById(R.id.colorValue);
        group.setOnCheckedChangeListener(fCont);

        //sets button listener
        Button rando = (Button) findViewById(R.id.randomButton);
        rando.setOnClickListener(fCont);

        //sets seekbar listener
        SeekBar redBar = (SeekBar) findViewById(R.id.redBar);
        SeekBar greenBar = (SeekBar) findViewById(R.id.greenBar);
        SeekBar blueBar = (SeekBar) findViewById(R.id.blueBar);
        redBar.setOnSeekBarChangeListener(fCont);
        greenBar.setOnSeekBarChangeListener(fCont);
        blueBar.setOnSeekBarChangeListener(fCont);

        //allows for the random button and radio buttons to change the seekbar values
        face.setRedBar(redBar);
        face.setGreenBar(greenBar);
        face.setBlueBar(blueBar);

        //initializes seekbars to skin color values
        redBar.setProgress(Color.red(face.skinColor));
        greenBar.setProgress(Color.green(face.skinColor));
        blueBar.setProgress(Color.blue(face.skinColor));

    }
}
