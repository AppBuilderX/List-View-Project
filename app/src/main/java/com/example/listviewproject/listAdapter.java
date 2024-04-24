package com.example.listviewproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class listAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] imageId;
    private final String[] titleText;
    private final String[] descText;

    public listAdapter(Activity context, Integer[] imageId, String[] titleText, String[] descText) {
        super(context, R.layout.list_layout, titleText);
        this.context = context;
        this.imageId = imageId;
        this.titleText = titleText;
        this.descText = descText;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater  layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.list_layout,null,true);

        ImageView image = rowView.findViewById(R.id.img_view);
        TextView title = rowView.findViewById(R.id.title_txt);
        TextView desc = rowView.findViewById(R.id.desc__txt);

        image.setImageResource(imageId[position]);
        title.setText(titleText[position]);
        desc.setText(descText[position]);

        return rowView;
    }
}
