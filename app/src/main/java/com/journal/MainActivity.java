package com.journal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button enter1, enter2, enter3, enter4;
    private EditText login, pass;
    private long backPressedTime;
    private Toast backToast;
    static boolean T1 = false, T2 = false, T3 = false, T4 = false;
    private static final String login_txt = "", pass_txt = "";

    public Retrofit retrofit;
    Server server;
    JSONObject jsonObject;
    Call<JSONObject> jsonObjectCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autor);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        enter1 = (Button) findViewById(R.id.enter1);
        enter2 = (Button) findViewById(R.id.enter2);
        enter3 = (Button) findViewById(R.id.enter3);
        enter4 = (Button) findViewById(R.id.enter4);
        addListenerOnButton();

        if (T1) enter1.setBackgroundResource(R.drawable.enter);
        if (T2) enter2.setBackgroundResource(R.drawable.enter);
        if (T3) enter3.setBackgroundResource(R.drawable.enter);
        if (T4) enter4.setBackgroundResource(R.drawable.enter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("file://desktop-545kfou/OpenServer/OSPanel/domains/hui-o4ko.ru/database.sqlite/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Server server = retrofit.create(Server.class);

    }

public void getJsonObject() throws IOException, JSONException{
        jsonObject = new JSONObject(a);
}


    public void addListenerOnButton() {
        login = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.Pas);

        enter1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            if (!T2 && !T3 && !T4 && T1) {
                                Intent intent = new Intent(MainActivity.this, Student.class);
                                startActivity(intent);
//                                } else Toast.makeText(
//                                        MainActivity.this, "Неверный логин или пароль",
//                                        Toast.LENGTH_SHORT
//                                ).show();
                            } else if ((T2 || T3 || T4) && !T1) {
                                enter2.setBackgroundResource(R.drawable.botton);
                                enter3.setBackgroundResource(R.drawable.botton);
                                enter4.setBackgroundResource(R.drawable.botton);
                                enter1.setBackgroundResource(R.drawable.enter);
                                T1 = true;
                                T2 = false;
                                T3 = false;
                                T4 = false;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как ученик",
                                        Toast.LENGTH_SHORT
                                ).show();
                            } else if (!T2 && !T3 && !T4 && !T1) {
                                enter1.setBackgroundResource(R.drawable.enter);
                                T1 = true;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как ученик",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        }
                    }
                }
        );
        enter2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            if (!T1 && !T3 && !T4 && T2) {

                                Intent intent = new Intent(MainActivity.this, Teacher.class);
                                startActivity(intent);
//                                } else Toast.makeText(
//                                        MainActivity.this, "Неверный логин или пароль",
//                                        Toast.LENGTH_SHORT
//                                ).show();
                            } else if ((T1 || T3 || T4) && !T2) {
                                enter1.setBackgroundResource(R.drawable.botton);
                                enter3.setBackgroundResource(R.drawable.botton);
                                enter4.setBackgroundResource(R.drawable.botton);
                                enter2.setBackgroundResource(R.drawable.enter);
                                T2 = true;
                                T1 = false;
                                T3 = false;
                                T4 = false;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как учитель",
                                        Toast.LENGTH_SHORT
                                ).show();
                            } else if (!T2 && !T3 && !T4 && !T1) {
                                enter2.setBackgroundResource(R.drawable.enter);
                                T2 = true;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как учитель",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        }
                    }
                }
        );
        enter3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            if (!T1 && !T2 && !T4 && T3) {
                                Intent intent = new Intent(MainActivity.this, Parent.class);
                                startActivity(intent);
//                                } else Toast.makeText(
//                                        MainActivity.this, "Неверный логин или пароль",
//                                        Toast.LENGTH_SHORT
//                                ).show();
                            } else if ((T1 || T2 || T4) && !T3) {
                                enter1.setBackgroundResource(R.drawable.botton);
                                enter2.setBackgroundResource(R.drawable.botton);
                                enter4.setBackgroundResource(R.drawable.botton);
                                enter3.setBackgroundResource(R.drawable.enter);
                                T3 = true;
                                T1 = false;
                                T2 = false;
                                T4 = false;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как родитель",
                                        Toast.LENGTH_SHORT
                                ).show();
                            } else if (!T2 && !T3 && !T4 && !T1) {
                                enter3.setBackgroundResource(R.drawable.enter);
                                T3 = true;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как родитель",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        }
                    }
                }
        );
        enter4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            if (!T1 && !T2 && !T3 && T4) {

                                Intent intent = new Intent(MainActivity.this,Master.class);
                                startActivity(intent);
//                                } else Toast.makeText(
//                                        MainActivity.this, "Неверный логин или пароль",
//                                        Toast.LENGTH_SHORT
//                                ).show();
                            } else if ((T1 || T2 || T3) && !T4) {
                                enter1.setBackgroundResource(R.drawable.botton);
                                enter2.setBackgroundResource(R.drawable.botton);
                                enter3.setBackgroundResource(R.drawable.botton);
                                enter4.setBackgroundResource(R.drawable.enter);
                                T4 = true;
                                T1 = false;
                                T2 = false;
                                T3 = false;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как директор",
                                        Toast.LENGTH_SHORT
                                ).show();
                            } else if (!T2 && !T3 && !T4 && !T1) {
                                enter4.setBackgroundResource(R.drawable.enter);
                                T4 = true;
                                Toast.makeText(
                                        MainActivity.this, "Подтверидте вход как директор",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        }
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
