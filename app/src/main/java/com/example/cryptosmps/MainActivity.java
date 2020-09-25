package com.example.cryptosmps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button enc, dec, abt;
    ViewFlipper vf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // A singled code to set the screen to full screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        setContentView(R.layout.activity_main);
        enc =findViewById(R.id.encd);
        dec = findViewById(R.id.decd);
        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent temp = new Intent(MainActivity.this,Encoder.class);
                startActivity(temp);

            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(MainActivity.this,Decoder.class);
                startActivity(temp);
            }
        });
        vf=findViewById(R.id.vf);
        int images [] ={R.drawable.cipher1,R.drawable.cipher2,R.drawable.cipher3};

        for (int i=0; i<images.length;i++)
        {
            flipper(images[i]);
        }
    }

    public void flipper(int images)
    {
        ImageView test =new ImageView(this);
        test.setBackgroundResource(images);
        vf.addView(test);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);
        vf.setInAnimation(this,android.R.anim.slide_in_left);

        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }

}