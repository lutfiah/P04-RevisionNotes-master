package com.myapplicationdev.android.p04_revisionnotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStars;
    RadioButton r1, r2, r3, r4, r5;
    Button btnInsertNote, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText)findViewById(R.id.editTextNote);
        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        r1 = (RadioButton)findViewById(R.id.radio1);
        r2 = (RadioButton)findViewById(R.id.radio2);
        r3 = (RadioButton)findViewById(R.id.radio3);
        r4 = (RadioButton)findViewById(R.id.radio4);
        r5 = (RadioButton)findViewById(R.id.radio5);
        btnInsertNote = (Button)findViewById(R.id.buttonInsertNote);
        btnShowList = (Button)findViewById(R.id.buttonShowList);

        btnInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);

                if(r1.isActivated()) {
                    db.insertNote(etNote.getText().toString(), 1);
                }else if(r2.isActivated()){
                    db.insertNote(etNote.getText().toString(), 2);
                }else if(r3.isActivated()){
                    db.insertNote(etNote.getText().toString(), 3);
                }else if(r4.isActivated()){
                    db.insertNote(etNote.getText().toString(), 4);
                }else{
                    db.insertNote(etNote.getText().toString(), 5);
                }
                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
