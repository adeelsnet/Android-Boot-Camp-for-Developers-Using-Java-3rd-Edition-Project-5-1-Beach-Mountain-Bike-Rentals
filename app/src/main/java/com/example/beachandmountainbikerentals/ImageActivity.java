package com.example.beachandmountainbikerentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        int imageToDisplay = getIntent().getIntExtra("IMAGE_ID", R.drawable.ic_launcher_background);

        ImageView imageView = findViewById (R.id.image_view);
        imageView.setImageDrawable(ContextCompat.getDrawable (this,imageToDisplay));

        String title = getIntent().getStringExtra("TITLE");
        setTitle(title);
    }
}
