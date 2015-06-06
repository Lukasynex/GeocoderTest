package pl.geocodertest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created by Lukasz Marczak on 2015-06-04.
 */
public class CoordinatesTask extends AsyncTask<Void, Void, String> {

    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private static final String API_KEY = "AIzaSyCsedH9yyiq2sBTjnIS_SUw0OVU2gS1e_w";
    private static final String LANGUAGE_SUFFIX = "&-PL";

    public static final String TAG = CoordinatesTask.class.getSimpleName();
    private String full_address;
    MainActivity context;

    ProgressDialog progressDialog;

    public CoordinatesTask(String address, String components, MainActivity context) {
        //todo: format string to pass to the default contructor
        this(address + "&components=" + components, context);
    }

    public CoordinatesTask(String address, MainActivity context) {
        //full_address = address;

        full_address = BASE + address + LANGUAGE_SUFFIX + "&key=" + API_KEY;
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("ogień!");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }


    @Override
    protected String doInBackground(Void... params) {
        String result = null;
        try {
            result = getDataFromURL(full_address);
        } catch (IOException | JSONException | GeneralSecurityException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getDataFromURL(String urlString) throws IOException, JSONException, GeneralSecurityException {
        //setup
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(false);
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        //print data logs
        Log.i(TAG, "Request:\n" + "/GET " + urlString);
        //connect
        connection.connect();
        //get result string
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String resultString = "";
        String line = "";
        while ((line = reader.readLine()) != null) {
            resultString += line;
        }
        //Log.i(TAG, "Response:\n" + new JSONObject(resultString).toString(3));
        //end connection
        connection.disconnect();
        //return result
        return resultString;
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        if (result == null) {
            Log.e(TAG, "empty JSON");
            Toast.makeText(context, "Null result", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            final String dzejson = result;
            Logger.json(result);
            Logger.json("jsObject parsed succesfully");

            JSONObject mainObject = new JSONObject(result);
            String lat = mainObject.getJSONArray("results").getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location").getString("lat");
            String lng = mainObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
                    .getJSONObject("location").getString("lng");

            TextView view = (TextView) context.findViewById(R.id.latlng);
            view.setText("(" + lat + "," + lng + ")");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Error geetting the json");
            Toast.makeText(context, "Error to get JSON", Toast.LENGTH_LONG).show();
        }
    }


}


