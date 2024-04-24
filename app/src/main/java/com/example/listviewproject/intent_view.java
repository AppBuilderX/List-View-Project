package com.example.listviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class intent_view extends AppCompatActivity {

    ImageView image;
    TextView titletext;
    TextView desctext;

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        image = findViewById(R.id.imageView2);
        titletext = findViewById(R.id.title_text);
        desctext = findViewById(R.id.dec_text);

        Intent i = getIntent();
        String titles = i.getExtras().getString("title");
        String desc = i.getExtras().getString("description");
        Integer img = i.getExtras().getInt("Image");

        image.setImageResource(img);
        titletext.setText(titles);
        desctext.setText(desc);

        imageButton = findViewById(R.id.back_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}