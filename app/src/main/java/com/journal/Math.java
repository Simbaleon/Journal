package com.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Math extends AppCompatActivity {

    TextView Klas;
    EditText Dz;
    Button Upg;
    String[] dz;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);
        Klas = (TextView) findViewById(R.id.klas);
        Dz = (EditText) findViewById(R.id.Dz);
        Upg = (Button)findViewById(R.id.Btn);
        Intent intent = getIntent();
        dz = intent.getStringArrayExtra("teacher");
        Klas.setText(dz[0]);
        Dz.setText(dz[1]);
        Upg.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String newDz = Dz.getText().toString();

            Intent iMath = new Intent(Math.this, List.class);
            iMath.putExtra("dz", newDz);
            setResult(1, iMath);
            finish();
        }
    };
    @Override
    public void onBackPressed(){
        String newDz = Dz.getText().toString();
        Intent iMath = new Intent(Math.this, List.class);
        iMath.putExtra("dz", newDz);
        setResult(1, iMath);
        finish();
    }

}

