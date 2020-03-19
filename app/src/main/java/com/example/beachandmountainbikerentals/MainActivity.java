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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        String[ ] bikes = {"Beach Bike Rentals", "Mountain Bike Rentals", "Bike Rentals Website"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.bikes, bikes));
    }

    @NonNull
    private Intent getIntentForImageActivity (int imageId)
    {
        Intent intent = new Intent (MainActivity.this, ImageActivity.class);

        intent.putExtra("IMAGE_ID",imageId);
        return intent;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch(position){
            case 0:
                startActivity(getIntentForImageActivity(R.drawable.beach));
                break;
            case 1:
                startActivity(getIntentForImageActivity(R.drawable.mountain));
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
}
