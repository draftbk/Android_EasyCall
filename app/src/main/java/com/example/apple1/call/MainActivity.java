package com.example.apple1.call;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private TextView textView;
    private Button goButton,backButton,callButton,changeButton,addButton;
    String name,phonenumber;
    int number=1;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        SharedPreferences preferences=getSharedPreferences("data" + i, MODE_PRIVATE);
        number=preferences.getInt("number",-1);
        Log.d("test", "number" + "         " + number);
        if (number==-1){
            Log.d("test", "number" + "         " + number);
            SharedPreferences.Editor editor=getSharedPreferences("data"+i,MODE_PRIVATE).edit();
            editor.putString("name", "路人甲");
            editor.putString("phone", "123456");
            editor.putInt("number", 1);
            editor.commit();
            number=1;
        }
        name=preferences.getString("name", "");
        phonenumber=preferences.getString("phone", "");
        Log.d("test","phonenumber"+"         "+phonenumber);
        Log.d("test","number"+"         "+number);
        Log.d("test","name"+"         "+name);
        textView.setText(name);
        Log.d("test","preferences"+"         "+preferences);


    }

    private void init() {
        textView=(TextView)findViewById(R.id.textview);

        goButton=(Button)findViewById(R.id.go);
        backButton=(Button)findViewById(R.id.back);
        callButton=(Button)findViewById(R.id.call);
        changeButton=(Button)findViewById(R.id.change);
        addButton=(Button)findViewById(R.id.add);

        goButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
        changeButton.setOnClickListener(this);
        addButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go:
                if (number!=1) {
                    i = (i + 1) % number;
                    SharedPreferences preferences1 = getSharedPreferences("data" + i, MODE_PRIVATE);
                    name = preferences1.getString("name", "");
                    phonenumber = preferences1.getString("phone", "");
                    textView.setText(name);
                }
                break;
            case R.id.back:
                if (number!=1) {
                    i = (i +number- 1) % number;
                    SharedPreferences preferences2 = getSharedPreferences("data" + i, MODE_PRIVATE);
                    name = preferences2.getString("name", "");
                    phonenumber = preferences2.getString("phone", "");
                    textView.setText(name);
                }
                break;
            case R.id.call:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phonenumber));
                startActivity(intent);
                break;
            case R.id.change:
                Intent intent1=new Intent(MainActivity.this,Change.class);
                intent1.putExtra("extra_data",i);
                intent1.putExtra("name", name);
                intent1.putExtra("phone",phonenumber);
                startActivity(intent1);
                finish();
                break;
            case R.id.add:
                Intent intent2=new Intent(MainActivity.this,Add.class);
                intent2.putExtra("extra_data", number);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
