package com.boaz.dragonski.ex5_demo_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements EnteredNumberListener {

    private Button enterNumberButton;
    private Fragment goFishFrag;
    private Fragment numberInputFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goFishButton = findViewById(R.id.go_fish);
        enterNumberButton = findViewById(R.id.tap_on_me);

        enterNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                numberInputFrag = new InputNumbersFrag();
                fragmentManager.beginTransaction().add(R.id.contain_numbers, numberInputFrag).addToBackStack(null).commit();
            }
        });

        goFishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                goFishFrag = new FisherManFrag();
                fragmentManager.beginTransaction().add(R.id.contain_fish, goFishFrag).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public void OnNumberEntered(CharSequence number) { //implement interface
        getSupportFragmentManager().beginTransaction().remove(numberInputFrag).commit();
        enterNumberButton.setText("You have enetered: " + number);
    }
}
