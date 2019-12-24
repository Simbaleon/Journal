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

import java.util.HashMap;

public class Teacher extends AppCompatActivity {

    String email, phone, qualification;
    boolean is_admin, is_newdz = false;
    public Button[] btns;
    public TextView[] textView;
    public TextView mon;
    public EditText[] editText;
    public static String Dz, Pr;
    String[] array;
    private final int USERID = 6000;
    private int countID, pr;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LinearLayout.LayoutParams forLessons = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams forDz = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    public void teacher (String name, String surname, String id, String login, String pass, String position,
                    String email, String phone, String qualification, boolean is_admin) {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(
                Teacher.this, "В onCreate",
                Toast.LENGTH_SHORT
        ).show();
        setContentView(R.layout.week);
        mon = findViewById(R.id.mon);
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
        hashMap.put(16, R.drawable.monday);
        hashMap.put(17, R.drawable.tuesday);
        hashMap.put(18, R.drawable.wednesday);
        hashMap.put(19, R.drawable.thursday);
        hashMap.put(20, R.drawable.friday);

        Intent intent = getIntent();

        btns = new Button[40];
        textView = new TextView[40];
        int nowText = 0;
        array = new String[2];
        for (int d = 1; d < 6; d++) {
            Context style_less = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 10));
            Context style_dz = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 5));
            for (int i = 0; i < array.length; i++) {
                array[0] = "9B:7;8B:0";
                array[1] = "4A:45";
                String[] a = array[i].split(";");
                for (int j = 0; j < a.length; j++) {
                    String[] b = a[j].split(":");
                    btns[nowText] = new Button(style_less);
                    btns[nowText].setBackgroundResource(hashMap.get(d + 15));
                    btns[nowText].setId(USERID + countID);
                    btns[nowText].setText(b[0]);
                    LinearLayout list_lessons = findViewById(hashMap.get(d));
                    list_lessons.addView(btns[nowText], forLessons);
                    final int finalNowText = nowText;
                    btns[nowText].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pr = finalNowText;
                            Toast.makeText(
                                    Teacher.this, "В onClicke " + pr,
                                    Toast.LENGTH_SHORT
                            ).show();
                            is_newdz = true;
                            Intent intent = new Intent(Teacher.this, Math.class);
                            String[] a = new String[2];
                            a[0] = ((Button) v).getText().toString();
                            a[1] = textView[pr].getText().toString();
                            intent.putExtra("teacher", a);
                            startActivityForResult(intent, 17);
                        }
                    });
                    if (is_newdz){
                        is_newdz = false;
                    }else {
                        countID++;
                        textView[nowText] = new TextView(style_dz);
                        textView[nowText].setText(b[1]);
                        LinearLayout list_dz = findViewById(hashMap.get(d));
                        list_dz.addView(textView[nowText], forDz);
                        nowText++;
                    }
                }
            }
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        textView[pr].setText(data.getStringExtra("dz"));
    }



    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Teacher.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

//    public void onClick(View v) {
//        Intent intent = new Intent(this, Math.class);
//        String[] a = new String[2];
//        a[0] = ((Button) v).getText().toString();
//        a[1] = "Дз";
//        intent.putExtra("teacher", a);
//        startActivity(intent);
//    }
}


