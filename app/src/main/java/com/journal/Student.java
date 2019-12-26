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
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Student extends AppCompatActivity {
//        implements Parcelable {

    int id, permit;
    public String name, surname, a, clas;
    public Button[] btns;
    boolean la = false;
    public TextView[] textView;
    public static String dz;
    String[] array;
    private int USERID = 7000;
    private int countID, pr;
    TextView Klas;
    TextView Dz;
    Button Upg, mar;
    Call<JSONObject> jsonObjectCall;
    JSONObject jsonObject;
    Retrofit retrofit;
    Server server;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    HashMap<Integer,String> hashMap2 = new HashMap<>();
    LinearLayout.LayoutParams forLessons = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams forDz = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//    Student(int id, String name, String surname, String clas, int permit){
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.clas = clas;
//        this.permit = permit;
//    }
//    Student(){};
//
//
//    protected Student(Parcel in) {
//        id = in.readInt();
//        name = in.readString();
//        surname = in.readString();
//        array = in.createStringArray();
//        USERID = in.readInt();
//        countID = in.readInt();
//        pr = in.readInt();
//    }


//    public static final Creator<Student> CREATOR = new Creator<Student>() {
//        @Override
//        public Student createFromParcel(Parcel in) {
//            return new Student(in);
//        }
//
//        @Override
//        public Student[] newArray(int size) {
//            return new Student[size];
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week);
        Window w = getWindow();
        mar = findViewById(R.id.mar);
        a = "{\"monday\":[{\"id\":216,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":20,\"homework\":\"\",\"name\":\"\u042d\u043a\u043e\u043d\u043e\u043c\u0438\u043a\u0430\",\"classroom\":\"20\",\"school_class_name\":\"11a\"},{\"id\":215,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":19,\"homework\":\"\",\"name\":\"\u041f\u0440\u0430\u0432\u043e\",\"classroom\":\"19\",\"school_class_name\":\"11a\"},{\"id\":214,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":18,\"homework\":\"\",\"name\":\"\u041e\u0411\u0416\",\"classroom\":\"18\",\"school_class_name\":\"11a\"},{\"id\":213,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":17,\"homework\":\"\",\"name\":\"\u041c\u0443\u0437\u044b\u043a\u0430\",\"classroom\":\"17\",\"school_class_name\":\"11a\"},{\"id\":212,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":16,\"homework\":\"\",\"name\":\"\u0418\u0417\u041e\",\"classroom\":\"16\",\"school_class_name\":\"11a\"},{\"id\":211,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":15,\"homework\":\"\",\"name\":\"\u041e\u043a\u0440\u0443\u0436\u0430\u044e\u0449\u0438\u0439 \u043c\u0438\u0440\",\"classroom\":\"15\",\"school_class_name\":\"11a\"}],\"tuesday\":[{\"id\":210,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":14,\"homework\":\"\",\"name\":\"\u041e\u0431\u0449\u0435\u0441\u0442\u0432\u043e\u0437\u043d\u0430\u043d\u0438\u0435\",\"classroom\":\"14\",\"school_class_name\":\"11a\"},{\"id\":209,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":13,\"homework\":\"\",\"name\":\"\u0413\u0435\u043e\u0433\u0440\u0430\u0444\u0438\u044f\",\"classroom\":\"13\",\"school_class_name\":\"11a\"},{\"id\":208,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":12,\"homework\":\"\",\"name\":\"\u0410\u043d\u0433\u043b.\u044f\u0437.\",\"classroom\":\"12\",\"school_class_name\":\"11a\"},{\"id\":207,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":10,\"homework\":\"\",\"name\":\"\u0413\u0435\u043e\u043c\u0435\u0442\u0440\u0438\u044f\",\"classroom\":\"10\",\"school_class_name\":\"11a\"},{\"id\":206,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":9,\"homework\":\"\",\"name\":\"\u0410\u043b\u0433\u0435\u0431\u0440\u0430\",\"classroom\":\"9\",\"school_class_name\":\"11a\"},{\"id\":205,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":8,\"homework\":\"\",\"name\":\"\u0424\u0438\u0437-\u0440\u0430\",\"classroom\":\"8\",\"school_class_name\":\"11a\"},{\"id\":204,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":7,\"homework\":\"\",\"name\":\"\u0418\u043d\u0444\u043e\u0440\u043c\u0430\u0442\u0438\u043a\u0430\",\"classroom\":\"7\",\"school_class_name\":\"11a\"}],\"wednesday\":[{\"id\":203,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":6,\"homework\":\"\",\"name\":\"\u0418\u0441\u0442\u043e\u0440\u0438\u044f\",\"classroom\":\"6\",\"school_class_name\":\"11a\"},{\"id\":202,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":5,\"homework\":\"\",\"name\":\"\u041b\u0438\u0442\u0435\u0440\u0430\u0442\u0443\u0440\u0430\",\"classroom\":\"5\",\"school_class_name\":\"11a\"},{\"id\":201,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":4,\"homework\":\"\",\"name\":\"\u0420\u0443\u0441\u0441\u043a\u0438\u0439\u044f\u0437\u044b\u043a\",\"classroom\":\"4\",\"school_class_name\":\"11a\"},{\"id\":200,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":3,\"homework\":\"\",\"name\":\"\u0424\u0438\u0437\u0438\u043a\u0430\",\"classroom\":\"3\",\"school_class_name\":\"11a\"},{\"id\":199,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":2,\"homework\":\"\",\"name\":\"\u0425\u0438\u043c\u0438\u044f\",\"classroom\":\"2\",\"school_class_name\":\"11a\"},{\"id\":198,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":1,\"homework\":\"\",\"name\":\"\u0411\u0438\u043e\u043b\u043e\u0433\u0438\u044f\",\"classroom\":\"1\",\"school_class_name\":\"11a\"}],\"thursday\":[{\"id\":197,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":11,\"homework\":\"\",\"name\":\"\u041c\u0430\u0442\u0435\u043c\u0430\u0442\u0438\u043a\u0430\",\"classroom\":\"11\",\"school_class_name\":\"11a\"},{\"id\":216,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":20,\"homework\":\"\",\"name\":\"\u042d\u043a\u043e\u043d\u043e\u043c\u0438\u043a\u0430\",\"classroom\":\"20\",\"school_class_name\":\"11a\"},{\"id\":215,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":19,\"homework\":\"\",\"name\":\"\u041f\u0440\u0430\u0432\u043e\",\"classroom\":\"19\",\"school_class_name\":\"11a\"},{\"id\":214,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":18,\"homework\":\"\",\"name\":\"\u041e\u0411\u0416\",\"classroom\":\"18\",\"school_class_name\":\"11a\"},{\"id\":213,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":17,\"homework\":\"\",\"name\":\"\u041c\u0443\u0437\u044b\u043a\u0430\",\"classroom\":\"17\",\"school_class_name\":\"11a\"},{\"id\":212,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":16,\"homework\":\"\",\"name\":\"\u0418\u0417\u041e\",\"classroom\":\"16\",\"school_class_name\":\"11a\"},{\"id\":211,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":15,\"homework\":\"\",\"name\":\"\u041e\u043a\u0440\u0443\u0436\u0430\u044e\u0449\u0438\u0439 \u043c\u0438\u0440\",\"classroom\":\"15\",\"school_class_name\":\"11a\"}],\"friday\":[{\"id\":210,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":14,\"homework\":\"\",\"name\":\"\u041e\u0431\u0449\u0435\u0441\u0442\u0432\u043e\u0437\u043d\u0430\u043d\u0438\u0435\",\"classroom\":\"14\",\"school_class_name\":\"11a\"},{\"id\":209,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":13,\"homework\":\"\",\"name\":\"\u0413\u0435\u043e\u0433\u0440\u0430\u0444\u0438\u044f\",\"classroom\":\"13\",\"school_class_name\":\"11a\"},{\"id\":208,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":12,\"homework\":\"\",\"name\":\"\u0410\u043d\u0433\u043b.\u044f\u0437.\",\"classroom\":\"12\",\"school_class_name\":\"11a\"},{\"id\":207,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":10,\"homework\":\"\",\"name\":\"\u0413\u0435\u043e\u043c\u0435\u0442\u0440\u0438\u044f\",\"classroom\":\"10\",\"school_class_name\":\"11a\"},{\"id\":206,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":9,\"homework\":\"\",\"name\":\"\u0410\u043b\u0433\u0435\u0431\u0440\u0430\",\"classroom\":\"9\",\"school_class_name\":\"11a\"},{\"id\":205,\"type\":\"subject\",\"students_list\":[\"\"],\"teacher_id\":8,\"homework\":\"\",\"name\":\"\u0424\u0438\u0437-\u0440\u0430\",\"classroom\":\"8\",\"school_class_name\":\"11a\"}]}";
        for (int m = 0; m < a.length(); m ++){
        }
        array = new String[5];
        array[0] = "Математика:7;Русский язык:45;География:16;Физика:5;Литература:58;";
        array[1] = "Русский язык:45;Математика:7;Русский язык:45;География:16;Физика:5;Литература:58;";
        array[2] = "Физика:5;Математика:7;Русский язык:45;География:16;Литература:58;";
        array[3] = "География:16;Физика:5;Литература:Прочитать 'Евгений Онегин' и 'Мастер и Маргарита' ууурааа;Математика:7;Русский язык:45";
        array[4] = "Математика:7;Русский язык:45;География:16;Физика:5;Литература:58;";
        Intent intent = getIntent();
        btns = new Button[40];
        textView = new TextView[40];
        int nowText = 0;

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
        hashMap2.put(1, "monday");
        hashMap2.put(2, "tuesday");
        hashMap2.put(3, "wednesday");
        hashMap2.put(4, "thursday");
        hashMap2.put(5, "friday");
        retrofit = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        server = retrofit.create(Server.class);
        try {
            getJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            Rasp();
        } catch (JSONException e) {
            e.printStackTrace();
        }





    }
    public void Rasp() throws JSONException{
        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Student.this, Marks.class);
                startActivity(inten);
            }
        });
        int nowText = 0;
        for (int d = 1; d < 6; d++) {
            Context style_less = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 10));
            Context style_dz = new ContextThemeWrapper(findViewById(hashMap.get(d)).getContext(), hashMap.get(d + 5));
            String[] a = array[d - 1].split(";");
            for (int j = 0; j < a.length; j++) {
                btns[nowText] = new Button(style_less);
                btns[nowText].setBackgroundResource(hashMap.get(d + 15));
                btns[nowText].setId(USERID + countID);
                btns[nowText].setText(jsonObject.getJSONArray(hashMap2.get(d)).getJSONObject(j).getString("name"));
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
                        la = true;
                        Klas = (TextView) findViewById(R.id.klas);
                        Dz = (TextView) findViewById(R.id.Dz);
                        Upg = (Button) findViewById(R.id.Btn);
                        Klas.setText(a[0]);
                        Dz.setText(a[1]);
                        Upg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.week);
                                la = false;
                                mar = findViewById(R.id.mar);
                                try {

                                    Rasp();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                });
                countID++;
                textView[nowText] = new TextView(style_dz);
                textView[nowText].setText(jsonObject.getJSONArray(hashMap2.get(d)).getJSONObject(j).getString("homework"));
                LinearLayout list_dz = findViewById(hashMap.get(d));
                list_dz.addView(textView[nowText], forDz);
                nowText++;

            }
        }
    }
//    public String makeStrScores(int k) throws JSONException {
//        String a = "";
//        for (int i = 0; i < jsonObject.getJSONObject(k).getJSONArray("name").length(); i++) {
//            a = a.concat(jsonObject.getJSONObject(k).getJSONArray("name").getString(i));
//        }
//        return a;
//    }

    public void getJsonObject() throws IOException, JSONException {
        jsonObject = new JSONObject(a);
    }
    @Override
    public void onBackPressed() {
        if (la){
            setContentView(R.layout.week);
            la = false;
            mar = findViewById(R.id.mar);
            try {

                Rasp();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Intent intent = new Intent(Student.this, MainActivity.class);
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
//        dest.writeInt(id);
//        dest.writeString(name);
//        dest.writeString(surname);
//        dest.writeString(a);
//        dest.writeStringArray(array);
//        dest.writeInt(USERID);
//        dest.writeInt(countID);
//        dest.writeInt(pr);
//    }
}


