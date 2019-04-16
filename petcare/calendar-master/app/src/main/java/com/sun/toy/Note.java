package com.sun.toy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);
        final ListView listview = (ListView) findViewById(R.id.listview1);

        listview.setAdapter(adapter);

        Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String text = editText.getText().toString();
                items.add(text);
                editText.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        Button modifyButton = (Button) findViewById(R.id.modify);
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int pos;
                pos = listview.getCheckedItemPosition();
                if(pos != ListView.INVALID_POSITION){
                    items.remove(pos);
                    listview.clearChoices();
                    adapter.notifyDataSetChanged();
                }

                String text = editText.getText().toString();
                items.add(text);
                editText.setText("");
                adapter.notifyDataSetChanged();


            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int pos;
                pos = listview.getCheckedItemPosition();
                if(pos != ListView.INVALID_POSITION){
                    items.remove(pos);
                    listview.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
