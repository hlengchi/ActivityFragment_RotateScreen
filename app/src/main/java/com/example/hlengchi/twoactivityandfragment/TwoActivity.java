package com.example.hlengchi.twoactivityandfragment;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {
    TextView textViewUserNameTwo,textViewGenderTwo;
    EditText txtMessageTwo;
    Button btnSentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        textViewUserNameTwo=findViewById(R.id.textViewUserNameTwo);
        textViewGenderTwo=findViewById(R.id.textViewGenderTwo);
        txtMessageTwo=findViewById(R.id.txtMessageTwo);
        btnSentTwo=findViewById(R.id.btnSentTwo);

        Bundle bundle=getIntent().getExtras();
                textViewUserNameTwo.setText(bundle.getString("NAME"));
                textViewGenderTwo.setText(bundle.getString("GENDER"));

                btnSentTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(TwoActivity.this,OneActivity.class);
                        intent.putExtra("MESSAGE"   ,txtMessageTwo.getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();

                    }
                });
                if(savedInstanceState!=null){

                    textViewUserNameTwo.setText(savedInstanceState.getString("SECONDNAME"));
                    textViewGenderTwo.setText(savedInstanceState.getString("SECONDGENDER"));
                }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("SECONDNAME",textViewUserNameTwo.getText().toString());
        outState.putString("SECONDGENDER",textViewGenderTwo.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("SECONDNAME");
        savedInstanceState.getString("SECONDGENDER");
    }
}
