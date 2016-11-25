package com.example.akashchandra.project01.HomeFragment;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akashchandra.project01.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.params.BasicHttpParams;

/**
 * Created by Akash Chandra on 11-11-2016.
 */

public class Today extends Fragment{

    TextView windSpeed;
    TextView windDirection;
    TextView weather;
    TextView humidity;
    TextView humidity_sub;
    TextView pressure;
    TextView sunrise;
    TextView sunset;
    TextView wind;
    TextView cordinate;
    TextView temperature;
    TextView main_header_text;
    TextView cloud_main;
    LinearLayout mainLinearLayout;

    String latitude, longitude,weather_desc,temperature_desc,pressure_desc,sunrise_time,sunset_time,wind_speed,humidity_desc;

    public Today()
    {
        //Empty Fragment
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_today, container, false);
        ButterKnife.bind(getActivity());


        pressure = (TextView)rootView.findViewById(R.id.pressure_data);
        weather = (TextView)rootView.findViewById(R.id.description);
        humidity = (TextView)rootView.findViewById(R.id.humidity_main);
        mainLinearLayout = (LinearLayout)rootView.findViewById(R.id.main_ll);
        main_header_text = (TextView)rootView.findViewById(R.id.temp_main);
        windSpeed = (TextView)rootView.findViewById(R.id.w_speed);
        windDirection = (TextView)rootView.findViewById(R.id.w_dir);
        cloud_main = (TextView)rootView.findViewById(R.id.cloud_main);
        humidity_sub = (TextView)rootView.findViewById(R.id.humidity_data);

        Typeface newfont = Typeface.createFromAsset(getActivity().getAssets(),"font/weknow_thin.ttf");
        Typeface montepetrum = Typeface.createFromAsset(getActivity().getAssets(),"font/montepetrum_bold.ttf");

        main_header_text.setTypeface(newfont);

        //Typeface newfont = Typeface.createFromAsset(getAssets(),"fonts/mytruetypefont.ttf");

        //AsyncJsonObject asyncJsonObject = new AsyncJsonObject();
        //asyncJsonObject.execute("");

        return rootView;
    }

    private class AsyncJsonObject extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            HttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
            HttpPost httpPost = new HttpPost("http://api.openweathermap.org/data/2.5/weather?q=Delhi,in&APPID=3fd0e78fd36e08ceeb5d4274687b0535");
            String jsonResult = "";

            try {
                HttpResponse response = httpClient.execute(httpPost);
                jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
                System.out.println("Returned Json object " + jsonResult.toString());

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return jsonResult;
        }
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);

                JSONObject cord_data = jsonObject.getJSONObject("coord");
                JSONArray weather_jsonArray = jsonObject.getJSONArray("weather");
                JSONObject main = jsonObject.getJSONObject("main");
                JSONObject wind_data = jsonObject.getJSONObject("wind");
                JSONObject sys_data = jsonObject.getJSONObject("sys");
                JSONObject cloud_data = jsonObject.getJSONObject("clouds");

                weather_desc = weather_jsonArray.getJSONObject(0).optString("description").toString();
                weather.setText(weather_desc);

                temperature_desc = main.optString("temp").toString();
                int t = (int) (Float.parseFloat(temperature_desc) - 273.15f);
                main_header_text.setText(String.valueOf(t)+ (char) 0x00B0+"C");

                pressure_desc = main.optString("pressure").toString();
                pressure.setText(pressure_desc+"hPa");

                humidity_desc = main.optString("humidity").toString();
                humidity_sub.setText(" Humidity : "+humidity_desc+"%");
                humidity.setText(" Humidity : "+humidity_desc+"%");

                //wind_speed = wind_data.optString("speed").toString();
                //Toast.makeText(getContext(),wind_speed,Toast.LENGTH_SHORT).show();
                //windSpeed.setText("Speed : "+wind_speed+" m/s");

                String deg = wind_data.getString("deg").toString();
                String CompassDir = degreeToCompass(Integer.parseInt(deg));
                windDirection.setText("Direction : "+CompassDir);

                /*
                latitude = cord_data.optString("lat").toString();
                longitude = cord_data.optString("lon").toString();




                sunrise_time = sys_data.optString("sunrise").toString();
                sunset_time = sys_data.optString("sunset").toString();

                String cloud = cloud_data.optString("all").toString();

                //Setting up the temperature area



                //weather_desc = weather_data.optString("description").toString();

                //Converting the Timestamp into normal date formate
                long unixSecond = Long.parseLong(sunrise_time);
                Date date = new Date(unixSecond*1000L);//*1000 is to convert seconds to milliseconds
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // the format of your date
                sdf.setTimeZone(TimeZone.getTimeZone("GMT-4")); // give a timezone reference for formating (see comment at the bottom
                String formattedDate = sdf.format(date);






                cloud_main.setText(" Cloud       : "+cloud+"%");*/

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = br.readLine()) != null) {
                    answer.append(rLine);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return answer;
        }
    }

    private String degreeToCompass(int degree) {
        int data = (int)((degree/22.5)+.5);
        String[] arr={"N","NNE","NE","ENE","E","ESE", "SE", "SSE","S","SSW","SW","WSW","W","WNW","NW","NNW"};
        return arr[(data%16)];
    }
}
