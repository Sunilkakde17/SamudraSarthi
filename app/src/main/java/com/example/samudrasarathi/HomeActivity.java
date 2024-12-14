package com.example.samudrasarathi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {

    private TextView cityNameText, temperatureText, humidityText, descriptionText, windText;
    private ImageView weatherIcon;
    private Button refreshButton;
    private EditText cityNameInput;

    private static final String API_KEY = "c96739031dc0b51d1c047a8eca465506";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cityNameText = findViewById(R.id.cityNameText);
        temperatureText = findViewById(R.id.temperatureText);
        humidityText = findViewById(R.id.humidityText);
        windText = findViewById(R.id.windText);
        descriptionText = findViewById(R.id.descriptionText);
        weatherIcon = findViewById(R.id.weatherIcon);
        refreshButton = findViewById(R.id.fetchWeatherButton);
        cityNameInput = findViewById(R.id.cityNameInput);


        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = cityNameInput.getText().toString();
                if (cityName.isEmpty()) {
                    FeatchWeatherData(cityName);
                } else {
                    cityNameInput.setError(("please Enter a City Name"));
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FeatchWeatherData("Goa");
    }

    private void FeatchWeatherData(String goa) {


        String url = "https:openweather.org/data/2.5/weather?q=" + cityNameText + "&appid=" + API_KEY + "&units=metric";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() ->
                {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    try {
                        Response response = client.newCall(request).execute();
                        String result = response.body().string();
                        runOnUiThread(() -> updateUI(result));
                    } catch (IOException e) {
                        e.printStackTrace();
                        ;
                    }
                }

        );


    }

    private void updateUI(String result) {

        if (result != null) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONObject main = jsonObject.getJSONObject("main");
                double temperature = main.getDouble("temp");
                double humidity = main.getDouble("humidity");
                double windSpeed = jsonObject.getJSONObject("wind").getDouble("speed");
                String deascription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
                String iconCode = jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");
                String resourceName = "ic_" + iconCode;
                int resId = getResources().getIdentifier(resourceName, "drawable", getPackageName());
                weatherIcon.setImageResource(resId);
                cityNameText.setText(jsonObject.getString("name"));
                temperatureText.setText(String.format("%.of", temperature));
                humidityText.setText(String.format("%.of%%", humidity));
                windText.setText(String.format("%.of km/h", windSpeed));
                descriptionText.setText(deascription);


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_all_beaches) {
            // Start BeachesActivity
            Intent intent = new Intent(this, BeachesActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "About the App", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}

    //        // Set up ListView for beaches
//        ListView listView= findViewById(R.id.list_beaches);
//        List <com.example.samudrasarathi.Beach>  beaches = getBeaches(); // Fetch the list of beaches
//        BeachAdapter adapter = new BeachAdapter(this, beaches); // Assuming you have created a BeachAdapter
//        listView.setAdapter(adapter);
//
//        // Handle item click to navigate to SubBeachListActivity
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            com.example.samudrasarathi.Beach selectedBeach = beaches.get(position);
//            Intent intent = new Intent(this, SubBeachListActivity.class);
//            intent.putExtra("selectedBeach", selectedBeach.getName()); // Passing beach name or whole object
//            startActivity(intent);
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu items from XML
//        getMenuInflater().inflate(R.menu.menu_home, menu);
//        Log.d("HomeActivity", "Menu created");
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.menu_all_beaches) {
//            // Open All Beaches activity
//            Intent allBeachesIntent = new Intent(this, BeachListActivity.class);
//            startActivity(allBeachesIntent);
//            return true;
//        } else if (id == R.id.menu_about) {
//            // Open About activity or show info about the app
//            Intent aboutIntent = new Intent(this, AboutActivity.class);
//            startActivity(aboutIntent);
//            return true;
//        } else if (id == R.id.menu_settings) {
//            // Open Settings activity
//            Intent settingsIntent = new Intent(this, SettingActivity.class);
//            startActivity(settingsIntent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    private List<Beach> getBeaches() {
//        // Return a list of beaches with their names, descriptions, and image resources
//        return Arrays.asList(
//                new Beach("Goa", "Famous for its beaches and nightlife.", R.drawable.goabeachimage),
//                new Beach("Digha", "A scenic beach destination in West Bengal.", R.drawable.arambol_beach),
//               new Beach("Lakshadweep", "An archipelago with stunning coral islands.", R.drawable.goabeachimage),
//               new Beach("Pondicherry", "Known for French colonial architecture and beaches.", R.drawable.arambol_beach),
//               new Beach("Tarkarli", "A beautiful beach with clear waters in Maharashtra.", R.drawable.goabeachimage),
//                new Beach("Alibaug", "A coastal town with beaches near Mumbai.", R.drawable.goabeachimage),
//                new Beach("Kovalam", "A beach town in Kerala, known for its lighthouses.", R.drawable.arambol_beach),
//                new Beach("Gokarna", "A famous temple town and beach destination in Karnataka.", R.drawable.goabeachimage),
//                new Beach("Varkala", "Known for its cliffs and serene beach.", R.drawable.arambol_beach),
//                new Beach("Diu", "A union territory with pristine beaches.", R.drawable.goabeachimage),
//                new Beach("Havelock Island", "A paradise in Andaman and Nicobar Islands.", R.drawable.goabeachimage)
//        );




