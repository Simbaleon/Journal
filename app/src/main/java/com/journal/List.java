package com.journal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class List extends AppCompatActivity implements View.OnClickListener{

    public Button [] btns;
    public TextView[] textView;
    public static String Dz, DzMath, DzRus, DzGeo, DzBio, DzFiz, DzHim, DzInf;
    private int Code;
    String [] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        HashMap <Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,R.id.monday);
        hashMap.put(2,R.id.tuesday);
        hashMap.put(3,R.id.wednesday);
        hashMap.put(4,R.id.thursday);
        hashMap.put(5,R.id.friday);


        textView = new TextView[40];


        int tekLay = 1;
        int tekText = 0;
        array = new String[2];
        array[0] = "monday:dz;hi:45";
        array[1] = "monday:dz;hi:45;";
        for (int i = 0; i < array.length; i++){
            String [] a = array[i].split(";");
            for (int j = 0; j < a.length; j++){
                String[] b = a[j].split(":");
                textView[tekText] = new TextView (this);
                textView[tekText].setText(b[0]  + b[1]);
                LinearLayout layout = findViewById(hashMap.get(1));
                layout.addView(textView[tekText], layoutParams);
                tekText++;
            }
            tekLay++;
        }
    }





    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent (List.this, MainActivity.class);
            startActivity(intent); finish();
        }catch(Exception e){

        }
    }

    @Override
    public void onClick(View v) {

    }
}

