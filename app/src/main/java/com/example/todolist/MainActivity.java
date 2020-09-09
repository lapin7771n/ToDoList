package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToSecondAct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToSecondAct = (Button) findViewById(R.id.btnToSecondAct);
        btnToSecondAct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnToSecondAct:
                Intent intent = new Intent(this, ActTwo.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}