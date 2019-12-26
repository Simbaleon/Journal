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

public class Teacher extends AppCompatActivity {
//        implements Parcelable {

    String email, phone, qualification;
    boolean is_admin, is_newdz = false;
    public Button[] btns;
    boolean la = false, Pr;
    public int id, permit;
    public String name, surname, login, pass, position;
    public TextView[] textView;
    public TextView mon;
    public EditText[] editText;
    public static String dz, Pr, newDz;
    String[] array;
    private final int USERID = 6000;
    private int countID, pr;
    TextView Klas;
    TextView Dz;
    Button Upg, Reg;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LinearLayout.LayoutParams forLessons = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams forDz = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//   Teacher(int id, String name, String surname, String login, String pass, String position,
//           boolean is_admin, int permit) {
//       this.id = id;
//       this.name = name;
//       this.surname = surname;
//       this.login = login;
//       this.pass = pass;
//       this.position = position;
//       this.email = email;
//       this.phone = phone;
//       this.qualification = qualification;
//       this.is_admin = is_admin;
//       this.permit = permit;
//    }


//    protected Teacher(Parcel in) {
//        email = in.readString();
//        phone = in.readString();
//        qualification = in.readString();
//        is_admin = in.readByte() != 0;
//        is_newdz = in.readByte() != 0;
//        array = in.createStringArray();
//        countID = in.readInt();
//        pr = in.readInt();
//    }
//
//    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
//        @Override
//        public Teacher createFromParcel(Parcel in) {
//            return new Teacher(in);
//        }
//
//        @Override
//        public Teacher[] newArray(int size) {
//            return new Teacher[size];
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_for_teacher);
        Reg = (Button)findViewById(R.id.reg);
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
        array = new String[5];
        array[0] = "9б:7;5а:45;8б:16;9а:5;10а:58";
        array[1] = "11а:45;7б:7;8а:45;9б:16;7а:5;6б:58";
        array[2] = "5б:5;10б:7;5б:45;9а:16;11б:58";
        array[3] = "7б:16;8б:5;10а:58;5а:7;9б:45";
        array[4] = "8б:7;5б:45;11а:16;6б:5;11б:58";
        Rasp();
    }
    public void Rasp(){

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
                                Teacher.this, "В onClicke " + pr,
                                Toast.LENGTH_SHORT
                        ).show();
                        String[] a = new String[2];
                        a[0] = ((Button) v).getText().toString();
                        a[1] = textView[pr].getText().toString();

                        setContentView(R.layout.for_teacher);
                        Klas = (TextView) findViewById(R.id.klas);
                        la = true;
                        Dz = (TextView) findViewById(R.id.Dz);
                        Upg = (Button) findViewById(R.id.Btn);
                        Klas.setText(a[0]);
                        Dz.setText(a[1]);
                        Upg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                newDz = Dz.getText().toString();
                                setContentView(R.layout.week_for_teacher);
                                la = false;
                                textView[pr].setText(newDz);
                                is_newdz = true;
                                Rasp();
                            }
                        });

                    }
                });
                countID++;
                if(is_newdz){
                    textView[nowText] = new TextView(style_dz);
                    textView[nowText].setText(newDz);
                    LinearLayout list_dz = findViewById(hashMap.get(d));
                    list_dz.addView(textView[nowText], forDz);
                    nowText++;
                    is_newdz = false;
                }else {
                    textView[nowText] = new TextView(style_dz);
                    textView[nowText].setText(b[1]);
                    LinearLayout list_dz = findViewById(hashMap.get(d));
                    list_dz.addView(textView[nowText], forDz);
                    nowText++;
                }

            }
        }
    }


    @Override
    public void onBackPressed() {
        if (la) {
            newDz = Dz.getText().toString();
            setContentView(R.layout.week_for_teacher);
            la = false;
            textView[pr].setText(newDz);
            is_newdz = true;
            Rasp();
        } else {
            try {
                Intent intent = new Intent(Teacher.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        }
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(email);
//        dest.writeString(phone);
//        dest.writeString(qualification);
//        dest.writeByte((byte) (is_admin ? 1 : 0));
//        dest.writeByte((byte) (is_newdz ? 1 : 0));
//        dest.writeStringArray(array);
//        dest.writeInt(USERID);
//        dest.writeInt(countID);
//        dest.writeInt(pr);
//    }
}

