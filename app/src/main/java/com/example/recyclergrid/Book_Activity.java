package com.example.recyclergrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvcategory = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        //Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Category = intent.getExtras().getString("Category");
        int image = intent.getExtras().getInt("Thumbnail");

        //setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        tvcategory.setText(Category);
        img.setImageResource(image);

    }
}