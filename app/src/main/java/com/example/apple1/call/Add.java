package com.example.apple1.call;

/**
 * Created by apple1 on 2015/8/31.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class Add extends ActionBarActivity implements View.OnClickListener {
    private EditText editName,editPhonenumber;
    private Button okButton;
    int number=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        Intent intent =getIntent();
        number=intent.getIntExtra("extra_data",0);
        init();
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
                Log.d("test", "有吗");
                String name=editName.getText().toString();
                String phonenumber=editPhonenumber.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data"+number,MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("phone", phonenumber);
                Log.d("test", "number+1" + number + 1);
                editor.commit();
                SharedPreferences.Editor editor1=getSharedPreferences("data"+0,MODE_PRIVATE).edit();
                editor1.putInt("number", number + 1);
                Log.d("test", "number+1" + number + 1);
                editor1.commit();
                Intent intentback=new Intent(Add.this,MainActivity.class);
                startActivity(intentback);
                break;
            default:
                Log.d("test", "这里总有吧");
                break;
        }



    }

}
