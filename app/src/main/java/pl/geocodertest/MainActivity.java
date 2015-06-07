package pl.geocodertest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import org.parceler.apache.commons.lang.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import app.App;
import pl.gson.Result;
import pl.rest.model.ApiResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    EditText edit;
    TextView tview;
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    public static final String API_KEY = "AIzaSyCsedH9yyiq2sBTjnIS_SUw0OVU2gS1e_w/";
    public static final String LANGUAGE_SUFFIX = "&-PL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tview = (TextView) findViewById(R.id.latlng);
        edit = (EditText) findViewById(R.id.input);
        Button btn = (Button) findViewById(R.id.button);
        edit.setText("Biszcza,339");
        final MainActivity context = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String txt = edit.getText().toString();
                new CoordinatesTask(txt,context).execute();
//                App.getRestClient().getGeoService().getLatLng(txt, new Callback<ApiResponse>() {
//                    @Override
//                    public void success(ApiResponse apiResponse, Response response) {
//                        Logger.d("success?");
//
//                        final Double lat = apiResponse.getResults().get(0).getGeometry().getLocation().getLat();
//                        final Double lng = apiResponse.getResults().get(0).getGeometry().getLocation().getLng();
//
//                        Logger.d(":(");
//
//                        tview.setText(lat + "," + lng);
//
//                    }
//
//                    @Override
//                    public void failure(RetrofitError error) {
//                        Log.e(TAG, "Error : " + error.getMessage());
//
//                    }
//                });


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
