package com.example.samudrasarathi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BeachesActivity extends AppCompatActivity {

    private String[] beaches = {
            "Goa", "Digha", "Lakshadweep", "Pondicherry", "Tarkarli",
            "Alibaug", "Kovalam", "Gokarna", "Varkala", "Diu", "Havelock Island"
    };

    private int[] beachImages = {
            R.drawable.goa, R.drawable.digha, R.drawable.lakshadweep, R.drawable.pondicherry,
            R.drawable.tarkarli, R.drawable.alibaug, R.drawable.kovalam, R.drawable.gokarna,
            R.drawable.varkala, R.drawable.diu, R.drawable.havelockisland
    };

    private String[] beachDescriptions = {
            "Goa is known for its vibrant nightlife, beautiful beaches, and Portuguese architecture.",
            "Digha is a popular coastal retreat with shallow sand beaches and casuarina plantations.",
            "Lakshadweep is famous for its coral reefs, water sports, and untouched beauty.",
            "Pondicherry boasts serene beaches, French-inspired townscapes, and cultural heritage.",
            "Tarkarli is a scuba diving paradise with white sand beaches and backwaters.",
            "Alibaug is renowned for its historic forts, beautiful beaches, and delicious seafood.",
            "Kovalam features crescent-shaped beaches and a lighthouse offering stunning views.",
            "Gokarna combines spiritual tranquility with pristine, unspoiled beaches.",
            "Varkala is known for its cliff-side beaches and natural mineral springs.",
            "Diu is a quiet island with Portuguese history, scenic beaches, and unique caves.",
            "Havelock Island is a part of the Andaman, famous for its azure waters and coral reefs."
    };

    private double[] beachLatitudes = {
            15.2993, 21.6220, 10.5667, 11.9416, 16.0410,
            18.6384, 8.3996, 14.5500, 8.7384, 20.7150, 12.0020
    };

    private double[] beachLongitudes = {
            74.1240, 87.5336, 72.6417, 79.8083, 73.4723,
            72.8776, 76.9712, 74.3186, 76.7063, 70.9877, 93.0027
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaches);

        ListView beachListView = findViewById(R.id.beach_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, beaches);
        beachListView.setAdapter(adapter);

        beachListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Open BeachDetailActivity with relevant data
                Intent intent = new Intent(BeachesActivity.this, BeachDetailActivity.class);
                intent.putExtra("beach_name", beaches[position]);
                intent.putExtra("beach_image", beachImages[position]);
                intent.putExtra("beach_description", beachDescriptions[position]);
                intent.putExtra("latitude", beachLatitudes[position]);
                intent.putExtra("longitude", beachLongitudes[position]);
                startActivity(intent);
            }
        });
    }
}


//package com.example.samudrasarathi;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class BeachesActivity extends AppCompatActivity {
//
//    private String[] beaches = {
//            "Goa", "Digha", "Lakshadweep", "Pondicherry", "Tarkarli",
//            "Alibaug", "Kovalam", "Gokarna", "Varkala", "Diu", "Havelock Island"
//    };
//
//    private int[] beachImages = {
//            R.drawable.arambol_beach, R.drawable.goabeachimage, R.drawable.benaulim_beach, R.drawable.arambol_beach,
//            R.drawable.benaulim_beach, R.drawable.goabeachimage, R.drawable.arambol_beach, R.drawable.benaulim_beach,
//            R.drawable.goabeachimage, R.drawable.benaulim_beach, R.drawable.arambol_beach
//    };
//
//    private String[] beachDescriptions = {
//            "Goa is known for its beaches, nightlife, and Portuguese heritage.",
//            "Digha is a popular beach town in West Bengal, ideal for family vacations.",
//            "Lakshadweep is a tropical paradise with pristine coral reefs and lagoons.",
//            "Pondicherry offers serene beaches and French colonial architecture.",
//            "Tarkarli is famous for its white sand beaches and scuba diving.",
//            "Alibaug is a coastal town near Mumbai known for its forts and beaches.",
//            "Kovalam is a beach town in Kerala with stunning crescent-shaped beaches.",
//            "Gokarna is a temple town with serene beaches, perfect for relaxation.",
//            "Varkala is known for its cliffs adjacent to the Arabian Sea.",
//            "Diu is a quiet island town with a rich Portuguese history.",
//            "Havelock Island offers crystal-clear waters and lush greenery."
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_beaches);
//
//        ListView beachListView = findViewById(R.id.beach_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, beaches);
//        beachListView.setAdapter(adapter);
//
//        beachListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(BeachesActivity.this, BeachDetailActivity.class);
//                intent.putExtra("beach_name", beaches[position]);
//                intent.putExtra("beach_image", beachImages[position]);
//                intent.putExtra("beach_description", beachDescriptions[position]);
//                startActivity(intent);
//            }
//        });
//    }
//}
//
//








//package com.example.samudrasarathi;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class BeachesActivity extends AppCompatActivity {
//
//    // Sample data: List of beaches and their corresponding images
//    private String[] beaches = {
//            "Goa", "Digha", "Lakshadweep", "Pondicherry", "Tarkarli",
//            "Alibaug", "Kovalam", "Gokarna", "Varkala", "Diu", "Havelock Island"
//    };
//
//    private int[] beachImages = {
//            R.drawable.goabeachimage, R.drawable.arambol_beach, R.drawable.benaulim_beach, R.drawable.goabeachimage,
//            R.drawable.arambol_beach, R.drawable.goabeachimage, R.drawable.arambol_beach, R.drawable.benaulim_beach,
//            R.drawable.goabeachimage, R.drawable.arambol_beach, R.drawable.benaulim_beach
//    };
//
//    private ImageView beachImageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_beaches);
//
//        // ImageView to display the selected beach image
//        beachImageView = findViewById(R.id.beach_image);
//
//        // ListView to display the list of beaches
//        ListView beachListView = findViewById(R.id.beach_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, beaches);
//        beachListView.setAdapter(adapter);
//
//        // Handle clicks on list items
//        beachListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Display the corresponding beach image
//                beachImageView.setImageResource(beachImages[position]);
//
//                // Optional: Show a toast with the beach name
//                Toast.makeText(BeachesActivity.this, "Selected: " + beaches[position], Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
