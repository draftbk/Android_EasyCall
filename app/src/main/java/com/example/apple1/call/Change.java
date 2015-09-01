package com.example.apple1.call;

/**
 * Created by apple1 on 2015/8/31.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;



public class Change extends ActionBarActivity implements View.OnClickListener {
    ArrayList<Caller> callerArrayList;
    private EditText editName,editPhonenumber;
    private Button okButton;
    int i=0;
    String name,phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        Intent intent =getIntent();
        i=intent.getIntExtra("extra_data",0);
        name=intent.getStringExtra("name");
        phonenumber=intent.getStringExtra("phone");
        callerArrayList=new ArrayList<Caller>();
        init();
        editName.setText(name);
        editPhonenumber.setText(phonenumber);
        okButton.setOnClickListener(this);
    }

    private void init() {
        editName=(EditText)findViewById(R.id.edit_name);
        editPhonenumber=(EditText)findViewById(R.id.edit_phonenumber);
        okButton=(Button)findViewById(R.id.btn_ok);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_ok:
                String name=editName.getText().toString();
                String phonenumber=editPhonenumber.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data"+i,MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("phone", phonenumber);
                editor.commit();
                Intent intentback=new Intent(Change.this,MainActivity.class);
                startActivity(intentback);
                break;
            default:
                break;
        }



    }

}
