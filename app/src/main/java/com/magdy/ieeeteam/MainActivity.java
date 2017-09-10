package com.magdy.ieeeteam;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    EditText name , id , pass , number;
    Button button;

    @Override
    protected void onCreate(Bundle o) {
        super.onCreate(o);
        setContentView(R.layout.activity_main);

         name = (EditText) findViewById(R.id.name);
         id = (EditText) findViewById(R.id.id);
         pass= (EditText) findViewById(R.id.pass);
         number = (EditText) findViewById(R.id.num);
         button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==button)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("Message");
            builder.setMessage("Are you sure ?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                    Profile profile = new Profile();
                    profile.setId(id.getText().toString());
                    profile.setName(name.getText().toString());
                    profile.setNumber(Integer.parseInt(number.getText().toString()));
                    profile.setPassword(pass.getText().toString());
                    intent.putExtra("profile",profile);
                    Toast.makeText(getBaseContext(),"Hello Main 2",Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getBaseContext(),"Canceled",Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
    }
        private int i = 0 ;
        public void notify(View view)
        {
            Intent intent = new Intent(getBaseContext(),NotifiyActivity.class);
            PendingIntent pendingIntent =  PendingIntent.getActivity(this,0,intent,Intent.FLAG_ACTIVITY_NEW_TASK);
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle("Launch this");
            builder.setSubText("Welcome");
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.addAction(android.R.drawable.ic_media_play,"Play",pendingIntent);
            builder.addAction(android.R.drawable.ic_media_pause,"Pause",pendingIntent);
            Notification notification = builder.build();
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(i++,notification);
        }
}

