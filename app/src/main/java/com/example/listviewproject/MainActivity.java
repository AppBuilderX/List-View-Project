package com.example.listviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    listAdapter adapter;

    String[] titleText = {"Battery", "File", "Extension", "Currency", "Corona Virus", "Color Lens"};
    String[] descText = {
            "An battery is a electrochemical cell",
            "This is a file sambole",
            "Extension uses basicaly chrome",
            "This is indian currency",
            "Conrona viruse is a dangures viruse",
            "Color lens use in mix color"
    };

    Integer[] imageId = {
            R.drawable.baseline_battery_charging_full_24,
            R.drawable.baseline_file_present_24,
            R.drawable.baseline_extension_24,
            R.drawable.baseline_currency_rupee_24,
            R.drawable.baseline_coronavirus_24,
            R.drawable.baseline_color_lens_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        list = findViewById(R.id.list_view);

        adapter = new listAdapter(MainActivity.this, imageId, titleText, descText);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, intent_view.class);

                intent.putExtra("title", titleText[position]);
                intent.putExtra("description", descText[position]);
                intent.putExtra("Image", imageId[position]);

                startActivity(intent);

            }
        });


    }
}