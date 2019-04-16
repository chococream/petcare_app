package com.sun.toy;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Check extends AppCompatActivity {

    ListView listview ;
    Button btn, btn2;
    EditText ed;
    CustomChoiceListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        listview = (ListView) findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        ed = (EditText) findViewById(R.id.edit);
        adapter = new CustomChoiceListViewAdapter();

        listview.setAdapter(adapter);

        adapter.addItem("우주 밥주기");
        adapter.addItem("우주 산책 시키기");
        adapter.addItem("우주 씻기기");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Check.this, "일정이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                adapter.addItem(ed.getText().toString());
                adapter.notifyDataSetChanged();
                ed.setText("");
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int pos;
                pos = listview.getCheckedItemPosition();
                if(pos != ListView.INVALID_POSITION){
                    adapter.removeItem(pos);
                    listview.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
