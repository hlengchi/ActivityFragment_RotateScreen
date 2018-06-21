package com.example.hlengchi.twoactivityandfragment;

import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnFragmentMainOne, btnFragmentMainTwo,btnActivityMain;
    FrameLayout frameLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivityMain=findViewById(R.id.btnActivityMain);
        btnFragmentMainOne=findViewById(R.id.btnFragmentMainOne);
        btnFragmentMainTwo=findViewById(R.id.btnFragmentMainTwo);
        frameLayoutMain=findViewById(R.id.frameLayoutMain);


        btnActivityMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),OneActivity.class);
                startActivity(intent);
            }
        });
        btnFragmentMainOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneFragment oneFragment=new OneFragment();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frameLayoutMain,oneFragment);
                ft.commit();
            }
        });
         btnFragmentMainTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TwoFragment twoFragment=new TwoFragment();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frameLayoutMain,twoFragment);
                ft.commit();

            }
        });
    }

}
