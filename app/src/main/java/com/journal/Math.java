package com.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Math extends AppCompatActivity {

    EditText Dz;
    Button Upg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);
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

