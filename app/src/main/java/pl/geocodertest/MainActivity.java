package pl.geocodertest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pl.gsonjson.GsonGeocoderTask;


public class MainActivity extends ActionBarActivity {
    EditText edit;
    TextView tview;
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    public static final String API_KEY = Data.GEOCODING_API_KEY;
    public static final String LANGUAGE_SUFFIX = "&-PL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tview = (TextView)findViewById(R.id.latlng);
        edit = (EditText)findViewById(R.id.input);
        Button btn = (Button)findViewById(R.id.button);
        final MainActivity context = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String txt= edit.getText().toString();
                new CoordinatesTask(txt,context).execute();
                //Gson's parser not working yet
//                String url =  BASE + txt + LANGUAGE_SUFFIX + "&key=" + API_KEY;
//                new GsonGeocoderTask(context,url).execute();
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
