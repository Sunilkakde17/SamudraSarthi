package com.example.samudrasarathi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BeachDetailActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView feedbackTextView;

    private TextView weatherInfoTextView;
    private TextView activitySuggestionsTextView;
    private TextView amenitiesTextView;
    private TextView environmentalAlertsTextView;
    private TextView nearbyPlacesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_detail);

        // Initialize UI components
        ImageView beachImage = findViewById(R.id.beach_image);
        TextView beachName = findViewById(R.id.beach_name);
        TextView beachDescription = findViewById(R.id.beach_description);
        Button locationButton = findViewById(R.id.location_button);
        ratingBar = findViewById(R.id.beach_rating);
        feedbackTextView = findViewById(R.id.feedback_text);

        // Initialize new components for additional information
        weatherInfoTextView = findViewById(R.id.weather_info);
        activitySuggestionsTextView = findViewById(R.id.activity_suggestions);
        amenitiesTextView = findViewById(R.id.amenities);
        environmentalAlertsTextView = findViewById(R.id.environmental_alerts);
        nearbyPlacesTextView = findViewById(R.id.nearby_places);

        // Retrieve data from the Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("beach_name");
        int image = intent.getIntExtra("beach_image", 0);
        String description = intent.getStringExtra("beach_description");
        double latitude = intent.getDoubleExtra("latitude", 0);
        double longitude = intent.getDoubleExtra("longitude", 0);

        // Set the data to UI components
        beachName.setText(name);
        beachImage.setImageResource(image);
        beachDescription.setText(description);

        // Set additional beach information (for demo purposes, static text is used)
        weatherInfoTextView.setText("Weather: 30°C, Humidity: 60%, Wind Speed: 15 km/h");
        activitySuggestionsTextView.setText("Suggested Activities: Surfing, Snorkeling, Beach Yoga");
        amenitiesTextView.setText("Amenities: Parking, Food Stalls, Restrooms, Lifeguard");
        environmentalAlertsTextView.setText("Environmental Alerts: Tide Timings, Jellyfish Presence");
        nearbyPlacesTextView.setText("Nearby Attractions: Restaurants, Hotels");

        // Set up Location Button to open Google Maps
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "geo:" + latitude + "," + longitude + "?q=" + Uri.encode(name);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        // Set up RatingBar to capture feedback
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    String feedback = "You rated this beach " + rating + " stars!";
                    feedbackTextView.setText(feedback);
                }
            }
        });
    }
}

//package com.example.samudrasarathi;
//
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class BeachDetailActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_beach_detail);
//
//        // Get data passed from the intent
//        String beachName = getIntent().getStringExtra("beach_name");
//        int beachImage = getIntent().getIntExtra("beach_image", R.drawable.arambol_beach);
//        String beachDescription = getIntent().getStringExtra("beach_description");
//
//        // Set the data in the views
//        ImageView beachImageView = findViewById(R.id.beach_image);
//        TextView beachNameTextView = findViewById(R.id.beach_name);
//        TextView beachDescriptionTextView = findViewById(R.id.beach_description);
//
//        beachImageView.setImageResource(beachImage);
//        beachNameTextView.setText(beachName);
//        beachDescriptionTextView.setText(beachDescription);
//    }
//}
