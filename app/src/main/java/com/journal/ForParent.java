package com.journal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ForParent extends AppCompatActivity {

    TextView Klas;
    TextView Dz;
    Button Upg;
    String[] dz;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_parent);
        Klas = (TextView) findViewById(R.id.klas);
        Dz = (TextView) findViewById(R.id.Dz);
        Upg = (Button)findViewById(R.id.Btn);
        Intent intent = getIntent();
        dz = intent.getStringArrayExtra("parent");
        Klas.setText(dz[0]);
        Dz.setText(dz[1]);
        Upg.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent iMath = new Intent(ForParent.this, Parent.class);
            finish();
        }
    };
    @Override
    public void onBackPressed(){
        Intent iMath = new Intent(ForParent.this, Parent.class);
        finish();
    }

}

