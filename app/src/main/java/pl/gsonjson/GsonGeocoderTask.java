package pl.gsonjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.util.logging.Logger;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonGeocoderTask extends AsyncTask<Void, Void, Void> {
    public static final String TAG = GsonGeocoderTask.class.getSimpleName();
    private ProgressDialog progressDialog;
    private Context context;
    private GeocodingResult geoJSON;
    private String url;

    public GsonGeocoderTask(Context o, String addr) {
        url=addr;
        context = o;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Reader reader = API.getData(url);
        geoJSON = new GsonBuilder().create().fromJson(reader, GeocodingResult.class);
        Log.e("results: ", geoJSON.getResults() + "");
        Log.e("status: ", geoJSON.getStatus() + "");
        Double latitude = geoJSON.getResults().get(0).getGeometry().get(0).getLocation().get(0).getLat();
        Double longtitude = geoJSON.getResults().get(0).getGeometry().get(0).getLocation().get(0).getLng();
        Log.d(TAG, "" + latitude);
        Log.d(TAG, "" + longtitude);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
    }
}
