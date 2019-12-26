package com.journal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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

public class Student extends AppCompatActivity  {

    int id, id_child;
    String name, surname;
    public Button[] btns;
    public TextView[] textView;
    public static String dz;
    String[] array;
    private int USERID = 7000;
    private int countID, pr;
    TextView Klas;
    TextView Dz;
    Button Upg;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LinearLayout.LayoutParams forLessons = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams forDz = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//    Student(int id, String name, String surname, int id_child){
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.id_child = id_child;
//    }


//    protected Student(Parcel in) {
//        id = in.readInt();
//        id_child = in.readInt();
//        name = in.readString();
//        surname = in.readString();
//        array = in.createStringArray();
//        USERID = in.readInt();
//        countID = in.readInt();
//        pr = in.readInt();
//    }



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
        hashMap.put(16, R.drawable.monday);
        hashMap.put(17, R.drawable.tuesday);
        hashMap.put(18, R.drawable.wednesday);
        hashMap.put(19, R.drawable.thursday);
        hashMap.put(20, R.drawable.friday);

        Intent intent = getIntent();
        btns = new Button[40];
        textView = new TextView[40];
        int nowText = 0;
        array = new String[5];
        array[0] = "Математика:7;Русский язык:45;География:16;Физика:5;Литература:58;";
        array[1] = "Русский язык:45;Математика:7;Русский язык:45;География:16;Физика:5;Литература:58;";
        array[2] = "Физика:5;Математика:7;Русский язык:45;География:16;Литература:58;";
        array[3] = "География:16;Физика:5;Литература:Прочитать 'Евгений Онегин' и 'Мастер и Маргарита' ууурааа;Математика:7;Русский язык:45";
        array[4] = "Математика:7;Русский язык:45;География:16;Физика:5;Литература:58;";
        Rasp();

    }
    public void Rasp() {
        int nowText = 0;
        for (int d = 1; d < 6; d++) {
            Context style_less = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 10));
            Context style_dz = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 5));
            String[] a = array[d - 1].split(";");
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
                                Student.this, "В onClicke " + pr,
                                Toast.LENGTH_SHORT
                        ).show();
                        String[] a = new String[2];
                        a[0] = ((Button) v).getText().toString();
                        a[1] = textView[pr].getText().toString();

                        setContentView(R.layout.for_student);
                        Klas = (TextView) findViewById(R.id.klas);
                        Dz = (TextView) findViewById(R.id.Dz);
                        Upg = (Button) findViewById(R.id.Btn);
                        Klas.setText(a[0]);
                        Dz.setText(a[1]);
                        Upg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.week);
                                Rasp();
                            }
                        });

                    }
                });
                countID++;
                textView[nowText] = new TextView(style_dz);
                textView[nowText].setText(b[1]);
                LinearLayout list_dz = findViewById(hashMap.get(d));
                list_dz.addView(textView[nowText], forDz);
                nowText++;

            }
        }
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Student.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

}


