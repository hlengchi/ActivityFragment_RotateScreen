package com.example.hlengchi.testrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestObjectActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_object);

        btn=(Button)findViewById(R.id.btnShowMessage);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Teacher teacher=new Teacher();
        Toast.makeText(this, "DI ="+teacher.id+", Name ="+teacher.name+", Gender ="+teacher.gender, Toast.LENGTH_SHORT).show();

    }

    public class Teacher{
        private int id;
        private String name;
        private String gender;
      public  Teacher(){
          this.id=120;
          this.name="Heng Lengchi";
          this.gender="Male";
      }
    }
}
