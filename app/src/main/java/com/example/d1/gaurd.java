package com.example.d1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class gaurd extends AppCompatActivity {
    Button i1,i2,i3,i4,i5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaurd);

        i1=(Button) findViewById(R.id.button);
        i2=(Button) findViewById(R.id.button1);
        i3=(Button) findViewById(R.id.button2);
        i4=(Button) findViewById(R.id.button3);
        i5=(Button) findViewById(R.id.button4);



        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(gaurd.this,ventry.class);
                startActivity(i);
                YoYo.with(Techniques.RubberBand).duration(300).repeat(1).playOn(i1);
                Toast.makeText(gaurd.this,"Opening Entry " + "",Toast.LENGTH_LONG).show();
            }
        });


        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(gaurd.this,pvistor.class);
                startActivity(i);
                YoYo.with(Techniques.RubberBand).duration(300).repeat(1).playOn(i3);
                Toast.makeText(gaurd.this,"Opening Permanent" + "",Toast.LENGTH_LONG).show();

            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(gaurd.this,emerg.class);
                startActivity(i);
                YoYo.with(Techniques.RubberBand).duration(300).repeat(1).playOn(i4);
                Toast.makeText(gaurd.this,"Alert!!!!!!" + "",Toast.LENGTH_LONG).show();

            }
        });


    }

    public void List(View view) {
        Intent intent=new Intent(this,ShowUserActivity.class);
        startActivity(intent);
    }



}
