package com.magdy.ieeeteam;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , RadioGroup.OnCheckedChangeListener {
    EditText editText;
    TextView  text;
    Button button;
    CheckBox checkBox ;
    ToggleButton toggleButton ;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle o) {
        super.onCreate(o);
        setContentView(R.layout.activity_main);



        text = (TextView) findViewById(R.id.text1);
         editText = (EditText) findViewById(R.id.editText);
         button = (Button) findViewById(R.id.button);
        checkBox = (CheckBox) findViewById(R.id.check);
        radioGroup = (RadioGroup) findViewById(R.id.rd);
        toggleButton = (ToggleButton) findViewById(R.id.toggle);
        button.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==button)
        {
            String s = editText.getText().toString();
            text.setText(s);
            editText.setText("");
        }

        else if(view==checkBox)
        {
            if(checkBox.isChecked())
            {
                text.setText(getString(R.string.checked));
            }
            else {
                text.setText(getString(R.string.not_check));
            }
        }
        else if(view==toggleButton)
        {
            if(toggleButton.isChecked())
            {
                text.setText("Tog Checked");
            }
            else {
                text.setText("Tog not Checked");
            }

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        if(radioGroup==this.radioGroup)
        {
            switch(i)
            {
                case R.id.first:
                    text.setText("First");
                    break;
                case R.id.sec:
                    text.setText("sec");

                    break;
                case R.id.third:
                    text.setText("third");

                    break;
            }
        }
    }
}

