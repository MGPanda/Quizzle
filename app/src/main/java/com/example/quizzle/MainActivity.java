package com.example.quizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.ListView);
        String[] items = getResources().getStringArray(R.array.menuArray);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                R.layout.menu_item, items);
        lv.setAdapter(adapt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                String s = tv.getText().toString();
                if (s.equals(getResources().getStringArray(R.array.menuArray)[0])) {
                    t = Toast.makeText(getApplicationContext(), "Let's play!", Toast.LENGTH_SHORT);
                } else if (s.equals(getResources().getStringArray(R.array.menuArray)[1])) {
                    t = Toast.makeText(getApplicationContext(), "View high scores", Toast.LENGTH_SHORT);
                } else if (s.equals(getResources().getStringArray(R.array.menuArray)[2])) {
                    t = Toast.makeText(getApplicationContext(), "Open settings", Toast.LENGTH_SHORT);
                } else if (s.equals(getResources().getStringArray(R.array.menuArray)[3])) {
                    t = Toast.makeText(getApplicationContext(), "Open the help menu", Toast.LENGTH_SHORT);
                }
                t.show();
            }
        });
    }
}
