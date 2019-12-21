package com.journal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Inf extends AppCompatActivity {

    EditText Dz;
    Button Upg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inf);
        Dz = (EditText) findViewById(R.id.Dz);
        Upg = findViewById(R.id.Btn);
        Intent intent = getIntent();
        String dz = intent.getStringExtra("Sub");
        Dz.setText(dz);
        Upg.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String newDz = Dz.getText().toString();
            Intent iInf = new Intent(Inf.this, List.class);
            iInf.putExtra("dz", newDz);
            setResult(7, iInf);
            finish();
        }
    };
    @Override
    public void onBackPressed(){
        String newDz = Dz.getText().toString();
        Intent iInf = new Intent(Inf.this, List.class);
        iInf.putExtra("dz", newDz);
        setResult(7, iInf);
        finish();
    }

}

