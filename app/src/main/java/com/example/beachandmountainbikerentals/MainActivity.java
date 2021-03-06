package com.example.beachandmountainbikerentals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String[] bikes;
    int[] bikeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        bikes = new String[]{"Beach Bike Rentals", "Mountain Bike Rentals", "Bike Rentals Website"};

        bikeImage = new int[]{R.drawable.beach, R.drawable.mountain, R.drawable.ic_launcher_background};

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.bikes, bikes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String currentBike = bikes[position];
        int currentBikeImg = bikeImage[position];
        switch(position){
            case 0:
            case 1:
                startActivity(getIntentForImageActivity(currentBikeImg, currentBike));
                break;
            case 2:
                startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://www.campusbikeshop.com")
                        ));
                break;
            default:
                super.onListItemClick(l, v, position, id);
        }
    }

    @NonNull
    private Intent getIntentForImageActivity (int imageId, String title)
    {
        Intent intent = new Intent (MainActivity.this, ImageActivity.class);

        intent.putExtra("IMAGE_ID",imageId);

        intent.putExtra("TITLE", title);
        return intent;
    }
}
