package com.bunty.sbnitmofficial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DeveloperProfile extends AppCompatActivity {

    private ImageView instabtn;
    private ImageView gitBtn;
    private ImageView linkBtn;
    private TextView callNumber;
    private TextView emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Developer profile");

        instabtn = findViewById(R.id.instaBtn);
        gitBtn = findViewById(R.id.gitBtn);
        linkBtn = findViewById(R.id.linkBtn);
        callNumber = findViewById(R.id.callNumber);
        emailBtn = findViewById(R.id.emailBtn);


        instabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoinstagram();
            }
        });

        gitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotogithub();
            }
        });

        linkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotolinkin();
            }
        });

    }

    public void gotoinstagram() {
        Uri uri = Uri.parse("https://www.instagram.com/singh_sandilya_/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/singh_sandilya_/")));
        }
    }

    public void gotolinkin() {
        Uri uri = Uri.parse("https://www.linkedin.com/in/bunty-kumar-039674193/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.linkedin.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/bunty-kumar-039674193/")));
        }
    }

    public void gotogithub() {
        Uri uri = Uri.parse("https://github.com/bunty2271999");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.github.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/bunty2271999")));
        }
    }

}