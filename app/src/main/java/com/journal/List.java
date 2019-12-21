package com.journal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class List extends AppCompatActivity {

    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30;
    public static String Dz, DzMath, DzRus, DzGeo, DzBio, DzFiz, DzHim, DzInf;
    private int Code;
    SharedPreferences sPref1, sPref2, sPref3, sPref4, sPref5, sPref6, sPref7;
    final String SAVED_TEXT1 = "1";
    final String SAVED_TEXT2 = "2";
    final String SAVED_TEXT3 = "3";
    final String SAVED_TEXT4 = "4";
    final String SAVED_TEXT5 = "5";
    final String SAVED_TEXT6 = "6";
    final String SAVED_TEXT7 = "7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);
        btn13 = (Button) findViewById(R.id.button13);
        btn14 = (Button) findViewById(R.id.button14);
        btn15 = (Button) findViewById(R.id.button15);
        btn16 = (Button) findViewById(R.id.button16);
        btn17 = (Button) findViewById(R.id.button17);
        btn18 = (Button) findViewById(R.id.button18);
        btn19 = (Button) findViewById(R.id.button19);
        btn20 = (Button) findViewById(R.id.button20);
        btn21 = (Button) findViewById(R.id.button21);
        btn22 = (Button) findViewById(R.id.button22);
        btn23 = (Button) findViewById(R.id.button23);
        btn24 = (Button) findViewById(R.id.button24);
        btn25 = (Button) findViewById(R.id.button25);
        btn26 = (Button) findViewById(R.id.button26);
        btn27 = (Button) findViewById(R.id.button27);
        btn28 = (Button) findViewById(R.id.button28);
        btn29 = (Button) findViewById(R.id.button29);
        btn30 = (Button) findViewById(R.id.button30);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btn10.setOnClickListener(onClickListener);
        btn11.setOnClickListener(onClickListener);
        btn12.setOnClickListener(onClickListener);
        btn13.setOnClickListener(onClickListener);
        btn14.setOnClickListener(onClickListener);
        btn15.setOnClickListener(onClickListener);
        btn16.setOnClickListener(onClickListener);
        btn17.setOnClickListener(onClickListener);
        btn18.setOnClickListener(onClickListener);
        btn19.setOnClickListener(onClickListener);
        btn20.setOnClickListener(onClickListener);
        btn21.setOnClickListener(onClickListener);
        btn22.setOnClickListener(onClickListener);
        btn23.setOnClickListener(onClickListener);
        btn24.setOnClickListener(onClickListener);
        btn25.setOnClickListener(onClickListener);
        btn26.setOnClickListener(onClickListener);
        btn27.setOnClickListener(onClickListener);
        btn28.setOnClickListener(onClickListener);
        btn29.setOnClickListener(onClickListener);
        btn30.setOnClickListener(onClickListener);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loadText();
    }



    View.OnClickListener onClickListener = new View.OnClickListener() {


        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.button1):
                case (R.id.button6):
                case (R.id.button9):
                case (R.id.button11):
                case (R.id.button16):
                case (R.id.button17):
                case (R.id.button27):
                    Code = 1;
                    Intent i1 = new Intent(List.this, Math.class);
                    i1.putExtra("Sub", DzMath);
                    startActivityForResult(i1,1);
                    break;
                case (R.id.button2):
                case (R.id.button10):
                case (R.id.button12):
                case (R.id.button13):
                case (R.id.button20):
                case (R.id.button22):
                case (R.id.button26):
                    Code = 2;
                    Intent i2 = new Intent( List.this, Rus.class);
                    i2.putExtra("Sub", DzRus);
                    startActivityForResult(i2,2);
                    break;
                case (R.id.button3):
                case (R.id.button29):
                    Code = 3;
                    Intent i3 = new Intent( List.this, Geo.class);
                    i3.putExtra("Sub", DzGeo);
                    startActivityForResult(i3,3);
                    break;
                case (R.id.button4):
                case (R.id.button24):
                    Code = 4;
                    Intent i4 = new Intent( List.this, Bio.class);
                    i4.putExtra("Sub", DzBio);
                    startActivityForResult(i4,4);
                    break;
                case (R.id.button5):
                case (R.id.button7):
                case (R.id.button15):
                case (R.id.button19):
                case (R.id.button21):
                    Code = 5;
                    Intent i5 = new Intent( List.this, Fiz.class);
                    i5.putExtra("Sub", DzFiz);
                    startActivityForResult(i5,5);
                    break;
                case (R.id.button14):
                case (R.id.button23):
                case (R.id.button28):
                    Code = 6;
                    Intent i6= new Intent( List.this, Him.class);
                    i6.putExtra("Sub", DzHim);
                    startActivityForResult(i6,6);
                    break;
                case (R.id.button8):
                case (R.id.button18):
                case (R.id.button25):
                case (R.id.button30):
                    Code = 7;
                    Intent i7= new Intent( List.this, Inf.class);
                    i7.putExtra("Sub", DzInf);
                    startActivityForResult(i7,7);
                    break;
            }
        }
    };
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (Code) {
            case 1:
                DzMath = data.getStringExtra("dz");
                saveText();
                break;
            case 2:
                DzRus = data.getStringExtra("dz");
                break;
            case 3:
                DzGeo = data.getStringExtra("dz");
                break;
            case 4:
                DzBio = data.getStringExtra("dz");
                break;
            case 5:
                DzFiz = data.getStringExtra("dz");
                break;
            case 6:
                DzHim = data.getStringExtra("dz");
                break;
            case 7:
                DzInf = data.getStringExtra("dz");
                break;
            default:
                btn1.setText(data.getStringExtra("dz"));
        }
    }
    private void saveText(){
        sPref1 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edMath = sPref1.edit();
        edMath.putString(SAVED_TEXT1, DzMath);
        edMath.apply();

        sPref2 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edRus = sPref2.edit();
        edRus.putString(SAVED_TEXT2, DzRus);
        edRus.apply();

        sPref3 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edGeo = sPref3.edit();
        edGeo.putString(SAVED_TEXT3, DzGeo);
        edGeo.apply();

        sPref4 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edBio = sPref4.edit();
        edBio.putString(SAVED_TEXT4, DzBio);
        edBio.apply();

        sPref5 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edFiz = sPref5.edit();
        edFiz.putString(SAVED_TEXT5, DzFiz);
        edFiz.apply();

        sPref6 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edHim = sPref6.edit();
        edHim.putString(SAVED_TEXT6, DzHim);
        edHim.apply();

        sPref7 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edInf = sPref7.edit();
        edInf.putString(SAVED_TEXT7, DzInf);
        edInf.apply();
    }

    private void loadText(){
        sPref1 = getPreferences(MODE_PRIVATE);
        String savedText1 = sPref1.getString(SAVED_TEXT1, "");
        DzMath = savedText1;
        sPref2 = getPreferences(MODE_PRIVATE);
        String savedText2 = sPref2.getString(SAVED_TEXT2, "");
        DzRus = savedText2;
        sPref3 = getPreferences(MODE_PRIVATE);
        String savedText3 = sPref3.getString(SAVED_TEXT3, "");
        DzGeo = savedText3;
        sPref4 = getPreferences(MODE_PRIVATE);
        String savedText4 = sPref4.getString(SAVED_TEXT4, "");
        DzBio = savedText4;
        sPref5 = getPreferences(MODE_PRIVATE);
        String savedText5 = sPref5.getString(SAVED_TEXT5, "");
        DzFiz = savedText5;
        sPref6 = getPreferences(MODE_PRIVATE);
        String savedText6 = sPref6.getString(SAVED_TEXT6, "");
        DzHim = savedText6;
        sPref7 = getPreferences(MODE_PRIVATE);
        String savedText7 = sPref7.getString(SAVED_TEXT7, "");
        DzInf = savedText7;
    }

    protected void onDestroy() {
        saveText();
        super.onDestroy();
        saveText();
    }
    protected void onResume() {
        saveText();
        super.onResume();
        saveText();
    }
    protected void onStop() {
        saveText();
        super.onStop();
        saveText();
    }
    @Override
    public void onBackPressed(){
        try{
            saveText();
            Intent intent = new Intent (List.this, MainActivity.class);
            startActivity(intent); finish();
        }catch(Exception e){

        }
    }
}

