package com.example.hlengchi.testrecyclerview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private EditText mEditTextName;
    private TextView mTextViewAmount;
    private int mAoumount=0;
    private GroceryAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GroceryDBHelper dbHelper=new GroceryDBHelper(this);
        mDatabase=dbHelper.getWritableDatabase();

        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter=new GroceryAdapter(this,getAllItems());
        recyclerView.setAdapter(mAdapter);

        //delete record swap swiped left or right

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long) viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(recyclerView);


        mEditTextName=findViewById(R.id.edittext_name);
        mTextViewAmount=findViewById(R.id.textview_amount);

        Button buttonIncrease=findViewById(R.id.button_increase);
        Button buttonDecrease=findViewById(R.id.button_decrease);
        Button buttonAdd=findViewById(R.id.button_add);

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increase();
            }
        });
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrease();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });

    }
    private void increase(){
        mAoumount++;
        mTextViewAmount.setText(String.valueOf(mAoumount));
    }
    private void decrease(){
        if(mAoumount>0) {
            mAoumount--;
            mTextViewAmount.setText(String.valueOf(mAoumount));
        }
    }
    private void addItem(){
        if(mTextViewAmount.getText().toString().trim().length()==0 || mAoumount==0){

            return;
        }
        String name = mEditTextName.getText().toString();
        ContentValues cv=new ContentValues();
        cv.put(GroceryCotract.GroceryEntry.COLUMN_NAME,name);
        cv.put(GroceryCotract.GroceryEntry.COLUMN_AMOUNT,mAoumount);

        mDatabase.insert(GroceryCotract.GroceryEntry.TABLE_NAME,null,cv);
        mAdapter.swapCursor(getAllItems());
        mEditTextName.getText().clear();

    }
    private Cursor getAllItems(){
        return mDatabase.query(
                GroceryCotract.GroceryEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                GroceryCotract.GroceryEntry.COLUMN_TIMESTAMP+" DESC"
        );
    }
    private void removeItem(long id){
        mDatabase.delete(GroceryCotract.GroceryEntry.TABLE_NAME,GroceryCotract.GroceryEntry._ID+"+"+id,null);
        mAdapter.swapCursor(getAllItems());
    }
}
