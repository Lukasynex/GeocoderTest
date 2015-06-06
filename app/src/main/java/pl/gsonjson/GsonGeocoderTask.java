package pl.gsonjson;
//android imports
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.Reader;
//frameworks imports
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;
//local import
import pl.gson.GeoBlob;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonGeocoderTask extends AsyncTask<Void, Void, Void> {
    public static final String TAG = GsonGeocoderTask.class.getSimpleName();
    private ProgressDialog progressDialog;
    private Context context;
    //private GeocodingResult geoJSON;
    private GeoBlob geoJSON;
    private static String url;

    public GsonGeocoderTask(Context o, String addr) {
        Logger.d("our link is: %s",addr);
        url = addr;
        context = o;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Logger.d("przed ");

        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Logger.d("w trakcie... ");

        Reader reader = API.getData(url);
        //geoJSON = new GsonBuilder().create().fromJson(reader, GeocodingResult.class);
        geoJSON = new GsonBuilder().create().fromJson(reader, GeoBlob.class);
        Log.e("results: ", geoJSON.getResults() + "");
        Log.e("status: ", geoJSON.getStatus() + "");
        Double latitude = geoJSON.getResults().get(0).getGeometry().getLocation().getLat();
        Double longtitude = geoJSON.getResults().get(0).getGeometry().getLocation().getLng();
        Log.d(TAG, "" + latitude);
        Log.d(TAG, "" + longtitude);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Logger.d("after");
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
    }
}
