package com.journal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Reg_Parent extends AppCompatActivity {

    Button Reg, Back;
    EditText t1, t2, t3, t4, t5;
    String Login, Pass, Name, Surname, Id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_teacher);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t1 = (EditText) findViewById(R.id.t1);
        t2 = (EditText) findViewById(R.id.t2);
        t3 = (EditText) findViewById(R.id.t3);
        t4 = (EditText) findViewById(R.id.t4);
        t5 = (EditText) findViewById(R.id.t5);
        Reg = (Button) findViewById(R.id.Reg);
        Back = (Button) findViewById(R.id.Back);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        Reg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Login = t1.getText().toString();
                        Pass = t2.getText().toString();
                        Surname = t3.getText().toString();
                        Name = t4.getText().toString();
                        Id = t5.getText().toString();
                    }
                }
        );
        Back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            try {
                                Intent intent = new Intent(Reg_Parent.this, ForMaster.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {

                            }
                        }
                    }
                }
        );

    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Reg_Parent.this, ForMaster.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

}

