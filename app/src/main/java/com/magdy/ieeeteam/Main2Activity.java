package com.magdy.ieeeteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = (TextView) findViewById(R.id.name);
        TextView pass= (TextView) findViewById(R.id.pass);
        TextView id= (TextView) findViewById(R.id.id);
        TextView num= (TextView) findViewById(R.id.number);
        Intent intent = getIntent();
        Profile p = (Profile) intent.getSerializableExtra("profile");
        name.setText(p.getName());
        id.setText(p.getId());
        pass.setText(p.getPassword());
        num.setText(String.format(Locale.getDefault(),"Hello %d",p.getNumber()));
    }
    public void onClick(View view)
    {
        finish();
    }


}
