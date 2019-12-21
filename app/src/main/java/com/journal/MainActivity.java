package com.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText login, pass;
    private long backPressedTime;
    private Toast backToast;

    private static final String login_txt = "simbaleon", pass_txt = "1223";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        enter();
    }

    public void enter(){
        btn = (Button) findViewById(R.id.enter);
        login = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.Pas);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        {
                            if((login.getText().toString().equals(login_txt))&& (pass.getText().toString().equals(pass_txt))) {
                                Intent intent = new Intent(MainActivity.this, List.class);
                                startActivity(intent);
                            }else Toast.makeText(
                                    MainActivity.this, "Неверный логин или пароль" ,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );
    }
    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
