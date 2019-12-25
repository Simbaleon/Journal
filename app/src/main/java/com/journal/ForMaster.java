package com.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ForMaster extends AppCompatActivity {

    Button b1, b2, b3, back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_master);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        back = (Button) findViewById(R.id.back);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            Intent intent = new Intent(ForMaster.this, Reg_Teacher.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            Intent intent = new Intent(ForMaster.this, Reg_Student.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            Intent intent = new Intent(ForMaster.this, Reg_Parent.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            Intent intent = new Intent(ForMaster.this, Master.class);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
        @Override
        public void onBackPressed () {
            Intent mas = new Intent(ForMaster.this, Master.class);
            startActivity(mas);
            finish();
        }


}

