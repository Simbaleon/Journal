package com.journal;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.HashMap;

public class List extends AppCompatActivity implements View.OnClickListener {

    public Button[] btns;
    public TextView[] textView;
    public EditText[] editText;
    public static String Dz;
    String[] array;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LinearLayout.LayoutParams forLessons = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams forDz = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        forLessons.leftMargin = 25;
        forLessons.rightMargin = 25;
        forLessons.topMargin = 15;

        forDz.leftMargin = 25;
        forDz.rightMargin = 25;
        forDz.bottomMargin = 15;

        hashMap.put(1, R.id.monday);
        hashMap.put(2, R.id.tuesday);
        hashMap.put(3, R.id.wednesday);
        hashMap.put(4, R.id.thursday);
        hashMap.put(5, R.id.friday);
        hashMap.put(6, R.style.Dz1);
        hashMap.put(7, R.style.Dz2);
        hashMap.put(8, R.style.Dz3);
        hashMap.put(9, R.style.Dz4);
        hashMap.put(10, R.style.Dz5);
        hashMap.put(11, R.style.Monday);
        hashMap.put(12, R.style.Tuesday);
        hashMap.put(13, R.style.Wednesday);
        hashMap.put(14, R.style.Thursday);
        hashMap.put(15, R.style.Friday);

        Intent intent = getIntent();
        RaspForStudent();
    }

    public void RaspForStudent() {

        textView = new TextView[40];
        int nowText = 0;
        array = new String[2];
        for (int d = 1; d < 6; d++) {
            Context style_less = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 10));
            Context style_dz = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 5));
            for (int i = 0; i < array.length; i++) {
                array[0] = "Математика:7";
                array[1] = "Русский язык:45;";
                String[] a = array[i].split(";");
                for (int j = 0; j < a.length; j++) {
                    String[] b = a[j].split(":");
                    textView[nowText] = new TextView(style_less);
                    textView[nowText].setText("1 " + b[0]);
                    LinearLayout list_lessons = findViewById(hashMap.get(d));
                    list_lessons.addView(textView[nowText], forLessons);

                    textView[nowText] = new TextView(style_dz);
                    textView[nowText].setText("2 " + b[1]);
                    LinearLayout list_dz = findViewById(hashMap.get(d));
                    list_dz.addView(textView[nowText], forDz);
                    nowText++;
                }
            }
        }
    }


    public void RaspForTeacher() {
        editText = new EditText[40];
        btns = new Button[40];
        int nowText = 0;
        array = new String[2];
        for (int d = 1; d < 6; d++) {
            Context style_less = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 10));
            Context style_dz = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 5));
            for (int i = 0; i < array.length; i++) {
                array[0] = "9B:7";
                array[1] = "4A:45;";
                String[] a = array[i].split(";");
                for (int j = 0; j < a.length; j++) {
                    String[] b = a[j].split(":");
                    btns[nowText] = new Button(style_less);
                    btns[nowText].setText("1 " + b[0]);
                    LinearLayout list_lessons = findViewById(hashMap.get(d));
                    list_lessons.addView(textView[nowText], forLessons);

                    editText[nowText] = new EditText(style_dz);
                    editText[nowText].setText("2 " + b[1]);
                    LinearLayout list_dz = findViewById(hashMap.get(d));
                    list_dz.addView(textView[nowText], forDz);
                    nowText++;
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(List.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ForTeacher.class);
        String[] a = new String[2];
        a[0] = ((Button) v).getText().toString();
        a[1] = "Дз";
        intent.putExtra("teacher", a);
        startActivity(intent);
    }
}

