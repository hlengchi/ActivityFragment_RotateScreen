package com.example.hlengchi.twoactivityandfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OneActivity extends AppCompatActivity {

    Button btnSubmitOne;
    TextView textViewShowOne;
    EditText txtGenderOne,txtUserNameOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        btnSubmitOne=findViewById(R.id.btnSubmitOne);
        textViewShowOne=findViewById(R.id.textViewShowOne);
        txtUserNameOne=findViewById(R.id.txtUserNameOne);
        txtGenderOne=findViewById(R.id.txtGenderOne);

        btnSubmitOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OneActivity.this,TwoActivity.class);
                        intent.putExtra("NAME",txtUserNameOne.getText().toString());
                        intent.putExtra("GENDER",txtGenderOne.getText().toString());
                        startActivityForResult(intent,1);

            }
        });

        if (savedInstanceState !=null) {

           textViewShowOne.setText(savedInstanceState.getString("SHOWMESSAGE"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK){

            textViewShowOne.setText(data.getStringExtra("MESSAGE"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("SHOWMESSAGE",textViewShowOne.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        savedInstanceState.getString("SHOWMESSAGE");

    }
}
